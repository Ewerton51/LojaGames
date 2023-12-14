package com.generation.lojagames.service;

import com.generation.lojagames.model.Categoria;
import com.generation.lojagames.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    public List<Categoria> listarCategorias() {
        return categoriaRepository.findAll();
    }

    public Optional<Categoria> encontrarCategoriaPorId(Long id) {
        return categoriaRepository.findById(id);
    }

    public Categoria salvarCategoria(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    public void excluirCategoria(Long id) {
        categoriaRepository.deleteById(id);
    }

    public Categoria atualizarCategoria(Long id, Categoria novaCategoria) {
        if (categoriaRepository.existsById(id)) {
            novaCategoria.setId(id);
            return categoriaRepository.save(novaCategoria);
        }
        return null; // Categoria não encontrada
    }
}

