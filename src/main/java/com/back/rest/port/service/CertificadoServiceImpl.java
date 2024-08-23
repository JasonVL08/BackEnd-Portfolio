package com.back.rest.port.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.back.rest.port.entity.Certificado;
import com.back.rest.port.repository.CertificadoRepository;

@Service
public class CertificadoServiceImpl implements CertificadoService{

	@Autowired
	private CertificadoRepository repo;

	
	@Override
	public Certificado insertaActualizaCertificado(Certificado obj) {
		return repo.save(obj);
	}

	@Override
	public void eliminaCertificado(int id) {
		repo.deleteById(id);
	}

	@Override
	public List<Certificado> listaCertificado() {
		return repo.findAll();
	}

}
