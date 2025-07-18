package com.dashboard.Controller;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;

import com.dashboard.DTOs.UpdateProductCategories;
import com.dashboard.DTOs.UpdateProductRequest;
import com.dashboard.Entities.Product;
import com.dashboard.Entities.ProductCategory;
import com.dashboard.Services.ProductService;

import javax.validation.Valid;

@RestController
public class ProductsController {
	
	private final ProductService productService;
	
	ProductsController(ProductService productService) {
	    this.productService = productService;
	  }
	
    @GetMapping("/productos")
    public List<Product> listar() {
    	return productService.listarProductos();
    }
    
    @GetMapping("/productos/{id}")
    public Product obtenerProducto(@PathVariable Long id) {
    	return productService.buscarPorId(id);
    }
    
    @PostMapping("/productos")
    public Product agregar(@RequestBody @Valid Product product) {
    	return productService.agregarProducto(product);
    }
    
    @PutMapping("/productos/{id}")
    public ResponseEntity<Product> actualizarProducto(@PathVariable Long id, 
    		@RequestBody @Valid UpdateProductRequest request) {
    	return ResponseEntity.ok(productService.actualizarProducto(id, request));
    }
    
    @PutMapping("/productos/{id}/categorias")
    public ResponseEntity<Product> actualizarCategorias(@PathVariable Long id, 
    		@RequestBody @Valid UpdateProductCategories productCategories) {
    	Product updatedProduct = productService.actualizarCategoria(id, productCategories.getCategories());
    	return ResponseEntity.ok(updatedProduct);
    }
    
    @GetMapping("/productos/{id}/categorias")
    public Set<ProductCategory> obtenerCategoriasPorProductoId(@PathVariable Long id) {
		return productService.obtenerCategorias(id);
	}
    
    @DeleteMapping("/productos/{id}")
    Product borrar(@PathVariable Long id) {
    	return productService.borrarProducto(id);
    }    
}
