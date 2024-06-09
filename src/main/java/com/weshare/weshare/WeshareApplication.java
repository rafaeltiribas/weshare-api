package com.weshare.weshare;

import com.weshare.weshare.model.Category;
import com.weshare.weshare.model.NonGovernmentalOrganization;
import com.weshare.weshare.repository.CategoryRepository;
import com.weshare.weshare.repository.NonGovernmentalOrganizationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;
import java.time.LocalDate;

@SpringBootApplication
public class WeshareApplication implements CommandLineRunner {

	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private NonGovernmentalOrganizationRepository nonGovernmentalOrganizationRepository;

	public static void main(String[] args) {
		SpringApplication.run(WeshareApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Category animal = new Category("Animal");
		categoryRepository.save(animal);

		NonGovernmentalOrganization ngo = new NonGovernmentalOrganization(
				"ias.png",
				"Instituo Ayrton Senna",
				"Child Care",
				LocalDate.of(2023, 4, 26),
				animal);
		nonGovernmentalOrganizationRepository.save(ngo);
	}
}
