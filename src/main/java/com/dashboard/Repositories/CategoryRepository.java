package com.dashboard.Repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dashboard.Entities.ProductCategory;
@Repository
public interface CategoryRepository extends JpaRepository<ProductCategory, Long> {
	ProductCategory findByName(String nombre);
}
