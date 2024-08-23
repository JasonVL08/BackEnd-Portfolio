package com.back.rest.port.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.back.rest.port.entity.Proyectos;
import com.back.rest.port.repository.ProyectosRepository;

@Service
public class ProyectosServiceImpl implements ProyectosService{

	@Autowired
	private ProyectosRepository repo;
	
	@Override
	public Proyectos insertaActualizaProyecto(Proyectos obj) {
		return repo.save(obj);
	}

	@Override
	public void eliminaProyecto(int id) {
		repo.deleteById(id);
		
	}

	@Override
	public List<Proyectos> listaProyecto() {
		return repo.findAll();
	}

}
