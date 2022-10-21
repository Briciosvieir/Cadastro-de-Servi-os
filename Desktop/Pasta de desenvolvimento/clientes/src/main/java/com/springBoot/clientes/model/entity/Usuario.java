package com.springBoot.clientes.model.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.ControllerAdvice;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Data
@NoArgsConstructor
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(unique = true)
	@NotEmpty(message = "${campo.login.obrigatorio}")
	private String username;

	@Column
	@NotEmpty(message = "${campo.senha.obrigatorio}")
	private String password;
}
