package com.dashboard.Repositories;

<<<<<<< HEAD
import java.util.List;
=======
>>>>>>> 21d727d9b5b8ac5cb3ae2a35f17456907075a0bf
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dashboard.Entities.ProductCategory;
@Repository
public interface CategoryRepository extends JpaRepository<ProductCategory, Long> {
	ProductCategory findByName(String nombre);
}
