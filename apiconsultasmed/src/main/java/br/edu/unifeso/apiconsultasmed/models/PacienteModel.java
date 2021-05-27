package br.edu.unifeso.apiconsultasmed.models;

public final class PacienteModel extends Pessoa {

	public PacienteModel(Integer id, String nome, String sobrenome, String cpf, String dataNascimento) {
		super(id, nome, sobrenome, cpf, dataNascimento);
	}

	public PacienteModel(String nome, String sobrenome, String cpf, String dataNascimento) {
		super(nome, sobrenome, cpf, dataNascimento);
	}
	
	public PacienteModel() {}
}
