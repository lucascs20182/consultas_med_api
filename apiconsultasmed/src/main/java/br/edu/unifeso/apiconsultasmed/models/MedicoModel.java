package br.edu.unifeso.apiconsultasmed.models;

import java.time.LocalDate;

public final class MedicoModel extends Pessoa {

	private String especialidade;
	private String crm;

	public MedicoModel(Integer id, String nome, String sobrenome, String cpf, LocalDate dataNascimento,
			String especialidade, String crm) {
		super(id, nome, sobrenome, cpf, dataNascimento);
		this.especialidade = especialidade;
		this.crm = crm;
	}

	public String getEspecialidade() {
		return especialidade;
	}

	public void setEspecialidade(String especialidade) {
		this.especialidade = especialidade;
	}

	public String getCrm() {
		return crm;
	}

	public void setCrm(String crm) {
		this.crm = crm;
	}
}
