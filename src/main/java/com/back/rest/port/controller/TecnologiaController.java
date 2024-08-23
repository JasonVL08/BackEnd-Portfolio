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


import com.back.rest.port.entity.Tecnologia;
import com.back.rest.port.service.TecnologiasService;
import com.back.rest.port.utils.AppSettings;

@RestController
@RequestMapping("url/tecnologia")
@CrossOrigin(AppSettings.URL_CROSS_ORIGIN)
public class TecnologiaController {
	
	@Autowired
	private TecnologiasService tecnologiasService;
	
	@GetMapping("/listarTecnologia")
	public ResponseEntity<List<Tecnologia>> lista(){
		List<Tecnologia> lstSalida = tecnologiasService.listaTecnologia();
		return ResponseEntity.ok(lstSalida);
	}
	
	
	@PostMapping("/registraTecnologia")
	@ResponseBody
	public ResponseEntity<?> insertaTecnologia(@RequestBody Tecnologia obj){
		Map<String, Object> salida = new HashMap<>();
		try {
			obj.setId(0);
			Tecnologia objSalida =  tecnologiasService.insertaActualizaTecnologias(obj);
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
	
	@PutMapping("/actualizaTecnologia")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> actualizaTecnologia(@RequestBody Tecnologia obj){
		Map<String, Object> salida = new HashMap<>();
		try {
			Tecnologia objSalida = tecnologiasService.insertaActualizaTecnologias(obj);
			if (objSalida == null) {
				salida.put("mensaje", AppSettings.MENSAJE_ACT_ERROR);
			} else {
				salida.put("mensaje", AppSettings.MENSAJE_ACT_EXITOSO + " Tecnologia de ID ==> " + obj.getId() + "...");
			}
		} catch (Exception e) {
			e.printStackTrace();
			salida.put("mensaje", AppSettings.MENSAJE_ACT_ERROR);
		}
		return ResponseEntity.ok(salida);
	}
	
	@DeleteMapping("/eliminaTecnologia/{id}")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> eliminaTecnologia(@PathVariable("id") int id) {
		Map<String, Object> salida = new HashMap<>();
		try {
			tecnologiasService.eliminaTecnologia(id);
			salida.put("mensaje", AppSettings.MENSAJE_ELI_EXITOSO + " Tecnologia de ID ==> " + id + "." );
		} catch (Exception e) {
			e.printStackTrace();
			salida.put("mensaje", AppSettings.MENSAJE_ELI_ERROR);
		}
		return ResponseEntity.ok(salida);
	}

}
