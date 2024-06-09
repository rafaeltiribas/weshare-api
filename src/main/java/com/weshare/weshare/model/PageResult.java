package com.weshare.weshare.model;

import java.util.List;

public record PageResult<T>(
        long totalItems,
        int totalPages,
        int currentPage,
        List<T> items
) {
}
