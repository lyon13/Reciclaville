package Leonardo.Ribeiro.Project.java.controllers;

import Leonardo.Ribeiro.Project.java.dtos.ItemDeclarationRequestDto;
import Leonardo.Ribeiro.Project.java.dtos.ItemDeclarationResponseDto;
import Leonardo.Ribeiro.Project.java.services.DeclarationService;
import Leonardo.Ribeiro.Project.java.services.ItemDeclarationService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/item-declarations")
public class ItemDeclarationController {
    @Autowired
   private ItemDeclarationService service;


    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ItemDeclarationResponseDto> get(){
        return service.findAll();
    }

    @GetMapping("{id}")
    @ResponseStatus(HttpStatus.FOUND)
    public ItemDeclarationResponseDto getById(@PathVariable Long id){
        return service.findById(id);
    }

    @PostMapping(consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public ItemDeclarationResponseDto create(@RequestBody ItemDeclarationRequestDto dto){
        return service.create(dto);
    }


}
