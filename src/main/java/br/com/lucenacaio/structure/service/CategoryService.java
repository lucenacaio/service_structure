package br.com.lucenacaio.structure.service;

import br.com.lucenacaio.structure.dto.CategoryDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

public interface CategoryService {

    Page<CategoryDTO> getAll(PageRequest of);

    CategoryDTO getOne(int id);

    CategoryDTO save(CategoryDTO categoryDTO);

}
