package br.edu.unifeso.apiconsultasmed.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.unifeso.apiconsultasmed.models.PacienteModel;
import br.edu.unifeso.apiconsultasmed.services.PacienteService;

@RestController
@RequestMapping("/paciente")
public class PacienteController {
	
	@Autowired
	PacienteService pacienteService;
	
	@GetMapping
	public List<PacienteModel> listarTodos() {
		return pacienteService.listarTodos();
	}
	
	@PostMapping("/cadastrar")
	public void cadastrar(@RequestBody PacienteModel paciente) {
		pacienteService.cadastrar(paciente);
	}
}
