package com.weshare.weshare.controller;

import com.weshare.weshare.exception.EntityNotFoundException;
import com.weshare.weshare.model.Category;
import com.weshare.weshare.model.CategoryDTO;
import com.weshare.weshare.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("http://localhost:5173")
@RestController
@RequestMapping("categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("{categoryId}")
    public Category getCategory(@PathVariable("categoryId") Long categoryId) {
        return categoryService.getCategory(categoryId)
                .orElseThrow(() -> new EntityNotFoundException(
                        "Category [" + categoryId + "] not found."));
    }

    @GetMapping("{categoryId}/ngos")          // http://localhost:8080/categorias/1/produtos
    public CategoryDTO getCategoryWithNgos(@PathVariable("categoryId") Long categoryId) {
        Category category = categoryService.getCategoryWithNgos(categoryId);
        return new CategoryDTO(category.getId(), category.getName(), category.getNgos());
    }
}
