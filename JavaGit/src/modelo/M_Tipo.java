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
    public boolean registrar(){
        try {
            db.conectar();
            String sql = "INSERT INTO tipo (id, nombre) " + 
                    " VALUES (?, ?)" ;
            PreparedStatement ps = db.getConexion().prepareStatement(sql);
            ps.setInt(1, this.id);
            ps.setString(2, this.nombre);
            
            int i = ps.executeUpdate();
            db.desconectar();
            return i > 0;
            
        } catch (SQLException e) {
            System.out.println("No se pudo registrar el tipo");
            System.out.println(e.getMessage());
            return false;
        }
    }
    
    public boolean editar(){
         try {
            db.conectar();
            String sql = "UPDATE tipo SET " + 
                    "nombre = ? " + "WHERE id = ?";
            PreparedStatement ps = db.getConexion().prepareStatement(sql);
            ps.setString(1, this.nombre);
            ps.setInt(2, this.id);
            
            int i = ps.executeUpdate();
            db.desconectar();
            return i > 0;
            
        } catch (SQLException e) {
            System.out.println("No se pudo editar el tipo");
            System.out.println(e.getMessage());
            return false;
        }
    }
    
    public boolean eliminar(){
           try {
            db.conectar();
            String sql = "DELETE FROM tipo WHERE id = ?";
            PreparedStatement ps = db.getConexion().prepareStatement(sql);
            ps.setInt(1, this.id);
            
            int i = ps.executeUpdate();
            db.desconectar();
            return i > 0;
            
        } catch (SQLException e) {
            System.out.println("No se pudo eliminar el tipo");
            System.out.println(e.getMessage());
            return false;
        }
    }
    
    public ArrayList<M_Tipo> getTipos(){
        ArrayList<M_Tipo> tipos = new ArrayList<>();
        try {
            db.conectar();
            String query = "SELECT * FROM tipo ORDER BY(id) DESC";
            PreparedStatement ps = db.getConexion().prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            while (rs.next()){
                M_Tipo tipo = new M_Tipo();
                tipo.setId(rs.getInt("id"));
                tipo.setNombre(rs.getString("nombre"));
                
                tipos.add(tipo);
            }
            
            db.desconectar();
            
        } catch (SQLException e) {
            System.out.println("No se pudo obtener los tipos.");
            System.out.println(e.getMessage());
        }
        return tipos;
    }
    
        public ArrayList<M_Tipo> getTiposAsc(){
        ArrayList<M_Tipo> tipos = new ArrayList<>();
        try {
            db.conectar();
            String query = "SELECT * FROM tipo ORDER BY(id) ASC";
            PreparedStatement ps = db.getConexion().prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            while (rs.next()){
                M_Tipo tipo = new M_Tipo();
                tipo.setId(rs.getInt("id"));
                tipo.setNombre(rs.getString("nombre"));
                
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


