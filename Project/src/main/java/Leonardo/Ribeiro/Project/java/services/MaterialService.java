package Leonardo.Ribeiro.Project.java.services;

import Leonardo.Ribeiro.Project.java.dtos.MaterialRequestDto;
import Leonardo.Ribeiro.Project.java.dtos.MaterialResponseDto;
import Leonardo.Ribeiro.Project.java.entities.MaterialEntity;

import java.util.List;

public interface MaterialService {

     List<MaterialResponseDto> findAll();
     MaterialResponseDto findById(Long id);
     MaterialResponseDto create(MaterialRequestDto dto);
     MaterialResponseDto update(Long id, MaterialRequestDto dto);
     MaterialEntity findEntityById(Long id);
     void delete(Long id);
}
