package com.nico.api.controller;

import com.nico.api.model.Product;
import com.nico.api.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/productos")
public class ProductController {

    private final ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    @GetMapping
    public List<Product> listar() {
        return service.findAll();
    }

    @PostMapping
    public Product crear(@RequestBody Product product) {
        return service.save(product);
    }

    @PutMapping("/{id}")
    public Product actualizar(@PathVariable Long id, @RequestBody Product product) {
        return service.update(id, product);
    }

    @DeleteMapping("/{id}")
    public String eliminar(@PathVariable Long id) {
        service.delete(id);
        return "Producto eliminado";
    }
}
