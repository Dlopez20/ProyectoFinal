/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeloHabitacion;

/**
 *
 * @author Usuario
 */
abstract class Datos {
    private int id;
    private String codigo_habitacion,descripcion;
    
    public Datos(){}

    public Datos(int id, String codigo_habitacion, String descripcion) {
        this.id = id;
        this.codigo_habitacion = codigo_habitacion;
        this.descripcion = descripcion;
    }
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCodigo_habitacion() {
        return codigo_habitacion;
    }

    public void setCodigo_habitacion(String codigo_habitacion) {
        this.codigo_habitacion = codigo_habitacion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    public int agregar(){return 0;}
    public int modificar(){return 0;}
    public int eliminar(){return 0;}
    public int mostrar(){return 0;}
}
