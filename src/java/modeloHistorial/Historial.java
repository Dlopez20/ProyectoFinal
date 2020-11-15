/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeloHistorial;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import javax.swing.table.DefaultTableModel;
import modelo.Conexion;

        
/**
 *
 * @author Usuario
 */
public class Historial extends Historia {
    private int id_diagnostico;
    Conexion cn;

    public Historial() {
    }

    public Historial(int id_diagnostico, int id, String observaciones) {
        super(id, observaciones);
        this.id_diagnostico = id_diagnostico;
    }
    
    
    public int getId_diagnostico() {
        return id_diagnostico;
    }

    public void setId_diagnostico(int id_diagnostico) {
        this.id_diagnostico = id_diagnostico;
    }
    
 public DefaultTableModel leer(){
 DefaultTableModel tabla = new DefaultTableModel();
 try{
     cn = new Conexion();
     cn.abrir_conexion();
      String query = "select h.id_historial as id,d.id_diagnostico,h.observaciones,d.descripcion_diagnostico FROM historial as h inner join diagnostico as d on h.id_diagnostico = d.id_diagnostico;";
      ResultSet consulta = cn.conexionBD.createStatement().executeQuery(query);
      String encabezado[] = {"id","id_diagnostico","observaciones","descripcion_diagnostico"};
      tabla.setColumnIdentifiers(encabezado);
      String datos[] = new String[4];
      while (consulta.next()){
          datos[0] = consulta.getString("id");
          datos[1] = consulta.getString("id_diagnostico");
          datos[2] = consulta.getString("observaciones");
          datos[3] = consulta.getString("descripcion_diagnostico");
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
        int retorno =0;
        try{
            PreparedStatement parametro;
            cn = new Conexion();
            String query = "insert into historial(id_diagnostico,observaciones) values(?,?);";
            cn.abrir_conexion();
            parametro = (PreparedStatement)cn.conexionBD.prepareStatement(query);
            parametro.setInt(1, getId_diagnostico());
            parametro.setString(2, getObservaciones());
            retorno = parametro.executeUpdate();
            cn.cerrar_conexion();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
    return retorno;
    }
    
    
    @Override
    public int modificar(){
        int retorno =0;
        try{
            PreparedStatement parametro;
            cn = new Conexion();
            String query = "update historial set id_diagnostico= ?,observaciones= ? where id_historial = ?;";
            cn.abrir_conexion();
            parametro = (PreparedStatement)cn.conexionBD.prepareStatement(query);
            parametro.setInt(1, getId_diagnostico());
            parametro.setString(2, getObservaciones());
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
            String query = "delete from historial where id_historial = ?;";
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