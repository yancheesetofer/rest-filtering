package com.project.restfiltering.service;

import com.project.restfiltering.model.Product;
import com.project.restfiltering.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> filterByPriceRange(Integer initialRange, Integer finalRange) {
        List<Product> products = productRepository.findByPriceBetween(initialRange, finalRange);
        if (products.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "sHoulD we reCheCK the RaNGe? :/");
        }
        return products;
    }

    public List<Product> sortByPrice() {
        return productRepository.findAllByOrderByPriceAsc();
    }
}
