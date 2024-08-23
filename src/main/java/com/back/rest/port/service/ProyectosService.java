package com.back.rest.port.service;

import java.util.List;

import com.back.rest.port.entity.Proyectos;


public interface ProyectosService {

	
	public abstract Proyectos insertaActualizaProyecto(Proyectos obj);
	public abstract void eliminaProyecto(int id);
	public abstract List<Proyectos> listaProyecto();
}
