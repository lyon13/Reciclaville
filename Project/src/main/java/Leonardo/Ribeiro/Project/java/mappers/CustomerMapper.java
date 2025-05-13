package Leonardo.Ribeiro.Project.java.mappers;

import Leonardo.Ribeiro.Project.java.dtos.CustomerResponseDto;
import Leonardo.Ribeiro.Project.java.entities.CustomerEntity;



public interface CustomerMapper {
    CustomerResponseDto toDto(CustomerEntity customer);
    CustomerEntity toEntity(CustomerResponseDto dto, CustomerEntity customerEntity);
}
