package com.estoquegeral.service;

import com.estoquegeral.dto.StockListAllDTO;
import com.estoquegeral.dto.StockSaveDTO;
import com.estoquegeral.dto.StockUpdateDTO;
import com.estoquegeral.exception.ResourceNotFoundException;
import com.estoquegeral.model.Stock;
import com.estoquegeral.repository.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class StockService {

    @Autowired
    private StockRepository stockRepository;

    public List<StockListAllDTO> listAllDTO() {
        return stockRepository.findAll()
                .stream()
                .map(this::convertToListAllDTO)
                .toList();
    }

    public Optional<Stock> findById(Long id) {
        return stockRepository.findById(id);
    }

    public StockListAllDTO saveDTO(StockSaveDTO dto) {
        if (stockRepository.existsByName(dto.getName())) {
            throw new IllegalArgumentException("Já existe um produto com o nome " + dto.getName());
        }
        Stock stock = convertToEntity(dto);
        Stock saved = stockRepository.save(stock);
        return convertToListAllDTO(saved);
    }

    public StockListAllDTO updateDTO(Long id, StockUpdateDTO dto) {
        Stock stock = stockRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Produto com ID " + id + " não encontrado."));

        // Permitir atualização parcial (se não for null, atualiza)
        if (dto.getName() != null && !dto.getName().equals(stock.getName())) {
            if (stockRepository.existsByName(dto.getName())) {
                throw new IllegalArgumentException("Já existe um produto com o nome " + dto.getName());
            }
            stock.setName(dto.getName());
        }

        if (dto.getQuantity() != null && dto.getQuantity() < 0) {
            throw new IllegalArgumentException("Quantidade não pode ser negativa");
        }

        if (dto.getGroup() != null) stock.setGroup(dto.getGroup());
        if (dto.getBrand() != null) stock.setBrand(dto.getBrand());
        if (dto.getDescription() != null) stock.setDescription(dto.getDescription());
        if (dto.getUnit() != null) stock.setUnit(dto.getUnit());
        if (dto.getLocation() != null) stock.setLocation(dto.getLocation());
        if (dto.getQuantity() != null) stock.setQuantity(dto.getQuantity());

        Stock updated = stockRepository.save(stock);
        return convertToListAllDTO(updated);
    }

    public void delete(long id) {
        if (!stockRepository.existsById(id)) {
            throw new ResourceNotFoundException("Produto não encontrado com ID: " + id);
        }
        stockRepository.deleteById(id);
    }

    // MÉTODOS PRIVADOS PARA CONVERSÃO ENTRE ENTIDADE E DTOs
    private Stock convertToEntity(StockSaveDTO dto) {
        Stock stock = new Stock();
        stock.setName(dto.getName());
        stock.setGroup(dto.getGroup());
        stock.setBrand(dto.getBrand());
        stock.setDescription(dto.getDescription());
        stock.setUnit(dto.getUnit());
        stock.setQuantity(dto.getQuantity());
        stock.setLocation(dto.getLocation());
        return stock;
    }

    private StockListAllDTO convertToListAllDTO(Stock stock) {
        StockListAllDTO dto = new StockListAllDTO();
        dto.setId(stock.getId());
        dto.setName(stock.getName());
        dto.setGroup(stock.getGroup());
        dto.setBrand(stock.getBrand());
        dto.setDescription(stock.getDescription());
        dto.setUnit(stock.getUnit());
        dto.setQuantity(stock.getQuantity());
        dto.setLocation(stock.getLocation());
        return dto;
    }

}