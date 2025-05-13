package Leonardo.Ribeiro.Project.java.mappers;

import Leonardo.Ribeiro.Project.java.dtos.DeclarationRequestDto;
import Leonardo.Ribeiro.Project.java.dtos.DeclarationResponseDto;
import Leonardo.Ribeiro.Project.java.entities.DeclarationEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper
public interface DeclarationMapper {
    DeclarationResponseDto toDto(DeclarationEntity declaration);
    DeclarationEntity toEntity(DeclarationRequestDto dto, @MappingTarget DeclarationEntity declaration);
}
