package Leonardo.Ribeiro.Project.java.mappers;

import Leonardo.Ribeiro.Project.java.dtos.CustomerResponseDto;
import Leonardo.Ribeiro.Project.java.dtos.DeclarationRequestDto;
import Leonardo.Ribeiro.Project.java.dtos.DeclarationResponseDto;
import Leonardo.Ribeiro.Project.java.dtos.ItemDeclarationResponseDto;
import Leonardo.Ribeiro.Project.java.entities.CustomerEntity;
import Leonardo.Ribeiro.Project.java.entities.DeclarationEntity;
import Leonardo.Ribeiro.Project.java.entities.ItemDeclarationEntity;
import Leonardo.Ribeiro.Project.java.services.CustomerService;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;


@Mapper(componentModel = "spring")
public interface DeclarationMapper {
     DeclarationResponseDto toDto(DeclarationEntity declaration);

     default DeclarationResponseDto toDto(DeclarationEntity declaration, @Context CustomerService customerService) {
        DeclarationResponseDto response = new DeclarationResponseDto();
        response.setId(declaration.getId());
        response.setIdCustomer(customerService.findById(declaration.getId()));
        response.setDeclarationDate(declaration.getDeclarationDate());
        response.setInitialPeriodDate(declaration.getInitialPeriodDate());
        response.setFinalPeriodDate(declaration.getFinalPeriodDate());
        response.setTotalMaterial(declaration.getTotalMaterial());
        response.setTotalCompensation(declaration.getTotalCompensation());
        response.setItemDeclaration(mapItems(declaration.getItemDeclaration()));
        return response;



    };
    DeclarationEntity toEntity(DeclarationRequestDto dto);
    CustomerEntity map(Long value);

    ItemDeclarationResponseDto map(ItemDeclarationEntity value);

    List<ItemDeclarationResponseDto> mapItems(List<ItemDeclarationEntity> items);

    default void afterMapping(@MappingTarget DeclarationEntity declaration, DeclarationRequestDto dto) {
        if (declaration.getItemDeclaration() != null) {
            declaration.getItemDeclaration().forEach(item -> item.setIdDeclaration(declaration));
        }
    }
    default CustomerEntity map(Long idCustomer, @Context CustomerService customerService){
        if(idCustomer == null){
            return null;
        }

        return customerService.findByIdEntity(idCustomer);
    }
    // CustomerResponseDto toCustomerDto(DeclarationEntity customer);
}
