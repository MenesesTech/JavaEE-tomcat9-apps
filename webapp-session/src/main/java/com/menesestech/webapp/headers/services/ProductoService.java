
package com.menesestech.webapp.headers.services;

import com.menesestech.webapp.headers.models.Producto;
import java.util.List;
import java.util.Optional;

public interface ProductoService {
    public List<Producto> listar();
    Optional<Producto> porId(Long id);
}
