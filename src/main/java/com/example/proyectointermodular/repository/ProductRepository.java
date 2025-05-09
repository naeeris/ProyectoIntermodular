package com.example.proyectointermodular.repository;

import com.example.proyectointermodular.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    // Para obtener productos filtrando por el ID del tipo
    List<Product> findByType_Id(Long typeId);

    // Para obtener productos filtrando por el ID del material
    List<Product> findByMaterial_Id(Long materialId);

    // Para combinar filtros: productos que tienen un determinado tipo y material
    List<Product> findByType_IdAndMaterial_Id(Long typeId, Long materialId);



}
