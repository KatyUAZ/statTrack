package com.stattrack.stat.controllers;

import com.stattrack.stat.dao.CategoriaDAO;
import com.stattrack.stat.models.Categoria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController

public class CategoriaController implements CategoriaDAO {

    //declaracion de un objeto de tipo CategoriaDAO
    @Autowired
    private CategoriaDAO categoriaDAO;

    /**
     * Retorna la lista de categorias existentes en la bd
     *
     * @return Lista de Categorias
     */
    @Override
    @RequestMapping(value = "categoria", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public List<Categoria> getCategorias() {
        return categoriaDAO.getCategorias();
    }

    /**
     * Permite guardar una nueva categoria
     *
     * @param categoria
     */
    @RequestMapping(value = "guardar-categoria", method = RequestMethod.POST)
    public void registrarCategoria(@RequestBody Categoria categoria) {

        categoriaDAO.registrarCategoria(categoria);
    }

    /**
     * Modifica una categoria de la base de datos
     *
     * @param categoria
     */
    @RequestMapping(value = "modificar-categoria", method = RequestMethod.POST)
    public void modificarCategoria(@RequestBody Categoria categoria) {
        categoriaDAO.modificarCategoria(categoria);
    }

    /**
     * Devuelve categoria relacionada con el id proporcionado
     *
     * @param id
     * @return categoria
     */
    @RequestMapping(value = "categoria/{id}", method = RequestMethod.GET)
    public Categoria getCategoria(@PathVariable int id) {
        return categoriaDAO.getCategoria(id);
    }


    /**
     * Permite eliminar una categoria de la tabla en la bd
     *
     * @param id
     */
    @RequestMapping(value = "eliminar-categoria/{id}", method = RequestMethod.DELETE)
    public void eliminarCategoria(@PathVariable int id) {
        categoriaDAO.eliminarCategoria(id);
    }


}
