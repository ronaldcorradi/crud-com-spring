package com.example.demo.dto;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.models.Pessoa;

public class PessoaDTO {
	
	private Long id;
	private String nome;
	
	public PessoaDTO(Pessoa pessoa) {
		this.id = pessoa.getId();
		this.nome = pessoa.getNome();
	}
	
	public Long getId() {
		return id;
	}
	
	public String getNome() {
		return nome;
	}
	
	public static List<PessoaDTO> converterListEntidadeParaListDTO(List<Pessoa> pessoas){
		List<PessoaDTO> listaDTO = new ArrayList<PessoaDTO>();
		for (Pessoa pessoa : pessoas) {
			PessoaDTO pessoaDTO = new PessoaDTO(pessoa);
			listaDTO.add(pessoaDTO);
		}
		return listaDTO;
	}
	
	

}
