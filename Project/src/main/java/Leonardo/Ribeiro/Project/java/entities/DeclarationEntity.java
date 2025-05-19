package Leonardo.Ribeiro.Project.java.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
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

    @Column
    private BigDecimal totalMaterial;

    @Column
    private BigDecimal totalCompensation;

    @OneToMany(mappedBy = "declaration", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ItemDeclarationEntity> itemDeclaration;



}
