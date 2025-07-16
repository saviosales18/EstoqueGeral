package com.estoquegeral.controller;

import com.estoquegeral.dto.StockDTO;
import com.estoquegeral.model.Stock;
import com.estoquegeral.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/stock")
public class StockController {

    @Autowired
    private StockService stockService;

    @GetMapping
    public List<Stock> listAll() {
        return stockService.listAll();
    }

    @PostMapping
    public ResponseEntity<Stock> save(@RequestBody @Valid Stock stock) {
        Stock saved = stockService.save(stock);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        stockService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
