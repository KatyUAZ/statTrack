package com.stattrack.stat.models;

import com.stattrack.stat.dao.GastoDAO;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.Date;
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
        //instruccion query para hacer la conuslta a la bd
        String query = "SELECT a.gastoId, a.gastoDescripcion, a.gastoCantidad, a.categoria.catId ,a.categoria.catNombre, a.categoria.catPresupuesto, a.gastoFecha FROM Gasto a INNER JOIN a.categoria ";

    return entityManager.createQuery(query).getResultList();
    }

    /**
     * Guarda un nuevo gasto
     *
     */
    @Override
    public void registrarGasto(String decrip, int categoria, double gastoCant) {
        //crea un nuevo gasto
        Gasto gasto = new Gasto();
        Categoria miCategoria = entityManager.find(Categoria.class, categoria);

        //establece los atributos del gasto
        gasto.setGastoDescripcion(decrip);
        gasto.setCategoria(miCategoria);
        gasto.setGastoCantidad(gastoCant);

        //establece la fecha en que es añadido el gasto
        LocalDate fechaActual = LocalDate.now();
        Date fecha = java.sql.Date.valueOf(fechaActual);
        gasto.setGastoFecha(fecha);

        // Imprimir el objeto gasto antes de enviarlo
        System.out.println("Objeto gasto antes de enviarlo: " + gasto.getGastoFecha() + gasto.getGastoCantidad() );

        entityManager.merge(gasto);
    }

    /**
     * Permite eliminar un gasto
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

    /**
     * Comprueba si los gastos por categoria sobrepasan el presupuesto asignado
     * @param id
     * @return
     */
    @Override
    public int comprobarGastos(int id) {
        //instruccion query
        String query = "SELECT CASE WHEN SUM(g.gastoCantidad) > (0.8 * c.catPresupuesto) THEN 1 ELSE 0 END FROM Gasto g JOIN g.categoria c WHERE c.catId = :catIdParametro";
        Query hqlQuery = entityManager.createQuery(query);
        hqlQuery.setParameter("catIdParametro", id);

        Integer resultado = (Integer) hqlQuery.getSingleResult();
        return resultado.intValue();
    }
}
