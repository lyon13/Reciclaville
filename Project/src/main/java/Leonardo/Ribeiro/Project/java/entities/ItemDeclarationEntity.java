package Leonardo.Ribeiro.Project.java.entities;


import jakarta.persistence.*;
import lombok.*;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

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

    @JoinColumn(name = "id_declaration", nullable = false)
    @ManyToOne
    private DeclarationEntity idDeclaration;

    @JoinColumn(name = "id_material", nullable = false)
    @ManyToOne
    private MaterialEntity idMaterial;

    @Column(nullable = false)
    private BigDecimal compensationPersentage;

    @Column(nullable = false)
    private BigDecimal tonsDeclareted;

    @Column(nullable = false)
    private BigDecimal tonsCompensation;

}
