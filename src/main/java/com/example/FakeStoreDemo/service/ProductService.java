package com.example.FakeStoreDemo.service;

import com.example.FakeStoreDemo.client.FakeStoreClient;
import com.example.FakeStoreDemo.dto.ProductDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    @Autowired
    private FakeStoreClient fakeStoreClient;

    public ProductDTO[] getAllProducts()
    {
        return fakeStoreClient.getAllProducts();
    }
    public ProductDTO getProductById(int id)
    {
        return fakeStoreClient.getProductById(id);
    }
    public  ProductDTO addProduct(ProductDTO productDTO)
    {
        return fakeStoreClient.addProduct(productDTO);
    }
    public  ProductDTO replaceProductById(int id,ProductDTO productDTO)
    {
        return fakeStoreClient.replaceProductById(id,productDTO);
    }
    public boolean deleteProductById(int id)
    {
        return fakeStoreClient.deleteProductById(id);
    }
}
