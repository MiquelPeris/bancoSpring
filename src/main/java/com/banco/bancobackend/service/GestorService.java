package com.banco.bancobackend.service;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.banco.bancobackend.model.Gestor;
import com.banco.bancobackend.repository.GestorRepository;

@Service
public class GestorService {
	
	@Autowired
	GestorRepository gestorRepository;
	
	public ArrayList<Gestor> leerGestores(){
		return (ArrayList<Gestor>) this.gestorRepository.findAll();
	}
	
	public Optional<Gestor> leerGestorPorId(Integer id){
		return this.gestorRepository.findById(id);
	}
	
	public Gestor guardarGestor(Gestor gestor) {
		return this.gestorRepository.save(gestor);
	}

}
