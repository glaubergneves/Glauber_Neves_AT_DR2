package com.gmail.vortexquatro.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gmail.vortexquatro.models.Paciente;
import com.gmail.vortexquatro.repository.PacienteRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

//***********************************************************************
//***********************************************************************
//http://localhost:8080/swagger-ui/index.html
//***********************************************************************
//***********************************************************************

@RestController
@RequestMapping(value="/api")
@Api(value="API REST Usuarios")
@CrossOrigin(origins = "*")
public class PacienteController {
	
	
	
	@Autowired
	PacienteRepository pacienteRepository;
	
	@GetMapping("/pacientes")
	@ApiOperation(value="Retorna uma lista de pacientes")
	public List<Paciente> listaUsuarios(){
		return pacienteRepository.findAll();
	}
	
	@GetMapping("/paciente/{id}")
	@ApiOperation(value="Retorna um paciente unico")
	public Optional<Paciente> listaPacienteUnico(@PathVariable(value="id") long id){
		return pacienteRepository.findById(id);
	}
	
	@PostMapping("/paciente")
	@ApiOperation(value="Salva um paciente")
	public Paciente salvaPaciente(@RequestBody @Valid Paciente paciente) {
		return pacienteRepository.save(paciente);
	}
	
	@DeleteMapping("/paciente")
	@ApiOperation(value="Deleta um paciente")
	public void deletaPaciente(@RequestBody @Valid Paciente paciente) {
		pacienteRepository.delete(paciente);
	}
	
	@PutMapping("/paciente")
	@ApiOperation(value="Atualiza um paciente")
	public Paciente atualizaPaciente(@RequestBody @Valid Paciente paciente) {
		return pacienteRepository.save(paciente);
	}
}

