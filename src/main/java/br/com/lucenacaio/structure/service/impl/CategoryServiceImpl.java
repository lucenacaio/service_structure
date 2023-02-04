package br.com.lucenacaio.structure.service.impl;


import br.com.lucenacaio.structure.domain.Category;
import br.com.lucenacaio.structure.dto.CategoryDTO;
import br.com.lucenacaio.structure.exception.CategoryNotFoundException;
import br.com.lucenacaio.structure.mapper.CategoryMapper;
import br.com.lucenacaio.structure.repository.CategoryRepository;
import br.com.lucenacaio.structure.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Autowired
    CategoryServiceImpl(CategoryRepository categoryRepository){
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Page<CategoryDTO> getAll(PageRequest of) {
        return categoryRepository.findAll(of).map(CategoryMapper.INSTANCE::toDTO);
    }

    @Override
    public CategoryDTO getOne(int id) {
        return categoryRepository.findById(id)
                .map(CategoryMapper.INSTANCE:: toDTO)
                .orElseThrow(() -> new CategoryNotFoundException(id));
    }

    @Override
    public CategoryDTO save(CategoryDTO categoryDTO) {
        Category category = categoryRepository
                .save(CategoryMapper.INSTANCE.toEntity(categoryDTO));
        return CategoryMapper.INSTANCE.toDTO(category);
    }

    @Override
    public void delete(int id) {
        try{
            categoryRepository.deleteById(id);
        }catch (EmptyResultDataAccessException e){
            throw new CategoryNotFoundException(id);
        }
    }

    @Override
    public CategoryDTO update(int id, CategoryDTO categoryDTO) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new CategoryNotFoundException(id));
        category.setName(categoryDTO.getName());
        category = this.categoryRepository.save(category);
        return CategoryMapper.INSTANCE.toDTO(category);
    }
}
