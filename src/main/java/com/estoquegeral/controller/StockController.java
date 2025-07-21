package com.estoquegeral.controller;


import com.estoquegeral.dto.StockListAllDTO;
import com.estoquegeral.dto.StockSaveDTO;
import com.estoquegeral.dto.StockUpdateDTO;
import com.estoquegeral.service.StockService;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/estoque")
public class StockController {

    @Autowired
    private StockService stockService;

    @GetMapping("/get")
    public ResponseEntity<List<StockListAllDTO>> listAll() {
        List<StockListAllDTO> dtoList = stockService.listAllDTO();
        return ResponseEntity.ok(dtoList);
    }

    @PostMapping("/post")
    public ResponseEntity<StockListAllDTO> save(@RequestBody @Valid StockSaveDTO dto) {
        StockListAllDTO saved = stockService.saveDTO(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    @PutMapping("/put/{id}")
    public ResponseEntity<StockListAllDTO> update(@PathVariable Long id, @RequestBody @Valid StockUpdateDTO dto) {
        StockListAllDTO updated = stockService.updateDTO(id, dto);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        stockService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
