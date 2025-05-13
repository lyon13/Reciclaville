package Leonardo.Ribeiro.Project.java.repositories;

import Leonardo.Ribeiro.Project.java.entities.DeclarationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DeclarationRepository extends JpaRepository<DeclarationEntity, Long> {
    void delete(Optional<DeclarationEntity> declaration);
}
