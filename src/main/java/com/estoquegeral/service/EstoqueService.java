package com.estoquegeral.service;

import com.estoquegeral.model.Estoque;
import com.estoquegeral.repository.EstoqueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstoqueService {

    @Autowired
    private EstoqueRepository estoqueRepository;

    public List<Estoque> listAll() {
        return estoqueRepository.findAll();
    }

    public Estoque save(Estoque estoque) {
        if (estoque.getQuantity() < 0) {
            throw new IllegalArgumentException("A quantidade não pode ser negativa.");
        }
        return estoqueRepository.save(estoque);
    }

    public Estoque delete(long id) {
        Estoque estoque = estoqueRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Estoque não encontrado com o ID: " + id));
        estoqueRepository.delete(estoque);
        return estoque;
    }


}
