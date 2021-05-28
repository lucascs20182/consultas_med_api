package br.edu.unifeso.apiconsultasmed.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import br.edu.unifeso.apiconsultasmed.models.ConsultaModel;

@Service
public class ConsultaService {
	public final static List<ConsultaModel> listaConsultas = new ArrayList<>();

	public void cadastrar(ConsultaModel consulta) {
		listaConsultas.add(consulta);
	}

	public List<ConsultaModel> listarTodos() {
		return ConsultaService.listaConsultas;
	}

	public ConsultaModel listarUm(Integer id) {
		for (ConsultaModel consulta : listaConsultas) {
			if (consulta.getId().compareTo(id) == 0) {
				return consulta;
			}
		}

		System.out.println("Consulta com id " + id + " não encontrado");
		return null;
	}

	public void deletar(Integer id) {
		for (ConsultaModel consulta : listaConsultas) {
			if (consulta.getId().compareTo(id) == 0) {
				listaConsultas.remove(listaConsultas.indexOf(consulta));
				
				return;
			}
		}

		System.out.println("Consulta com id " + id + " não encontrado");
	}

	public void atualizarDados(Integer id, ConsultaModel novosDados) {
		for (ConsultaModel consulta : listaConsultas) {
			if (consulta.getId().compareTo(id) == 0) {
				consulta.setIdMedico(novosDados.getIdMedico());
				consulta.setIdPaciente(novosDados.getIdPaciente());
				consulta.setDataConsulta(novosDados.getDataConsulta());
				
				return;
			}
		}

		System.out.println("Consulta com id " + id + " não encontrado");
	}
}
