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

import br.edu.unifeso.apiconsultasmed.models.MedicoModel;
import br.edu.unifeso.apiconsultasmed.services.MedicoService;

@RestController
@RequestMapping("/medico")
public class MedicoController {

	@Autowired
	MedicoService medicoService;
	
	@GetMapping
	public List<MedicoModel> listarTodos() {
		return medicoService.listarTodos();
	}
	
	@GetMapping("/{id}")
	public MedicoModel listarUm(@PathVariable Integer id) {
		return medicoService.listarUm(id);
	}
	
	@PostMapping("/cadastrar")
	public void cadastrar(@RequestBody MedicoModel medico) {
		medicoService.cadastrar(medico);
	}
	
	@DeleteMapping("/{id}")
	public void deletar(@PathVariable Integer id) {
		medicoService.deletar(id);
	}
	
	@PutMapping("/{id}")
	public void atualizarDados(@PathVariable Integer id, @RequestBody MedicoModel medico) {
		medicoService.atualizarDados(id, medico);
	}
}
