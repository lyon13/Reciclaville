package Leonardo.Ribeiro.Project.java.services;

import Leonardo.Ribeiro.Project.java.dtos.MaterialRequestDto;
import Leonardo.Ribeiro.Project.java.dtos.MaterialResponseDto;
import Leonardo.Ribeiro.Project.java.entities.MaterialEntity;
import Leonardo.Ribeiro.Project.java.mappers.MaterialMapper;
import Leonardo.Ribeiro.Project.java.repositories.MaterialRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Service
public class MaterialServiceImpl implements MaterialService {

    private final MaterialRepository repository;
    private final MaterialMapper mapper;

    public MaterialServiceImpl(MaterialRepository repository, MaterialMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }
    @Override
    public List<MaterialResponseDto> findAll() {
        List<MaterialEntity> materials = repository.findAll();
        return materials.stream().map(mapper::toDto).toList();


    }


    @Override
    public MaterialResponseDto findById(Long id) {

        return mapper.toDto(findEntityById(id));
    }
    @Override
    public MaterialResponseDto create(MaterialRequestDto dto ) {
        MaterialEntity material =  mapper.toEntity(dto);
        MaterialEntity materialResult = repository.save(material);
        return mapper.toDto(materialResult);
    }
    @Override
    public MaterialResponseDto update(Long id, MaterialRequestDto dto) {
        MaterialEntity material =  findEntityById(id);
        material.setName(dto.name());
        material.setCompensationPercentage(dto.compensationPercentage());

        MaterialEntity materialResult = repository.save(material);
        return mapper.toDto(materialResult);
    }
    @Override
    public void delete(Long id) {
        MaterialEntity material = findEntityById(id);
        repository.delete(material);
    }
    private MaterialEntity findEntityById(Long id) {

        return repository.findById(id).orElseThrow(()-> new RuntimeException("Material not found with id: " + id));
    }
}
