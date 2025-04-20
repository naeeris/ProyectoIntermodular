package com.example.proyectointermodular.controller;

import com.example.proyectointermodular.repository.TypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Controlador para la pagina de inicio.
 */
@Controller
public class HomeController {

    @Autowired
    private TypeRepository typeRepository;

    /**
     * Metodo para mostrar las categorias de product.
     * @param model Modelo donde se añade la lista de types.
     * @return Devuelve las categorias en una vista HTML.
     */
    @GetMapping("/")
    public String homeIndex(Model model) {
        // Puedes enviar la lista completa de categorías para construir la vista de manera dinámica.
        model.addAttribute("types", typeRepository.findAll());
        return "home";
    }

}
