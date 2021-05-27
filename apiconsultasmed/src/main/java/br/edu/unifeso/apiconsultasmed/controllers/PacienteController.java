package br.edu.unifeso.apiconsultasmed.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	
	@GetMapping("/{id}")
	public PacienteModel listarUm(@PathVariable Integer id) {
		return pacienteService.listarUm(id);
	}
	
	@PostMapping("/cadastrar")
	public void cadastrar(@RequestBody PacienteModel paciente) {
		pacienteService.cadastrar(paciente);
	}
	
	@DeleteMapping("/{id}")
	public void deletar(@PathVariable Integer id) {
		pacienteService.deletar(id);
	}
	
	@PutMapping("/{id}")
	public void atualizarDados(@PathVariable Integer id, @RequestBody PacienteModel paciente) {
		pacienteService.atualizarDados(id, paciente);
	}
}
