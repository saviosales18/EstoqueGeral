package com.estoquegeral.service;

import com.estoquegeral.exception.ResourceNotFoundException;
import com.estoquegeral.model.Stock;
import com.estoquegeral.repository.StockRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StockService {

    @Autowired
    private StockRepository stockRepository;

    public List<Stock> listAll() {
        return stockRepository.findAll(); //lista todos os produtos em estoque
    }

    public Optional<Stock> findById(Long id) {
        return stockRepository.findById(id); //busca produto por ID
    }

    public Stock save(Stock stock) {
        // Validação já é feita via @Valid no controller
        return stockRepository.save(stock); //salva o produto no estoque
    }

    public Stock update(Long id, Stock stock) {
        if (!stockRepository.existsById(id)) {
            throw new ResourceNotFoundException("Estoque não encontrado com ID: " + id);
        }
        stock.setId(id); // Define o ID do estoque a ser atualizado
        return stockRepository.save(stock); //atualiza o produto no estoque
    }

    public Stock delete(long id) {
        Stock stock = stockRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Estoque não encontrado com ID: " + id));
        stockRepository.deleteById(id);
        return stock; //deleta o produto do estoque
    }
}