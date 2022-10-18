package com.assessment.stockdata.service;

import com.assessment.stockdata.model.Stock;

import com.assessment.stockdata.repository.StockRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

public interface StockService {
  List<Stock> listAll();

  Stock saveOrUpdate(Stock stock);

  List<Stock> getByStock(String stock);

  void importData(String stockForm);

}