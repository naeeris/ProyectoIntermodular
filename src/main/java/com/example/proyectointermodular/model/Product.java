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

    /**
     * Setter para establecer el tipo.
     * @param type Tipo de producto.
     */
    public void setType(Type type) {
        this.type = type;
    }

    /**
     * Getter para obtener el material.
     * @return Devuelve el material.
     */
    public Material getMaterial() {
        return material;
    }

    /**
     * Setter para establecer el material.
     * @param material Material del producto.
     */
    public void setMaterial(Material material) {
        this.material = material;
    }

    /**
     * Getter para obtener la descripcion.
     * @return Devuelve la descripcion.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Setter para establecer la descripcion.
     * @param description Descripcion del producto.
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Getter para obtener el precio.
     * @return Devuelve el precio del producto.
     */
    public double getPrice() {
        return price;
    }

    /**
     * Setter para establecer el precio.
     * @param price Precio del producto.
     */
    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type=" + type +
                ", material=" + material +
                ", description='" + description + '\'' +
                ", price=" + price +
                '}';
    }
}
