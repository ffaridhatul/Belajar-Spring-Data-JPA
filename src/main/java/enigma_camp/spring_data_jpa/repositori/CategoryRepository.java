package enigma_camp.spring_data_jpa.repositori;

import enigma_camp.spring_data_jpa.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Long> {

    //Where name = ?
    Optional<Category> findFirstByName(String name);

    //Where name like ?
    List<Category> findALlByNameLike(String name);
}
