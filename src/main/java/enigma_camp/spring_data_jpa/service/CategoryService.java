package enigma_camp.spring_data_jpa.service;

import enigma_camp.spring_data_jpa.entity.Category;
import enigma_camp.spring_data_jpa.repositori.CategoryRepository;
import jakarta.persistence.Transient;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.support.TransactionOperations;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private TransactionOperations transactionOperations;

    public void error(){
        throw new RuntimeException("Ups..");
    }
    @Transactional
    public void createCategories(){
        transactionOperations.executeWithoutResult(transactionStatus -> {
            for (int i = 0; i < 5; i++) {
                Category category = new Category();
                category.setName("Masakan " + i);
                categoryRepository.save(category);
            }
            error();
        });
    }

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
