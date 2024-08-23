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

import com.back.rest.port.entity.Educacion;
import com.back.rest.port.service.EducacionService;
import com.back.rest.port.utils.AppSettings;

@RestController
@RequestMapping("url/educacion")
@CrossOrigin(AppSettings.URL_CROSS_ORIGIN)
public class EducacionController {

	@Autowired
	private EducacionService educacionService;
	
	@GetMapping("/listarEducacion")
	public ResponseEntity<List<Educacion>> lista(){
		List<Educacion> lstSalida = educacionService.listaEducacion();
		return ResponseEntity.ok(lstSalida);
	}
	
	
	@PostMapping("/registraEducacion")
	@ResponseBody
	public ResponseEntity<?> insertaEducacion(@RequestBody Educacion obj){
		Map<String, Object> salida = new HashMap<>();
		try {
			obj.setId(0);
			Educacion objSalida =  educacionService.insertaActualizaEducacion(obj);
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
	
	@PutMapping("/actualizaEducacion")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> actualizaEducacion(@RequestBody Educacion obj){
		Map<String, Object> salida = new HashMap<>();
		try {
			Educacion objSalida = educacionService.insertaActualizaEducacion(obj);
			if (objSalida == null) {
				salida.put("mensaje", AppSettings.MENSAJE_ACT_ERROR);
			} else {
				salida.put("mensaje", AppSettings.MENSAJE_ACT_EXITOSO + " Educacion de ID ==> " + obj.getId() + "...");
			}
		} catch (Exception e) {
			e.printStackTrace();
			salida.put("mensaje", AppSettings.MENSAJE_ACT_ERROR);
		}
		return ResponseEntity.ok(salida);
	}
	
	@DeleteMapping("/eliminaEducacion/{id}")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> eliminaEducacion(@PathVariable("id") int id) {
		Map<String, Object> salida = new HashMap<>();
		try {
			educacionService.eliminaEducacion(id);
			salida.put("mensaje", AppSettings.MENSAJE_ELI_EXITOSO + " Educacion de ID ==> " + id + "." );
		} catch (Exception e) {
			e.printStackTrace();
			salida.put("mensaje", AppSettings.MENSAJE_ELI_ERROR);
		}
		return ResponseEntity.ok(salida);
	}

}
