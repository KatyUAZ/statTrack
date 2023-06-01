package com.stattrack.stat.models;

import com.stattrack.stat.dao.GastoDAO;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class GastoDaoImp implements GastoDAO {

    //declaracion de objeto EntityManager
    @PersistenceContext
    EntityManager entityManager;

    /**
     * Retorna una lista con todos los gastos de la entidad gasto
     *
     * @return
     */
    @Override
    public List<Gasto> getGastos() {
        String query = "FROM Gasto";
        return entityManager.createQuery(query).getResultList();
    }

    /**
     * Guarda una nueva categoria
     *
     * @param gasto
     */
    @Override
    public void registrarGasto(Gasto gasto) {
        entityManager.merge(gasto);
    }

    /**
     * Permite eliminar una categoria
     *
     * @param id
     */
    @Override
    public void eliminarGasto(int id) {
        Gasto gasto = entityManager.find(Gasto.class, id);
        entityManager.remove(gasto);
    }

    /**
     * Permite modificar un gasto
     *
     * @param gasto
     */
    @Override
    public void modificarGasto(Gasto gasto) {
        entityManager.merge(gasto);
    }

    /**
     * Devuelve un gasto
     *
     * @param id
     * @return gasto
     */
    @Override
    public Gasto getGasto(int id) {
        Gasto gasto = entityManager.find(Gasto.class, id);
        return gasto;
    }

}
