package com.hs.e.Com.service;

import com.hs.e.Com.entity.Category;
import com.hs.e.Com.entity.Product;
import com.hs.e.Com.exception.ProductNotFoundException;
import com.hs.e.Com.repository.CategoryRepository;
import com.hs.e.Com.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    public ProductService(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    public Product createProduct(Product product){
        if (product.getCategory() != null) {
            Long categoryId = product.getCategory().getId();

            Category category = categoryRepository.findById(categoryId)
                    .orElseThrow(() ->
                            new RuntimeException(
                                    "Category not found with id: " + categoryId
                            ));

            product.setCategory(category);
        }
        return productRepository.save(product);
    }

    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }

    public Product getProductById(Long id){

        return productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("Product not found with id: "+id));
    }

    public Product updateProduct(Long id, Product updatedProduct){
        Product existingProduct = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));

        existingProduct.setName(updatedProduct.getName());
        existingProduct.setDescription(updatedProduct.getDescription());
        existingProduct.setPrice(updatedProduct.getPrice());

        return productRepository.save(existingProduct);
    }

    public void deleteProduct(Long id){
        productRepository.deleteById(id);
    }
}
