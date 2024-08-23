package com.back.rest.port.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.back.rest.port.entity.Perfil;
import com.back.rest.port.repository.PerfilRepository;

@Service
public class PerfilServiceImpl implements PerfilService{

	@Autowired
	private PerfilRepository repo;
	
	@Override
	public Perfil insertaActualizaPerfil(Perfil obj) {
		return repo.save(obj);
	}

	@Override
	public void eliminaPerfil(int id) {
		repo.deleteById(id);
		
	}

	@Override
	public List<Perfil> listaPerfil() {
		return repo.findAll();
	}

}
