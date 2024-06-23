package com.weshare.weshare.controller;

import com.weshare.weshare.model.Category;
import com.weshare.weshare.model.NonGovernmentalOrganization;
import com.weshare.weshare.model.PageResult;
import com.weshare.weshare.service.NonGovernmentalOrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("http://localhost:5173")
@RestController
@RequestMapping("ngos")
public class NonGovernmentalOrganizationController {

    @Autowired
    private NonGovernmentalOrganizationService nonGovernmentalOrganizationService;

    @GetMapping   // http://localhost:8080/produtos
    public List<NonGovernmentalOrganization> getNgos() {
        return nonGovernmentalOrganizationService.getNgos();
    }

    @PostMapping   // http://localhost:8080/produtos
    public NonGovernmentalOrganization insertNgo(@RequestBody NonGovernmentalOrganization ngo) {
        return nonGovernmentalOrganizationService.insertNgo(ngo);
    }

    @PutMapping
    public ResponseEntity<NonGovernmentalOrganization> updateNgo(@RequestBody NonGovernmentalOrganization ngo) {
        NonGovernmentalOrganization aNgo = nonGovernmentalOrganizationService.updateNgo(ngo);
        return new ResponseEntity<NonGovernmentalOrganization>(aNgo, HttpStatus.OK);
    }

    @DeleteMapping ("{ngoId}")     // http://localhost:8080/produtos/1
    public NonGovernmentalOrganization deleteNgo(@PathVariable("ngoId") Long id) {
        return nonGovernmentalOrganizationService.deleteNgo(id);
    }

    @GetMapping("category/{byid}")             // http://localhost:8080/produtos/categoria/1
    public List<NonGovernmentalOrganization> getNgoByCategoryId(@PathVariable("byid") Long byId)  {
        System.out.println(byId);
        return nonGovernmentalOrganizationService.getNgoByCategoryId(byId);
    }

    @GetMapping("categories")    // http://localhost:8080/produtos/categorias
    public List<NonGovernmentalOrganization> getNgoWithCategory() {
        return nonGovernmentalOrganizationService.getNgosWithCategory();
    }

    @GetMapping("page")
    public PageResult<NonGovernmentalOrganization> getNgosWithPages(
            @RequestParam(value = "page", defaultValue = "0") int pages,
            @RequestParam(value = "size", defaultValue = "3") int size,
            @RequestParam(value = "name", defaultValue = "") String name) {
        Pageable pageable = PageRequest.of(pages, size);
        Page<NonGovernmentalOrganization> page = nonGovernmentalOrganizationService.getNgosWithPages(name, pageable);
        PageResult<NonGovernmentalOrganization> pageResult = new PageResult<>(
                page.getTotalElements(),
                page.getTotalPages(),
                page.getNumber(),
                page.getContent());
        return pageResult;
    }
}
