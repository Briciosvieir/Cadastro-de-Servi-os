package com.springBoot.clientes.rest;


import com.springBoot.clientes.rest.exception.ApiErros;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class ApplicationControllerAdvice {

	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ApiErros handleValidationErros(MethodArgumentNotValidException ex){
		BindingResult bindingResult = ex.getBindingResult();
		List<String> messeges= bindingResult.getAllErrors()
				.stream().map(objectError -> objectError.getDefaultMessage())
				.collect(Collectors.toList());

		return new ApiErros(messeges);

	}

	@ExceptionHandler(ResponseStatusException.class)
	public ResponseEntity handleResponseStatusException (ResponseStatusException ex){
		String mensagemErro = ex.getReason();
		HttpStatus codigoStatus = ex.getStatus();
		ApiErros apiErros = new ApiErros(mensagemErro);
		return new ResponseEntity(apiErros, codigoStatus);
	}


}
