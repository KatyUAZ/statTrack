package com.stattrack.stat.models;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "gasto")//hace referencia a la tabla de la bd
public class Gasto {
    //declaracion de atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "gasto_id")//nombre de mi columna en la base de datos
    private int gastoId;// declaracion del id de gasto
    private String gastoDescripcion;//declaracion de la descripcion del gasto
    private double gastoCantidad;//declaracion de la cantidad del gasto
    private Date gastoFecha;//fecha en que fue añadido el gasto

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cat_id") //se indica clave foranea en la bd
    private Categoria categoria; //categoria a la que pertenece el gasto

    /**
     * Constructor con 5 parametros
     *
     * @param gastoId
     * @param gastoDescripcion
     * @param gastoCantidad
     * @param gastoFecha
     * @param categoria
     */
    public Gasto(int gastoId, String gastoDescripcion, double gastoCantidad, Date gastoFecha, Categoria categoria) {
        this.gastoId = gastoId;
        this.gastoDescripcion = gastoDescripcion;
        this.gastoCantidad = gastoCantidad;
        this.gastoFecha = gastoFecha;
        this.categoria = categoria;
    }

    /**
     * Devuelve el valor del id del gasto
     *
     * @return gastoId
     */
    public int getGastoId() {
        return gastoId;
    }

    /**
     * Establece el id del gasto
     *
     * @param gastoId
     */
    public void setGastoId(int gastoId) {
        this.gastoId = gastoId;
    }

    /**
     * Devuelve la descripcion del gasto
     *
     * @return gastoDescripcion
     */
    public String getGastoDescripcion() {
        return gastoDescripcion;
    }

    /**
     * Establece la descripcion del gasto
     *
     * @param gastoDescripcion
     */
    public void setGastoDescripcion(String gastoDescripcion) {
        this.gastoDescripcion = gastoDescripcion;
    }

    /**
     * Devuelve la cantidad del gasto
     *
     * @return gastoCantidad
     */
    public double getGastoCantidad() {
        return gastoCantidad;
    }

    /**
     * Establece la cantidad del gasto
     *
     * @param gastoCantidad
     */
    public void setGastoCantidad(double gastoCantidad) {
        this.gastoCantidad = gastoCantidad;
    }

    /**
     * Devuelve la fecha del gasto
     *
     * @return gastoFecha
     */
    public Date getGastoFecha() {
        return gastoFecha;
    }

    /**
     * Establece la fecha del gasto
     *
     * @param gastoFecha
     */
    public void setGastoFecha(Date gastoFecha) {
        this.gastoFecha = gastoFecha;
    }

    /**
     * Devuelve la categoria a la que pertence el gasto
     *
     * @return categoria
     */
    public Categoria getCategoria() {
        return categoria;
    }

    /**
     * Establece la categoria a la que pertenece el gasto
     *
     * @param categoria
     */
    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
}
