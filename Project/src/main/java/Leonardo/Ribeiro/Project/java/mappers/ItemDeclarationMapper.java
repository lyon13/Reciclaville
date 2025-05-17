package Leonardo.Ribeiro.Project.java.mappers;

import Leonardo.Ribeiro.Project.java.dtos.ItemDeclarationRequestDto;
import Leonardo.Ribeiro.Project.java.dtos.ItemDeclarationResponseDto;
import Leonardo.Ribeiro.Project.java.entities.ItemDeclarationEntity;
import Leonardo.Ribeiro.Project.java.entities.MaterialEntity;
import lombok.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")

public interface ItemDeclarationMapper {

    ItemDeclarationResponseDto toDto(ItemDeclarationEntity entity);
    ItemDeclarationEntity toEntity(ItemDeclarationRequestDto dto);
    List<ItemDeclarationResponseDto> toDtoList(List<ItemDeclarationEntity> entities);
    List<ItemDeclarationEntity> toEntityList(List<ItemDeclarationRequestDto> dtos);
}
