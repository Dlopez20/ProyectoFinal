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
public class Paciente {
    private int id_paciente;
    private String nombre_paciente;
    Conexion cn;
    
    public Paciente(){};

    public Paciente(int id_paciente, String nombre_paciente) {
        this.id_paciente = id_paciente;
        this.nombre_paciente = nombre_paciente;
    }
    

    public int getId_paciente() {
        return id_paciente;
    }

    public void setId_paciente(int id_paciente) {
        this.id_paciente = id_paciente;
    }

    public String getNombre_paciente() {
        return nombre_paciente;
    }

    public void setNombre_paciente(String nombre_paciente) {
        this.nombre_paciente = nombre_paciente;
    }
    
    public HashMap drop_paciente(){
    HashMap<String,String> drop = new HashMap();
    try{
        String query ="SELECT id_paciente AS id,nombre_paciente FROM paciente";
         cn = new Conexion();
         cn.abrir_conexion();
            ResultSet consulta = cn.conexionBD.createStatement().executeQuery(query);
            while (consulta.next()){
            drop.put(consulta.getString("id"),consulta.getString("nombre_paciente") );
            }
         cn.cerrar_conexion();
    }catch(SQLException ex){
        System.out.println(ex.getMessage());
    }
    return drop;
    }
}
