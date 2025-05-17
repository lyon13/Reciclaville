package Leonardo.Ribeiro.Project.java.controllers;


import Leonardo.Ribeiro.Project.java.dtos.DeclarationRequestDto;
import Leonardo.Ribeiro.Project.java.dtos.DeclarationResponseDto;
import Leonardo.Ribeiro.Project.java.dtos.ItemDeclarationRequestDto;
import Leonardo.Ribeiro.Project.java.entities.ItemDeclarationEntity;
import Leonardo.Ribeiro.Project.java.services.DeclarationService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/declarations")
@RequiredArgsConstructor
public class DeclarationController {


    private final DeclarationService service;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<DeclarationResponseDto> getAllDeclarations() {
        return service.findAll();
    }

    @GetMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public DeclarationResponseDto getDeclarationById(@PathVariable Long id) {
        return service.findById(id);

    }

    @PostMapping(consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public DeclarationResponseDto createDeclaration(@RequestBody DeclarationRequestDto dto) {
        return service.create(dto);

    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteDeclaration(@PathVariable Long id) {
        service.delete(id);
    }
}
