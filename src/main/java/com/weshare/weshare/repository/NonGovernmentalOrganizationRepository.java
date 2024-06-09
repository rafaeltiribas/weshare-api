package com.weshare.weshare.repository;

import com.weshare.weshare.model.Category;
import com.weshare.weshare.model.NonGovernmentalOrganization;
import jakarta.persistence.LockModeType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface NonGovernmentalOrganizationRepository extends JpaRepository<NonGovernmentalOrganization, Long> {
    List<NonGovernmentalOrganization> findByCategory(Category category);

    @Query("select n from NonGovernmentalOrganization n " +
            "left outer join fetch n.category " +
            "order by n.id")
    List<NonGovernmentalOrganization> getNgosWithCategory();

    @Lock(LockModeType.PESSIMISTIC_WRITE)
    @Query("select n from NonGovernmentalOrganization n where n.id = :id")
    Optional<NonGovernmentalOrganization> getByIdWithLock(Long id);

    @Query(
            value = "select n from NonGovernmentalOrganization n " +
                    "left outer join fetch n.category " +
                    "where n.name like %:name% " +
                    "order by n.id",
            countQuery = "select count(n) " +
                    "from NonGovernmentalOrganization n " +
                    "where n.name like %:name% "
    )
    Page<NonGovernmentalOrganization> getNgosWithPages(String name, Pageable pageable);

    @Query("select n from NonGovernmentalOrganization n " +
            "left outer join fetch n.category " +
            "where n.id = :id")
    Optional<NonGovernmentalOrganization> getNgoById(Long id);
}
