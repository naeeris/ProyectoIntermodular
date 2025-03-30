package com.example.proyectointermodular.repository;

import com.example.proyectointermodular.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {


}
