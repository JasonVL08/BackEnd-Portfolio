package com.back.rest.port.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.back.rest.port.entity.Certificado;
import com.back.rest.port.service.CertificadoService;
import com.back.rest.port.utils.AppSettings;

@RestController
@RequestMapping("url/certificado")
@CrossOrigin(AppSettings.URL_CROSS_ORIGIN)
public class CertificadoController {

	@Autowired
	private CertificadoService certificadoService;
	
	@GetMapping("/listarCertificado")
	public ResponseEntity<List<Certificado>> lista(){
		List<Certificado> lstSalida = certificadoService.listaCertificado();
		return ResponseEntity.ok(lstSalida);
	}
	
	
	@PostMapping("/registraCertificado")
	@ResponseBody
	public ResponseEntity<?> insertaCertificado(@RequestBody Certificado obj){
		Map<String, Object> salida = new HashMap<>();
		try {
			obj.setId(0);
			Certificado objSalida = certificadoService.insertaActualizaCertificado(obj);
			if (objSalida == null) {
				salida.put("mensaje", AppSettings.MENSAJE_REG_ERROR);
			} else {
				salida.put("mensaje", AppSettings.MENSAJE_REG_EXITOSO);
			}
	} catch (Exception e) {
		e.printStackTrace();
		salida.put("mensaje", AppSettings.MENSAJE_REG_ERROR);
	}
	return ResponseEntity.ok(salida);
	}
	
	@PutMapping("/actualizaCertificado")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> actualizaCertificado(@RequestBody Certificado obj){
		Map<String, Object> salida = new HashMap<>();
		try {
			Certificado objSalida = certificadoService.insertaActualizaCertificado(obj);
			if (objSalida == null) {
				salida.put("mensaje", AppSettings.MENSAJE_ACT_ERROR);
			} else {
				salida.put("mensaje", AppSettings.MENSAJE_ACT_EXITOSO + " Certificado de ID ==> " + obj.getId() + "...");
			}
		} catch (Exception e) {
			e.printStackTrace();
			salida.put("mensaje", AppSettings.MENSAJE_ACT_ERROR);
		}
		return ResponseEntity.ok(salida);
	}
	
	@DeleteMapping("/eliminaCertificado/{id}")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> eliminaCertificado(@PathVariable("id") int id) {
		Map<String, Object> salida = new HashMap<>();
		try {
			certificadoService.eliminaCertificado(id);
			salida.put("mensaje", AppSettings.MENSAJE_ELI_EXITOSO + " Certificado de ID ==> " + id + "." );
		} catch (Exception e) {
			e.printStackTrace();
			salida.put("mensaje", AppSettings.MENSAJE_ELI_ERROR);
		}
		return ResponseEntity.ok(salida);
	}
	
	
}
