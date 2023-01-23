/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package interfaz.tareas2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/**
 *
 * @author Sergio
 */
public class Conector {
    // Para establecer la conexión con la base de datos tenemos que seguir la siguiente estructura: jdbc:mysql://[host][:puerto]/[DB]
    static final private String HOST = "localhost";
    static final private String PORT = "3306";
    static final private String DBNAME = "classroom";
    static final private String USER = "root";
    static final private String PASS = "";
    

// Para usarlo con MariaDB en una base de datos local llamada javanet  -> Connnection conex = new Conexion("localhost","3306","javanet","javanet","1234qwerty").makeconnect();
    
    public static Connection makeConnect(){
        try{
            //jdbc:mysql://localhost:3306/clasroom?zeroDateTimeBehavior=CONVERT_TO_NULL [root on Default schema]
            //jdbc:mariadb://localhost:3306/clasroom [root on Default schema]
            String url="jdbc:mysql://"+HOST+":"+PORT+"/"+DBNAME+"?zeroDateTimeBehavior=CONVERT_TO_NULL";
            return DriverManager.getConnection(url, USER, PASS);
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
    
//    public static ResultSet comprobarDatos(String consulta, Connection conDB){
//        try {
//            Statement st = conDB.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
//            ResultSet rs = st.executeQuery(consulta);
//            if(!rs.first()){
//                return null;
//            }
//            else{
//                return rs;
//            }
//        } catch (SQLException ex) {
//            System.out.println("Error al comprobar datos");
//        }
//        return null;
//    }
//    
    public static ResultSet getSelect(String consulta, Connection conDB){
        try {
            Statement st = conDB.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = st.executeQuery(consulta);
            return rs;
        } catch (SQLException ex) {
            System.out.println("Error al leer datos");
        }
        return null;
    }
//    
//    public ResultSet insertTable(String consulta, Connection conDB){
//        try {
//            Statement st = conDB.createStatement();
//            ResultSet rs = st.executeQuery(consulta);
//            rs.moveToInsertRow();
//            rs.updateString(PORT, PORT);
//            return rs;
//        } catch (SQLException ex) {
//            System.out.println("Error al insertar datos");
//        }
//        return null;
//    }
//    
//    public static int editTable(String consulta, Connection conDB){
//        try{
//            Statement st = conDB.createStatement();
//            int rs = st.executeUpdate(consulta);
//            return rs;
//        } catch (SQLException ex) {
//            System.out.println("Error al editar datos");
//            return -1;
//        }
//    }
//    
//    public static ResultSet getTabla(int resultSetType, int resultSetConcurrence, String consulta, Connection conDB){
//        try {
//            Statement smt = conDB.createStatement(resultSetType,resultSetConcurrence);
//            ResultSet rs = smt.executeQuery(consulta);
//            return rs;
//        } catch (SQLException ex) {
//            System.out.println("Error al recuperar datos");
//            return null;
//        }
//    }
   
}