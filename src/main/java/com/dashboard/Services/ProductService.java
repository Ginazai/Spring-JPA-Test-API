package com.dashboard.Services;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import com.dashboard.DTOs.UpdateProductRequest;
import com.dashboard.Entities.Product;
import com.dashboard.Entities.ProductCategory;

public interface ProductService {
	List<Product> listarProductos(); //get
	Product buscarPorId(Long id); //get
	Product agregarProducto(Product contenido); //post
	Product borrarProducto(Long id); //put
	Product actualizarCategoria(Long id, Set<String> categories); //put
	Product actualizarProducto(UpdateProductRequest requestData);
}