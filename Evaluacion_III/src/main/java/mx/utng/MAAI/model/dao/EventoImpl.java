package mx.utng.MAAI.model.dao;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import mx.utng.MAAI.model.entity.Evento;

@Repository
public class EventoImpl implements IEventoDao {
    //Entity Manager y contexto de persistencia
    //Guarda internamente todas las entidads y
    //utiliza como una cache datos de BD
    //@PersistenceContext
    @Autowired
    private EntityManager em;


    @SuppressWarnings("unchecked")
    @Override
    public List<Evento> list() {
        return em.createQuery("from Evento").getResultList();
    }

    @Override
    public void save(Evento evento) {
        System.out.println("Carne id="+evento.getId());
        if(evento.getId() != null && evento.getId() >0){
            //Actualizo estudiante
            em.merge(evento);
        }else{
            //Creamos nuevo estudiante en la base
            em.persist(evento);
        }
    }

    @Override
    public Evento getById(Long id) {
        return em.find(Evento.class, id);
    }

    @Override
    public void delete(Long id) {
        Evento evento = getById(id);
        em.remove(evento);
    }

    
}
