package Leonardo.Ribeiro.Project.java.dtos;
import Leonardo.Ribeiro.Project.java.entities.CustomerEntity;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;


public record DeclarationRequestDto(CustomerEntity idCustomer, LocalDate declarationDate, LocalDate initialPeriodDate, LocalDate finalPeriodDate, BigDecimal totalMaterial, BigDecimal totalCompensation) {

}
