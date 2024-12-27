package enigma_camp.spring_data_jpa.repositori;

import enigma_camp.spring_data_jpa.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
