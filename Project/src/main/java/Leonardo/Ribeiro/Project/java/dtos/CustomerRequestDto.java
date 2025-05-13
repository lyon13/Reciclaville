package Leonardo.Ribeiro.Project.java.dtos;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CustomerRequestDto {

    private String name;
    private String cnpj;
    private String economicActivity;
    private String ownerName;
}
