package com.example.FakeStoreDemo.client;

import com.example.FakeStoreDemo.dto.ProductResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class FakeStoreClient
{
    @Autowired
    RestTemplate restTemplate;

    public ProductResponseDTO[] getAllProducts()
    {
        String url="https://fakestoreapi.com/products";
        return restTemplate.getForObject(url,ProductResponseDTO[].class);
    }
    public  ProductResponseDTO getProductById(int id)
    {
        String url="https://fakestoreapi.com/products/"+id;
        return restTemplate.getForObject(url,ProductResponseDTO.class);
    }
}
