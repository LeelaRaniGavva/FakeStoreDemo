package com.example.FakeStoreDemo.controller;

import com.example.FakeStoreDemo.dto.ProductResponseDTO;
import com.example.FakeStoreDemo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

@Autowired
private ProductService productService;

@GetMapping("/products")
    public ProductResponseDTO[] getAllProducts()
{
  return productService.getAllProducts();
}
@GetMapping("/products/{id}")
    public ProductResponseDTO getProductById(@PathVariable int id)
{
      return productService.getProductById(id);
}

}
