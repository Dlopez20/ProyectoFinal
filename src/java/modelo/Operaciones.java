/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author Andres
 */
public class Operaciones {
 String driver;
 String url;
 String uss;
 String contra;
 
    public Operaciones (){
    driver = "com.mysql.jdbc.Driver";
    url="jdbc:mysql://localhost:3306/db_clinica";
    uss="root";
    contra="";
    
    
    }
    public int loguear (String us, String contra){
    Connection conn;
    PreparedStatement pst;
    ResultSet rs;
    
  
    int nivel=0;
    
    String sql="select nivel from usuarios where usuario='" + us +"' and pass='" + contra +"';";
    try{
        Class.forName(this.driver);
        conn = DriverManager.getConnection(
        this.url,
        this.uss,
        this.contra
        );
        pst= conn.prepareStatement(sql);
        rs = pst.executeQuery();
        while (rs.next()){
        nivel = rs.getInt(1);
        }
        conn.close();
        
        
    }catch(ClassNotFoundException | SQLException e){
    }
    
    
        
        return nivel;
    }
    
}
