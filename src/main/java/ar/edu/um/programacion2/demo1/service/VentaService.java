package ar.edu.um.programacion2.demo1.service;

import org.springframework.stereotype.Service;

@Service
public class VentaService implements Venta{
	
	@Override
	public String vende() {
		return "Vendido";
	}


}
