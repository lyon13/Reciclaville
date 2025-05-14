package Leonardo.Ribeiro.Project.java.controllers;

import Leonardo.Ribeiro.Project.java.dtos.CustomerRequestDto;
import Leonardo.Ribeiro.Project.java.dtos.CustomerResponseDto;
import Leonardo.Ribeiro.Project.java.services.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("customers")
@RequiredArgsConstructor
public class CustomerController {

    @Autowired
    private CustomerService service;

    @GetMapping
    public List<CustomerResponseDto> get() {
        return service.findAll();
    }

    @GetMapping("{id}")
    public CustomerResponseDto getById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping(consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public CustomerResponseDto create(@RequestBody CustomerRequestDto dto) {
        return service.create(dto);
    }

    @PutMapping("{id}")
    public CustomerResponseDto update(@PathVariable Long id, @RequestBody CustomerRequestDto dto) {
        return service.update(id, dto);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

}
