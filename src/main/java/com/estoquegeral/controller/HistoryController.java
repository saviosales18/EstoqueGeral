package com.estoquegeral.controller;

import com.estoquegeral.model.History;
import com.estoquegeral.service.HistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/historico")
@CrossOrigin(origins = "*")
public class HistoryController {

    @Autowired
    private HistoryService historyService;

    @GetMapping
    public List<History> listarHistorico() {
        return historyService.listarHistorico();
    }
}
