package Leonardo.Ribeiro.Project.java.services;

import Leonardo.Ribeiro.Project.java.dtos.CustomerRequestDto;
import Leonardo.Ribeiro.Project.java.dtos.CustomerResponseDto;

import java.util.ArrayList;
import java.util.List;

public interface CustomerService {

    List<CustomerResponseDto> findAll();
    CustomerResponseDto findById(Long id);
    CustomerResponseDto create(CustomerRequestDto dto);
    CustomerResponseDto update(Long id, CustomerRequestDto dto);
    void delete(Long id);
}
