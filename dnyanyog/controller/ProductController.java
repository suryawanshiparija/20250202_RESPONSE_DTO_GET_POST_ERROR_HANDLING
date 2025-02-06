package org.dnyanyog.controller;

import org.dnyanyog.dto.Product;
import org.dnyanyog.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    private final ProductService productService = new ProductService();

    @PostMapping("/add")
    public String addProduct(@RequestBody Product product) {
        return productService.addProduct(product);
    }

    @GetMapping("/search/{name}")
    public List<Product> searchProduct(@PathVariable String name) {
        return productService.searchProduct(name);
    }
}
