/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.libro.repository;

import com.example.libro.model.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
/**
 *
 * @author Eduardo
 */
public interface LibroRepository extends JpaRepository<Libro, Long> {
    
}