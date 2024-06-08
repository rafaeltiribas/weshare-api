package com.weshare.weshare.service;

import com.weshare.weshare.exception.EntityNotFoundException;
import com.weshare.weshare.model.Category;
import com.weshare.weshare.repository.CategoryRepository;
import com.weshare.weshare.repository.NonGovernmentalOrganizationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private NonGovernmentalOrganizationRepository ngoRepository;

    public Optional<Category> getCategory(Long categoryId) {
        return categoryRepository.findById(categoryId);
    }

    public Category getCategoryWithNgos(Long categoryId) {
        return categoryRepository.getCategoryWithNgosByCategoryId(categoryId)
                .orElseThrow(() -> new EntityNotFoundException(
                        "Category [" + categoryId + "] not found."));
    }
}
