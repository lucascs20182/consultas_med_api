package br.edu.unifeso.apiconsultasmed.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import br.edu.unifeso.apiconsultasmed.exceptions.ItemNotFoundException;
import br.edu.unifeso.apiconsultasmed.models.PacienteModel;

@Service
public final class PacienteService {
	public final static List<PacienteModel> listaPacientes = new ArrayList<>();

	public PacienteModel cadastrar(PacienteModel paciente) {
		listaPacientes.add(paciente);
		
		return paciente;
	}

	public List<PacienteModel> listarTodos() {
		return PacienteService.listaPacientes;
	}

	public PacienteModel listarUm(Integer id) throws ItemNotFoundException {
		for (PacienteModel paciente : listaPacientes) {
			if (paciente.getId().compareTo(id) == 0) {
				return paciente;
			}
		}

		throw new ItemNotFoundException("Paciente com id " + id + " não encontrado");
	}

	public String deletar(Integer id) throws ItemNotFoundException {
		for (PacienteModel paciente : listaPacientes) {
			if (paciente.getId().compareTo(id) == 0) {
				listaPacientes.remove(listaPacientes.indexOf(paciente));
				
				return "Deletado com sucesso";
			}
		}

		throw new ItemNotFoundException("Paciente com id " + id + " não encontrado");
	}

	public PacienteModel atualizarDados(Integer id, PacienteModel novosDados) throws ItemNotFoundException {
		for (PacienteModel paciente : listaPacientes) {
			if (paciente.getId().compareTo(id) == 0) {
				paciente.setNome(novosDados.getNome());
				paciente.setSobrenome(novosDados.getSobrenome());
				paciente.setCpf(novosDados.getCpf());
				paciente.setDataNascimento(novosDados.getDataNascimento());
				
				return paciente;
			}
		}

		throw new ItemNotFoundException("Paciente com id " + id + " não encontrado");
	}
}
