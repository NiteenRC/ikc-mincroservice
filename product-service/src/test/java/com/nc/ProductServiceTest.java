package com.nc;

import com.nc.common.Category;
import com.nc.common.ProductCategoryRequest;
import com.nc.common.ProductCategoryResponse;
import com.nc.model.Product;
import com.nc.service.IProductService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
public class ProductServiceTest {

    @MockBean
    private IProductService iProductService;

    @Test
    public void shouldReturnAllProducts() {
        Product product1 = new Product(1L, "Apple");
        Product product2 = new Product(2L, "Samsung");
        when(iProductService.findAll()).thenReturn(Arrays.asList(product1, product2));

        List<Product> products = iProductService.findAll();
        assertTrue(2 == products.size());
    }

    @Test
    public void shouldReturnAllProducts1() {
        Product product1 = new Product(1L, "Apple");
        Product product2 = new Product(2L, "Samsung");

        Category category1 = new Category(1L, "Mobiles");
        Category category2 = new Category(3L, "Laptops");

        ProductCategoryRequest productCategoryRequest1 = new ProductCategoryRequest(product1, category1);
        ProductCategoryResponse productCategoryResponse = new ProductCategoryResponse(product2, category2, "Request is Successful");

        when(iProductService.save(productCategoryRequest1)).thenReturn(productCategoryResponse);

        ProductCategoryResponse productActual = iProductService.save(productCategoryRequest1);
        assertNotNull(productActual);
        assertEquals(productActual, product1);
    }
}
