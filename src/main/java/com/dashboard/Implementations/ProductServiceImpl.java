package com.dashboard.Implementations;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import com.dashboard.Exceptions.ProductNotFoundException;

import org.springframework.stereotype.Service;

import com.dashboard.Entities.Product;
import com.dashboard.Entities.ProductCategory;
import com.dashboard.Repositories.CategoryRepository;
import com.dashboard.Repositories.ProductRepository;
import com.dashboard.Services.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
	
	private final ProductRepository productRepository;
	private final CategoryRepository categoryRepository;
	
	public ProductServiceImpl(ProductRepository productRepository, 
			CategoryRepository categoryRepository) {
		this.productRepository = productRepository;
		this.categoryRepository = categoryRepository;
	}

	@Override
	public List<Product> listarProductos() {
		return productRepository.findAll();
	}

	@Override
	public Product agregarProducto(Product producto) {
		LocalDateTime current_time = LocalDateTime.now();
		producto.setCreate_date(current_time);
		producto.setLast_update(current_time);
		return productRepository.save(producto);
	}

	@Override
	public Product borrarProducto(Long id) {
		Product product = productRepository.findById(id)
				.orElse(null);
		if(product!=null) {product.setActive(false); return product;}
		return null;
	}

	@Override
	public Product buscarPorId(Long id) {
		return productRepository.findById(id)
			      .orElseThrow(() -> new ProductNotFoundException(id));
	}

	@Override
	public Product actualizarProducto(Long id, Product updatedProduct) {
		Product existingProduct = productRepository.findById(id)
				.orElseThrow(() -> new ProductNotFoundException(id));
		if (existingProduct != null) {
			LocalDateTime updated_time = LocalDateTime.now();
			String newName = updatedProduct.getName() != null ? updatedProduct.getName()
					: existingProduct.getName(); 
			float newPrice = (float) updatedProduct.getPrice() != 0f ? updatedProduct.getPrice()
					: existingProduct.getPrice();
			String newTags = updatedProduct.getTags() != null ? updatedProduct.getTags()
					: existingProduct.getTags();
			Boolean newActive = updatedProduct.getActive() != null ? updatedProduct.getActive()
					: existingProduct.getActive();
			existingProduct.setName(newName);
			existingProduct.setPrice(newPrice);
			existingProduct.setTags(newTags);
			existingProduct.setActive(newActive);
			existingProduct.setLast_update(updated_time);
			return productRepository.save(existingProduct);
		} else {return null;}
	}
	
	@Override
	@Transactional
	public Product actualizarCategoria(Long id, Set<String> newCategories) {
		Product existingProduct = productRepository.findById(id)
				.orElseThrow(() -> new ProductNotFoundException(id));
		if (newCategories == null || newCategories.isEmpty()) {
	        throw new IllegalArgumentException("Debe proporcionar al menos una categoría.");
	    }		
		Set<ProductCategory> categories = newCategories.stream()
	            .map(name -> categoryRepository.findByName(name))
	            .filter(Objects::nonNull)
	            .collect(Collectors.toSet());
		if (categories.isEmpty()) {
	        throw new IllegalArgumentException("No se encontraron categorías válidas.");
	    }
		//Limpiar relaciones anteriores
		existingProduct.getCategories().clear();
	    //Asociar nuevas categorías
		existingProduct.getCategories().addAll(categories);
		
		return productRepository.save(existingProduct);
	}
}
