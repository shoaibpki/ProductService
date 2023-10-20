package com.myecommerce.ProductService.service;

import com.myecommerce.ProductService.model.ProductRequest;
import com.myecommerce.ProductService.model.ProductResponse;
import org.springframework.stereotype.Service;

public interface ProductService {
    Long addProduct(ProductRequest productRequest);

    ProductResponse getProductById(Long productId);

    void reduceQuantity(long productId, long quantity);
}
