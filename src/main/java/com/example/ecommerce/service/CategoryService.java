package com.example.ecommerce.service;

import com.example.ecommerce.entity.Category;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CategoryService {
  List<Category> getAllCategory();
  Category findById(int id);
}
