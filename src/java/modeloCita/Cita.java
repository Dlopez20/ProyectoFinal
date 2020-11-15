/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeloCita;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import javax.swing.table.DefaultTableModel;
import modelo.Conexion;
/**
 *
 * @author Usuario
 */
public class Cita extends Reservacion {
    private int id_paciente,id_sucursal,id_habitacion,id_personal;
    Conexion cn;

    public Cita() {
    }

    public Cita(int id_paciente, int id_sucursal, int id_habitacion, int id_personal, int id, String fecha_cita, String fecha_salida) {
        super(id, fecha_cita, fecha_salida);
        this.id_paciente = id_paciente;
        this.id_sucursal = id_sucursal;
        this.id_habitacion = id_habitacion;
        this.id_personal = id_personal;
    }
    
    
    public int getId_paciente() {
        return id_paciente;
    }

    public void setId_paciente(int id_paciente) {
        this.id_paciente = id_paciente;
    }

    public int getId_sucursal() {
        return id_sucursal;
    }

    public void setId_sucursal(int id_sucursal) {
        this.id_sucursal = id_sucursal;
    }

    public int getId_habitacion() {
        return id_habitacion;
    }

    public void setId_habitacion(int id_habitacion) {
        this.id_habitacion = id_habitacion;
    }

    public int getId_personal() {
        return id_personal;
    }

    public void setId_personal(int id_personal) {
        this.id_personal = id_personal;
    }
    
    
    public DefaultTableModel leer(){
    DefaultTableModel tabla = new DefaultTableModel();
    try{
     cn = new Conexion();
     cn.abrir_conexion();
      String query = "select c.id_cita as id, p.id_paciente, s.id_sucursal, h.id_habitacion, pe.id_personal, c.fecha_cita, c.fecha_salida, p.nombre_paciente, s.direcion_sucursal, h.codigo_habitacion, pe.nombre_personal from cita as c inner join paciente as p on c.id_paciente = p.id_paciente inner join \n" +
"sucursal as s on c.id_sucursal = c.id_sucursal inner join\n" +
"habitacion as h on c.id_habitacion = h.id_habitacion inner join\n" +
"personal as pe on c.id_personal = pe.id_personal;\n";
      ResultSet consulta = cn.conexionBD.createStatement().executeQuery(query);
      String encabezado[] = {"id","id_paciente","id_sucursal","id_habitacion","id_personal","fecha_cita","fecha_salida","nombre_paciente","direcion_sucursal","codigo_habitacion","nombre_personal"};
      tabla.setColumnIdentifiers(encabezado);
      String datos[] = new String[11];
      while (consulta.next()){
          datos[0] = consulta.getString("id");
          datos[1] = consulta.getString("id_paciente");
          datos[2] = consulta.getString("id_sucursal");
          datos[3] = consulta.getString("id_habitacion");
          datos[4] = consulta.getString("id_personal");
          datos[5] = consulta.getString("fecha_cita");
          datos[6] = consulta.getString("fecha_salida");
          datos[7] = consulta.getString("nombre_paciente");
          datos[8] = consulta.getString("direcion_sucursal");
          datos[9] = consulta.getString("codigo_habitacion");
          datos[10] = consulta.getString("nombre_personal");
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
        int retorno=0;
        try{
            PreparedStatement parametro;
            cn = new Conexion();
            String query = "insert into cita(id_paciente,id_sucursal,id_habitacion,id_personal,fecha_cita,fecha_salida) values(?,?,?,?,?,?);";
            cn.abrir_conexion();
            parametro = (PreparedStatement)cn.conexionBD.prepareStatement(query);
            parametro.setInt(1,getId_paciente());
            parametro.setInt(2,getId_sucursal());
            parametro.setInt(3,getId_habitacion());
            parametro.setInt(4,getId_personal());
            parametro.setString(5,getFecha_cita());
            parametro.setString(6,getFecha_salida());
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
            String query = "update cita set id_paciente = ?,id_sucursal = ?,id_habitacion = ?,id_personal = ?,fecha_cita = ?,fecha_salida = ? where id_cita = ?;";
            cn.abrir_conexion();
            parametro = (PreparedStatement)cn.conexionBD.prepareStatement(query);
            parametro.setInt(1,getId_paciente());
            parametro.setInt(2,getId_sucursal());
            parametro.setInt(3,getId_habitacion());
            parametro.setInt(4,getId_personal());
            parametro.setString(5,getFecha_cita());
            parametro.setString(6,getFecha_salida());
            parametro.setInt(7, getId());
            retorno = parametro.executeUpdate();
            cn.cerrar_conexion();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
    return retorno;
    }
    
    
    @Override
    public int eliminar(){
        int retorno =0;
        try{
            PreparedStatement parametro;
            cn = new Conexion();
            String query = "delete from cita where id_cita = ?;";
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
