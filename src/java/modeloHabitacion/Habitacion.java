/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeloHabitacion;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;
import modelo.Conexion;
/**
 *
 * @author Usuario
 */
public class Habitacion extends Datos {
    Conexion cn;    

    public Habitacion() {
    }

    public Habitacion(int id, String codigo_habitacion, String descripcion) {
        super(id, codigo_habitacion, descripcion);
    }
    
    
    public DefaultTableModel leer(){
 DefaultTableModel tabla = new DefaultTableModel();
 try{
     cn = new Conexion();
     cn.abrir_conexion();
      String query = "select h.id_habitacion as id,h.codigo_habitacion,h.descripcion from habitacion as h;";
      ResultSet consulta = cn.conexionBD.createStatement().executeQuery(query);
      String encabezado[] = {"id","codigo_habitacion","descripcion"};
      tabla.setColumnIdentifiers(encabezado);
      String datos[] = new String[3];
      while (consulta.next()){
          datos[0] = consulta.getString("id");
          datos[1] = consulta.getString("codigo_habitacion");
          datos[2] = consulta.getString("descripcion");
          tabla.addRow(datos);
      
      }
      
     cn.cerrar_conexion();
 }catch(SQLException ex){
     System.out.println(ex.getMessage());
 }
 return tabla;
 }
    
    
    
    
    
    
    
    
    @Override
    public int agregar(){
        int retorno = 0;
        try{
            PreparedStatement parametro;
            cn = new Conexion();
            String query ="insert into habitacion(codigo_habitacion,descripcion) values(?,?);"; 
            cn.abrir_conexion();
            parametro = (PreparedStatement)cn.conexionBD.prepareStatement(query);
            parametro.setString(1, getCodigo_habitacion());
            parametro.setString(2, getDescripcion());
            
            retorno = parametro.executeUpdate();
            cn.cerrar_conexion();
            
        }
        catch(SQLException ex){
        System.out.println(ex.getMessage());
        retorno = 0;
    
        } 
    return retorno;
    } 
    
    
      @Override
    public int modificar (){
        int retorno =0;
        try{
            PreparedStatement parametro;
            cn = new Conexion();
            String query = "update habitacion set codigo_habitacion = ?,descripcion= ? where id_habitacion = ?;";
            cn.abrir_conexion();
            parametro = (PreparedStatement)cn.conexionBD.prepareStatement(query);
            parametro.setString(1, getCodigo_habitacion());
            parametro.setString(2, getDescripcion());
            parametro.setInt(3, getId());
            retorno = parametro.executeUpdate();
            cn.cerrar_conexion();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
    return retorno;
    }
    
    
     @Override
    public int eliminar (){
        int retorno =0;
        try{
            PreparedStatement parametro;
            cn = new Conexion();
            String query = "delete from habitacion where id_habitacion = ?;";
            cn.abrir_conexion();
            parametro = (PreparedStatement)cn.conexionBD.prepareStatement(query);
            parametro.setInt(1, getId());
            retorno = parametro.executeUpdate();
            cn.cerrar_conexion();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
    return retorno;
    }
    
    
    
}
