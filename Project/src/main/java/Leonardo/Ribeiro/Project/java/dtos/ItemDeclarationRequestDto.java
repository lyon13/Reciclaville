package Leonardo.Ribeiro.Project.java.dtos;

import Leonardo.Ribeiro.Project.java.entities.MaterialEntity;

import java.math.BigDecimal;

public record ItemDeclarationRequestDto(Long idMaterial,
        BigDecimal tonsDeclarated) {

}
