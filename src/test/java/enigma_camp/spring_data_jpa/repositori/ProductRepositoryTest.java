package enigma_camp.spring_data_jpa.repositori;

import enigma_camp.spring_data_jpa.entity.Category;
import enigma_camp.spring_data_jpa.entity.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class ProductRepositoryTest {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ProductRepository productRepository;

    @Test
    void createProduct() {
        Category category = categoryRepository.findById(1L).orElse(null);
        assertNotNull(category);
        {
            Product product = new Product();
            product.setName("Rendang Sapi");
            product.setPrice(15000L);
            product.setCategory(category);
            productRepository.save(product);

        }
    }

    @Test
    void findByCategoryName() {
        List<Product> products = productRepository.findAllByCategory_Name("Masakan Minang");
        assertEquals(1, products.size());
        assertEquals("Rendang Sapi", products.get(0).getName());
    }
}