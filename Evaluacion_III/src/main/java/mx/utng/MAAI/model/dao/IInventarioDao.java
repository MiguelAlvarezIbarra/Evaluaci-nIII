package mx.utng.MAAI.model.dao;

import java.util.List;

import mx.utng.MAAI.model.entity.Inventario;

public interface IInventarioDao {
    List<Inventario> list();
    void save(Inventario inventario);
    Inventario getById(Long id);
    void delete(Long id);
}
