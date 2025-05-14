package Leonardo.Ribeiro.Project.java.entities;


import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;


@Entity
@Table(name = "materials")

public class MaterialEntity {
    public MaterialEntity() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getCompensationPercentage() {
        return compensationPercentage;
    }

    public void setCompensationPercentage(BigDecimal compensationPercentage) {
        this.compensationPercentage = compensationPercentage;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private BigDecimal compensationPercentage;



}
