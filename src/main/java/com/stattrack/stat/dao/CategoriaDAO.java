package com.stattrack.stat.dao;

import com.stattrack.stat.models.Categoria;

import java.util.List;

public interface CategoriaDAO {
    //Este metodo retorna todas las categorias de la bd
    List<Categoria> getCategorias();

    //Este metodo permite guardar una nueva categoria
    void registrarCategoria(Categoria categoria);

    //Este metodo permite eliminar una categoria
    void eliminarCategoria(int id);

    //Este metodo permite modficar una categoria seleccionada
    void modificarCategoria(Categoria categoria);

    //Este metodo devuelve una categoria
    Categoria getCategoria(int id);
}
