/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adm_modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author KAKU
 */
public class M_Herramienta {
    private int id;
    private String descripcion;
    private String marca;
    private ConexionBD db;

    public M_Herramienta() {
        this.id = 0;
        this.descripcion = "";
        this.marca = "";
        db = new ConexionBD();
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

   
    
    
    // METODOS
    public boolean registrar(String descripcion, String marca){
        try {
            db.conectar();
            String sql = "INSERT INTO herramienta (descripcion, marca) " + 
                    " VALUES (?, ?)" ;
            PreparedStatement ps = db.getConexion().prepareStatement(sql);
            ps.setString(1, descripcion);
            ps.setString(2, marca);
            
            int i = ps.executeUpdate();
            db.desconectar();
            return i > 0;
            
        } catch (SQLException e) {
            System.out.println("No se pudo registrar la herramienta");
            System.out.println(e.getMessage());
            return false;
        }
    }
    
    public boolean editar(int id, String descripcion, String marca){
         try {
            db.conectar();
            String sql = "UPDATE herramienta SET " + 
                    "descripcion = ?, " +
                    "marca = ? " + "WHERE id = ?";
            PreparedStatement ps = db.getConexion().prepareStatement(sql);
            ps.setString(1, descripcion);
            ps.setString(2, marca);
            ps.setInt(3, id);
            
            int i = ps.executeUpdate();
            db.desconectar();
            return i > 0;
            
        } catch (SQLException e) {
            System.out.println("No se pudo editar la herramienta");
            System.out.println(e.getMessage());
            return false;
        }
    }
    
    public boolean eliminar(int id){
           try {
            db.conectar();
            String sql = "DELETE FROM herramienta WHERE id = ?";
            PreparedStatement ps = db.getConexion().prepareStatement(sql);
            ps.setInt(1, id);
            
            int i = ps.executeUpdate();
            db.desconectar();
            return i > 0;
            
        } catch (SQLException e) {
            System.out.println("No se pudo eliminar la herramienta");
            System.out.println(e.getMessage());
            return false;
        }
    }
    
    public ArrayList<ArrayList> getHerramientas(){
        ArrayList<ArrayList> herramientas = new ArrayList();
        try {
            db.conectar();
            String query = "SELECT * FROM herramienta ORDER BY(id) DESC";
            PreparedStatement ps = db.getConexion().prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            while (rs.next()){
                ArrayList herramienta = new ArrayList();
                herramienta.add(rs.getInt("id"));
                herramienta.add(rs.getString("descripcion"));
                herramienta.add(rs.getString("marca"));
                
                herramientas.add(herramienta);
            }
            
            db.desconectar();
            
        } catch (SQLException e) {
            System.out.println("No se pudo obtener las herramientas.");
            System.out.println(e.getMessage());
        }
        return herramientas;
    }
    
     public ArrayList<ArrayList> getHerramientasAsc(){
        ArrayList<ArrayList> herramientas = new ArrayList();
        try {
            db.conectar();
            String query = "SELECT * FROM herramienta ORDER BY(id) ASC";
            PreparedStatement ps = db.getConexion().prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            while (rs.next()){
                ArrayList herramienta = new ArrayList();
                herramienta.add(rs.getInt("id"));
                herramienta.add(rs.getString("descripcion"));
                herramienta.add(rs.getString("marca"));
                
                herramientas.add(herramienta);
            }
            
            db.desconectar();
            
        } catch (SQLException e) {
            System.out.println("No se pudo obtener las herramientas.");
            System.out.println(e.getMessage());
        }
        return herramientas;
    }
}

