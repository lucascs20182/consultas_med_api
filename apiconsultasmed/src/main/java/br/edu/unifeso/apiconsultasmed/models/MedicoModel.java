package br.edu.unifeso.apiconsultasmed.models;

public final class MedicoModel extends Pessoa {

	private String especialidade;
	private String crm;

	public MedicoModel(Integer id, String nome, String sobrenome, String cpf, String dataNascimento,
			String especialidade, String crm) {
		super(id, nome, sobrenome, cpf, dataNascimento);
		this.especialidade = especialidade;
		this.crm = crm;
	}

	public MedicoModel(String nome, String sobrenome, String cpf, String dataNascimento, String especialidade,
			String crm) {
		super(nome, sobrenome, cpf, dataNascimento);
		this.especialidade = especialidade;
		this.crm = crm;
	}
	
	public MedicoModel() {}

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
