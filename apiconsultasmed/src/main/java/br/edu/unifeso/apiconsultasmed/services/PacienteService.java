package br.edu.unifeso.apiconsultasmed.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import br.edu.unifeso.apiconsultasmed.models.PacienteModel;

@Service
public final class PacienteService {
	public final static List<PacienteModel> listaPacientes = new ArrayList<>();

	public void cadastrar(PacienteModel paciente) {
		listaPacientes.add(paciente);
	}

	public List<PacienteModel> listarTodos() {
		return PacienteService.listaPacientes;
	}

	public PacienteModel listarUm(Integer id) {
		for (PacienteModel paciente : listaPacientes) {
			if (paciente.getId().compareTo(id) == 0) {
				return paciente;
			}
		}

		System.out.println("Paciente com id " + id + " não encontrado");
		return null;
	}

	public void deletar(Integer id) {
		for (PacienteModel paciente : listaPacientes) {
			if (paciente.getId().compareTo(id) == 0) {
				listaPacientes.remove(listaPacientes.indexOf(paciente));
				
				return;
			}
		}

		System.out.println("Paciente com id " + id + " não encontrado");
	}

	public void atualizarDados(Integer id, PacienteModel novosDados) {
		for (PacienteModel paciente : listaPacientes) {
			if (paciente.getId().compareTo(id) == 0) {
				paciente.setNome(novosDados.getNome());
				paciente.setSobrenome(novosDados.getSobrenome());
				paciente.setCpf(novosDados.getCpf());
				paciente.setDataNascimento(novosDados.getDataNascimento());
				
				return;
			}
		}

		System.out.println("Paciente com id " + id + " não encontrado");
	}
}
