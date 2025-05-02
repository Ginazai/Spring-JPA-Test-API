package com.dashboard.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.dashboard.Entities.ProductCategory;

public interface CategoryService {
	List<ProductCategory> listarCategorias(); //get
	ProductCategory buscarPorId(Long id); //get
	ProductCategory agregarCategoria(ProductCategory contenido); //post
	ProductCategory borrarCategoria(Long id); //put
	ProductCategory actualizarCategoria(Long id, ProductCategory contenidoEntidad); //put
	ProductCategory obtenerPorNombre(String categoria);
}
