package com.example.proyectointermodular.model;

import jakarta.persistence.*;

@Entity
@Table(name = "type_product")
public class Type {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false, unique = true)
    private String name;

    //Constructor vacio

    /**
     * Constructor vacio
     */
    public Type() {
    }

    /**
     * Constructor con todos los atributos
     * @param id ID de tipo.
     * @param name Nombre del tipo.
     */
    public Type(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    /**
     * Getter para obtener el ID de tipo.
     * @return Devuelve el ID de tipo.
     */
    public Long getId() {

        return id;
    }

    /**
     * Setter para establecer el ID de tipo.
     * @param id ID del nuevo tipo.
     */
    public void setId(Long id) {

        this.id = id;
    }

    /**
     * Getter para obtener el nombre de tipo.
     * @return Devuelve el nombre de tipo.
     */
    public String getName() {

        return name;
    }

    /**
     * Setter para establecer el nombre de tipo.
     * @param name Nombre del nuevo tipo.
     */
    public void setName(String name) {

        this.name = name;
    }

    @Override
    public String toString() {
        return "Type{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
