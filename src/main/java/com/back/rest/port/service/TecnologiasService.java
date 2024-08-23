package com.back.rest.port.service;

import java.util.List;

import com.back.rest.port.entity.Tecnologia;

public interface TecnologiasService {
	
	public abstract Tecnologia insertaActualizaTecnologias(Tecnologia obj);
	public abstract void eliminaTecnologia(int id);
	public abstract List<Tecnologia> listaTecnologia();

}
