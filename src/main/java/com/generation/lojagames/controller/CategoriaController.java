package com.generation.lojagames.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import com.generation.lojagames.model.Categoria;
import com.generation.lojagames.service.CategoriaService;

@Service
@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping
    public List<Categoria> listarCategorias() {
        return categoriaService.listarCategorias();
    }

    @GetMapping("/{id}")
    public Optional<Categoria> encontrarCategoriaPorId(@PathVariable Long id) {
        return categoriaService.encontrarCategoriaPorId(id);
    }

    @PostMapping
    public Categoria salvarCategoria(@RequestBody Categoria categoria) {
        return categoriaService.salvarCategoria(categoria);
    }

    @DeleteMapping("/{id}")
    public void excluirCategoria(@PathVariable Long id) {
        categoriaService.excluirCategoria(id);
    }

    @PutMapping("/{id}")
    public Categoria atualizarCategoria(@PathVariable Long id, @RequestBody Categoria novaCategoria) {
        return categoriaService.atualizarCategoria(id, novaCategoria);
    }
}
