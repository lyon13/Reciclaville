package Leonardo.Ribeiro.Project.java.mappers;

import Leonardo.Ribeiro.Project.java.dtos.ItemDeclarationRequestDto;
import Leonardo.Ribeiro.Project.java.dtos.ItemDeclarationResponseDto;
import Leonardo.Ribeiro.Project.java.entities.ItemDeclarationEntity;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-05-16T22:56:05-0300",
    comments = "version: 1.6.0.Beta1, compiler: javac, environment: Java 21.0.7 (Microsoft)"
)
@Component
public class ItemDeclarationMapperImpl implements ItemDeclarationMapper {

    @Override
    public ItemDeclarationResponseDto toDto(ItemDeclarationEntity entity) {
        if ( entity == null ) {
            return null;
        }

        ItemDeclarationResponseDto itemDeclarationResponseDto = new ItemDeclarationResponseDto();

        return itemDeclarationResponseDto;
    }

    @Override
    public ItemDeclarationEntity toEntity(ItemDeclarationRequestDto dto) {
        if ( dto == null ) {
            return null;
        }

        ItemDeclarationEntity.ItemDeclarationEntityBuilder itemDeclarationEntity = ItemDeclarationEntity.builder();

        itemDeclarationEntity.idMaterial( dto.idMaterial() );

        return itemDeclarationEntity.build();
    }

    @Override
    public List<ItemDeclarationResponseDto> toDtoList(List<ItemDeclarationEntity> entities) {
        if ( entities == null ) {
            return null;
        }

        List<ItemDeclarationResponseDto> list = new ArrayList<ItemDeclarationResponseDto>( entities.size() );
        for ( ItemDeclarationEntity itemDeclarationEntity : entities ) {
            list.add( toDto( itemDeclarationEntity ) );
        }

        return list;
    }

    @Override
    public List<ItemDeclarationEntity> toEntityList(List<ItemDeclarationRequestDto> dtos) {
        if ( dtos == null ) {
            return null;
        }

        List<ItemDeclarationEntity> list = new ArrayList<ItemDeclarationEntity>( dtos.size() );
        for ( ItemDeclarationRequestDto itemDeclarationRequestDto : dtos ) {
            list.add( toEntity( itemDeclarationRequestDto ) );
        }

        return list;
    }
}
