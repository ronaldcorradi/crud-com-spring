package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.models.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa,Long> {

}
