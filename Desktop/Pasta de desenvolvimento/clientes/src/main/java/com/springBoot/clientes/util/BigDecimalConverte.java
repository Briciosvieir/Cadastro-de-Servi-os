package com.springBoot.clientes.util;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class BigDecimalConverte {

	public BigDecimal converter(String value){
		value= value.replace(".","").replace(",",".");

		if (value == null){
			return null;
		}

		return new BigDecimal(value);
	}
}
