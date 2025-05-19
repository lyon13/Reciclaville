package Leonardo.Ribeiro.Project.java.services;


import Leonardo.Ribeiro.Project.java.dtos.CustomerRequestDto;
import Leonardo.Ribeiro.Project.java.dtos.CustomerResponseDto;
import Leonardo.Ribeiro.Project.java.entities.CustomerEntity;
import Leonardo.Ribeiro.Project.java.exceptions.badrequests.CustomerRequestException;
import Leonardo.Ribeiro.Project.java.mappers.CustomerMapper;
import Leonardo.Ribeiro.Project.java.repositories.CustomerRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CustomerServiceImpl implements CustomerService{

     private CustomerRepository repository;
     private CustomerMapper mapper;


     public List<CustomerResponseDto> findAll() {
        return repository.findAll().stream()
                 .map(mapper::toDto)
                 .collect(Collectors.toList());
     }


    public CustomerResponseDto findById(Long id) {
        return mapper.toDto(repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Customer not found")));
     }

    @Override
    public CustomerEntity findByIdEntity(Long id) {

         return repository.findById(id).orElseThrow(() -> new RuntimeException("Customer not found with id: " + id));
    }


    public CustomerResponseDto create(CustomerRequestDto dto) {
        validateDto(dto);
        CustomerEntity customer = mapper.toEntity(dto);

        customer = repository.save(customer);
        return mapper.toDto(customer);
     }

    public CustomerResponseDto update(Long id, CustomerRequestDto dto) {
        CustomerEntity customer = repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Customer not found"));
        mapper.toEntity(dto);
        customer.setName(dto.name());
        customer.setCnpj(dto.cnpj());
        customer.setEconomicActivity(dto.economicActivity());
        customer.setOwnerName(dto.ownerName());
        CustomerEntity customerResult = repository.save(customer);
        return mapper.toDto(customerResult);
     }

    public void delete(Long id) {
        CustomerEntity customer = repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Customer not found"));
        repository.delete(customer);
     }

    private void validateDto(CustomerRequestDto dto) {
        if (dto == null) {
            throw new CustomerRequestException("CustomerRequestDto cannot be null");
        }
        if (dto.name() == null || dto.name().trim().isEmpty()) {
            throw new CustomerRequestException("Name cannot be null or empty");
        }
        if (dto.cnpj() == null || dto.cnpj().trim().isEmpty()) {
            throw new CustomerRequestException("CNPJ cannot be null or empty");
        }
        if (dto.economicActivity() == null || dto.economicActivity().trim().isEmpty()) {
            throw new CustomerRequestException("Economic activity cannot be null or empty");
        }
        if (dto.ownerName() == null || dto.ownerName().trim().isEmpty()) {
            throw new CustomerRequestException("Owner name cannot be null or empty");
        }
    }
}
