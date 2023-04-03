package com.project.restfiltering.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="product")
public class Product {

    @Id //as primary key
    private String barcode;

    private String item;
    //@Enumerated(EnumType.STRING)
    //to be done when categories are defined
    private String category;

    private Integer price;

    private Integer discount;

    private Integer available;

    // getters and setters
}

