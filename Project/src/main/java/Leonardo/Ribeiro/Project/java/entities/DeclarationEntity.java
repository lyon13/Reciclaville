package Leonardo.Ribeiro.Project.java.entities;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "declarations")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class DeclarationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne@JoinColumn(name = "id_customer", nullable = false)
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

    @OneToMany(mappedBy = "idDeclaration", cascade = CascadeType.ALL)
    private List<ItemDeclarationEntity> itemDeclaration;



}
