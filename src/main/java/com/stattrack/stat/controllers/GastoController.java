package com.stattrack.stat.controllers;

import com.stattrack.stat.dao.GastoDAO;
import com.stattrack.stat.models.Gasto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class GastoController implements GastoDAO {
    @Autowired
    private GastoDAO gastoDAO;

    /**
     * Retorna la lista de gastos
     *
     * @return
     */
    @Override
    @RequestMapping(value = "gastos", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public List<Gasto> getGastos() {
        return gastoDAO.getGastos();
    }

    /**
     * Permite guardar un nuevo gasto
     *
     */
    @RequestMapping(value = "guardargasto/{decrip}/{categoria}/{cant}", method = RequestMethod.POST)
    public void registrarGasto(@PathVariable String decrip,@PathVariable int categoria, @PathVariable double cant ) {
        gastoDAO.registrarGasto(decrip, categoria,  cant);
    }

    /**
     * Permite eliminar un gasto de la tabla en la bd
     *
     * @param id
     */
    @RequestMapping(value = "eliminar-gasto/{id}", method = RequestMethod.DELETE)
    public void eliminarGasto(@PathVariable int id) {
        gastoDAO.eliminarGasto(id);
    }

    /**
     * Modifica un gasto de la base de datos
     *
     * @param gasto
     */
    @RequestMapping(value = "modificar-gasto", method = RequestMethod.POST)
    public void modificarGasto(@RequestBody Gasto gasto) {
        gastoDAO.modificarGasto(gasto);
    }

    /**
     * Devuelve un gasto relacionado con el id proporcionado
     *
     * @param id
     * @return gasto
     */
    @RequestMapping(value = "gasto/{id}", method = RequestMethod.GET)
    public Gasto getGasto(@PathVariable int id) {
        return gastoDAO.getGasto(id);
    }

    /**
     * Este metodo permite comprobar la cantidad del gasto para saber si sobrepasa el presupuesto
     * @param id
     * @return
     */
    @RequestMapping(value = "comprobargasto/{id}", method = RequestMethod.GET)
    public int comprobarGastos(@PathVariable int id){
        return  gastoDAO.comprobarGastos(id);
    }
}
