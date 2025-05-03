package com.dashboard.DTOs;

import java.util.Set;
import com.dashboard.Entities.ProductCategory;

public class UpdateProductCategories {
    private Set<String> categoryNames;
    public Set<String> getCategoryNames() {
        return categoryNames;
    }
    public void setCategoryNames(Set<String> categoryNames) {
        this.categoryNames = categoryNames;
    }
}
