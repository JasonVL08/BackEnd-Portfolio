package com.back.rest.port.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.back.rest.port.entity.Certificado;

public interface CertificadoRepository extends JpaRepository<Certificado, Integer> {

}
