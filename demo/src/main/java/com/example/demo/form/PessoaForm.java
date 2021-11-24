package com.example.demo.form;

import com.example.demo.models.Pessoa;

public class PessoaForm {
	
	private String nome;
	private String email;
	private String cpf;
	
	public PessoaForm() {
	}
	
	public PessoaForm(String nome, String email, String cpf) {
		this.nome = nome;
		this.email = email;
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public String getEmail() {
		return email;
	}

	public String getCpf() {
		return cpf;
	}
	
	
	public Pessoa toModel() {
		return new Pessoa(nome, email, cpf);
	}
}
