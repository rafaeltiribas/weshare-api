package com.weshare.weshare.model;

import java.time.LocalDate;

public record NonGovernmentalOrganizationDTO(Long id,
                                             String image,
                                             String name,
                                             String description,
                                             LocalDate signup,
                                             Category category) {
}
