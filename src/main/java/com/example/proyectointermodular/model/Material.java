package com.example.proyectointermodular.model;

import jakarta.persistence.*;

@Entity
@Table(name = "material_product")
public class Material {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false, unique = true)
    private String name;

    /**
     * Constructor vacio.
     */
    public Material() {
    }

    /**
     * Constructor con todos los atributos
     * @param id ID de material.
     * @param name Nombre del material.
     */
    public Material(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    /**
     * Getter para obtener el ID de material.
     * @return Devuelve el ID de material.
     */
    public Long getId() {
        return id;
    }

    /**
     * Setter para establecer el ID de material.
     * @param id ID del nuevo material.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Getter para obtener el nombre de material.
     * @return Devuelve el ID de material.
     */
    public String getName() {
        return name;
    }

    /**
     * Setter para establecer el nombre de material.
     * @param name Nombre del nuevo material.
     */
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Material{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
