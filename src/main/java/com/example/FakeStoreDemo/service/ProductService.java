package com.example.FakeStoreDemo.service;

import com.example.FakeStoreDemo.client.FakeStoreClient;
import com.example.FakeStoreDemo.dto.ProductResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ProductService {
    @Autowired
    private FakeStoreClient fakeStoreClient;

    public ProductResponseDTO[] getAllProducts()
    {
        return fakeStoreClient.getAllProducts();
    }
    public ProductResponseDTO getProductById(int id)
    {
        return fakeStoreClient.getProductById(id);
    }
}
