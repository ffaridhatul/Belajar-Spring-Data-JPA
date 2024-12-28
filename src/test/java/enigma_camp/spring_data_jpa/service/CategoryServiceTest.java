package enigma_camp.spring_data_jpa.service;

import enigma_camp.spring_data_jpa.entity.Category;
import enigma_camp.spring_data_jpa.repositori.CategoryRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CategoryServiceTest {

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    private CategoryService categoryService;

    @Test
    void success() {
        assertThrows(RuntimeException.class, () -> {
            categoryService.create();
        });
    }

    @Test
    void failed() {
        assertThrows(RuntimeException.class, () -> {
            categoryService.test();
        });
    }

    @Test
    void programmatic() {
        assertThrows(RuntimeException.class, () -> {
            categoryService.createCategories();
        });
    }

    @Test
    void queryTestMethod() {
        Category category = categoryRepository.findFirstByName("Masakan Padang").orElse(null);
        assertNotNull(category);
        assertEquals("Masakan Padang", category.getName());

        List<Category> aLlByNameLike = categoryRepository.findALlByNameLike("%Masakan%");
        assertEquals(1, aLlByNameLike.size());
        assertEquals("Masakan Padang", aLlByNameLike.get(0).getName());

    }
}