package com.fiap.shift.aluno.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.fiap.shift.aluno.exception.ResourceNotFoundException;
import com.fiap.shift.aluno.model.Aluno;
import com.fiap.shift.aluno.repository.AlunoRepository;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class AlunoController {
	
	@Autowired
    AlunoRepository alunoRepository;
	
	// Get All Alunos
	@GetMapping("/alunos")
	public List<Aluno> getAllAlunos() {
	    return alunoRepository.findAll();
	}
	
	// Create a new Aluno
	@PostMapping("/alunos")
	public Aluno createAluno(@Valid @RequestBody Aluno guest) {
	    return alunoRepository.save(guest);
	}
	
	// Get a Single Aluno
	@GetMapping("/alunos/{id}")
	public Aluno getAlunoById(@PathVariable(value = "id") Long AlunoId) {
	    return alunoRepository.findById(AlunoId)
	            .orElseThrow(() -> new ResourceNotFoundException("Aluno", "id", AlunoId));
	}

	
	// Update a Aluno
	@PutMapping("/alunos/{id}")
	public Aluno updateAluno(@PathVariable(value = "id") Long AlunoId,
	                                        @Valid @RequestBody Aluno AlunoDetails) {

	    Aluno Aluno = alunoRepository.findById(AlunoId)
	            .orElseThrow(() -> new ResourceNotFoundException("Aluno", "id", AlunoId));

	    Aluno.setName(AlunoDetails.getName());

	    Aluno updatedAluno = alunoRepository.save(Aluno);
	    return updatedAluno;
	}

	// Delete a Aluno
	@DeleteMapping("/alunos/{id}")
	public ResponseEntity<?> deleteAluno(@PathVariable(value = "id") Long AlunoId) {
	    Aluno Aluno = alunoRepository.findById(AlunoId)
	            .orElseThrow(() -> new ResourceNotFoundException("Aluno", "id", AlunoId));

	    alunoRepository.delete(Aluno);

	    return ResponseEntity.ok().build();
	}




}