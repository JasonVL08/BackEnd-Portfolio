package com.back.rest.port.service;

import java.util.List;

import com.back.rest.port.entity.Contacto;

public interface ContactoService {
	
	public abstract Contacto insertaActualizaContacto(Contacto obj);
	public abstract void eliminaContacto(int id);
	public abstract List<Contacto> listaContacto();

}
