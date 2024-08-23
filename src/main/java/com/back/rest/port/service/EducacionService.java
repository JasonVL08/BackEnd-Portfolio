package com.back.rest.port.service;

import java.util.List;

import com.back.rest.port.entity.Educacion;

public interface EducacionService {
	
	public abstract Educacion insertaActualizaEducacion(Educacion obj);
	public abstract void eliminaEducacion (int id);
	public abstract List<Educacion> listaEducacion();

}
