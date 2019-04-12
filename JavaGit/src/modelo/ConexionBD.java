/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author rodrigo
 */
public class ConexionBD {
    private Connection conexion = null;
    private static final String DB_NAME = "arquitectura";
    private static final String HOST = "localhost";
    private static final String USER = "rodrigo";
    private static final String PASSW = "lrm3532021";

    public ConexionBD() {       
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("No se pudo registrar el Driver de \"mysql\".");
        }
    }
    
    public void conectar(){
        try {
            String url = "jdbc:mysql://" + HOST + ":3306/" + 
                    DB_NAME+"?autoReconnect=true&useSSL=false";
            conexion = DriverManager.getConnection(url, USER, PASSW);
//            System.out.println("Conectado");
        } catch (SQLException e) {
            System.out.println("No se pudo conectar con " + HOST + ".");
            System.out.println(e.getMessage());
        }
    }
    
    public void desconectar(){
        try {
            conexion.close();
//            System.out.println("Desconectado");
        } catch (SQLException e) {
            System.out.println("Error " + e.getMessage());
        }
    }

    public Connection getConexion() {
        return conexion;
    }
    
    
}
