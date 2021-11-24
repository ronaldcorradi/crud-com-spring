package com.example.demo.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.PessoaDTO;
import com.example.demo.dto.PessoaDetalhadaDTO;
import com.example.demo.form.PessoaForm;
import com.example.demo.form.PessoaFormAtualizacao;
import com.example.demo.models.Pessoa;
import com.example.demo.services.PessoaService;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {
	
	@Autowired
	private PessoaService pessoaService;
	
	@GetMapping
	public ResponseEntity<List<PessoaDTO>> listarTodos(){
		List<Pessoa> lista = pessoaService.buscarTodos();
		List<PessoaDTO> listaPessoaDTO = PessoaDTO.converterListEntidadeParaListDTO(lista);
		return ResponseEntity.ok(listaPessoaDTO);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<PessoaDetalhadaDTO> buscarPorId(@PathVariable Long id){
		Optional<Pessoa> pessoa = pessoaService.buscarPorId(id);
		if(pessoa.isPresent()) {
			return ResponseEntity.ok(new PessoaDetalhadaDTO(pessoa.get()));
		}
		return ResponseEntity.notFound().build();
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<PessoaDetalhadaDTO> buscarPorId(@PathVariable Long id,
			                                     @RequestBody PessoaFormAtualizacao pessoaFormAtualizacao){
		Optional<Pessoa> pessoa = pessoaService.atualizar(pessoaFormAtualizacao, id);
		if(pessoa.isPresent()) {
			return ResponseEntity.ok(new PessoaDetalhadaDTO(pessoa.get()));
		}
		return ResponseEntity.notFound().build();
	}
	
	@PostMapping
	public ResponseEntity<PessoaDetalhadaDTO> salvar (@RequestBody PessoaForm pessoaForm){
		Pessoa pessoa = pessoaService.salvar(pessoaForm);
		if(pessoa==null) {
			return ResponseEntity.badRequest().build();
		}
		return ResponseEntity.ok(new PessoaDetalhadaDTO(pessoa));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deletar(@PathVariable Long id){
		if(pessoaService.deletar(id)) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.notFound().build();
	}
	
	

}
