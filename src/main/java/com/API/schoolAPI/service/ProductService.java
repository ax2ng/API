package com.API.schoolAPI.service;


import com.API.schoolAPI.model.ProductModel;

import java.util.List;
import java.util.UUID;

public interface ProductService {
    public List<ProductModel> findAllProducts();

    public ProductModel findProductById(UUID id);

    public ProductModel addProduct(ProductModel product);

    public ProductModel updateProduct(ProductModel product);

    public void deleteProduct(UUID id);
}
