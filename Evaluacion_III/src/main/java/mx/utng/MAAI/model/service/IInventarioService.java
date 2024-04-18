package mx.utng.MAAI.model.service;

import java.util.List;

import mx.utng.MAAI.model.entity.Inventario;

public interface IInventarioService {
     List<Inventario> list();
    void save(Inventario inventario);
    Inventario getById(Long id);
    void delete(Long id);
}
