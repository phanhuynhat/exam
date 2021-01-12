package com.example.ecommerce.controller;

import com.example.ecommerce.dto.ProductDTONew;
import com.example.ecommerce.entity.*;
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


@Controller
@RequestMapping(value = "/product")
public class ProductController {

    @Autowired
    ProductService productService;

    @Autowired
    CategoryService categoryService;

    @Autowired
    ImageService imageService;

    @Autowired
    ProductRepository productRepository;

    @RequestMapping(method = RequestMethod.GET)
    public String showHome() {
        return "home";
    }


    @RequestMapping(value = "admin")
    public String showPageAdmin(Model model) {
        Product product = new Product();
        ModelMapper modelMapper = new ModelMapper();
        model.addAttribute("product", product);
        List<Tuple> tuples = productRepository.getAllProductTuple();

//        Type listType = new TypeToken<List<ProductDTONew>>(){}.getType();
//
//        List<ProductDTONew> postDTOList = modelMapper.map(tuples, listType);

        List<ProductDTONew> productList = tuples
                                        .stream()
                                        .map(tuple -> new ProductDTONew((Integer) tuple.get("id"), String.valueOf(tuple.get("productName")), (Double) tuple.get("price"),String.valueOf(tuple.get("nameCategory"))))
                                        .collect(Collectors.toList());

//        for( int i = 0; i<tuples.size(); i++){
//            Tuple postDTO = tuples.get(i);
//            ProductDTONew productDTONew = new ProductDTONew((Integer) postDTO.get("id"), String.valueOf(postDTO.get("productName")), (Double) postDTO.get("price"),String.valueOf(postDTO.get("nameCategory")));
//            productList.add(productDTONew);
//        }

        if (productList.isEmpty()) {
            model.addAttribute("message", "Not Found List Product!!!");
        } else {
            model.addAttribute("productList", productList);
        }
        return "adminPage";
    }

    @RequestMapping("addCategory")
    public String showPageAddCategory() {
        return "addCategory";
    }

//  @PostMapping("saveProduct")
//  public String saveProduct(@ModelAttribute Product product) {
//    productService.saveProduct(product);
//    return "redirect:/admin";
//  }

    @PostMapping("saveProduct")
    public String saveProductMaterial(@ModelAttribute Product product) {
        productService.saveProduct(product);

        return "adminPage";
    }

    @GetMapping("editProduct/{id}")
    public String showFormEdit(@PathVariable("id") int id, Model model) {
        Product product = productService.getProductById(id);
        List<Category> categories = categoryService.getAllCategory();
        List<Image> images = imageService.getAllImage();
        model.addAttribute("product", product);
        model.addAttribute("categories", categories);
        model.addAttribute("images", images);
        return "formEditProduct";
    }

    @GetMapping("deleteProduct/{id}")
    public String deleteProductById(@PathVariable("id") int id, Model model) {
        productService.deleteProduct(id);
        model.addAttribute("message", "The product deleted!!!");
        return "redirect:/admin";
    }

    @PostMapping("/saveProductAjax")
    public String saveProductAjax(@ModelAttribute ProductDTO productDTO, Model model) {
        Product product = new Product();
        product.setProductName(productDTO.getProductName());
        product.setPrice(productDTO.getPrice());
        product.setCategory(categoryService.findById(productDTO.getCategory()));
        productService.saveProduct(product);
        List<ProductDTOTest> productList = productService.getAllProducts(1);
        model.addAttribute("productList", productList);
        return "include/table";
    }


}
