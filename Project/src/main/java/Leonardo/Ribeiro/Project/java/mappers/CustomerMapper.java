package Leonardo.Ribeiro.Project.java.mappers;

import Leonardo.Ribeiro.Project.java.dtos.CustomerRequestDto;
import Leonardo.Ribeiro.Project.java.dtos.CustomerResponseDto;
import Leonardo.Ribeiro.Project.java.entities.CustomerEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;


@Mapper(componentModel = "spring")
public interface CustomerMapper {
    CustomerResponseDto toDto(CustomerEntity customer);
    CustomerEntity toEntity(CustomerRequestDto dto);
}
