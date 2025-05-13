package Leonardo.Ribeiro.Project.java.dtos;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MaterialRequestDto {

    private String name;
    private String compensationPercentage;
}
