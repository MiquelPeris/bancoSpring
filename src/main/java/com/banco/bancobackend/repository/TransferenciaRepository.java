package com.banco.bancobackend.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.banco.bancobackend.model.Cliente;
import com.banco.bancobackend.model.Transferencia;

public interface TransferenciaRepository extends JpaRepository<Transferencia, Integer>{

	public List<Transferencia> findByOrdenanteId(Integer id);
	public List<Transferencia> findByBeneficiarioId(Integer id);


}
