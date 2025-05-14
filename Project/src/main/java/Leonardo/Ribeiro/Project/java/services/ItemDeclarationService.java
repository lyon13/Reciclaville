package Leonardo.Ribeiro.Project.java.services;

import Leonardo.Ribeiro.Project.java.dtos.ItemDeclarationRequestDto;
import Leonardo.Ribeiro.Project.java.dtos.ItemDeclarationResponseDto;

import java.util.List;

public interface ItemDeclarationService {

    List<ItemDeclarationResponseDto> findAll();
    ItemDeclarationResponseDto findById(Long id);
    ItemDeclarationResponseDto create(ItemDeclarationRequestDto dto);



}
