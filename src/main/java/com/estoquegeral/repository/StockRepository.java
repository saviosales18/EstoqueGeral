package com.estoquegeral.repository;

import com.estoquegeral.model.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface StockRepository extends JpaRepository<Stock, Long> {

    boolean existsByName(String name);
    Optional<Stock> findByName(String name);

}
