package Leonardo.Ribeiro.Project.java.services;


import Leonardo.Ribeiro.Project.java.dtos.DeclarationRequestDto;
import Leonardo.Ribeiro.Project.java.dtos.DeclarationResponseDto;
import Leonardo.Ribeiro.Project.java.entities.DeclarationEntity;
import Leonardo.Ribeiro.Project.java.mappers.DeclarationMapper;
import Leonardo.Ribeiro.Project.java.repositories.DeclarationRepository;
import lombok.RequiredArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor

@Service
public class DeclarationServiceImpl implements DeclarationService{

    private final DeclarationRepository repository;
    private final DeclarationMapper mapper = Mappers.getMapper(DeclarationMapper.class);

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
        DeclarationEntity declaration = new DeclarationEntity();
        mapper.toEntity(dto, declaration);

        declaration = repository.save(declaration);
        return mapper.toDto(declaration);
    }

    @Override
    public void delete(Long id) {
        Optional<DeclarationEntity> declaration = repository.findById(id);
        repository.delete(declaration);
    }


}
