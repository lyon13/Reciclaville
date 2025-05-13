package Leonardo.Ribeiro.Project.java.repositories;

import Leonardo.Ribeiro.Project.java.entities.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<CustomerEntity, Long> {
}
