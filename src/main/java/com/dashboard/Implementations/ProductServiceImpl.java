package com.dashboard.Implementations;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import com.dashboard.Exceptions.ProductNotFoundException;

import org.springframework.stereotype.Service;

import com.dashboard.DTOs.UpdateProductRequest;
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
<<<<<<< HEAD
		if(product!=null) {
			product.setActive(false); 
			return productRepository.save(product); 
		}
=======
		if(product!=null) {product.setActive(false); return product;}
>>>>>>> 21d727d9b5b8ac5cb3ae2a35f17456907075a0bf
		return null;
	}

	@Override
	public Product buscarPorId(Long id) {
		return productRepository.findById(id)
			      .orElseThrow(() -> new ProductNotFoundException(id));
	}

	@Override
	public Product actualizarProducto(Long id, UpdateProductRequest request) {
		Product existingProduct = productRepository.findById(id)
				.orElseThrow(() -> new ProductNotFoundException(id));
		LocalDateTime updated_time = LocalDateTime.now();
		String newName = request.getName() != null ? request.getName()
				: existingProduct.getName(); 
		float newPrice = (float) request.getPrice() != 0f ? request.getPrice()
				: existingProduct.getPrice();
		String newTags = request.getTags() != null ? request.getTags()
				: existingProduct.getTags();
		Boolean newActive = request.getActive() != null ? request.getActive()
				: existingProduct.getActive();
		existingProduct.setName(newName);
		existingProduct.setPrice(newPrice);
		existingProduct.setTags(newTags);
		existingProduct.setActive(newActive);
		existingProduct.setLast_update(updated_time);
		return productRepository.save(existingProduct);
		
	}
	
<<<<<<< HEAD
	public Set<ProductCategory> obtenerCategorias(Long id) {
		Product existingProduct = productRepository.findById(id)
				.orElseThrow(() -> new ProductNotFoundException(id));
		Set<ProductCategory> categories = existingProduct.getCategories();
		if (categories == null || categories.isEmpty()) {
			throw new IllegalArgumentException("El producto no tiene categorías asociadas.");
		}
		return categories.stream()
				.map(category -> categoryRepository.findById(category.getId())
						.orElseThrow(() -> new ProductNotFoundException(id)))
				.collect(Collectors.toSet());
	}
	
=======
>>>>>>> 21d727d9b5b8ac5cb3ae2a35f17456907075a0bf
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
