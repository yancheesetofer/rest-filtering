package com.project.restfiltering.controlller;

import com.project.restfiltering.model.Product;
import com.project.restfiltering.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/filter/price/{initialRange}/{finalRange}")
    public List<Product> filterByPriceRange(@PathVariable Integer initialRange, @PathVariable Integer finalRange) {
        return productService.filterByPriceRange(initialRange, finalRange);
    }

    @GetMapping("/sort/price")
    public List<Product> sortByPrice() {
        return productService.sortByPrice();
    }
}

