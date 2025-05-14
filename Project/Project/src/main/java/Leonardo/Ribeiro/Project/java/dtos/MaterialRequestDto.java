package Leonardo.Ribeiro.Project.java.dtos;

import java.math.BigDecimal;


public record MaterialRequestDto(
        String name,
        BigDecimal compensationPercentage) {
}



