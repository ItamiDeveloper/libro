/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.libro.controller;

import com.example.libro.model.Libro;
import com.example.libro.repository.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
/**
 *
 * @author Eduardo
 */
@Controller
public class LibroController {

    @Autowired
    private LibroRepository libroRepository;

    @PostMapping("/submitLibro")
    public String procesarFormulario(@ModelAttribute Libro libro, Model model) {
        libroRepository.save(libro); // Guardar el libro en la base de datos
        return "redirect:/listarLibros"; // Redirigir a la lista de libros
    }

    @GetMapping("/listarLibros")
    public String listarLibros(Model model) {
        List<Libro> libros = libroRepository.findAll(); // Obtener todos los libros
        model.addAttribute("libros", libros);
        model.addAttribute("libro", new Libro()); // Para agregar un nuevo libro
        return "listar_libros"; // Vista listar_libros.html
    }

    @GetMapping("/editarLibro/{id}")
    public String editarLibro(@PathVariable("id") Long id, Model model) {
        Libro libro = libroRepository.findById(id).orElse(null);
        if (libro != null) {
            model.addAttribute("libro", libro);
            return "formulario_libros"; // Vista formulario_libros.html
        }
        return "redirect:/listarLibros"; // Redirigir si no se encuentra
    }

    @PostMapping("/submitEdicionLibro")
    public String submitEdicionLibro(@ModelAttribute Libro libro) {
        libroRepository.save(libro); // Guardar el libro editado
        return "redirect:/listarLibros"; // Redirigir a la lista de libros
    }

    @GetMapping("/eliminarLibro/{id}")
    public String eliminarLibro(@PathVariable("id") Long id) {
        libroRepository.deleteById(id); // Eliminar el libro
        return "redirect:/listarLibros"; // Redirigir después de eliminar
    }
}
