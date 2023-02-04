package br.com.lucenacaio.structure.service;


import br.com.lucenacaio.structure.dto.CategoryDTO;
import br.com.lucenacaio.structure.dto.ImmutableCategoryDTO;
import br.com.lucenacaio.structure.service.impl.CategoryServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
class CategoryServiceTest extends AbstractTestContainer{

    @Autowired
    private CategoryServiceImpl categoryServiceImpl;

    @Test
    void testCreateCategory() {
        CategoryDTO categoryDTO = ImmutableCategoryDTO.builder().name("teste").build();
        CategoryDTO categoryDTOReturn = this.categoryServiceImpl.save(categoryDTO);
        Assertions.assertNotNull(categoryDTOReturn);
        Assertions.assertEquals(categoryDTO.getName(), categoryDTOReturn.getName());
    }
}