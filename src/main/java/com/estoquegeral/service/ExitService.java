package com.estoquegeral.service;

import com.estoquegeral.model.Stock;
import com.estoquegeral.repository.StockRepository;
import org.springframework.stereotype.Service;

@Service
public class ExitService {

    private final StockRepository stockRepository;

    public ExitService(StockRepository stockRepository) {
        this.stockRepository = stockRepository;
    }

    public Stock registrarSaida(Long id, double quantidade) {
        Stock stock = stockRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado com ID: " + id));

        if (stock.getQuantity() < quantidade) {
            throw new RuntimeException("Quantidade insuficiente no estoque!");
        }

        stock.setQuantity(stock.getQuantity() - quantidade);
        return stockRepository.save(stock);
    }
}
