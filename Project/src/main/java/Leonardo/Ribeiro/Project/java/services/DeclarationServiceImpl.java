package Leonardo.Ribeiro.Project.java.services;


import Leonardo.Ribeiro.Project.java.dtos.DeclarationRequestDto;
import Leonardo.Ribeiro.Project.java.dtos.DeclarationResponseDto;
import Leonardo.Ribeiro.Project.java.dtos.ItemDeclarationRequestDto;
import Leonardo.Ribeiro.Project.java.dtos.MaterialResponseDto;
import Leonardo.Ribeiro.Project.java.entities.CustomerEntity;
import Leonardo.Ribeiro.Project.java.entities.DeclarationEntity;
import Leonardo.Ribeiro.Project.java.entities.ItemDeclarationEntity;
import Leonardo.Ribeiro.Project.java.entities.MaterialEntity;
import Leonardo.Ribeiro.Project.java.exceptions.badrequests.CustomerRequestException;
import Leonardo.Ribeiro.Project.java.exceptions.badrequests.DeclarationRequestException;
import Leonardo.Ribeiro.Project.java.exceptions.notfounds.DeclarationNotFoundException;
import Leonardo.Ribeiro.Project.java.mappers.DeclarationMapper;
import Leonardo.Ribeiro.Project.java.repositories.DeclarationRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class DeclarationServiceImpl implements DeclarationService{

    private final DeclarationRepository repository;
    private final DeclarationMapper mapper;
    private final MaterialService materialService;
    private final CustomerService customerService;
    // private final ItemDeclarationRequestDto itemDeclarationRequestDto;


    @Override
    public List<DeclarationResponseDto> findAll() {
        List<DeclarationEntity> declarations = repository.findAll();
        return declarations.stream().map(mapper::toDto).toList();
    }
    @Override
    public DeclarationResponseDto findById(Long id) {
        DeclarationEntity declaration = repository.findById(id)
                .orElseThrow(() -> new DeclarationNotFoundException(id));
        return mapper.toDto(declaration);
    }




    public DeclarationResponseDto create(DeclarationRequestDto requestDto) {
        if (requestDto.initialPeriodDate().isAfter(requestDto.finalPeriodDate())) {
            throw new DeclarationRequestException("Initial period date cannot be after final period date");
        }

        CustomerEntity customer = customerService.findByIdEntity(requestDto.idCustomer());
        if (customer == null){
            throw new CustomerRequestException("Customer not found with id: " + requestDto.idCustomer());
        }
        DeclarationEntity declaration = mapper.toEntity(requestDto);
        declaration.setIdCustomer(customer);
        declaration.setDeclarationDate(LocalDate.now());

        if(declaration.getItemDeclaration() == null){
            declaration.setItemDeclaration(new ArrayList<>());
        }

        List<ItemDeclarationEntity> items = declaration.getItemDeclaration();
        BigDecimal totalMaterial = BigDecimal.ZERO;
        BigDecimal totalCompensation = BigDecimal.ZERO;


        for (var itemDto : requestDto.itemDeclaration()) {
            MaterialEntity material = materialService.findEntityById(itemDto.idMaterial());
            if (material == null) {
                throw new DeclarationRequestException("Material not found with id: " + itemDto.idMaterial());
            }
            BigDecimal tonsDeclarated = Optional.ofNullable(itemDto.tonsDeclarated()).orElse(BigDecimal.ZERO);

            if (tonsDeclarated.compareTo(BigDecimal.ZERO) <= 0) {
                throw new DeclarationRequestException("Declared tons cannot be negative");
            }


        BigDecimal itemCompensation = tonsDeclarated
                .multiply(material.getCompensationPercentage())
                .divide(new BigDecimal("100"));

        ItemDeclarationEntity itemEntity = mapper.toEntity(itemDto);
        itemEntity.setTonsDeclarated(tonsDeclarated);
        itemEntity.setCompensationPersentage(material.getCompensationPercentage());
        itemEntity.setIdMaterial(material);
        itemEntity.setDeclaration(declaration);
        items.add(itemEntity);

            totalMaterial = totalMaterial.add(tonsDeclarated);
            totalCompensation = totalCompensation.add(itemCompensation);
        }
        declaration.setTotalMaterial(totalMaterial);
        declaration.setTotalCompensation(totalCompensation);

        DeclarationEntity savedDeclaration = repository.save(declaration);;
        return mapper.toDto(savedDeclaration);
    }

    @Override
    public void delete(Long id) {

        DeclarationEntity declaration = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Declaration not found with id: " + id));
        repository.delete(declaration);

    }


}
