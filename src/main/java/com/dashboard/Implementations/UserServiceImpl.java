package com.dashboard.Implementations;

import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dashboard.Entities.Product;
import com.dashboard.Entities.Role;
import com.dashboard.Entities.User;
import com.dashboard.Exceptions.UserNotFoundException;
import com.dashboard.Repositories.RolesRepository;
import com.dashboard.Repositories.UserRepository;
import com.dashboard.Services.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private RolesRepository rolesRepository;

    @Override
    public User buscarPorUsername(String username) {
        return userRepository.findByUsername(username);
    }

	@Override
	public User buscarPorId(Long id) {
		return userRepository.findById(id).get();
	}

	@Override
	public void setActive(Long id, Boolean isIt) {
		User selectedUser = userRepository.getReferenceById(id);
		selectedUser.setActive(isIt);
	}

	@Override
	public List<User> listarUsuarios() {
		return userRepository.findAll();
	}

	@Override
	public User actualizarUsuario(Long id, User updatedUser) {
		User existingUser = userRepository.findById(id)
				.orElse(null);
		if (existingUser != null) {
			String newName = updatedUser.getName() != null ? updatedUser.getName() 
					: existingUser.getName();
			String newPassword= updatedUser.getPassword() != null ? updatedUser.getPassword() 
					: existingUser.getPassword();
			Boolean newActive = updatedUser.getActive() != null ? updatedUser.getActive()
					: existingUser.getActive();
			existingUser.setName(newName);
			existingUser.setPassword(newPassword);
			existingUser.setActive(newActive);
			return userRepository.save(existingUser);
		} else {return null;}
	}

	@Override
	public User borrarUsuario(Long id) {
		User user = userRepository.findById(id)
				.orElse(null);
		if(user!=null) {user.setActive(false); return user;}
		return null;
	}
	
	@Override
	@Transactional
	public User actualizarRoles(Long id, Set<String> newRoles) {
		User user = userRepository.findById(id)
				.orElseThrow(() -> new UserNotFoundException(id));
		if (newRoles == null || newRoles.isEmpty()) {
	        throw new IllegalArgumentException("Debe proporcionar al menos un rol.");
	    }		
		Set<Role> roles = newRoles.stream()
	            .map(role -> rolesRepository.findByName(role))
	            .filter(Objects::nonNull)
	            .collect(Collectors.toSet());
		if (roles.isEmpty()) {
	        throw new IllegalArgumentException("No se encontraron categorías válidas.");
	    }
		user.getRoles().clear();
		user.getRoles().addAll(roles);
		
		return userRepository.save(user);
	}
}
