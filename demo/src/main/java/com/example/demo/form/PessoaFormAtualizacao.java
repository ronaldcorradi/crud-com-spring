package com.example.demo.form;

import com.example.demo.models.Pessoa;

public class PessoaFormAtualizacao {
	
	private String nome;
	private String email;
	
	public PessoaFormAtualizacao() {
	}
	
	public PessoaFormAtualizacao(String nome, String email) {
		this.nome = nome;
		this.email = email;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public Pessoa toModel() {
		Pessoa pessoa = new Pessoa();
		pessoa.setEmail(email);
		pessoa.setNome(nome);
		return pessoa;
	}
	
}
