package com.stattrack.stat.dao;

import com.stattrack.stat.models.Categoria;
import com.stattrack.stat.models.Gasto;

import java.util.List;

public interface GastoDAO {
    //Este metodo retorna todos los gastos de la bd
    List<Gasto> getGastos();

    //Este metodo permite guardar un nuevo gasto
    void registrarGasto(Gasto gasto);

    //Este metodo permite eliminar un gasto
    void eliminarGasto(int id);

    //Este metodo permite modficar un gasto seleccionada
    void modificarGasto(Gasto gasto);

    //Este metodo devuelve un gasto
    Gasto getGasto(int id);
}
