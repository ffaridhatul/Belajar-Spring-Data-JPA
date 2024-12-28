package enigma_camp.spring_data_jpa.repositori;

import enigma_camp.spring_data_jpa.entity.Category;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CategoryRepositoryTest {
    
    @Autowired
    CategoryRepository categoryRepository;

    @Test
    void insert() {
        Category category = new Category();
        category.setName("Makanan");

        categoryRepository.save(category);

        assertNotNull(category.getId());
    }

    @Test
    void update() {
        Category category = categoryRepository.findById(1L).orElse(null);
        assertNotNull(category);

        category.setName("Masakan Minang");
        categoryRepository.save(category);

        category = categoryRepository.findById(1L).orElse(null);
        assertNotNull(category);
        assertEquals("Masakan Minang", category.getName());

    }
}