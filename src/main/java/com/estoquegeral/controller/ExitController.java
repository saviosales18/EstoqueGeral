package com.estoquegeral.controller;

import com.estoquegeral.model.Exit;
import com.estoquegeral.service.ExitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/saidas")
@CrossOrigin(origins = "*")
public class ExitController {

    @Autowired
    private ExitService exitService;

    @PostMapping
    public Exit salvarSaida(@RequestBody Exit saida) {
        return exitService.salvarSaida(saida);
    }

    @GetMapping
    public List<Exit> listarSaidas() {
        return exitService.listarSaidas();
    }
}
