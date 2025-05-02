package com.dashboard.Services;

import com.dashboard.Entities.User;
import java.util.List;
import java.util.Set;

public interface UserService {
	User buscarPorUsername(String username); //Get
    User buscarPorId(Long id); //Get
    User crearUsuario(User user); //Post
    List<User> listarUsuarios(); //Get
    User actualizarUsuario(Long id, User user); //put
    void borrarUsuario(Long id); //delete
    void setActive(Long id, Boolean isIt); //Put
    User actualizarRoles(Long id, Set<String> roles); //put
}
