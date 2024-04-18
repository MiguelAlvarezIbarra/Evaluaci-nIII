package mx.utng.MAAI.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.utng.MAAI.model.dao.IInventarioDao;
import mx.utng.MAAI.model.entity.Inventario;

/*
 * Una clase service, esta basada en el patrón de diseño fachada
 * Es un único punto de acceso hacia los DAOs. Dentro de la clase
 * service , podemos operar con distintas clases DAO
 */
@Service
public class InventarioServiceImpl implements IInventarioService{
   //Inyectamos la interfaz para utilizar los métodos de CRUD
    //C-Create, R-Read Retrieve, U-Update, D-Delete
    @Autowired
    private IInventarioDao dao;


    @Transactional(readOnly = true)
    @Override
    public List<Inventario> list() {
        return dao.list();
    }

    @Transactional
    @Override
    public void save(Inventario inventario) {
        dao.save(inventario);
    }

    @Transactional(readOnly = true)
    @Override
    public Inventario getById(Long id) {
        return dao.getById(id);
    }

    @Transactional
    @Override
    public void delete(Long id) {
        dao.delete(id);
    }
    
}
