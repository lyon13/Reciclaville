package Leonardo.Ribeiro.Project.java.mappers;

import Leonardo.Ribeiro.Project.java.dtos.ItemDeclarationRequestDto;
import Leonardo.Ribeiro.Project.java.dtos.ItemDeclarationResponseDto;
import Leonardo.Ribeiro.Project.java.entities.ItemDeclarationEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface ItemDeclarationMapper {

    ItemDeclarationResponseDto toDto(ItemDeclarationEntity Dto);
    ItemDeclarationEntity toEntity(ItemDeclarationRequestDto Dto);
}
