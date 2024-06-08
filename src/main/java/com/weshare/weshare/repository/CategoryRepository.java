package com.weshare.weshare.repository;

import com.weshare.weshare.model.Category;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface CategoryRepository {
    @Query("select c from Category c left outer join fetch c.ngos where c.id = 1")
    Optional<Category> getCategoryWithNgosByCategoryId(Long id);
}
