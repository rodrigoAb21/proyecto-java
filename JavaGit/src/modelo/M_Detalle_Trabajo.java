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
public class M_Detalle_Trabajo {
    private int trabajo_id;
    private int herramienta_id;
    private ConexionBD db;

    public M_Detalle_Trabajo() {
        this.trabajo_id = 0;
        this.herramienta_id = 0;
        this.db = new ConexionBD();
    }

    public int getTrabajo_id() {
        return trabajo_id;
    }

    public void setTrabajo_id(int trabajo_id) {
        this.trabajo_id = trabajo_id;
    }

    public int getHerramienta_id() {
        return herramienta_id;
    }

    public void setHerramienta_id(int herramienta_id) {
        this.herramienta_id = herramienta_id;
    }

     
    
        
    // METODOS
    public boolean agregar(int trabajo_id, int herramienta_id){
        try {
            db.conectar();
            String sql = "INSERT INTO detalle_trabajo (trabajo_id, herramienta_id)" + 
                    " VALUES (?, ?)" ;
            PreparedStatement ps = db.getConexion().prepareStatement(sql);
            ps.setInt(1, trabajo_id);
            ps.setInt(2, herramienta_id);
            
            int i = ps.executeUpdate();
            db.desconectar();
            return i > 0;
            
        } catch (SQLException e) {
            System.out.println("No se pudo registrar el detalle");
            System.out.println(e.getMessage());
            return false;
        }
    }
    
    
    public boolean quitar(int trabajo_id, int herramienta_id){
           try {
            db.conectar();
            String sql = "DELETE FROM detalle_trabajo WHERE trabajo_id = ? AND herramienta_id = ?";
            PreparedStatement ps = db.getConexion().prepareStatement(sql);
            ps.setInt(1, trabajo_id);
            ps.setInt(2, herramienta_id);
            
            int i = ps.executeUpdate();
            db.desconectar();
            return i > 0;
            
        } catch (SQLException e) {
            System.out.println("No se pudo eliminar el detalle");
            System.out.println(e.getMessage());
            return false;
        }
    }
    
    public ArrayList<ArrayList> getDetalles(int trabajo_id){
        ArrayList<ArrayList> detalles = new ArrayList();
        try {
            db.conectar();
            String query = "SELECT detalle_trabajo.herramienta_id, herramienta.descripcion, " + 
                    "herramienta.marca  FROM detalle_trabajo, herramienta WHERE trabajo_id = ? " + 
                    "and detalle_trabajo.herramienta_id = herramienta.id ORDER BY(herramienta_id) DESC";
            PreparedStatement ps = db.getConexion().prepareStatement(query);
            ps.setInt(1, trabajo_id);
            ResultSet rs = ps.executeQuery();

            while (rs.next()){
                ArrayList detalle_trabajo = new ArrayList();
                detalle_trabajo.add(rs.getInt("detalle_trabajo.herramienta_id"));
                detalle_trabajo.add(rs.getString("herramienta.descripcion"));
                detalle_trabajo.add(rs.getString("herramienta.marca"));
                
                detalles.add(detalle_trabajo);
            }
            
            db.desconectar();
            
        } catch (SQLException e) {
            System.out.println("No se pudo obtener los detalles.");
            System.out.println(e.getMessage());
        }
        return detalles;
    }
    
}

