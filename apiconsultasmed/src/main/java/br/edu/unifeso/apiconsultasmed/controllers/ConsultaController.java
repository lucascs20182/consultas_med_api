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

import br.edu.unifeso.apiconsultasmed.models.ConsultaModel;
import br.edu.unifeso.apiconsultasmed.services.ConsultaService;

@RestController
@RequestMapping("/consulta")
public class ConsultaController {

	@Autowired
	ConsultaService consultaService;
	
	@GetMapping
	public List<ConsultaModel> listarTodos() {
		return consultaService.listarTodos();
	}
	
	@GetMapping("/{id}")
	public ConsultaModel listarUm(@PathVariable Integer id) {
		return consultaService.listarUm(id);
	}
	
	@PostMapping("/cadastrar")
	public void cadastrar(@RequestBody ConsultaModel consulta) {
		consultaService.cadastrar(consulta);
	}
	
	@DeleteMapping("/{id}")
	public void deletar(@PathVariable Integer id) {
		consultaService.deletar(id);
	}
	
	@PutMapping("/{id}")
	public void atualizarDados(@PathVariable Integer id, @RequestBody ConsultaModel consulta) {
		consultaService.atualizarDados(id, consulta);
	}
}
