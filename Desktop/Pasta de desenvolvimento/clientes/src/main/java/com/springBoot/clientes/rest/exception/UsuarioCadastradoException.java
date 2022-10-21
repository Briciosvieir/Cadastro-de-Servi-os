package com.springBoot.clientes.rest.exception;

public class UsuarioCadastradoException extends RuntimeException {

	public UsuarioCadastradoException( String  login){
		super("Usuario já cadastrado para o Login "+login);
	}
}
