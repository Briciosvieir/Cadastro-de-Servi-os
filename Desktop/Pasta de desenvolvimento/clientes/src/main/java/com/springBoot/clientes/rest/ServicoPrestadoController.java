package com.springBoot.clientes.rest;

import com.springBoot.clientes.model.entity.Cliente;
import com.springBoot.clientes.model.entity.ServicoPrestado;
import com.springBoot.clientes.model.repository.ClienteRepository;
import com.springBoot.clientes.model.repository.ServicoPrestadoRepository;
import com.springBoot.clientes.rest.dto.ServicoPrestadoDTO;
import com.springBoot.clientes.util.BigDecimalConverte;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/servicos-prestados")
@RequiredArgsConstructor
public class ServicoPrestadoController {

	private final ClienteRepository clienteRepository;
	private final ServicoPrestadoRepository servicoPrestadoRepository;
	private final BigDecimalConverte bigDecimalConverte;



	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ServicoPrestado salvar(@RequestBody @Valid ServicoPrestadoDTO dto){
		LocalDate data = LocalDate.parse(dto.getData(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		Integer idCliente = dto.getIdCliente();
		Optional<Cliente> clienteOption = clienteRepository.findById(idCliente);
		Cliente cliente = clienteOption.orElseThrow(()->new ResponseStatusException(HttpStatus.BAD_REQUEST, "Cliente inexistente"));

		ServicoPrestado servicoPrestado = new ServicoPrestado();
		servicoPrestado.setDescricao(dto.getDescricao());
		servicoPrestado.setData(data);
		servicoPrestado.setCliente(cliente);
		servicoPrestado.setValor(bigDecimalConverte.converter(dto.getPreco()));

		return servicoPrestadoRepository.save(servicoPrestado);

	}

	@GetMapping
	public List<ServicoPrestado> pesquisarServicoPrestado(
			@RequestParam( value = "name", required = false, defaultValue = "") String name,
			@RequestParam(value = "mes", required = false) Integer mes) {


		return servicoPrestadoRepository.findByNomeClienteAndMes("%" + name+ "%", mes);
	}


}
