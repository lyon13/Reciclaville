package Leonardo.Ribeiro.Project.java.dtos;

import Leonardo.Ribeiro.Project.java.entities.CustomerEntity;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Builder
public class DeclarationRequestDto {

    private CustomerEntity idCustomer;
    private LocalDate declarationDate;
    private LocalDate initialPeriodDate;
    private LocalDate finalPeriodDate;
    private BigDecimal totalMaterial;
    private BigDecimal totalCompensation;
}
