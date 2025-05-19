package Leonardo.Ribeiro.Project.java.entities;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
@Table(name = "items_declarations")
public class ItemDeclarationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_declaration")
    private DeclarationEntity declaration;

    @ManyToOne
    @JoinColumn(name = "id_material", nullable = false)
    private MaterialEntity idMaterial;

    @Column
    private BigDecimal compensationPersentage;

    @Column(nullable = false)
    private BigDecimal tonsDeclarated;

    @Column
    private BigDecimal tonsCompensation;

}
