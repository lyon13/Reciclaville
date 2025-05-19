package Leonardo.Ribeiro.Project.java.services;

import Leonardo.Ribeiro.Project.java.dtos.MaterialRequestDto;
import Leonardo.Ribeiro.Project.java.dtos.MaterialResponseDto;
import Leonardo.Ribeiro.Project.java.entities.MaterialEntity;
import Leonardo.Ribeiro.Project.java.exceptions.badrequests.MaterialRequestException;
import Leonardo.Ribeiro.Project.java.exceptions.notfounds.MaterialNotFoundException;
import Leonardo.Ribeiro.Project.java.mappers.MaterialMapper;
import Leonardo.Ribeiro.Project.java.repositories.MaterialRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
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



    public MaterialEntity findEntityById(Long id) {

        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Material not found with id: " + id));
    }

    @Override
    public MaterialResponseDto findById(Long id){
        MaterialEntity material = findEntityById(id);
        if (material == null) {
            throw new MaterialNotFoundException(id);
        }
        return mapper.toDto(material);
    }
    @Override
    public MaterialResponseDto create(MaterialRequestDto dto ) {
        validateDto(dto);
        MaterialEntity material =  mapper.toEntity(dto);
        MaterialEntity materialResult = repository.save(material);
        return mapper.toDto(materialResult);
    }
    @Override
    public MaterialResponseDto update(Long id, MaterialRequestDto dto) {
        MaterialEntity material =  findEntityById(id);
        if (material == null) {
            throw new MaterialNotFoundException(id);
        }
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

    public void validateDto(MaterialRequestDto dto) {
        if (dto.name() == null || dto.name().trim().isEmpty()) {
            throw new MaterialRequestException("Name cannot be null or empty");
        }
        if (dto.compensationPercentage() == null || dto.compensationPercentage().compareTo(BigDecimal.ZERO) < 0) {
            throw new MaterialRequestException("Compensation percentage cannot be null or negative");
        }
    }

}
