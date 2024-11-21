package com.mycompany.app;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class JugamosConLambdasTest {

    private List<Datos> listaTransformar;

    @BeforeEach
    public void setup() {
        listaTransformar = new ArrayList<>();

        listaTransformar.add(new Datos(3, "Juan"));
        listaTransformar.add(new Datos(44, "Jose"));
    }

    @Test
    public void testTransformar_SinLambdas() {
        // Lo aplicamos con foreach de arraylist
        listaTransformar.forEach(new Consumer<Datos>() {
            @Override
            public void accept(Datos dato) {
                dato.setEdad(dato.getEdad() * 3);
            }
        });
        assertEquals(listaTransformar.get(0).getEdad(), 9);
        assertEquals(listaTransformar.get(1).getEdad(), 132);
    }

    @Test
    public void testTransformar_ConLambdas() {
        listaTransformar.forEach((dato) -> dato.setEdad(dato.getEdad() * 3));

        assertEquals(listaTransformar.get(0).getEdad(), 9);
        assertEquals(listaTransformar.get(1).getEdad(), 132);
    }
    @Test
    public void testTransformar_ConFor(){
        for (Datos datos : listaTransformar) {
            datos.setEdad(datos.getEdad()*3);
        }
    }

}
