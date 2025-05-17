package Leonardo.Ribeiro.Project.java.services;


import Leonardo.Ribeiro.Project.java.dtos.DeclarationRequestDto;
import Leonardo.Ribeiro.Project.java.dtos.DeclarationResponseDto;
import Leonardo.Ribeiro.Project.java.entities.CustomerEntity;
import Leonardo.Ribeiro.Project.java.entities.DeclarationEntity;
import Leonardo.Ribeiro.Project.java.entities.ItemDeclarationEntity;
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
    private DeclarationMapper mapper;
    private final MaterialService materialService;
    private final CustomerService customerService;


    @Override
    public List<DeclarationResponseDto> findAll() {
        List<DeclarationEntity> declarations = repository.findAll();
        return declarations.stream().map(mapper::toDto).toList();
    }
    @Override
    public DeclarationResponseDto findById(Long id) {
        DeclarationEntity declaration = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Declaration not found with id: " + id));
        return mapper.toDto(declaration);
    }




    public DeclarationResponseDto create(DeclarationRequestDto requestDto) {
        if(requestDto.initialPeriodDate().isAfter(requestDto.finalPeriodDate())){
            throw new IllegalArgumentException("Initial period date cannot be after final period date");
        }

        if (requestDto.totalMaterial().compareTo(BigDecimal.ZERO)<= 0) {throw new IllegalArgumentException("Declared tons must be greater than 0");
        }
        if (requestDto.compensationPercentage().compareTo(BigDecimal.ZERO) < 0 || requestDto.compensationPercentage().compareTo(new BigDecimal("100")) > 0){
            throw new IllegalArgumentException("Compensation percentage must be between 0 and 100");
        }
         CustomerEntity customer = customerService.findByIdEntity(requestDto.idCustomer());


        DeclarationEntity declaration = new DeclarationEntity();
        declaration.setIdCustomer(customer);
        declaration.setDeclarationDate(LocalDate.now());
        declaration.setInitialPeriodDate(requestDto.initialPeriodDate());
        declaration.setFinalPeriodDate(requestDto.finalPeriodDate());
        declaration.setTotalMaterial(requestDto.totalMaterial());

        BigDecimal totalCompensation = requestDto.totalMaterial()
                .multiply(requestDto.compensationPercentage())
                .divide(new BigDecimal("100"));
        declaration.setTotalCompensation(totalCompensation);


        DeclarationEntity savedDeclaration = repository.save(declaration);


        return mapper.toDto(savedDeclaration);
    }

    @Override
    public void delete(Long id) {

        DeclarationEntity declaration = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Declaration not found with id: " + id));
        repository.delete(declaration);

    }


}
