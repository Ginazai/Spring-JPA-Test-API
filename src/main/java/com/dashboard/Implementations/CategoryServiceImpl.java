package com.dashboard.Implementations;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.stereotype.Service;
import com.dashboard.Entities.ProductCategory;
import com.dashboard.Exceptions.CategoryNotFoundException;
import com.dashboard.Repositories.CategoryRepository;
import com.dashboard.Services.CategoryService;
@Service
public class CategoryServiceImpl implements CategoryService {
	
	private final CategoryRepository categoryRepository;
	
	public CategoryServiceImpl(CategoryRepository categoryRepository) {
		this.categoryRepository = categoryRepository;
	}


	@Override
	public List<ProductCategory> listarCategorias() {
		return categoryRepository.findAll();
	}

	@Override
	public ProductCategory agregarCategoria(ProductCategory category) {
		LocalDateTime current_time = LocalDateTime.now();
		category.setCreate_date(current_time);
		category.setLast_update(current_time);
		return categoryRepository.save(category);
	}

	@Override
	public ProductCategory borrarCategoria(Long id) {
		ProductCategory category = categoryRepository.findById(id)
				.orElse(null);
		if(category!=null) {category.setActive(false); return category;}
		return null;
	}

	@Override
	public ProductCategory buscarPorId(Long id) {
		return categoryRepository.findById(id)
			      .orElseThrow(() -> new CategoryNotFoundException(id));
	}

	@Override
	public ProductCategory actualizarCategoria(Long id, ProductCategory updatedCategory) {
		ProductCategory existingCategory = categoryRepository.findById(id)
				.orElse(null);
		if (existingCategory != null) {
			LocalDateTime updated_time = LocalDateTime.now();
			String newName = updatedCategory.getName() != null ? updatedCategory.getName() 
					: existingCategory.getName();
			Boolean newActive = updatedCategory.getActive() != null ? updatedCategory.getActive()
					: existingCategory.getActive();
			existingCategory.setName(newName);
			existingCategory.setActive(newActive);
			existingCategory.setLast_update(updated_time);
			return categoryRepository.save(existingCategory);
		} else {return null;}
	}


	@Override
	public ProductCategory obtenerPorNombre(String categoria) {
		return categoryRepository.findByName(categoria);
	}

}
