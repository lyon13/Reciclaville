package Leonardo.Ribeiro.Project.java.dtos;

import Leonardo.Ribeiro.Project.java.entities.DeclarationEntity;
import Leonardo.Ribeiro.Project.java.entities.MaterialEntity;

import java.math.BigDecimal;

public class ItemDeclarationResponseDto {
    private Long id;
    private MaterialResponseDto idMaterial;
    private BigDecimal compensationPersentage;
    private BigDecimal tonsDeclareted;
    private BigDecimal tonsCompensation;
}
