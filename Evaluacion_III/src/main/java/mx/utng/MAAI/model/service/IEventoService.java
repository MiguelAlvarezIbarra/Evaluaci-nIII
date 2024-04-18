package mx.utng.MAAI.model.service;

import java.util.List;

import mx.utng.MAAI.model.entity.Evento;

public interface IEventoService {
List<Evento> list();
void save(Evento evento);
Evento getById(Long id);
void delete(Long id);
}
