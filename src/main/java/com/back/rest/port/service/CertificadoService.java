package com.back.rest.port.service;

import java.util.List;

import com.back.rest.port.entity.Certificado;

public interface CertificadoService {
	
	public abstract Certificado insertaActualizaCertificado(Certificado obj);
	public abstract void eliminaCertificado(int id);
	public abstract List<Certificado> listaCertificado();

}
