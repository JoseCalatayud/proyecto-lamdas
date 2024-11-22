package com.mycompany.app;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class JugamosConStreamsTest {

    private List<Datos> listaTransformar;

    @BeforeEach
    public void setup() {
        listaTransformar = new ArrayList<>();

        listaTransformar.add(new Datos(3, "Juan"));
        listaTransformar.add(new Datos(44, "Jose"));
        listaTransformar.add(new Datos(6, "Juaquin"));
        listaTransformar.add(new Datos(87, "Andres"));
        listaTransformar.add(new Datos(34, "Sergio"));
        listaTransformar.add(new Datos(54, "Alejandro"));
        listaTransformar.add(new Datos(14, "Nicolas"));
        listaTransformar.add(new Datos(76, "Jorge"));
        listaTransformar.add(new Datos(57, "Felipe"));
        listaTransformar.add(new Datos(33, "Miguel"));

    }

    @Test
    public void filtrarNombres() {
        int longitudNombres = listaTransformar.stream()
                .filter(d -> d.getNombre().toLowerCase().startsWith("j") && d.getNombre().length() > 4)
                .mapToInt(d -> d.getNombre().length())
                .filter(d -> d > 4)
                .sum();

        assertTrue(longitudNombres == 12, "Falla algo");
        ;
    }

    @Test
    void testStream() {
        List<String> lista = Arrays.asList("hola", "adios", "hi", "bonjour");
        int suma = lista.stream()
                .mapToInt(s -> s.length())
                .filter(d -> d >= 5)
                .sum();

        assertEquals(12, suma);

        List<String>lista2 = lista.stream()
            .filter(s-> s.length() < 5)
            .collect(Collectors.toList());

        assertEquals(2, lista2.size());

    }

}
