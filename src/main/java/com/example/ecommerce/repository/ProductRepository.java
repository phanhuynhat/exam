package com.example.ecommerce.repository;





import com.example.ecommerce.entity.Product;
import com.example.ecommerce.entity.ProductDTO;
import com.example.ecommerce.entity.ProductDTOTest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.Tuple;
import java.util.List;


@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {


@Query(value = "select p.id AS id, p.price AS price, p.product_name AS productName, p.category_id AS categoryId, c.category_name AS nameCategory from product p inner join category c on p.category_id = c.id LIMIT 10 OFFSET ?1", nativeQuery = true)
List<ProductDTOTest> getAllProducts(int page);

@Query(value = "select p.id, p.price, p.product_name AS productName, c.category_name AS nameCategory from product p inner join category c on p.category_id = c.id", nativeQuery = true)
List<Tuple> getAllProductTuple();

@Query(value = "select count(*) from product", nativeQuery = true)
Integer countProduct();
}
