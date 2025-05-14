package Leonardo.Ribeiro.Project.java.mappers;

import Leonardo.Ribeiro.Project.java.dtos.ItemDeclarationRequestDto;
import Leonardo.Ribeiro.Project.java.dtos.ItemDeclarationResponseDto;
import Leonardo.Ribeiro.Project.java.entities.ItemDeclarationEntity;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-05-14T20:06:32-0300",
    comments = "version: 1.6.0.Beta1, compiler: javac, environment: Java 21.0.7 (Microsoft)"
)
@Component
public class ItemDeclarationMapperImpl implements ItemDeclarationMapper {

    @Override
    public ItemDeclarationResponseDto toDto(ItemDeclarationEntity Dto) {
        if ( Dto == null ) {
            return null;
        }

        ItemDeclarationResponseDto itemDeclarationResponseDto = new ItemDeclarationResponseDto();

        return itemDeclarationResponseDto;
    }

    @Override
    public ItemDeclarationEntity toEntity(ItemDeclarationRequestDto Dto) {
        if ( Dto == null ) {
            return null;
        }

        ItemDeclarationEntity.ItemDeclarationEntityBuilder itemDeclarationEntity = ItemDeclarationEntity.builder();

        itemDeclarationEntity.idMaterial( Dto.idMaterial() );

        return itemDeclarationEntity.build();
    }
}
