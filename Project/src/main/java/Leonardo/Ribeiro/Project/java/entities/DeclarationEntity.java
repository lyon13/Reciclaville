package Leonardo.Ribeiro.Project.java.entities;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.mapping.Constraint;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "declarations")
@Builder
@RequiredArgsConstructor
@Setter
@Getter
public class DeclarationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne@JoinColumn(name = "id_customer", nullable = false)
    @Column(nullable = false)
    private CustomerEntity idCustomer;

    @Column(nullable = false)
    private LocalDate declarationDate;

    @Column(nullable = false)
    private LocalDate initialPeriodDate;

    @Column(nullable = false)
    private LocalDate finalPeriodDate;

    @Column(nullable = false)
    private BigDecimal totalMaterial;

    @Column(nullable = false)
    private BigDecimal totalCompensation;




}
