package com.project.restfiltering;

import com.project.restfiltering.controlller.ProductController;
import com.project.restfiltering.model.Product;
import com.project.restfiltering.service.ProductService;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
//Tests still need to be fixed. Issue : repository
class ProductControllerTest {

    @Mock
    private ProductService productService = new ProductService();

    @InjectMocks
    private ProductController productController = new ProductController();

    @Test
    public void testGetAllProducts() {
        // Arrange
        List<Product> products = Arrays.asList(
                new Product("11111", "Carrefour Procurement Management", "ASYX", 15, 0, 10),
                new Product("2222222", "Bank Negara Indonesia (BNI) Financial Supply Chain Management", "ASYX", 18, 5, 20)
        );
        Mockito.when(productService.sortByPrice()).thenReturn(products);

        // Act
        List<Product> result = productController.sortByPrice();

        // Assert
        Assert.assertEquals(products, result);
    }
}
