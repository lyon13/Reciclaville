package Leonardo.Ribeiro.Project.java.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class MaterialResponseDto {

    private Long id;
    private String name;
    private BigDecimal compensationPercentage;


}
