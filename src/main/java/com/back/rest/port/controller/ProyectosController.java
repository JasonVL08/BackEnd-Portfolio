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

import com.back.rest.port.entity.Proyectos;
import com.back.rest.port.service.ProyectosService;
import com.back.rest.port.utils.AppSettings;


@RestController
@RequestMapping("url/proyecto")
@CrossOrigin(AppSettings.URL_CROSS_ORIGIN)
public class ProyectosController {

	
	@Autowired
	private ProyectosService proyectoService;
	
	
	@GetMapping("/listarProyecto")
	public ResponseEntity<List<Proyectos>> lista(){
		List<Proyectos> lstSalida = proyectoService.listaProyecto();
		return ResponseEntity.ok(lstSalida);
	}
	
	
	@PostMapping("/registraProyecto")
	@ResponseBody
	public ResponseEntity<?> insertaProyecto(@RequestBody Proyectos obj){
		Map<String, Object> salida = new HashMap<>();
		try {
			obj.setId(0);
			Proyectos objSalida =  proyectoService.insertaActualizaProyecto(obj);
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
	
	@PutMapping("/actualizaProyecto")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> actualizaProyecto(@RequestBody Proyectos obj){
		Map<String, Object> salida = new HashMap<>();
		try {
			Proyectos objSalida = proyectoService.insertaActualizaProyecto(obj);
			if (objSalida == null) {
				salida.put("mensaje", AppSettings.MENSAJE_ACT_ERROR);
			} else {
				salida.put("mensaje", AppSettings.MENSAJE_ACT_EXITOSO + " Proyecto de ID ==> " + obj.getId() + "...");
			}
		} catch (Exception e) {
			e.printStackTrace();
			salida.put("mensaje", AppSettings.MENSAJE_ACT_ERROR);
		}
		return ResponseEntity.ok(salida);
	}
	
	@DeleteMapping("/eliminaProyecto/{id}")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> eliminaProyecto(@PathVariable("id") int id) {
		Map<String, Object> salida = new HashMap<>();
		try {
			proyectoService.eliminaProyecto(id);
			salida.put("mensaje", AppSettings.MENSAJE_ELI_EXITOSO + " Proyecto de ID ==> " + id + "." );
		} catch (Exception e) {
			e.printStackTrace();
			salida.put("mensaje", AppSettings.MENSAJE_ELI_ERROR);
		}
		return ResponseEntity.ok(salida);
	}
	
}
