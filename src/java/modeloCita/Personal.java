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
public class Personal {
    private int id_pesonal;
    private String nombre_personal;
    Conexion cn;
    
    public Personal(){};

    public Personal(int id_pesonal, String nombre_personal) {
        this.id_pesonal = id_pesonal;
        this.nombre_personal = nombre_personal;
    }
    
    

    public int getId_pesonal() {
        return id_pesonal;
    }

    public void setId_pesonal(int id_pesonal) {
        this.id_pesonal = id_pesonal;
    }

    public String getNombre_personal() {
        return nombre_personal;
    }

    public void setNombre_personal(String nombre_personal) {
        this.nombre_personal = nombre_personal;
    }
    
    public HashMap drop_personal(){
    HashMap<String,String> drop3 = new HashMap();
    try{
        String query ="SELECT id_personal AS id,nombre_personal FROM personal";
         cn = new Conexion();
         cn.abrir_conexion();
            ResultSet consulta = cn.conexionBD.createStatement().executeQuery(query);
            while (consulta.next()){
            drop3.put(consulta.getString("id"),consulta.getString("nombre_personal") );
            }
         cn.cerrar_conexion();
    }catch(SQLException ex){
        System.out.println(ex.getMessage());
    }
    return drop3;
    }
}
