package com.estoquegeral.service;

import com.estoquegeral.model.Stock;
import com.estoquegeral.repository.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class StockService {

    @Autowired
    private StockRepository stockRepository;

    public List<Stock> listAll() {
        return stockRepository.findAll();
    }

    public Stock save(Stock stock) {
        if (stock.getQuantity() < 0) {
            throw new IllegalArgumentException("Quantity cannot be negative.");
        }
        return stockRepository.save(stock);
    }

    public Stock delete(long id) {
        Stock stock = stockRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Inventory not found with ID: " + id));
        stockRepository.delete(stock);
        return stock;
    }

}
