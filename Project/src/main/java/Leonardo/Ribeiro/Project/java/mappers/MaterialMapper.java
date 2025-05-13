package Leonardo.Ribeiro.Project.java.mappers;


import Leonardo.Ribeiro.Project.java.dtos.MaterialRequestDto;
import Leonardo.Ribeiro.Project.java.dtos.MaterialResponseDto;
import Leonardo.Ribeiro.Project.java.entities.MaterialEntity;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper
public interface MaterialMapper {

    MaterialResponseDto toDto(MaterialEntity materialEntity);
    MaterialEntity toEntity(MaterialRequestDto Dto, @MappingTarget MaterialEntity materialEntity);


}
