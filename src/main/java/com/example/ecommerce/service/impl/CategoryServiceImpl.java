package com.example.ecommerce.service.impl;

import com.example.ecommerce.entity.Category;
import com.example.ecommerce.repository.CategoryRepository;
import com.example.ecommerce.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

  @Autowired
  CategoryRepository categoryRepository;

  @Override
  public List<Category> getAllCategory() {
    return (List) categoryRepository.findAll();
  }

  @Override
  public Category findById(int id) {
    return categoryRepository.findById(id).orElse(null);
  }
}
