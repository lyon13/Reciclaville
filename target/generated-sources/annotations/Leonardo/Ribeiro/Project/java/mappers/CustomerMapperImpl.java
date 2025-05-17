package Leonardo.Ribeiro.Project.java.mappers;

import Leonardo.Ribeiro.Project.java.dtos.CustomerRequestDto;
import Leonardo.Ribeiro.Project.java.dtos.CustomerResponseDto;
import Leonardo.Ribeiro.Project.java.entities.CustomerEntity;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-05-16T22:56:05-0300",
    comments = "version: 1.6.0.Beta1, compiler: javac, environment: Java 21.0.7 (Microsoft)"
)
@Component
public class CustomerMapperImpl implements CustomerMapper {

    @Override
    public CustomerResponseDto toDto(CustomerEntity customer) {
        if ( customer == null ) {
            return null;
        }

        CustomerResponseDto.CustomerResponseDtoBuilder customerResponseDto = CustomerResponseDto.builder();

        customerResponseDto.id( customer.getId() );
        customerResponseDto.name( customer.getName() );
        customerResponseDto.cnpj( customer.getCnpj() );
        customerResponseDto.economicActivity( customer.getEconomicActivity() );
        customerResponseDto.ownerName( customer.getOwnerName() );

        return customerResponseDto.build();
    }

    @Override
    public CustomerEntity toEntity(CustomerRequestDto dto) {
        if ( dto == null ) {
            return null;
        }

        CustomerEntity.CustomerEntityBuilder customerEntity = CustomerEntity.builder();

        customerEntity.name( dto.name() );
        customerEntity.cnpj( dto.cnpj() );
        customerEntity.economicActivity( dto.economicActivity() );
        customerEntity.ownerName( dto.ownerName() );

        return customerEntity.build();
    }
}
