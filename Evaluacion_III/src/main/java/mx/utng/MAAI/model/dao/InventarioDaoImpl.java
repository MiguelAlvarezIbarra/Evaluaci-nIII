package mx.utng.MAAI.model.dao;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import mx.utng.MAAI.model.entity.Inventario;

@Repository
public class InventarioDaoImpl implements IInventarioDao{
    //Entity Manager y contexto de persistencia
    //Guarda internamente todas las entidads y
    //utiliza como una cache datos de BD
    //@PersistenceContext
    @Autowired
    private EntityManager em;


    @SuppressWarnings("unchecked")
    @Override
    public List<Inventario> list() {
        return em.createQuery("from Inventario").getResultList();
    }

    @Override
    public void save(Inventario inventario) {
        if(inventario.getId() != null && inventario.getId() >0){
            em.merge(inventario);
        }else{
            em.persist(inventario);
        }
    }

    @Override
    public Inventario getById(Long id) {
        return em.find(Inventario.class, id);
    }

    @Override
    public void delete(Long id) {
        Inventario inventario = getById(id);
        em.remove(inventario);
    }
}
