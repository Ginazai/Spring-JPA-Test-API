package com.dashboard.DTOs;

import java.util.Set;
import com.dashboard.Entities.ProductCategory;

public class UpdateProductCategories {
    private Set<String> categories;
    public Set<String> getCategories() {
        return categories;
    }
    public void setCategories(Set<String> categories) {
        this.categories = categories;
    }
}
