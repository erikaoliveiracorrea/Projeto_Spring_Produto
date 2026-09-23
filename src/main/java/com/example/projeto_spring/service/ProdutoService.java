package com.example.projeto_spring.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.example.projeto_spring.exceptions.RecursoNaoEncontrado;
import com.example.projeto_spring.model.Produto;
import com.example.projeto_spring.repository.ProdutoRepository;

@Service
public class ProdutoService {

    private final ProdutoRepository produtoRepository;

    public ProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    public List<Produto> listarprodutos() {
        return produtoRepository.findAll();
    }

    public Produto buscarPorId(Long id) {
        return produtoRepository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontrado("Produto com ID " + id + " não encontrado"));
    }

    public Produto salvarProduto(Produto produto) {
        return produtoRepository.save(produto);
    }

    public void deletarProduto(long id) {

        if (!produtoRepository.existsById(id)) {
            throw new RecursoNaoEncontrado("Produto com ID " + id + " não encontrado");
        }

        produtoRepository.deleteById(id);
    }
}
