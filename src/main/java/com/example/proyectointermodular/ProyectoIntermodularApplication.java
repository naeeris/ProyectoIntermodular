package com.example.proyectointermodular;

import com.example.proyectointermodular.model.Material;
import com.example.proyectointermodular.model.Product;
import com.example.proyectointermodular.model.Type;
import com.example.proyectointermodular.repository.MaterialRepository;
import com.example.proyectointermodular.repository.ProductRepository;
import com.example.proyectointermodular.repository.TypeRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;

@SpringBootApplication
public class ProyectoIntermodularApplication {

    public static void main(String[] args) {

        ApplicationContext context = SpringApplication.run(ProyectoIntermodularApplication.class, args);
        System.out.println("Aplicación Arrancada");

        //Obtener repositorios
        var productRepo = context.getBean(ProductRepository.class);
        var typeRepo = context.getBean(TypeRepository.class);
        var materialRepo = context.getBean(MaterialRepository.class);

        // Crear y guardar Type y Material primero
        List<Type> types = List.of(
                new Type(null, "Necklace"),
                new Type(null, "Bracelet"),
                new Type(null, "Ring")
        );
        typeRepo.saveAll(types);

        List<Material> materials = List.of(
                new Material(null, "Gold"),
                new Material(null, "Silver"),
                new Material(null, "Stainless steel")

        );
        materialRepo.saveAll(materials);

        List<Type> savedTypes = typeRepo.findAll(); // [Necklace, Bracelet, Ring]
        List<Material> savedMaterials = materialRepo.findAll(); // [Gold, Silver, Stainless steel]


        List<Product> products = List.of(
                new Product(null, "Collar floral", savedTypes.get(0), savedMaterials.get(0), "Collar de 15 cm.", 25.99),
                new Product(null, "Pulsera floral", savedTypes.get(1), savedMaterials.get(1), "Pulsera de 8 cm.", 15.99),
                new Product(null, "Anillo floral", savedTypes.get(2), savedMaterials.get(2), "Anillo talla 12.", 20.99)
        );

        productRepo.saveAll(products);

    }
}
