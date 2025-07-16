package com.estoquegeral.service;

import com.estoquegeral.model.History;
import com.estoquegeral.repository.HistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class HistoryService {

    @Autowired
    private HistoryRepository historyRepository;

    public List<History> listarHistorico() {
        return historyRepository.findAll();
    }

    public History salvarMovimentacao(History historico) {
        return historyRepository.save(historico);
    }
}
