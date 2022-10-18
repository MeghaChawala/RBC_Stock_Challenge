package com.assessment.stockdata.repository;

import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.assessment.stockdata.model.Stock;

public interface StockRepository extends MongoRepository<Stock, String> {
    List<Stock> findAllByStock(String stock);

    List<Stock> findAll(Sort by);

}
