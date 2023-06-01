package com.stattrack.stat.models;

import com.stattrack.stat.dao.CategoriaDAO;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class CategoriaDaoImp implements CategoriaDAO {

    //declaracion de objeto EntityManager
    @PersistenceContext
    EntityManager entityManager;

    /**
     * Retorna una lista con todas las categorias de la entidad categoria
     *
     * @return lista de categorias
     */
    @Override
    public List<Categoria> getCategorias() {
        String query = "FROM Categoria";
        return entityManager.createQuery(query).getResultList();
    }

    /**
     * Guarda una nueva categoria
     *
     * @param categoria
     */
    @Override
    public void registrarCategoria(Categoria categoria) {
        entityManager.merge(categoria);
    }


    /**
     * Permite eliminar una categoria
     *
     * @param id
     */
    @Override
    public void eliminarCategoria(int id) {
        Categoria categoria = entityManager.find(Categoria.class, id);
        entityManager.remove(categoria);
    }

    /**
     * Permite modificar una categoria
     *
     * @param categoria
     */
    @Override
    public void modificarCategoria(Categoria categoria) {
        entityManager.merge(categoria);
    }

    /**
     * Devuelve una categoria
     *
     * @param id
     * @return categoria
     */
    @Override
    public Categoria getCategoria(int id) {
        Categoria categoria = entityManager.find(Categoria.class, id);
        return categoria;
    }

}
