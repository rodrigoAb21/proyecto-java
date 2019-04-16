/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author KAKU
 */
public class M_Tipo {
    private int id;
    private String nombre;
    private ConexionBD db;

    public M_Tipo(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
        db = new ConexionBD();
    }

    public M_Tipo() {
        this.id = 0;
        this.nombre = "";
        db = new ConexionBD();
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
   
    
    
    // METODOS
    public boolean registrar(String nombre){
        try {
            db.conectar();
            String sql = "INSERT INTO tipo (nombre) " + 
                    " VALUES (?)" ;
            PreparedStatement ps = db.getConexion().prepareStatement(sql);
            ps.setString(1, nombre);
            
            int i = ps.executeUpdate();
            db.desconectar();
            return i > 0;
            
        } catch (SQLException e) {
            System.out.println("No se pudo registrar el tipo");
            System.out.println(e.getMessage());
            return false;
        }
    }
    
    public boolean editar(int id, String nombre){
         try {
            db.conectar();
            String sql = "UPDATE tipo SET " + 
                    "nombre = ? " + "WHERE id = ?";
            PreparedStatement ps = db.getConexion().prepareStatement(sql);
            ps.setString(1, nombre);
            ps.setInt(2, id);
            
            int i = ps.executeUpdate();
            db.desconectar();
            return i > 0;
            
        } catch (SQLException e) {
            System.out.println("No se pudo editar el tipo");
            System.out.println(e.getMessage());
            return false;
        }
    }
    
    public boolean eliminar(int id){
           try {
            db.conectar();
            String sql = "DELETE FROM tipo WHERE id = ?";
            PreparedStatement ps = db.getConexion().prepareStatement(sql);
            ps.setInt(1, id);
            
            int i = ps.executeUpdate();
            db.desconectar();
            return i > 0;
            
        } catch (SQLException e) {
            System.out.println("No se pudo eliminar el tipo");
            System.out.println(e.getMessage());
            return false;
        }
    }
    
    public ArrayList<ArrayList> getTipos(){
        ArrayList<ArrayList> tipos = new ArrayList();
        try {
            db.conectar();
            String query = "SELECT * FROM tipo ORDER BY(id) DESC";
            PreparedStatement ps = db.getConexion().prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            while (rs.next()){
                ArrayList tipo = new ArrayList();
                tipo.add(rs.getInt("id"));
                tipo.add(rs.getString("nombre"));
                
                tipos.add(tipo);
            }
            
            db.desconectar();
            
        } catch (SQLException e) {
            System.out.println("No se pudo obtener los tipos.");
            System.out.println(e.getMessage());
        }
        return tipos;
    }
    
        public ArrayList<ArrayList> getTiposAsc(){
          ArrayList<ArrayList> tipos = new ArrayList();
        try {
            db.conectar();
            String query = "SELECT * FROM tipo ORDER BY(id) ASC";
            PreparedStatement ps = db.getConexion().prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            while (rs.next()){
                ArrayList tipo = new ArrayList();
                tipo.add(rs.getInt("id"));
                tipo.add(rs.getString("nombre"));
                
                tipos.add(tipo);
            }
            
            db.desconectar();
            
        } catch (SQLException e) {
            System.out.println("No se pudo obtener los tipos.");
            System.out.println(e.getMessage());
        }
        return tipos;
    }
    
}


