package com.example.ProjetoVendass.service;




import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ProjetoVendass.entities.Turma;
import com.example.ProjetoVendass.repository.TurmaRepository; 

  

  

@Service 

public class TurmaService { 

	private final TurmaRepository turmaRepository;  

  

	@Autowired  

	public TurmaService (TurmaRepository turmaRepository) {  

		this.turmaRepository = turmaRepository;  

	}  

  

	public List<Turma> buscaTodosTurmas(){  

		return turmaRepository.findAll();  

	}  

  

	public Turma buscaTurmaById(Long id) {  

		Optional <Turma> turma = turmaRepository.findById(id);  

		return turma.orElse(null);  

	}  

  

	public Turma salvaTurma (Turma turma) {  

		return turmaRepository.save(turma);  

	}  

  

	public Turma alteraTurma(long id, Turma alteraTurma) {  

		Optional <Turma> existeTurma = turmaRepository.findById(id);  

		if (existeTurma.isPresent()) {  

			alteraTurma.setId(id);  

			return turmaRepository.save(alteraTurma);  

		}  

		return null;  

	}  

  

	public boolean apagarTurma(Long id) {  

		Optional <Turma> existeTurma = turmaRepository.findById(id);  

		if (existeTurma.isPresent()) {  

			turmaRepository.deleteById(id);  

			return true;  

		}  

		return false;  

	}  

	 

	 

  

} 
