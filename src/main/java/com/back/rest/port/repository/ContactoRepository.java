package com.back.rest.port.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.back.rest.port.entity.Contacto;

public interface ContactoRepository extends JpaRepository<Contacto, Integer>{

}
