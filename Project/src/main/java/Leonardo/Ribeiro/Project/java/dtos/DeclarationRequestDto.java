package Leonardo.Ribeiro.Project.java.dtos;
import Leonardo.Ribeiro.Project.java.entities.CustomerEntity;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;


public record DeclarationRequestDto(Long idCustomer, LocalDate initialPeriodDate, LocalDate finalPeriodDate, List<ItemDeclarationResponseDto> itemDeclaration, BigDecimal totalMaterial, BigDecimal compensationPercentage) {

    public BigDecimal totalMaterial() {
        return totalMaterial != null ? totalMaterial:BigDecimal.ZERO;
    }

    public BigDecimal compensationPercentage() {
        return compensationPercentage != null ? compensationPercentage:BigDecimal.ZERO;
    }
}
