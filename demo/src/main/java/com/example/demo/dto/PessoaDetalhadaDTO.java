package com.example.demo.dto;

import com.example.demo.models.Pessoa;

public class PessoaDetalhadaDTO {
	
	private Long id;
	private String nome;
	private String cpf;
	private String email;
	
	public PessoaDetalhadaDTO() {
	}
	
	public PessoaDetalhadaDTO(Pessoa pessoa) {
		this.id = pessoa.getId();
		this.nome = pessoa.getNome();
		this.cpf = pessoa.getCpf();
		this.email = pessoa.getEmail();
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getCpf() {
		return cpf;
	}

	public String getEmail() {
		return email;
	};
	
	
}
