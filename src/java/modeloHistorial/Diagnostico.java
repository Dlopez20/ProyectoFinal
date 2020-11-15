/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeloHistorial;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import modelo.Conexion;
/**
 *
 * @author Usuario
 */
public class Diagnostico {
    private int id_diagnostico;
    private String descripcion_diagnostico;
    Conexion cn;
    
    public Diagnostico(){}

    public Diagnostico(int id_diagnostico, String descripcion_diagnostico) {
        this.id_diagnostico = id_diagnostico;
        this.descripcion_diagnostico = descripcion_diagnostico;
    }
    
    
    public int getId_diagnostico() {
        return id_diagnostico;
    }

    public void setId_diagnostico(int id_diagnostico) {
        this.id_diagnostico = id_diagnostico;
    }

    public String getDescripcion_diagnostico() {
        return descripcion_diagnostico;
    }

    public void setDescripcion_diagnostico(String descripcion_diagnostico) {
        this.descripcion_diagnostico = descripcion_diagnostico;
    }
    
    
    public HashMap drop_diagnostico(){
    HashMap<String,String> drop = new HashMap();
    try{
        String query ="select id_diagnostico as id,descripcion_diagnostico from diagnostico;";
         cn = new Conexion();
         cn.abrir_conexion();
            ResultSet consulta = cn.conexionBD.createStatement().executeQuery(query);
            while (consulta.next()){
            drop.put(consulta.getString("id"),consulta.getString("descripcion_diagnostico") );
            }
         cn.cerrar_conexion();
    }catch(SQLException ex){
        System.out.println(ex.getMessage());
    }
    return drop;
    }
    
}
