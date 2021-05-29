package br.edu.unifeso.apiconsultasmed.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import br.edu.unifeso.apiconsultasmed.exceptions.ItemNotFoundException;
import br.edu.unifeso.apiconsultasmed.models.MedicoModel;

@Service
public class MedicoService {
	public final static List<MedicoModel> listaMedicos = new ArrayList<>();

	public MedicoModel cadastrar(MedicoModel medico) {
		listaMedicos.add(medico);
		
		return medico;
	}

	public List<MedicoModel> listarTodos() {
		return MedicoService.listaMedicos;
	}

	public MedicoModel listarUm(Integer id) throws ItemNotFoundException {
		for (MedicoModel medico : listaMedicos) {
			if (medico.getId().compareTo(id) == 0) {
				return medico;
			}
		}

		throw new ItemNotFoundException("Médico com id " + id + " não encontrado");
	}

	public String deletar(Integer id) throws ItemNotFoundException {
		for (MedicoModel medico : listaMedicos) {
			if (medico.getId().compareTo(id) == 0) {
				listaMedicos.remove(listaMedicos.indexOf(medico));
				
				return "Deletado com sucesso";
			}
		}

		throw new ItemNotFoundException("Médico com id " + id + " não encontrado");
	}

	public MedicoModel atualizarDados(Integer id, MedicoModel novosDados) throws ItemNotFoundException {
		for (MedicoModel medico : listaMedicos) {
			if (medico.getId().compareTo(id) == 0) {
				medico.setNome(novosDados.getNome());
				medico.setSobrenome(novosDados.getSobrenome());
				medico.setCpf(novosDados.getCpf());
				medico.setDataNascimento(novosDados.getDataNascimento());
				medico.setEspecialidade(novosDados.getEspecialidade());
				medico.setCrm(novosDados.getCrm());
				
				return medico;
			}
		}

		throw new ItemNotFoundException("Médico com id " + id + " não encontrado");
	}
}
