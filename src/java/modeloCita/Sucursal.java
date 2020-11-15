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
public class Sucursal {
    private int id_sucursal;
    private String direcion_sucursal;
    Conexion cn;
    
    public Sucursal(){};

    public Sucursal(int id_sucursal, String direccion_sucursal) {
        this.id_sucursal = id_sucursal;
        this.direcion_sucursal = direccion_sucursal;
    }

    public int getId_sucursal() {
        return id_sucursal;
    }

    public void setId_sucursal(int id_sucursal) {
        this.id_sucursal = id_sucursal;
    }

    public String getDirecion_sucursal() {
        return direcion_sucursal;
    }

    public void setDireccion_sucursal(String direccion_sucursal) {
        this.direcion_sucursal = direccion_sucursal;
    }
    
    public HashMap drop_sucursal(){
    HashMap<String,String> drop1 = new HashMap();
    try{
        String query ="SELECT id_sucursal AS id,direcion_sucursal FROM sucursal";
         cn = new Conexion();
         cn.abrir_conexion();
            ResultSet consulta = cn.conexionBD.createStatement().executeQuery(query);
            while (consulta.next()){
            drop1.put(consulta.getString("id"),consulta.getString("direcion_sucursal") );
            }
         cn.cerrar_conexion();
    }catch(SQLException ex){
        System.out.println(ex.getMessage());
    }
    return drop1;
    }
}
