/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeloCita;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import modelo.Conexion;
/**
 *
 * @author Usuario
 */
public class Habitacion {
    private int id_habitacion;
    private String codigo_habitacion;
    Conexion cn;
    
    public Habitacion(){};

    public Habitacion(int id_habitacion, String codigo_habitacion) {
        this.id_habitacion = id_habitacion;
        this.codigo_habitacion = codigo_habitacion;
    }
    
    

    public int getId_habitacion() {
        return id_habitacion;
    }

    public void setId_habitacion(int id_habitacion) {
        this.id_habitacion = id_habitacion;
    }

    public String getCodigo_habitacion() {
        return codigo_habitacion;
    }

    public void setCodigo_habitacion(String codigo_habitacion) {
        this.codigo_habitacion = codigo_habitacion;
    }
    
    public HashMap drop_habitacion(){
    HashMap<String,String> drop2 = new HashMap();
    try{
        String query ="SELECT id_habitacion AS id,codigo_habitacion FROM habitacion";
         cn = new Conexion();
         cn.abrir_conexion();
            ResultSet consulta = cn.conexionBD.createStatement().executeQuery(query);
            while (consulta.next()){
            drop2.put(consulta.getString("id"),consulta.getString("codigo_habitacion") );
            }
         cn.cerrar_conexion();
    }catch(SQLException ex){
        System.out.println(ex.getMessage());
    }
    return drop2;
    }
}
