package com.banco.bancobackend.model;
	import java.util.Date;

import jakarta.persistence.Entity;
	import jakarta.persistence.GeneratedValue;
	import jakarta.persistence.GenerationType;
	import jakarta.persistence.Id;
	import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
	
	@Entity
	public class Mensaje {
		
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		
		private Integer id;
		@ManyToOne
		private Gestor origen;
		private String texto;
		@ManyToOne
		private Gestor destino;
		
		private Date fecha;
		@PrePersist
		private void llamarAntes() {
			this.fecha= new Date();
		}
		
	public Mensaje() {
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public Gestor getOrigen() {
		return origen;
	}

	public void setOrigen(Gestor origen) {
		this.origen = origen;
	}

	public Gestor getDestino() {
		return destino;
	}

	public void setDestino(Gestor destino) {
		this.destino = destino;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	
	

}
