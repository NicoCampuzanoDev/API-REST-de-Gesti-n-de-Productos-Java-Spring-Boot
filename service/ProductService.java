package com.nico.api.service;

import com.nico.api.model.Product;
import com.nico.api.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository repository;

    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    public List<Product> findAll() {
        return repository.findAll();
    }

    public Product save(Product product) {
        return repository.save(product);
    }

    public Product update(Long id, Product productData) {
        Product product = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));

        product.setNombre(productData.getNombre());
        product.setPrecio(productData.getPrecio());
        product.setStock(productData.getStock());

        return repository.save(product);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
