package com.dashboard.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dashboard.Entities.Product;
import com.dashboard.Entities.User;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{
}
