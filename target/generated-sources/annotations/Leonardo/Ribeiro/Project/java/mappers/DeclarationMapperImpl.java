package Leonardo.Ribeiro.Project.java.mappers;

import Leonardo.Ribeiro.Project.java.dtos.CustomerResponseDto;
import Leonardo.Ribeiro.Project.java.dtos.DeclarationRequestDto;
import Leonardo.Ribeiro.Project.java.dtos.DeclarationResponseDto;
import Leonardo.Ribeiro.Project.java.dtos.ItemDeclarationResponseDto;
import Leonardo.Ribeiro.Project.java.entities.CustomerEntity;
import Leonardo.Ribeiro.Project.java.entities.DeclarationEntity;
import Leonardo.Ribeiro.Project.java.entities.ItemDeclarationEntity;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-05-16T23:50:38-0300",
    comments = "version: 1.6.0.Beta1, compiler: javac, environment: Java 21.0.7 (Microsoft)"
)
@Component
public class DeclarationMapperImpl implements DeclarationMapper {

    @Override
    public DeclarationResponseDto toDto(DeclarationEntity declaration) {
        if ( declaration == null ) {
            return null;
        }

        DeclarationResponseDto.DeclarationResponseDtoBuilder declarationResponseDto = DeclarationResponseDto.builder();

        declarationResponseDto.id( declaration.getId() );
        declarationResponseDto.idCustomer( customerEntityToCustomerResponseDto( declaration.getIdCustomer() ) );
        declarationResponseDto.declarationDate( declaration.getDeclarationDate() );
        declarationResponseDto.initialPeriodDate( declaration.getInitialPeriodDate() );
        declarationResponseDto.finalPeriodDate( declaration.getFinalPeriodDate() );
        declarationResponseDto.totalMaterial( declaration.getTotalMaterial() );
        declarationResponseDto.totalCompensation( declaration.getTotalCompensation() );
        declarationResponseDto.itemDeclaration( mapItems( declaration.getItemDeclaration() ) );

        return declarationResponseDto.build();
    }

    @Override
    public DeclarationEntity toEntity(DeclarationRequestDto dto) {
        if ( dto == null ) {
            return null;
        }

        DeclarationEntity.DeclarationEntityBuilder declarationEntity = DeclarationEntity.builder();

        declarationEntity.idCustomer( map( dto.idCustomer() ) );
        declarationEntity.initialPeriodDate( dto.initialPeriodDate() );
        declarationEntity.finalPeriodDate( dto.finalPeriodDate() );
        declarationEntity.totalMaterial( dto.totalMaterial() );
        declarationEntity.itemDeclaration( itemDeclarationResponseDtoListToItemDeclarationEntityList( dto.itemDeclaration() ) );

        return declarationEntity.build();
    }

    @Override
    public CustomerEntity map(Long value) {
        if ( value == null ) {
            return null;
        }

        CustomerEntity.CustomerEntityBuilder customerEntity = CustomerEntity.builder();

        return customerEntity.build();
    }

    @Override
    public ItemDeclarationResponseDto map(ItemDeclarationEntity value) {
        if ( value == null ) {
            return null;
        }

        ItemDeclarationResponseDto itemDeclarationResponseDto = new ItemDeclarationResponseDto();

        return itemDeclarationResponseDto;
    }

    @Override
    public List<ItemDeclarationResponseDto> mapItems(List<ItemDeclarationEntity> items) {
        if ( items == null ) {
            return null;
        }

        List<ItemDeclarationResponseDto> list = new ArrayList<ItemDeclarationResponseDto>( items.size() );
        for ( ItemDeclarationEntity itemDeclarationEntity : items ) {
            list.add( map( itemDeclarationEntity ) );
        }

        return list;
    }

    protected CustomerResponseDto customerEntityToCustomerResponseDto(CustomerEntity customerEntity) {
        if ( customerEntity == null ) {
            return null;
        }

        CustomerResponseDto.CustomerResponseDtoBuilder customerResponseDto = CustomerResponseDto.builder();

        customerResponseDto.id( customerEntity.getId() );
        customerResponseDto.name( customerEntity.getName() );
        customerResponseDto.cnpj( customerEntity.getCnpj() );
        customerResponseDto.economicActivity( customerEntity.getEconomicActivity() );
        customerResponseDto.ownerName( customerEntity.getOwnerName() );

        return customerResponseDto.build();
    }

    protected ItemDeclarationEntity itemDeclarationResponseDtoToItemDeclarationEntity(ItemDeclarationResponseDto itemDeclarationResponseDto) {
        if ( itemDeclarationResponseDto == null ) {
            return null;
        }

        ItemDeclarationEntity.ItemDeclarationEntityBuilder itemDeclarationEntity = ItemDeclarationEntity.builder();

        return itemDeclarationEntity.build();
    }

    protected List<ItemDeclarationEntity> itemDeclarationResponseDtoListToItemDeclarationEntityList(List<ItemDeclarationResponseDto> list) {
        if ( list == null ) {
            return null;
        }

        List<ItemDeclarationEntity> list1 = new ArrayList<ItemDeclarationEntity>( list.size() );
        for ( ItemDeclarationResponseDto itemDeclarationResponseDto : list ) {
            list1.add( itemDeclarationResponseDtoToItemDeclarationEntity( itemDeclarationResponseDto ) );
        }

        return list1;
    }
}
