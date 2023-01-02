/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import java.sql.*;

/**
 *
 * @author Sergio
 */
public class Connection {
    
    public Connection makeConnect(){
        try{
            //jdbc:mysql://localhost:3306/zoo?zeroDateTimeBehavior=CONVERT_TO_NULL [zoologico on Default schema]
            String url="jdbc:mysql://"+this.host+":"+this.port+"/"+this.dbName;
            Connection conex = DriverManager.getConnection(url, this.user, this.pass);
            return conex;
        }catch(SQLException ex){
            System.err.println("Error al establecer la conexion "+ex.getMessage());
            return null;
        }
        
    }
    public static void closeConnect(Connection con){
        try {
            // Cerramos posibles conexiones abiertas
            if (con!=null) con.close();    
          } catch (Exception e) {
            System.out.println("Error cerrando conexiones: " + e.toString());
          } 
    }
}
