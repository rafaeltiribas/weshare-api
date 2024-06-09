package com.weshare.weshare.service;


import com.weshare.weshare.exception.DEntityException;
import com.weshare.weshare.exception.EntityNotFoundException;
import com.weshare.weshare.exception.TransientEntityException;
import com.weshare.weshare.model.Category;
import com.weshare.weshare.model.NonGovernmentalOrganization;
import com.weshare.weshare.repository.NonGovernmentalOrganizationRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NonGovernmentalOrganizationService {

    @Autowired
    private NonGovernmentalOrganizationRepository nonGovernmentalOrganizationRepository;

    public List<NonGovernmentalOrganization> getNgos() {
        return nonGovernmentalOrganizationRepository.getNgosWithCategory();
    }

    public NonGovernmentalOrganization insertNgo(NonGovernmentalOrganization ngo) {
        if (ngo.getId() == null) {
            return nonGovernmentalOrganizationRepository.save(ngo);
        }
        else {
            throw new DEntityException(
                    "DEntity Exception.");
        }
    }

    @Transactional
    public NonGovernmentalOrganization updateNgo(NonGovernmentalOrganization ngo) {
        if (ngo.getId() == null) {
            throw new TransientEntityException("Trying to update non-go ngo.");
        }
        else {
            nonGovernmentalOrganizationRepository.getByIdWithLock(ngo.getId())
                    .orElseThrow(() -> new EntityNotFoundException(
                            "Non-Governmental Organization [" + ngo.getId() + "] not found."));
            return nonGovernmentalOrganizationRepository.save(ngo);
        }
    }

    public NonGovernmentalOrganization deleteNgo(Long id) {
        NonGovernmentalOrganization n = nonGovernmentalOrganizationRepository.getNgoById(id)
                .orElseThrow(() -> new EntityNotFoundException(
                        "Non-Governmental Organization [" + id + "] not found."));
        nonGovernmentalOrganizationRepository.delete(n);
        return n;
    }

    public List<NonGovernmentalOrganization> getNgoByCategoryId(Category category) {
        return nonGovernmentalOrganizationRepository.findByCategory(category);
    }

    public List<NonGovernmentalOrganization> getNgosWithCategory() {
        // return produtoRepository.findAll();
        return nonGovernmentalOrganizationRepository.getNgosWithCategory();
    }

    public Page<NonGovernmentalOrganization> getNgosWithPages(String name, Pageable pageable) {
        return nonGovernmentalOrganizationRepository.getNgosWithPages(name, pageable);
    }
}
