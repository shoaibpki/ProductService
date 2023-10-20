package com.myecommerce.ProductService.service;

import com.myecommerce.ProductService.entity.Product;
import com.myecommerce.ProductService.exception.ProductCustomException;
import com.myecommerce.ProductService.model.ProductRequest;
import com.myecommerce.ProductService.model.ProductResponse;
import com.myecommerce.ProductService.repository.ProductRepository;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import static org.springframework.beans.BeanUtils.*;

@Service
@Log4j2
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {

    ProductRepository productRepository;
    @Override
    public Long addProduct(ProductRequest productRequest) {
        log.info("Adding Product....");
        Product product = Product.builder()
                .productName(productRequest.getName())
                .price(productRequest.getPrice())
                .quantity(productRequest.getQuantity())
                .build();
        productRepository.save(product);
        log.info("Product Created....");
        return product.getProductId();
    }

    @Override
    public ProductResponse getProductById(Long productId) {
        log.info("Get product for productId: {}",productId);

        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new
                        ProductCustomException("Product with given Id not Found","PRODUCT_NOT_FOUND"));

        ProductResponse productResponse = new ProductResponse();
        copyProperties(product, productResponse);
        return productResponse;
    }
}
