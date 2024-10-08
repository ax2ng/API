package com.API.schoolAPI.service;

import com.API.schoolAPI.model.ProductModel;
import com.API.schoolAPI.model.StudentModel;
import com.API.schoolAPI.repository.ProductRepository;
import com.API.schoolAPI.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class InMemoryProductService implements ProductService {
    @Autowired
    private final ProductRepository productRepository;
    @Autowired
    private StudentRepository studentRepository;



    public InMemoryProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<ProductModel> findAllProducts(){
        return productRepository.findAll(Sort.by("id"));
    }

    @Override
    public ProductModel findProductById(UUID id) {
        return productRepository.findById(id).orElse(null);
    }

    @Override
    public ProductModel addProduct(ProductModel product) {
        // Сохраняем продукт
        ProductModel savedProduct = productRepository.save(product);

        // Обрабатываем студентов, если они есть
        if (product.getStudents() != null) {
            for (StudentModel student : product.getStudents()) {
                Optional<StudentModel> optionalStudent = studentRepository.findById(student.getId());
                if (optionalStudent.isPresent()) {
                    StudentModel existingStudent = optionalStudent.get();
                    existingStudent.getProducts().add(savedProduct); // Добавляем продукт к студенту
                    studentRepository.save(existingStudent); // Сохраняем изменения студента
                }
            }
        }

        return savedProduct;
    }

    @Override
    public ProductModel updateProduct(ProductModel product){
        if (productRepository.existsById(product.getId())) {
            return productRepository.save(product);
        }
        return null;
    }

    @Override
    public void deleteProduct(UUID id){
        if (productRepository.existsById(id)) {
            productRepository.deleteById(id);
        }
    }

}
