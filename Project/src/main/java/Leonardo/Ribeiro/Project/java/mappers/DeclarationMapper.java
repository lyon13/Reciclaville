package Leonardo.Ribeiro.Project.java.mappers;

import Leonardo.Ribeiro.Project.java.dtos.DeclarationRequestDto;
import Leonardo.Ribeiro.Project.java.dtos.DeclarationResponseDto;
import Leonardo.Ribeiro.Project.java.dtos.ItemDeclarationRequestDto;
import Leonardo.Ribeiro.Project.java.dtos.ItemDeclarationResponseDto;
import Leonardo.Ribeiro.Project.java.entities.CustomerEntity;
import Leonardo.Ribeiro.Project.java.entities.DeclarationEntity;
import Leonardo.Ribeiro.Project.java.entities.ItemDeclarationEntity;
import Leonardo.Ribeiro.Project.java.entities.MaterialEntity;
import Leonardo.Ribeiro.Project.java.services.CustomerService;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.math.BigDecimal;
import java.util.List;


@Mapper(componentModel = "spring", uses = {CustomerService.class, MaterialMapper.class})
public interface DeclarationMapper {
    @Mapping(target = "idCustomer", source = "idCustomer.id")
    @Mapping(target = "itemDeclaration", source = "itemDeclaration")
    DeclarationResponseDto toDto(DeclarationEntity declaration);

    @Mapping(target = "itemDeclaration", ignore = true)
    DeclarationEntity toEntity(DeclarationRequestDto dto);

    @Mapping(target = "idMaterial", source = "idMaterial")
    ItemDeclarationResponseDto toDto(ItemDeclarationEntity entity);

    @Mapping(target = "declaration", ignore = true)
    ItemDeclarationEntity toEntity(ItemDeclarationRequestDto dto);
    //DeclarationResponseDto toDto(DeclarationEntity entity);
     DeclarationEntity map(BigDecimal value);
   // ItemDeclarationResponseDto map(ItemDeclarationEntity value);
    MaterialEntity map(Long value);
    // List<ItemDeclarationResponseDto> mapItems(List<ItemDeclarationEntity> items);


    default CustomerEntity map(Long idCustomer, @Context CustomerService customerService){
        if(idCustomer == null){
            return null;
        }

        return customerService.findByIdEntity(idCustomer);
    }


    // CustomerResponseDto toCustomerDto(DeclarationEntity customer);
}
