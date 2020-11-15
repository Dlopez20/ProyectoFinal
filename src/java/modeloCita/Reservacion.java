/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeloCita;

/**
 *
 * @author Usuario
 */
abstract class Reservacion {
    private int id;
    private String fecha_cita,fecha_salida;

    public Reservacion(){};
    
    public Reservacion(int id, String fecha_cita, String fecha_salida) {
        this.id = id;
        this.fecha_cita = fecha_cita;
        this.fecha_salida = fecha_salida;
    }
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String getFecha_cita() {
        return fecha_cita;
    }

    public void setFecha_cita(String fecha_cita) {
        this.fecha_cita = fecha_cita;
    }

    public String getFecha_salida() {
        return fecha_salida;
    }

    public void setFecha_salida(String fecha_salida) {
        this.fecha_salida = fecha_salida;
    }
    
    
  public int agregar(){return 0;}
  public int modificar(){return 0;}
  public int eliminar(){return 0;}
}
