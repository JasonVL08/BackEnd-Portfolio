package com.back.rest.port.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.back.rest.port.entity.Educacion;
import com.back.rest.port.repository.EducacionRepository;

@Service
public class EducacionServiceImpl implements EducacionService{

	@Autowired
	private EducacionRepository repo;
	
	@Override
	public Educacion insertaActualizaEducacion(Educacion obj) {
		return repo.save(obj);
	}

	@Override
	public void eliminaEducacion(int id) {
		repo.deleteById(id);
		
	}

	@Override
	public List<Educacion> listaEducacion() {
		return repo.findAll();
	}

}
