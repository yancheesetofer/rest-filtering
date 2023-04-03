package com.project.restfiltering.repository;

import com.project.restfiltering.model.Product;
import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, String> {

    @NonNull
    List<Product> findByPriceBetween(Integer initialRange, Integer finalRange);

    List<Product> findAllByOrderByPriceAsc();
}

