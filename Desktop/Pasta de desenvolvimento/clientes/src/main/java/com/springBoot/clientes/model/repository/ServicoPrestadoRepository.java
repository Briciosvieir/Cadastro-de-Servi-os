package com.springBoot.clientes.model.repository;

import com.springBoot.clientes.model.entity.ServicoPrestado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ServicoPrestadoRepository extends JpaRepository<ServicoPrestado, Integer> {

	@Query("select s from ServicoPrestado s join s.cliente c "+
			"where upper( c.name ) like upper(:name ) and MONTH (s.data) = :mes")
	List<ServicoPrestado> findByNomeClienteAndMes(@Param("name") String name, @Param("mes") Integer mes);
}
