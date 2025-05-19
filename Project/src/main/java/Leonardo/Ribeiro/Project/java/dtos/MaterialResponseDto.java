package Leonardo.Ribeiro.Project.java.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;


@Builder

public record MaterialResponseDto(Long id,
       String name, BigDecimal compensationPercentage)
{
}
