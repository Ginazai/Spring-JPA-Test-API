package com.dashboard.Services;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import com.dashboard.Entities.Product;
import com.dashboard.Entities.ProductCategory;

public interface ProductService {
	List<Product> listarProductos(); //get
	Product buscarPorId(Long id); //get
	Product agregarProducto(Product contenido); //post
	Product borrarProducto(Long id); //put
	Product actualizarProducto(Long id, Product contenidoEntidad); //put
	Product actualizarCategoria(Long id, Set<String> categories);
}