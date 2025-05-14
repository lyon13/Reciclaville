package Leonardo.Ribeiro.Project.java.services;

import Leonardo.Ribeiro.Project.java.dtos.DeclarationRequestDto;
import Leonardo.Ribeiro.Project.java.dtos.DeclarationResponseDto;

import java.util.List;


public interface DeclarationService {
    List<DeclarationResponseDto> findAll();
    DeclarationResponseDto findById (Long id);
    DeclarationResponseDto create(DeclarationRequestDto dto);
    void delete(Long id);


}
