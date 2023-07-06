package com.banco.bancobackend.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.banco.bancobackend.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer>{
	
	public List<Cliente> findByGestorId(Integer id);
	
	public Optional<Cliente> findFirstByCorreo(String correo);
	
	public Optional<Cliente> findFirstByCorreoAndPassword(String correo, String password);
	
	public Optional<Cliente> guardarNuevoCliente(Integer id, String usuario, String correo, String password, Integer gestor, Integer saldo);


}
