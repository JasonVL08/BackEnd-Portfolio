package com.back.rest.port.service;

import java.util.List;

import com.back.rest.port.entity.Perfil;

public interface PerfilService {

	public abstract Perfil insertaActualizaPerfil(Perfil obj);
	public abstract void eliminaPerfil(int id);
	public abstract List<Perfil> listaPerfil();
}
