package Leonardo.Ribeiro.Project.java.services;


import Leonardo.Ribeiro.Project.java.dtos.DeclarationRequestDto;
import Leonardo.Ribeiro.Project.java.dtos.DeclarationResponseDto;
import Leonardo.Ribeiro.Project.java.entities.DeclarationEntity;
import Leonardo.Ribeiro.Project.java.mappers.DeclarationMapper;
import Leonardo.Ribeiro.Project.java.repositories.DeclarationRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class DeclarationServiceImpl implements DeclarationService{

    private DeclarationRepository repository;
    private DeclarationMapper mapper = Mappers.getMapper(DeclarationMapper.class);

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



    @Override
    public DeclarationResponseDto create(DeclarationRequestDto dto ) {
        DeclarationEntity declaration = mapper.toEntity(dto);


        declaration = repository.save(declaration);
        return mapper.toDto(declaration);
    }

    @Override
    public void delete(Long id) {

        DeclarationEntity declaration = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Declaration not found with id: " + id));
        repository.delete(declaration);

    }


}
