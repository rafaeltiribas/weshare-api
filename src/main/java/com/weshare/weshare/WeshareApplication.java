package com.weshare.weshare;

import com.weshare.weshare.model.Category;
import com.weshare.weshare.model.NonGovernmentalOrganization;
import com.weshare.weshare.repository.CategoryRepository;
import com.weshare.weshare.repository.NonGovernmentalOrganizationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

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

		Category child = new Category("Child");
		categoryRepository.save(child);

		Category education = new Category("Education");
		categoryRepository.save(education);

		Category environment = new Category("Environment");
		categoryRepository.save(environment);

		Category food = new Category("Food");
		categoryRepository.save(food);

		Category health = new Category("Health");
		categoryRepository.save(health);

		NonGovernmentalOrganization ngo = new NonGovernmentalOrganization(
				"ias.png",
				"Instituto Ayrton Senna",
				"The Instituto Ayrton Senna promotes comprehensive education by means of research," +
						" teacher training and innovative projects.",
				LocalDate.of(2023, 4, 26),
				education);
		nonGovernmentalOrganizationRepository.save(ngo);

		ngo = new NonGovernmentalOrganization(
				"greenpeace.png",
				"Greenpeace",
				"Greenpeace investigates, documents and exposes the causes of environmental destruction.",
				LocalDate.of(2023, 4, 27),
				environment);
		nonGovernmentalOrganizationRepository.save(ngo);

		ngo = new NonGovernmentalOrganization(
				"msf.png",
				"Doctors Without Borders",
				"an international humanitarian organisation that provides " +
						"consistently neutral and impartial medical support in diverse crises.",
				LocalDate.of(2023, 4, 28),
				health);
		nonGovernmentalOrganizationRepository.save(ngo);

		ngo = new NonGovernmentalOrganization(
				"fam.png",
				"Feeding America",
				"Feeding America is a nonprofit network of 200 " +
						"food banks leading the fight against hunger in the United States",
				LocalDate.of(2023, 4, 24),
				food);
		nonGovernmentalOrganizationRepository.save(ngo);

		ngo = new NonGovernmentalOrganization(
				"caramelo.png",
				"Caramelo Institute",
				"The Caramelo Institute is a Brazilian organization that provides support to " +
						"children and young people in situations of social vulnerability, promoting " +
						"education, culture, and personal development.",
				LocalDate.of(2023, 4, 21),
				child);
		nonGovernmentalOrganizationRepository.save(ngo);

		ngo = new NonGovernmentalOrganization(
				"graac.png",
				"GRAACC",
				"\n" +
						"GRAACC is a Brazilian NGO dedicated to the treatment and research of childhood cancer, " +
						"providing specialized medical care and support to affected families.",
				LocalDate.of(2023, 4, 20),
				health);
		nonGovernmentalOrganizationRepository.save(ngo);
	}
}

