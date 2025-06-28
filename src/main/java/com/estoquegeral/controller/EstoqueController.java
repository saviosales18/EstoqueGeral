package com.estoquegeral.controller;

import com.estoquegeral.model.Estoque;
import com.estoquegeral.service.EstoqueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/estoque")
public class EstoqueController {

    @Autowired
    private EstoqueService estoqueService;

    @GetMapping
    public List<Estoque> listAll() {
        return estoqueService.listAll();
    }

    @PostMapping
    public Estoque save(@RequestBody Estoque estoque) {
        return estoqueService.save(estoque);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        estoqueService.delete(id);
    }
}
