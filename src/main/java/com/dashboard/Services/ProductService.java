package com.dashboard.Services;

import java.util.List;
import java.util.Set;
import com.dashboard.DTOs.UpdateProductRequest;
import com.dashboard.Entities.Product;
<<<<<<< HEAD
import com.dashboard.Entities.ProductCategory;
=======
>>>>>>> 21d727d9b5b8ac5cb3ae2a35f17456907075a0bf

public interface ProductService {
	List<Product> listarProductos(); //get
	Product buscarPorId(Long id); //get
	Product agregarProducto(Product contenido); //post
	Product borrarProducto(Long id); //put
	Product actualizarCategoria(Long id, Set<String> categories); //put
	Product actualizarProducto(Long id, UpdateProductRequest requestData);
<<<<<<< HEAD
	Set<ProductCategory> obtenerCategorias(Long id); //get
=======
>>>>>>> 21d727d9b5b8ac5cb3ae2a35f17456907075a0bf
}