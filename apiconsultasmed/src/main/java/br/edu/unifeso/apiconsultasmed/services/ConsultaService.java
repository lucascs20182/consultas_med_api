package br.edu.unifeso.apiconsultasmed.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import br.edu.unifeso.apiconsultasmed.exceptions.ItemNotFoundException;
import br.edu.unifeso.apiconsultasmed.models.ConsultaModel;
import br.edu.unifeso.apiconsultasmed.models.MedicoModel;
import br.edu.unifeso.apiconsultasmed.models.PacienteModel;

@Service
public class ConsultaService {
	public final static List<ConsultaModel> listaConsultas = new ArrayList<>();
	
	private String constroiComoPacienteSeraRepresentado(Integer id, PacienteService pacienteService) throws ItemNotFoundException {
		if(pacienteService == null) {
			throw new ItemNotFoundException("Paciente com id " + id + " não encontrado");
		}
		
		for (PacienteModel paciente : pacienteService.listarTodos()) {
			if (id.compareTo(paciente.getId()) == 0) {
				
				return String.format("%s - %s", paciente.getNome(), paciente.getCpf());
			}
		}
		
		throw new ItemNotFoundException("Paciente com id " + id + " não encontrado");
	}
	
	private String constroiComoMedicoSeraRepresentado(Integer id, MedicoService medicoService) throws ItemNotFoundException {
		if(medicoService == null) {
			throw new ItemNotFoundException("Médico com id " + id + " não encontrado");
		}
		
		for (MedicoModel medico : medicoService.listarTodos()) {
			if (id.compareTo(medico.getId()) == 0) {
				
				return String.format("%s - %s", medico.getNome(), medico.getCpf());
			}
		}
		
		throw new ItemNotFoundException("Médico com id " + id + " não encontrado");
	}

	public ConsultaModel cadastrar(ConsultaModel consulta, PacienteService pacienteService, 
			MedicoService medicoService) throws ItemNotFoundException {
				Integer idConsulta = consulta.getId();
				
				consulta.setRepresentacaoPaciente(constroiComoPacienteSeraRepresentado(idConsulta, pacienteService));
				consulta.setRepresentacaoMedico(constroiComoMedicoSeraRepresentado(idConsulta, medicoService));		
				
				listaConsultas.add(consulta);
				
				return consulta;
	}

	public List<ConsultaModel> listarTodos() {
		return ConsultaService.listaConsultas;
	}

	public ConsultaModel listarUm(Integer id) throws ItemNotFoundException {
		for (ConsultaModel consulta : listaConsultas) {
			if (consulta.getId().compareTo(id) == 0) {
				return consulta;
			}
		}

		throw new ItemNotFoundException("Consulta com id " + id + " não encontrado");
	}

	public String deletar(Integer id) throws ItemNotFoundException {
		for (ConsultaModel consulta : listaConsultas) {
			if (consulta.getId().compareTo(id) == 0) {
				listaConsultas.remove(listaConsultas.indexOf(consulta));
				
				return "Deletado com sucesso";
			}
		}

		throw new ItemNotFoundException("Consulta com id " + id + " não encontrado");
	}

	public ConsultaModel atualizarDados(Integer id, ConsultaModel novosDados) throws ItemNotFoundException {
		for (ConsultaModel consulta : listaConsultas) {
			if (consulta.getId().compareTo(id) == 0) {
				consulta.setIdMedico(novosDados.getIdMedico());
				consulta.setIdPaciente(novosDados.getIdPaciente());
				consulta.setDataConsulta(novosDados.getDataConsulta());
				
				return consulta;
			}
		}

		throw new ItemNotFoundException("Consulta com id " + id + " não encontrado");
	}
}
