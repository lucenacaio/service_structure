package br.com.lucenacaio.structure.controllers;

import br.com.lucenacaio.structure.dto.CategoryDTO;
import br.com.lucenacaio.structure.service.CategoryService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    private static final Logger LOGGER = Logger.getLogger(CategoryController.class);

    private final CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public ResponseEntity<Page<CategoryDTO>> getAll(@RequestParam(value = "page", defaultValue = "0") int page,
                                                    @RequestParam(value = "size", defaultValue = "10") int size){
        Page<CategoryDTO> categories = this.categoryService.getAll(PageRequest.of(page, size));
        return ResponseEntity.ok(categories);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryDTO> getOne(@PathVariable int id){
        CategoryDTO category = this.categoryService.getOne(id);
        return ResponseEntity.ok(category);
    }

    @PostMapping
    public ResponseEntity save(@RequestBody CategoryDTO categoryDTO){
        try {
            return new ResponseEntity<>(this.categoryService.save(categoryDTO), HttpStatus.CREATED);
        } catch (Exception e) {
            String message = "Error while trying to save a new Category.";
            LOGGER.error(message, e);
            return ResponseEntity.internalServerError().body(message);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable int id){
        this.categoryService.delete(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoryDTO> update(@PathVariable int id, @RequestBody CategoryDTO categoryDTO){
        return ResponseEntity.ok(this.categoryService.update(id, categoryDTO));
    }

}
