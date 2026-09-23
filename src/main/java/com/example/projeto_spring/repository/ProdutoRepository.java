package com.example.projeto_spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.projeto_spring.model.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}
