package enigma_camp.spring_data_jpa.service;

import enigma_camp.spring_data_jpa.repositori.CategoryRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CategoryServiceTest {

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

}