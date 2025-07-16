package com.estoquegeral.controller;

import com.estoquegeral.model.Entry;
import com.estoquegeral.service.EntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/entradas")
@CrossOrigin(origins = "*")
public class EntryController {

    @Autowired
    private EntryService entryService;

    @PostMapping
    public Entry salvarEntrada(@RequestBody Entry entrada) {
        return entryService.salvarEntrada(entrada);
    }

    @GetMapping
    public List<Entry> listarEntradas() {
        return entryService.listarEntradas();
    }
}
