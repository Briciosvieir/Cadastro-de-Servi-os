package com.springBoot.clientes.model.repository;

import com.springBoot.clientes.model.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotEmpty;
import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

	@Query
	boolean existsByUsername(@NotEmpty(message = "{campo.login.obrigatorio}") String username);
	Optional<Usuario> findByUsername(String username);
}
