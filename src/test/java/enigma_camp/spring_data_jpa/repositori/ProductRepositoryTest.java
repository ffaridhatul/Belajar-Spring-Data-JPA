package enigma_camp.spring_data_jpa.repositori;

import enigma_camp.spring_data_jpa.entity.Category;
import enigma_camp.spring_data_jpa.entity.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

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
            Product product1 = new Product();
            product1.setName("Rendang Sapi");
            product1.setPrice(15000L);
            product1.setCategory(category);
            productRepository.save(product1);

            Product product2 = new Product();
            product2.setName("Gulai Ayam");
            product2.setPrice(12000L);
            product2.setCategory(category);
            productRepository.save(product2);

            Product product3 = new Product();
            product3.setName("Sate Padang");
            product3.setPrice(10000L);
            product3.setCategory(category);
            productRepository.save(product3);

            Product product4 = new Product();
            product4.setName("Dendeng Balado");
            product4.setPrice(18000L);
            product4.setCategory(category);
            productRepository.save(product4);

            Product product5 = new Product();
            product5.setName("Ayam Pop");
            product5.setPrice(14000L);
            product5.setCategory(category);
            productRepository.save(product5);


        }
    }

    @Test
    void findByCategoryName() {
        List<Product> products = productRepository.findAllByCategory_Name("Masakan Minang");
        assertEquals(1, products.size());
        assertEquals("Rendang Sapi", products.get(0).getName());
    }

    @Test
    void findProductsSortTest() {
        Sort sort = Sort.by("name").descending();
        List<Product> products = productRepository.findAllByCategory_Name("Masakan Minang", sort);

        // Memastikan bahwa hasil tidak null dan tidak kosong
        assertNotNull(products);
        assertFalse(products.isEmpty());

        // Memastikan produk-produk diurutkan dengan benar berdasarkan nama secara descending
        for (int i = 0; i < products.size() - 1; i++) {
            assertTrue(products.get(i).getName().compareTo(products.get(i + 1).getName()) >= 0);
        }
    }

    @Test
    void testFindProductsWithPageable() {
        // page 0
        Pageable pageable = PageRequest.of(0, 1, Sort.by(Sort.Order.desc("id")));
        List<Product> products = productRepository.findAllByCategory_Name("Masakan Minang", pageable);

        assertEquals(1, products.size());
        assertEquals("Ayam Pop", products.get(0).getName());

        // page 1
        pageable = PageRequest.of(2, 1, Sort.by(Sort.Order.desc("id")));
        products = productRepository.findAllByCategory_Name("Masakan Minang", pageable);

        assertEquals(1, products.size());
        assertEquals("Sate Padang", products.get(0).getName());
    }


}