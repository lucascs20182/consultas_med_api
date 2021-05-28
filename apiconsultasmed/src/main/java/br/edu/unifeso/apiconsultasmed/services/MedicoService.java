package br.edu.unifeso.apiconsultasmed.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import br.edu.unifeso.apiconsultasmed.models.MedicoModel;

@Service
public class MedicoService {
	public final static List<MedicoModel> listaMedicos = new ArrayList<>();

	public void cadastrar(MedicoModel medico) {
		listaMedicos.add(medico);
	}

	public List<MedicoModel> listarTodos() {
		return MedicoService.listaMedicos;
	}

	public MedicoModel listarUm(Integer id) {
		for (MedicoModel medico : listaMedicos) {
			if (medico.getId().compareTo(id) == 0) {
				return medico;
			}
		}

		System.out.println("Médico com id " + id + " não encontrado");
		return null;
	}

	public void deletar(Integer id) {
		for (MedicoModel medico : listaMedicos) {
			if (medico.getId().compareTo(id) == 0) {
				listaMedicos.remove(listaMedicos.indexOf(medico));
				
				return;
			}
		}

		System.out.println("Médico com id " + id + " não encontrado");
	}

	public void atualizarDados(Integer id, MedicoModel novosDados) {
		for (MedicoModel medico : listaMedicos) {
			if (medico.getId().compareTo(id) == 0) {
				medico.setNome(novosDados.getNome());
				medico.setSobrenome(novosDados.getSobrenome());
				medico.setCpf(novosDados.getCpf());
				medico.setDataNascimento(novosDados.getDataNascimento());
				medico.setEspecialidade(novosDados.getEspecialidade());
				medico.setCrm(novosDados.getCrm());
				
				return;
			}
		}

		System.out.println("Médico com id " + id + " não encontrado");
	}
}
