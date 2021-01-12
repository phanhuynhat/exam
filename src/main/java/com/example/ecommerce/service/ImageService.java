package com.example.ecommerce.service;

import com.example.ecommerce.entity.Image;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ImageService {
  void saveImage(Image image);
  List<Image> getAllImage();
}
