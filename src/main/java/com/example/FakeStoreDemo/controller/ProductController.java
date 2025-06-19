package com.example.FakeStoreDemo.controller;

import com.example.FakeStoreDemo.dto.ProductDTO;
import com.example.FakeStoreDemo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductController {

@Autowired
private ProductService productService;

@GetMapping("/products")
    public ProductDTO[] getAllProducts()
{
  return productService.getAllProducts();
}
@GetMapping("/products/{id}")
    public ResponseEntity<ProductDTO> getProductById(@PathVariable int id)
{
    if(id<=0)
        throw new IllegalArgumentException("Product Id is not valid");
    else
    {
        ProductDTO productDTO = productService.getProductById(id);
        return new ResponseEntity<>(productDTO, HttpStatus.OK);
    }

}
@PostMapping("/products")
    public ProductDTO addProduct(@RequestBody ProductDTO productDTO)
{
    return productService.addProduct(productDTO);
}

@PutMapping("/products/{id}")
    public ProductDTO replaceProductById(@PathVariable int id, @RequestBody ProductDTO productDTO)
{
    return productService.replaceProductById(id,productDTO);
}
@DeleteMapping("/products/{id}")
    public boolean deleteProductById(@PathVariable int id)
{
    return productService.deleteProductById(id);
}
@ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> handleException(IllegalArgumentException e)
{
    return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
}
}
