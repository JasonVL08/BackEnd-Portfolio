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

import com.back.rest.port.entity.Perfil;
import com.back.rest.port.service.PerfilService;
import com.back.rest.port.utils.AppSettings;

@RestController
@RequestMapping("url/perfil")
@CrossOrigin(AppSettings.URL_CROSS_ORIGIN)
public class PerfilController {

	
	@Autowired
	private PerfilService perfilService;
	
	@GetMapping("/listarPerfil")
	public ResponseEntity<List<Perfil>> lista(){
		List<Perfil> lstSalida = perfilService.listaPerfil();
		return ResponseEntity.ok(lstSalida);
	}
	
	
	@PostMapping("/registraPerfil")
	@ResponseBody
	public ResponseEntity<?> insertaPerfil(@RequestBody Perfil obj){
		Map<String, Object> salida = new HashMap<>();
		try {
			obj.setId(0);
			Perfil objSalida =  perfilService.insertaActualizaPerfil(obj);
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
	
	@PutMapping("/actualizaPerfil")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> actualizaPerfil(@RequestBody Perfil obj){
		Map<String, Object> salida = new HashMap<>();
		try {
			Perfil objSalida = perfilService.insertaActualizaPerfil(obj);
			if (objSalida == null) {
				salida.put("mensaje", AppSettings.MENSAJE_ACT_ERROR);
			} else {
				salida.put("mensaje", AppSettings.MENSAJE_ACT_EXITOSO + " Perfil de ID ==> " + obj.getId() + "...");
			}
		} catch (Exception e) {
			e.printStackTrace();
			salida.put("mensaje", AppSettings.MENSAJE_ACT_ERROR);
		}
		return ResponseEntity.ok(salida);
	}
	
	@DeleteMapping("/eliminaPerfil/{id}")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> eliminaPerfil(@PathVariable("id") int id) {
		Map<String, Object> salida = new HashMap<>();
		try {
			perfilService.eliminaPerfil(id);
			salida.put("mensaje", AppSettings.MENSAJE_ELI_EXITOSO + " Perfil de ID ==> " + id + "." );
		} catch (Exception e) {
			e.printStackTrace();
			salida.put("mensaje", AppSettings.MENSAJE_ELI_ERROR);
		}
		return ResponseEntity.ok(salida);
	}

}
