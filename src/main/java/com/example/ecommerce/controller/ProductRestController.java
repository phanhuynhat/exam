package com.example.ecommerce.controller;

import com.example.ecommerce.dto.CategoryDTO;
import com.example.ecommerce.dto.ProductDTONew;
import com.example.ecommerce.entity.*;
import com.example.ecommerce.repository.CategoryRepository;
import com.example.ecommerce.repository.ProductRepository;
import com.example.ecommerce.service.CategoryService;
import com.example.ecommerce.service.ImageService;
import com.example.ecommerce.service.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Tuple;
import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/productAPI")
public class ProductRestController {

    @Autowired
    ProductService productService;

    @Autowired
    CategoryService categoryService;

    @Autowired
    ImageService imageService;

    @Autowired
    ProductRepository productRepository;

    @Autowired
    CategoryRepository categoryRepository;

    @RequestMapping(value = "admin")
    public List<ProductDTONew> showPageAdmin(Model model) {
        List<Tuple> tuples = productRepository.getAllProductTuple();
        List<ProductDTONew> productList = tuples
                                        .stream()
                                        .map(tuple -> new ProductDTONew((Integer) tuple.get("id"), String.valueOf(tuple.get("productName")), (Double) tuple.get("price"),String.valueOf(tuple.get("nameCategory"))))
                                        .collect(Collectors.toList());

        return productList;
    }

    @RequestMapping(value = "getListCategory")
    public List<CategoryDTO> getAllCategory(){
    List<Tuple> tuples = categoryRepository.getAllCategoryTuple();
        List<CategoryDTO> categories = tuples
                .stream()
                .map(tuple -> new CategoryDTO((Integer) tuple.get("id"), String.valueOf(tuple.get("categoryName"))))
                .collect(Collectors.toList());
    return categories;
    }

//    @PostMapping("addProduct")
//    public int addNewProduct(@RequestBody ProductDTO productDTO){
//        Product product = new Product();
//        if(productDTO.getId() != 0){
//
//        }
//
//        product.setProductName(productDTO.getProductName());
//        product.setPrice(productDTO.getPrice());
//        Category category = categoryService.findById(productDTO.getCategory());
//        product.setCategory(category);
//        productService.saveProduct(product);
//
//        return 1;
//    }

    @PostMapping("addProduct")
    public int addNewProduct(@ModelAttribute ProductDTO productDTO){
        Product product = new Product();
        if(productDTO.getId() != 0)
        {
            product.setId(productDTO.getId());
        }
        product.setProductName(productDTO.getProductName());
        product.setPrice(productDTO.getPrice());
        Category category = categoryService.findById(productDTO.getCategory());

        product.setCategory(category);
        productService.saveProduct(product);

        return 1;
    }

    @GetMapping("deleteProduct/{id}")
    public int deleteProduct(@PathVariable int id){
        productRepository.deleteById(id);
        return 1;
    }

}
