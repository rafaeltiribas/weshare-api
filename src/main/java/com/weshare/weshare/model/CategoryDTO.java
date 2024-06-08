package com.weshare.weshare.model;

import java.util.List;

public record CategoryDTO (Long id, String name, List<NonGovernmentalOrganization> list) {
}
