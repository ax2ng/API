package com.API.schoolAPI.controllers;

import com.API.schoolAPI.model.ProductModel;
import com.API.schoolAPI.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/v1/api/products")
public class ProductApiController {
    @Autowired
    private final ProductService productService;

    public ProductApiController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<ProductModel> getAllProducts() {
        return productService.findAllProducts();
    }

    @GetMapping("/{id}")
    public ProductModel getProductById(@PathVariable UUID id){
        return productService.findProductById(id);
    }

    @PostMapping
    public ProductModel createProduct(@RequestBody ProductModel product){
        return productService.addProduct(product);
    }

    @PutMapping("/{id}")
    public ProductModel updateProduct(@PathVariable UUID id, @RequestBody ProductModel product){
        product.setId(id);
        return productService.updateProduct(product);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable UUID id){
        productService.deleteProduct(id);
    }
}
