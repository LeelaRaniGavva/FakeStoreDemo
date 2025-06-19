package com.example.FakeStoreDemo.client;

import com.example.FakeStoreDemo.dto.ProductDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.HttpMessageConverterExtractor;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@Component
public class FakeStoreClient
{
    @Autowired
    RestTemplate restTemplate;

    public ProductDTO[] getAllProducts()
    {
        String url="https://fakestoreapi.com/products";
        return restTemplate.getForObject(url, ProductDTO[].class);
    }
    public ProductDTO getProductById(int id)
    {
        String url="https://fakestoreapi.com/products/"+id;
        return restTemplate.getForObject(url, ProductDTO.class);
    }
    public ProductDTO addProduct(ProductDTO productDTO)
    {
        String url="https://fakestoreapi.com/products";
        return restTemplate.postForObject(url,productDTO,ProductDTO.class);
    }
    public  ProductDTO replaceProductById(int id,  ProductDTO productDTO)
    {
        String url="https://fakestoreapi.com/products/"+id;
        return  requestForObject(url,HttpMethod.PUT,productDTO,ProductDTO.class);
    }
    public boolean deleteProductById(int id)
    {
        String url="https://fakestoreapi.com/products/"+id;
        try {
            requestForObject(url, HttpMethod.DELETE, null, ProductDTO.class);
            return true;
        }
        catch (Exception e)
        {
            System.out.println(e);
            return false;
        }
    }
    public <T> T requestForObject(String url, HttpMethod httpMethod,@Nullable Object request, Class<T> responseType, Object... uriVariables) throws RestClientException {
        RequestCallback requestCallback = restTemplate.httpEntityCallback(request, responseType);
        HttpMessageConverterExtractor<T> responseExtractor = new HttpMessageConverterExtractor(responseType, restTemplate.getMessageConverters());
        return (T)restTemplate.execute(url, httpMethod, requestCallback, responseExtractor, uriVariables);
    }
}
