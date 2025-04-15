package com.example.proyectointermodular.repository;

import com.example.proyectointermodular.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    // Para obtener productos filtrando por el ID del tipo
    List<Product> findByType_Id(Long typeId);

    // Para obtener productos filtrando por el ID del material
    List<Product> findByMaterial_Id(Long materialId);

    // Para combinar filtros: productos que tienen un determinado tipo Y material
    List<Product> findByType_IdAndMaterial_Id(Long typeId, Long materialId);

    /*
     * Nota:
     * Cuando tu entidad Product tiene atributos tipo objeto (por ejemplo, Type type), debes acceder
     * a sus propiedades mediante el separador de guion bajo (_). Es decir, findByType_Id consultará la propiedad id del objeto Type.
     */


}
