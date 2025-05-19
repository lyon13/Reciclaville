package Leonardo.Ribeiro.Project.java.dtos;

import Leonardo.Ribeiro.Project.java.entities.CustomerEntity;
import Leonardo.Ribeiro.Project.java.entities.ItemDeclarationEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.w3c.dom.ls.LSException;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;


@Builder

public record DeclarationResponseDto(
     Long id,
     CustomerResponseDto idCustomer,
     LocalDate declarationDate,
     LocalDate initialPeriodDate,
     LocalDate finalPeriodDate,
     BigDecimal totalMaterial,
     BigDecimal totalCompensation,
     List<ItemDeclarationResponseDto> itemDeclaration
){
}
