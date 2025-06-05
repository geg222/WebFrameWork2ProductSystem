package kr.ac.hansung.cse.hellospringdatajpa.service;

import kr.ac.hansung.cse.hellospringdatajpa.entity.Product;

import java.util.List;

public interface ProductService {
    Product get(long id);
    List<Product> listAll();
    void save(Product product);
    void delete(long id);
}
