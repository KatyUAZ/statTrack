package com.stattrack.stat.dao;

import com.stattrack.stat.models.Gasto;

import java.util.List;

public interface GastoDAO {
    //Este metodo retorna todos los gastos de la bd
    List<Gasto> getGastos();

    //Este metodo permite guardar un nuevo gasto
    void registrarGasto(String decrip, int categoria, double gastoCant);

    //Este metodo permite eliminar un gasto
    void eliminarGasto(int id);

    //Este metodo permite modficar un gasto seleccionada
    void modificarGasto(Gasto gasto);

    //Este metodo devuelve un gasto
    Gasto getGasto(int id);

    //Comprueba la cantidad del gasto para saber si sobrepasa el presupuesto
    int comprobarGastos(int id);
}
