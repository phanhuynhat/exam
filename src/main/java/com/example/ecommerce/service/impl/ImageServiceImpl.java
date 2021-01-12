package com.example.ecommerce.service.impl;

import com.example.ecommerce.entity.Image;
import com.example.ecommerce.repository.ImageRepository;
import com.example.ecommerce.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImageServiceImpl implements ImageService {

  @Autowired
  ImageRepository imageRepository;

  @Override
  public void saveImage(Image image) {
    imageRepository.save(image);
  }

  @Override
  public List<Image> getAllImage() {
    return imageRepository.findAll();
  }
}
