package com.dashboard.Implementations;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.dashboard.Entities.Product;
import com.dashboard.Entities.User;
import com.dashboard.Repositories.UserRepository;
import com.dashboard.Services.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    //@Autowired
    //private PasswordEncoder passwordEncoder;

    @Override
    public User buscarPorUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public User crearUsuario(User user) {
        // Codificar contraseña antes de guardar
        //user.setPassword(passwordEncoder.encode(user.getPassword()));
    	user.setPassword(user.getPassword());
        user.setCreate_date(java.time.LocalDateTime.now());
        return userRepository.save(user);
    }

	@Override
	public User buscarPorId(Long id) {
		return userRepository.getReferenceById(id);
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
	public void borrarUsuario(Long id) {
		userRepository.getReferenceById(id).setActive(false);
	}
}
