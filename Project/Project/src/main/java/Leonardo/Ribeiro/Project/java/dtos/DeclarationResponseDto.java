package Leonardo.Ribeiro.Project.java.dtos;

import Leonardo.Ribeiro.Project.java.entities.CustomerEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.w3c.dom.ls.LSException;

import java.math.BigDecimal;
import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class DeclarationResponseDto {
    private Long id;
    private CustomerEntity idCustomer;
    private LocalDate declarationDate;
    private LocalDate initialPeriodDate;
    private LocalDate finalPeriodDate;
    private BigDecimal totalMaterial;
    private BigDecimal totalCompensation;
}
