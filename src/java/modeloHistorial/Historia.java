/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeloHistorial;

/**
 *
 * @author Usuario
 */
abstract class Historia {
    private int id;
    private String observaciones;
    
    public Historia(){}

    public Historia(int id, String observaciones) {
        this.id = id;
        this.observaciones = observaciones;
    }
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }
    
public int agregar(){return 0;}
public int modificar (){return 0;}
public int eliminar (){return 0;}
}
