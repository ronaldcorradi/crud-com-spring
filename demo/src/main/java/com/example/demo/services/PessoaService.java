package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.form.PessoaForm;
import com.example.demo.form.PessoaFormAtualizacao;
import com.example.demo.models.Pessoa;
import com.example.demo.repositories.PessoaRepository;

@Service
public class PessoaService {
	
	@Autowired
	private PessoaRepository pessoaRepository;
	
	@Transactional
	public Pessoa salvar(PessoaForm pessoaForm) {
		Pessoa pessoa = pessoaForm.toModel();
		pessoaRepository.save(pessoa);
		return pessoa;
	}
	
	@Transactional
	public Optional<Pessoa> atualizar(PessoaFormAtualizacao pessoaFormAtualizacao,Long id){
		Optional<Pessoa> pessoa = pessoaRepository.findById(id);
		if(pessoa.isPresent()) {
			pessoa.get().setEmail(pessoaFormAtualizacao.getEmail());
			pessoa.get().setNome(pessoaFormAtualizacao.getNome());
			return pessoa;
		}
		return Optional.empty();
	}
	
	@Transactional
	public boolean deletar (Long id) {
		Optional<Pessoa> pessoa = pessoaRepository.findById(id);
		if(pessoa.isPresent()) {
			pessoaRepository.deleteById(id);
			return true;
		}
		return false;
	}
	
	public Optional<Pessoa> buscarPorId(Long id){
		Optional<Pessoa> pessoa = pessoaRepository.findById(id);
		if(pessoa.isEmpty()) {
			return Optional.empty();
		}
		return pessoa;
	}
	
	public List<Pessoa> buscarTodos(){
		return pessoaRepository.findAll();
	}

}
