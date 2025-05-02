package com.dashboard.Controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.dashboard.Entities.ProductCategory;
import com.dashboard.Services.CategoryService;

@RestController
public class CategoriesController {
	private final CategoryService categoryService;
	
	CategoriesController(CategoryService categoryService) {
	    this.categoryService = categoryService;
	  }
	
    @GetMapping("/categorias")
    public List<ProductCategory> listar() {
    	return categoryService.listarCategorias();
    }
    
    @GetMapping("/categorias/{id}")
    public ProductCategory obtenerCategoria(@PathVariable Long id) {
    	return categoryService.buscarPorId(id);
    }
    
    @PostMapping("/categorias")
    public ProductCategory agregarCategoria(@RequestBody ProductCategory categoria) {
    	return categoryService.agregarCategoria(categoria);
    }
    
    @PutMapping("/categorias/{id}")
    public ProductCategory actualizarProducto(@PathVariable Long id, 
    		@RequestBody @Valid ProductCategory categoria) {
    	return categoryService.actualizarCategoria(id, categoria);
    }
    
    @DeleteMapping("/categorias/{id}")
    ProductCategory borrar(@PathVariable Long id) {
    	return categoryService.borrarCategoria(id);
    }    
}
