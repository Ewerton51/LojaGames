package com.generation.lojagames.controller;

import com.generation.lojagames.model.Produto;
import com.generation.lojagames.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @GetMapping
    public List<Produto> listarProdutos() {
        return produtoService.listarProdutos();
    }

    @GetMapping("/{id}")
    public Optional<Produto> encontrarProdutoPorId(@PathVariable Long id) {
        return produtoService.encontrarProdutoPorId(id);
    }

    @PostMapping
    public Produto salvarProduto(@RequestBody Produto produto) {
        return produtoService.salvarProduto(produto);
    }

    @DeleteMapping("/{id}")
    public void excluirProduto(@PathVariable Long id) {
        produtoService.excluirProduto(id);
    }

    @PutMapping("/{id}")
    public Produto atualizarProduto(@PathVariable Long id, @RequestBody Produto novoProduto) {
        return produtoService.atualizarProduto(id, novoProduto);
    }
}