package br.edu.unifeso.apiconsultasmed.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.unifeso.apiconsultasmed.exceptions.ItemNotFoundException;
import br.edu.unifeso.apiconsultasmed.models.ConsultaModel;
import br.edu.unifeso.apiconsultasmed.models.MedicoModel;
import br.edu.unifeso.apiconsultasmed.models.PacienteModel;
import br.edu.unifeso.apiconsultasmed.repositories.ConsultaRepository;

@Service
public class ConsultaService {
	@Autowired
	ConsultaRepository consultaRepository;
	
	private String constroiComoPacienteSeraRepresentado(String id, PacienteService pacienteService) throws ItemNotFoundException {
		PacienteModel paciente = pacienteService.listarUm(id);
		
		return String.format("%s - %s", paciente.getNome(), paciente.getCpf());
	}
	
	private String constroiComoMedicoSeraRepresentado(String id, MedicoService medicoService) throws ItemNotFoundException {
		MedicoModel medico = medicoService.listarUm(id);
		
		return String.format("%s - %s", medico.getNome(), medico.getCpf());
	}

	public ConsultaModel cadastrar(ConsultaModel consulta, PacienteService pacienteService, 
			MedicoService medicoService) throws ItemNotFoundException {
				String idConsulta = consulta.getId();
				
				consulta.setRepresentacaoPaciente(constroiComoPacienteSeraRepresentado(idConsulta, pacienteService));
				consulta.setRepresentacaoMedico(constroiComoMedicoSeraRepresentado(idConsulta, medicoService));		
				
				return consultaRepository.save(consulta);
	}

	public List<ConsultaModel> listarTodos() {
		return consultaRepository.findAll();
	}

	public ConsultaModel listarUm(String id) throws ItemNotFoundException {
		if(consultaRepository.findById(id).isEmpty()) {
			throw new ItemNotFoundException("Consulta com id " + id + " não encontrado");
		}
		
		return consultaRepository.findById(id).get();
	}

	public void deletar(String id) throws ItemNotFoundException {
		if(consultaRepository.findById(id).isEmpty()) {
			throw new ItemNotFoundException("Consulta com id " + id + " não encontrado");
		}
		
		consultaRepository.deleteById(id);
	}

	public ConsultaModel atualizarDados(String id, ConsultaModel novosDados) throws ItemNotFoundException {
		ConsultaModel consulta = listarUm(id);
		
		consulta.setIdMedico(novosDados.getIdMedico());
		consulta.setIdPaciente(novosDados.getIdPaciente());
		consulta.setDataConsulta(novosDados.getDataConsulta());
		
		return consultaRepository.save(consulta);
	}
}
