package com.estoquegeral.service;

import com.estoquegeral.model.Stock;
import com.estoquegeral.repository.StockRepository;
import org.springframework.stereotype.Service;

@Service
public class EntryService {

    private final StockRepository stockRepository;

    public EntryService(StockRepository stockRepository) {
        this.stockRepository = stockRepository;
    }

    public Stock adicionarEntrada(Long id, double quantidade) {
        Stock stock = stockRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado com ID: " + id));

        stock.setQuantity(stock.getQuantity() + quantidade);
        return stockRepository.save(stock);
    }
}