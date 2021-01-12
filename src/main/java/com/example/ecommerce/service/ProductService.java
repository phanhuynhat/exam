package com.example.ecommerce.service;


import com.example.ecommerce.entity.Product;
import com.example.ecommerce.entity.ProductDTOTest;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public interface ProductService {
  List<Product> findAllProduct();
  List<ProductDTOTest> getAllProducts(int page);
  void saveProduct(Product product);
  void deleteProduct(int id);
  Product getProductById(int id);
  Integer countProduct();

}

