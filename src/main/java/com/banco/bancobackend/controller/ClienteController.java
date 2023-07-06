package com.banco.bancobackend.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.banco.bancobackend.model.Cliente;
import com.banco.bancobackend.service.ClienteService;

@RestController
//  En desarrollo https://localhost: 8080/cliente
@RequestMapping("/cliente")
@CrossOrigin(origins= "http://localhost:4200")

public class ClienteController {

	@Autowired
	ClienteService clienteService;

	@GetMapping
	public ArrayList<Cliente> obtenerGestores() {
		return this.clienteService.leerClientes();
	}

	@PostMapping()
	public Cliente guardarCliente(@RequestBody Cliente cliente) {
		return this.clienteService.guardarCliente(cliente);

	}

	@GetMapping(path = "/{id}")
	public Optional<Cliente> obtenerCliente(@PathVariable("id") Integer id) {
		return this.clienteService.leerClientePorId(id);

	}

	@DeleteMapping(path = "/{id}")
	public void borrarCliente(@PathVariable("id") Integer id) {
		this.clienteService.borrarClientePorId(id);
	}

	@GetMapping(path = "/correo/{email}")
	public Optional<Cliente> obtenerCliente(@PathVariable("email") String email) {
		return this.clienteService.buscarPorCorreo(email);
	}

	@GetMapping(path = "/login")
	public Optional<Cliente> loguearCliente(@RequestParam("email") String email,
			@RequestParam("password") String password) {
		return this.clienteService.buscarClientePorCorreoYPass(email, password);
	}

	@GetMapping(path = "/gestor/{id}")
	public List<Cliente> obtenerClientePorGestor(@PathVariable("idGestor") Integer id) {
		return this.clienteService.buscarPorIdGestor(id);

	}

}
