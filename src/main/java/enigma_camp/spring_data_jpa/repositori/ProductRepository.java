package enigma_camp.spring_data_jpa.repositori;

import enigma_camp.spring_data_jpa.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findAllByCategory_Name(String name); // findAllByCategoryName(String name)>
}
