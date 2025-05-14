package Leonardo.Ribeiro.Project.java.mappers;


import Leonardo.Ribeiro.Project.java.dtos.MaterialRequestDto;
import Leonardo.Ribeiro.Project.java.dtos.MaterialResponseDto;
import Leonardo.Ribeiro.Project.java.entities.MaterialEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface MaterialMapper {
    MaterialResponseDto toDto(MaterialEntity materialEntity);
    MaterialEntity toEntity(MaterialRequestDto Dto);


}
