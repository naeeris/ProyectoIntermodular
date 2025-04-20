package com.example.proyectointermodular.controller;

import com.example.proyectointermodular.model.Product;
import com.example.proyectointermodular.repository.MaterialRepository;
import com.example.proyectointermodular.repository.ProductRepository;
import com.example.proyectointermodular.repository.TypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private TypeRepository typeRepository;

    @Autowired
    private MaterialRepository materialRepository;

    /**
     * Metodo para listar todos los productos.
     * @param model Producto.
     * @return  Devuelve el listado de los productos en una vista HTML.
     */
    @GetMapping("")
    public String findAll(Model model) {
        model.addAttribute("products", productRepository.findAll());
        // Cargamos también tipos y materiales para el formulario de filtrado.
        model.addAttribute("types", typeRepository.findAll());
        model.addAttribute("materials", materialRepository.findAll());
        return "product-list";
    }

    /**
     * Metodo para filtrar por type y/o material.
     * @param typeId ID del tipo de producto.
     * @param materialId ID del material del producto.
     * @param model Producto.
     * @return Devuelve el filtro de los productos en una vista HTML.
     */
    @GetMapping("/filter")
    public String filterProducts( @RequestParam(required = false) Long typeId, @RequestParam(required = false) Long materialId, Model model) {
        List<Product> products;

        if (typeId != null && materialId != null) {
            products = productRepository.findByType_IdAndMaterial_Id(typeId, materialId);
        } else if (typeId != null) {
            products = productRepository.findByType_Id(typeId);
        } else if (materialId != null) {
            products = productRepository.findByMaterial_Id(materialId);
        } else {
            products = productRepository.findAll();
        }
        model.addAttribute("products", products);
        // Se vuelven a cargar para el formulario de filtrado.
        model.addAttribute("types", typeRepository.findAll());
        model.addAttribute("materials", materialRepository.findAll());
        return "product-list";
    }

    /**
     * Metodo para mostrar los detalles de un solo producto.
     * @param id ID del producto.
     * @param model Producto.
     * @return Devuelve el detalle de un producto en una vista HTML.
     */
    @GetMapping("/view/{id}")
    public String findById(Model model, @PathVariable long id) {
        model.addAttribute("product", productRepository.findById(id).get());
        return "product-view";
    }

    /**
     * Metodo para obtener un formulario vacio para crear un producto.
     * @param model Producto.
     * @return Devuelve el formulario vacio de un producto en un vista HTML.
     */
    @GetMapping("/form")
    public String getForm(Model model) {
        model.addAttribute("product", new Product());
        model.addAttribute("types", typeRepository.findAll());
        model.addAttribute("materials", materialRepository.findAll());
        return "product-form";
    }

    /**
     * Metodo para crear un nuevo producto en la BD.
     * @param product Producto.
     * @return Devuelve una redireccion a /products.
     */
    @PostMapping("")
    public String createProduct(@ModelAttribute Product product){
        productRepository.save(product);
        return "redirect:/products";
    }

    /**
     * Metodo para editar un producto a traves de un formulario completo.
     * @param model Producto.
     * @param id ID del producto.
     * @return Devuelve el formulario vacio de un producto en una vista HTML, o devuelve una redireccion al formulario vacio para añadir un nuevo producto.
     */
    @GetMapping("/edit/{id}")
    public String editForm(Model model, @PathVariable long id) {
        //Verificamos si existe el ID en la base de datos
        if(productRepository.existsById(id)){
            productRepository.findById(id).ifPresent(product -> {
                model.addAttribute("product", product);
                model.addAttribute("types", typeRepository.findAll());
                model.addAttribute("materials", materialRepository.findAll());
            });
            return "product-form";

        //Si no encuentra el ID en la base de datos, redirige al formulario vacio para crear un nuevo producto
        }else{
            return "redirect:/products/form";
        }
    }

    /**
     * Metodo para actualizar la informacion de un producto en la base de datos.
     * @param updatedProduct Datos del nuevo producto.
     * @param id ID del producto.
     * @return Devuelve una redireccion a /products o redirige al formulario vacío si no existe el ID.
     */
    @PostMapping("/update/{id}")
    public String updateProduct(@ModelAttribute Product updatedProduct, @PathVariable Long id){
        //Si el ID esta en BD -> actualiza la siguiente info
        if(productRepository.existsById(id)){
            productRepository.findById(id).ifPresent(product -> {
                //Actualizamos los atributos modificables
                product.setName(updatedProduct.getName());
                product.setType(updatedProduct.getType());
                product.setMaterial(updatedProduct.getMaterial());
                product.setDescription(updatedProduct.getDescription());
                product.setQuantity(updatedProduct.getQuantity());
                product.setPrice(updatedProduct.getPrice());

                //Guardo la info actualizada en la BD
                productRepository.save(product);
            });

            return "redirect:/products";

        }else{

            //Si no encuentra el ID, redirige al formulario vacio para crear un nuevo producto
            return "redirect:/products/form";
        }
    }

    /**
     * Metodo para eliminar un producto teniendo en cuenta el ID.
     * @param id ID del producto.
     * @param redirectAttributes Para enviar un mensaje flash.
     * @return Devuelve una redireccion a /products.
     */
    @GetMapping("/delete/{id}")
    public String deleteById(@PathVariable Long id, RedirectAttributes redirectAttributes){
        productRepository.findById(id).ifPresent(product -> {
            productRepository.deleteById(product.getId());
        });

        //Mensaje conforme se ha eliminado
        redirectAttributes.addFlashAttribute("message", "Product deleted successfully.");

        return "redirect:/products";
    }

}
