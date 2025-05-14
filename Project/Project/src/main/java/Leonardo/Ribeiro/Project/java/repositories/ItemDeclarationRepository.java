package Leonardo.Ribeiro.Project.java.repositories;

import Leonardo.Ribeiro.Project.java.entities.ItemDeclarationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ItemDeclarationRepository  extends JpaRepository<ItemDeclarationEntity, Long> {


}
