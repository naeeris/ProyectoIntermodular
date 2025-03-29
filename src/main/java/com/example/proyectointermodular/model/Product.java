package com.example.proyectointermodular.model;

import jakarta.persistence.*;

/**
 * Esta clase representa un producto con los atributos id, nombre, tipo, material, descripcion y precio.
 * Se han generado los metodos para poder hacer un CRUD de producto.
 * @author NoeliaCH
 * @version 1.0
 */

@Entity
@Table (name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name", nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name = "type_product_id", nullable = false)
    private Type type;

    @ManyToOne
    @JoinColumn(name = "material_product_id", nullable = false)
    private Material material;

    @Column(name = "description")
    private String description;

    @Column(name = "price", nullable = false)
    private double price;

    /**
     * Constructor vacio
     */
    public Product() {

    }

    /**
     * Constructor para poder crear un producto con todos sus atributos.
     * @param id ID del producto.
     * @param name Nombre del producto.
     * @param type Tipo de producto.
     * @param material Material del producto.
     * @param price Precio del producto.
     * @param description Descripción del producto.
     */
    public Product(long id, String name, Type type, Material material, String description, double price) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.material = material;
        this.description = description;
        this.price = price;
    }

    /**
     * Getter para obtener el ID.
     * @return Devuelve el ID.
     */
    public long getId() {
        return id;
    }

    /**
     * Setter para establecer el ID.
     * @param id ID del producto.
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * Getter para obtener el nombre.
     * @return Devuelve el nombre.
     */
    public String getName() {
        return name;
    }

    /**
     * Setter para establecer el nombre.
     * @param name Nombre del producto
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Getter para obtener el tipo.
     * @return Devuelve el tipo.
     */
    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
