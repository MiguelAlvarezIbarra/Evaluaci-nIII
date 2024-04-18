package mx.utng.MAAI.model.dao;

import java.util.List;

import mx.utng.MAAI.model.entity.Evento;

public interface IEventoDao {
    List<Evento> list();
    void save(Evento carne);
    Evento getById(Long id);
    void delete(Long id);
    
} 