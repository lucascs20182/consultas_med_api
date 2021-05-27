package br.edu.unifeso.apiconsultasmed.models;

import java.time.LocalDate;

public final class PacienteModel extends Pessoa {

	public PacienteModel(Integer id, String nome, String sobrenome, String cpf, LocalDate dataNascimento) {
		super(id, nome, sobrenome, cpf, dataNascimento);
	}
}
