package com.menesestech.webapp.headers.services;

import com.menesestech.webapp.headers.models.Libro;
import java.util.Arrays;
import java.util.List;

public class LibroServiceImp implements LibroService {

    @Override
    public List<Libro> listar() {
        return Arrays.asList(new Libro(1L, "El Sexto", "Jose Maria A.", "Narrativo"),
                new Libro(2L, "Los ríos profundos", "Jose Maria A.", "Dramatico"),
                new Libro(3L, "Yawar Fiesta", "Jose Maria A.", "Lirico"));
    }

}
