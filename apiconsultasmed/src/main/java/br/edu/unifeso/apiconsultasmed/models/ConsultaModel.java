package br.edu.unifeso.apiconsultasmed.models;

public class ConsultaModel {

	private Integer id;
	private Integer idPaciente;
	private Integer idMedico;
	private String dataConsulta;

	public ConsultaModel(Integer id, Integer idPaciente, Integer idMedico, String dataConsulta) {
		this.id = id;
		this.idPaciente = idPaciente;
		this.idMedico = idMedico;
		this.dataConsulta = dataConsulta;
	}
	
	public ConsultaModel() {}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getIdPaciente() {
		return idPaciente;
	}

	public void setIdPaciente(Integer idPaciente) {
		this.idPaciente = idPaciente;
	}

	public Integer getIdMedico() {
		return idMedico;
	}

	public void setIdMedico(Integer idMedico) {
		this.idMedico = idMedico;
	}

	public String getDataConsulta() {
		return dataConsulta;
	}

	public void setDataConsulta(String dataConsulta) {
		this.dataConsulta = dataConsulta;
	}
}
