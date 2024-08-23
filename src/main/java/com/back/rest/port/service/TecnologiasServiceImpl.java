package com.back.rest.port.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.back.rest.port.entity.Tecnologia;
import com.back.rest.port.repository.TecnologiasRepository;

@Service
public class TecnologiasServiceImpl implements TecnologiasService{

	
	@Autowired
	private TecnologiasRepository repo;
	
	@Override
	public Tecnologia insertaActualizaTecnologias(Tecnologia obj) {
		return repo.save(obj);
	}

	@Override
	public void eliminaTecnologia(int id) {
		repo.deleteById(id);
		
	}

	@Override
	public List<Tecnologia> listaTecnologia() {
		return repo.findAll();
	}

	
	
}
