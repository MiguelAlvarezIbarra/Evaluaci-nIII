package mx.utng.MAAI.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.utng.MAAI.model.dao.IEventoDao;
import mx.utng.MAAI.model.entity.Evento;



/*
 * Una clase service, esta basada en el patrón de diseño fachada
 * Es un único punto de acceso hacia los DAOs. Dentro de la clase
 * service , podemos operar con distintas clases DAO
 */
@Service
public class EventoServiceImpl implements IEventoService {
     //Inyectamos la interfaz para utilizar los métodos de CRUD
    //C-Create, R-Read Retrieve, U-Update, D-Delete
    @Autowired
    private IEventoDao dao;


    @Transactional(readOnly = true)
    @Override
    public List<Evento> list() {
        return dao.list();
    }

    @Transactional
    @Override
    public void save(Evento evento) {
        dao.save(evento);
    }

    @Transactional(readOnly = true)
    @Override
    public Evento getById(Long id) {
        return dao.getById(id);
    }

    @Transactional
    @Override
    public void delete(Long id) {
        dao.delete(id);
    }
   
}