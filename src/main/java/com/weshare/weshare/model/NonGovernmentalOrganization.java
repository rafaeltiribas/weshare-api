package com.weshare.weshare.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@ToString
@Getter
@Setter
@NoArgsConstructor
@Entity
public class NonGovernmentalOrganization {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "[MISSING IMAGE].")
    private String image;

    @NotEmpty(message = "[MISSING NAME].")
    private String name;

    @NotEmpty(message = "[MISSING DESCRIPTION]")
    private String description;

    @NotNull(message = "[SIGN UP DATE]")
    private LocalDate signupDate;

    @ManyToOne
    private Category category;

    public NonGovernmentalOrganization(final String image,
                                       final String name,
                                       final String description,
                                       final LocalDate signupDate,
                                       final Category category) {
        this.image = image;
        this.name = name;
        this.description = description;
        this.signupDate = signupDate;
        this.category = category;
    }
}
