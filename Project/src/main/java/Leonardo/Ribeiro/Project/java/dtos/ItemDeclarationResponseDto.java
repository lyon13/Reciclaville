package Leonardo.Ribeiro.Project.java.dtos;

import Leonardo.Ribeiro.Project.java.entities.DeclarationEntity;
import Leonardo.Ribeiro.Project.java.entities.MaterialEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;


@Builder

public record ItemDeclarationResponseDto (
     Long id,
     MaterialResponseDto idMaterial,
     BigDecimal tonsDeclarated ){
}
