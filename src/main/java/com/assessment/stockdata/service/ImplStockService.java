package com.assessment.stockdata.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import com.assessment.stockdata.model.Stock;
import com.assessment.stockdata.repository.StockRepository;

@Service
public class ImplStockService implements StockService {

    @Autowired
    private StockRepository stockRepo;

    @Autowired
    MongoTemplate mongoTemplate;

    @Value("${mongodb.installation.path}")
    private String MONGODBPATH;

    public void importData(String filePath) {

        System.out.println("filepath" + filePath + "Path of mongodb = " + MONGODBPATH);
        Runtime r = Runtime.getRuntime();
        Process p = null;
        String command = MONGODBPATH
                + " --host localhost --port 27017 --db megha --collection stock --type=csv -- headerline --file="
                + filePath;
        try {
            p = r.exec(command);
            System.out.println("Importing data in database");

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error while executing " + command + e.toString());
        }
    }

    public void queryDocument() {
    }

    @Override
    public List<Stock> listAll() {

        List<Stock> returnedList = (List<Stock>) stockRepo.findAll(Sort.by(Sort.Direction.ASC, "stock"));
        System.out.println("******** returned list = " + returnedList.size());
        return returnedList;

    }

    @Override
    public List<Stock> getByStock(String stock) {
        List<Stock> returnedList = (List<Stock>) stockRepo.findAllByStock(stock);
        return returnedList;
    }

    @Override
    public Stock saveOrUpdate(Stock stock) {
        stockRepo.save(stock);
        return stock;
    }

}
