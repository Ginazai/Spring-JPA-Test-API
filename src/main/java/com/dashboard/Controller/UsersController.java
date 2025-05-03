package com.dashboard.Controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.dashboard.DTOs.RegisterResponse;
import com.dashboard.DTOs.UpdateUserRoles;
import com.dashboard.DTOs.RegisterRequest;
import com.dashboard.Entities.User;
import com.dashboard.Services.UserService;

@RestController
public class UsersController {
	private final UserService userService;
	
	@Autowired
	private RegisterResponse response;
	
	UsersController(UserService userService) {
	    this.userService = userService;
	  }
	
    @GetMapping("/usuarios")
    public List<User> listar(User user) {
    	return userService.listarUsuarios();
    }
    
    @GetMapping("/usuarios/{id}")
    public ResponseEntity<User> obtenerUsuario(@PathVariable Long id) {
    	return ResponseEntity.ok(userService.buscarPorId(id));
    }
    
    @PostMapping("/usuarios")
    public  ResponseEntity<User> agregarUsuario(@RequestBody RegisterRequest request) {
    	User user = response.register(request);
    	return ResponseEntity.ok(user);
    }
    
    @PutMapping("/usuarios/{id}")
    public User actualizarUsuario(@PathVariable Long id, 
    		@RequestBody @Valid User user) {
    	return userService.actualizarUsuario(id, user);
    }
    
    @PutMapping("/usuarios/{id}/roles")
    public ResponseEntity<User> actualizarCategorias(@PathVariable Long id, 
    		@RequestBody @Valid UpdateUserRoles updatedRoles) {
    	User updatedUser = userService.actualizarRoles(id, updatedRoles.getRoleNames());
    	return ResponseEntity.ok(updatedUser);
    } 
    
    @DeleteMapping("/usuarios/{id}")
    public ResponseEntity<User> borrarUsuario(@PathVariable Long id) {
    	return ResponseEntity.ok(userService.borrarUsuario(id));
    }    
}
