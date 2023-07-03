package com.banco.bancobackend.controller;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.banco.bancobackend.model.Gestor;
import com.banco.bancobackend.service.GestorService;

@RestController
//  En desarrollo https://localhost: 8080/gestor
@RequestMapping("/gestor")
public class GestorController {

	@Autowired
	GestorService gestorService;

	@GetMapping
	public ArrayList<Gestor> obtenerGestores() {
		return this.gestorService.leerGestores();
	}

	@PostMapping()
	public Gestor guardarGestor(@RequestBody Gestor gestor) {
		return this.gestorService.guardarGestor(gestor);

	}
	
	@GetMapping(path = "/{id}")
	public Optional<Gestor> obtenerGestor(@PathVariable("id") Integer id) {
		return this.gestorService.leerGestorPorId(id);
		
	}
	
	@DeleteMapping(path = "/{id}")
	public void borrarGestor(@PathVariable("id") Integer id) {
		this.gestorService.borrarGestorPorId(id);
		}
	
	@GetMapping(path = "/correo/{email}") 
		public Optional<Gestor> obtenerGestor(@PathVariable("email")String email){
			return this.gestorService.buscarPorCorreo(email);
		}
	
	@GetMapping(path = "/login")
	public Optional<Gestor> loguearGestor(@RequestParam("email") String email, @RequestParam("password") String password) {
		return this.gestorService.buscarGestorPorCorreoYPass(email, password);
	}
	
}
