package com.example.proyectointermodular.controller;

import com.example.proyectointermodular.repository.MaterialRepository;
import com.example.proyectointermodular.repository.ProductRepository;
import com.example.proyectointermodular.repository.TypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private TypeRepository typeRepository;

    @Autowired
    private MaterialRepository materialRepository;



}
