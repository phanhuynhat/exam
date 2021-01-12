package com.example.ecommerce.service.impl;

import com.example.ecommerce.entity.Product;
import com.example.ecommerce.entity.ProductDTO;
import com.example.ecommerce.entity.ProductDTOTest;
import com.example.ecommerce.repository.ProductRepository;
import com.example.ecommerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class ProductServiceImpl implements ProductService {

  @Autowired
  ProductRepository productRepository;


  @Override
  public List<Product> findAllProduct() {
    return productRepository.findAll();
  }

  @Override
  public List<ProductDTOTest> getAllProducts(int page) {
   return (List) productRepository.getAllProducts(page);
  }

  @Override
  public void saveProduct(Product product) {
    productRepository.save(product);
  }

  @Override
  public void deleteProduct(int id) {
    productRepository.deleteById(id);
  }

  @Override
  public Product getProductById(int id) {
    return  productRepository.findById(id).orElse(null);
  }

  @Override
  public Integer countProduct() {
    return productRepository.countProduct();
  }

}
