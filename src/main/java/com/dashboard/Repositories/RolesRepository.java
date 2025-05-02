package com.dashboard.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dashboard.Entities.Product;
import com.dashboard.Entities.Role;

public interface RolesRepository extends JpaRepository<Product, Long> {
	Role findByName(String role);
}
