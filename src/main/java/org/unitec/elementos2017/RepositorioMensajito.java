package org.unitec.elementos2017;

import java.io.Serializable;
import org.springframework.data.repository.CrudRepository;
import java.util.*;
public interface RepositorioMensajito extends
        CrudRepository<Mensajito, Integer>{
    List <Mensajito> findByTitulo(String titulo);
}