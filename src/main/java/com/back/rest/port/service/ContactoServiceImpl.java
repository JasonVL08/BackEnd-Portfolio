package com.back.rest.port.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.back.rest.port.entity.Contacto;
import com.back.rest.port.repository.ContactoRepository;

@Service
public class ContactoServiceImpl implements ContactoService {

	@Autowired
	private ContactoRepository repo;
	
	@Override
	public Contacto insertaActualizaContacto(Contacto obj) {
		return repo.save(obj);
	}

	@Override
	public void eliminaContacto(int id) {
		repo.deleteById(id);
	}

	@Override
	public List<Contacto> listaContacto() {
		return repo.findAll();
	}

}
