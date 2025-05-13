package Leonardo.Ribeiro.Project.java.dtos;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Builder
@Data
public class MaterialResponseDto {

    private Long id;
    private String name;
    private BigDecimal compensationPercentage;


}
