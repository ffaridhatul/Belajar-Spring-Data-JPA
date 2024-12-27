package enigma_camp.spring_data_jpa.service;

import enigma_camp.spring_data_jpa.entity.Category;
import enigma_camp.spring_data_jpa.repositori.CategoryRepository;
import jakarta.persistence.Transient;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Transactional
    public void create(){
        for (int i = 0; i < 5; i++) {
            Category category = new Category();
            category.setName("Makanan " + i);
            categoryRepository.save(category);
        }
        throw new RuntimeException("Ups Rollback please");
    }

    public void test(){
        create();
    }

}
