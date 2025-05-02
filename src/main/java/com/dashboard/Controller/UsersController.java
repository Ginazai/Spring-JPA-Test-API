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
import com.dashboard.Entities.User;
import com.dashboard.Services.UserService;

@RestController
public class UsersController {
	private final UserService userService;
	
	UsersController(UserService userService) {
	    this.userService = userService;
	  }
	
    @GetMapping("/usuarios")
    public List<User> listar(User user) {
    	return userService.listarUsuarios();
    }
    
    @GetMapping("/usuarios/{id}")
    public User obtenerUsuario(@PathVariable Long id) {
    	return userService.buscarPorId(id);
    }
    
    @PostMapping("/usuarios")
    public User agregarUsuario(@RequestBody User user) {
    	return userService.crearUsuario(user);
    }
    
    @PutMapping("/usuarios/{id}")
    public User actualizarUsuario(@PathVariable Long id, 
    		@RequestBody @Valid User user) {
    	return userService.actualizarUsuario(id, user);
    }
    
    @DeleteMapping("/usuarios/{id}")
    void borrarUsuario(@PathVariable Long id) {
    	userService.borrarUsuario(id);
    }    
}
