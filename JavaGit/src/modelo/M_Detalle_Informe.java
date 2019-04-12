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
public class M_Detalle_Informe {
    private int informe_id;
    private int equipo_id;
    private float costo;
    private String observacion;
    private ConexionBD db;

    public M_Detalle_Informe() {
        this.informe_id = 0;
        this.equipo_id = 0;
        this.costo = 0f;
        this.observacion = "";
        this.db =  new ConexionBD();
    }

    public int getInforme_id() {
        return informe_id;
    }

    public void setInforme_id(int informe_id) {
        this.informe_id = informe_id;
    }

    public int getEquipo_id() {
        return equipo_id;
    }

    public void setEquipo_id(int equipo_id) {
        this.equipo_id = equipo_id;
    }

    public float getCosto() {
        return costo;
    }

    public void setCosto(float costo) {
        this.costo = costo;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }
    
        
    // METODOS
    public boolean registrar(int informe_id, int equipo_id, float costo, String observacion){
        try {
            db.conectar();
            String sql = "INSERT INTO detalle_informe (informe_id, equipo_id," + 
                    " costo, observacion) VALUES (?, ?, ?, ?)" ;
            PreparedStatement ps = db.getConexion().prepareStatement(sql);
            ps.setInt(1, informe_id);
            ps.setInt(2, equipo_id);
            ps.setFloat(3, costo);
            ps.setString(4, observacion);
            
            int i = ps.executeUpdate();
            db.desconectar();
            return i > 0;
            
        } catch (SQLException e) {
            System.out.println("No se pudo registrar el detalle");
            System.out.println(e.getMessage());
            return false;
        }
    }
    
    public boolean editar(int informe_id, int equipo_id, float costo, String observacion){
         try {
            db.conectar();
            String sql = "UPDATE detalle_informe SET " + 
                    "costo = ?, " +
                    "observacion = ? " + "WHERE informe_id = ? AND equipo_id = ?";
            PreparedStatement ps = db.getConexion().prepareStatement(sql);
            ps.setFloat(1, costo);
            ps.setString(2, observacion);
            ps.setInt(3, informe_id);
            ps.setInt(4, equipo_id);
            
            int i = ps.executeUpdate();
            db.desconectar();
            return i > 0;
            
        } catch (SQLException e) {
            System.out.println("No se pudo editar el detalle");
            System.out.println(e.getMessage());
            return false;
        }
    }
    
    public boolean eliminar(int informe_id, int equipo_id){
           try {
            db.conectar();
            String sql = "DELETE FROM detalle_informe WHERE informe_id = ? AND equipo_id = ?";
            PreparedStatement ps = db.getConexion().prepareStatement(sql);
            ps.setInt(1, informe_id);
            ps.setInt(2, equipo_id);
            
            int i = ps.executeUpdate();
            db.desconectar();
            return i > 0;
            
        } catch (SQLException e) {
            System.out.println("No se pudo eliminar el detalle");
            System.out.println(e.getMessage());
            return false;
        }
    }
    
    public ArrayList<ArrayList> getDetalles(int informe_id){
        ArrayList<ArrayList> detalles = new ArrayList();
        try {
            db.conectar();
            String query = "SELECT * FROM detalle_informe WHERE informe_id = ? ORDER BY(equipo_id) DESC";
            PreparedStatement ps = db.getConexion().prepareStatement(query);
            ps.setInt(1, informe_id);
            ResultSet rs = ps.executeQuery();

            while (rs.next()){
                ArrayList detalle_informe = new ArrayList();
                detalle_informe.add(rs.getInt("informe_id"));
                detalle_informe.add(rs.getInt("equipo_id"));
                detalle_informe.add(rs.getFloat("costo"));
                detalle_informe.add(rs.getString("observacion"));
                
                detalles.add(detalle_informe);
            }
            
            db.desconectar();
            
        } catch (SQLException e) {
            System.out.println("No se pudo obtener los detalles.");
            System.out.println(e.getMessage());
        }
        return detalles;
    }
    
        public ArrayList<ArrayList> getDetallesAsc(int informe_id){
        ArrayList<ArrayList> detalles = new ArrayList();
        try {
            db.conectar();
            String query = "SELECT * FROM detalle_informe WHERE informe_id = ? ORDER BY(equipo_id) ASC";
            PreparedStatement ps = db.getConexion().prepareStatement(query);
            ps.setInt(1, informe_id);
            ResultSet rs = ps.executeQuery();

            while (rs.next()){
                ArrayList detalle_informe = new ArrayList();
                detalle_informe.add(rs.getInt("informe_id"));
                detalle_informe.add(rs.getInt("equipo_id"));
                detalle_informe.add(rs.getFloat("costo"));
                detalle_informe.add(rs.getString("observacion"));
                
                detalles.add(detalle_informe);
            }
            
            db.desconectar();
            
        } catch (SQLException e) {
            System.out.println("No se pudo obtener los detalles.");
            System.out.println(e.getMessage());
        }
        return detalles;
    }
    
    public float calcularTotal(int informe_id){
        float resultado = 0f;
        try {
            db.conectar();
            String query = "SELECT * FROM detalle_informe WHERE informe_id = ?";
            PreparedStatement ps = db.getConexion().prepareStatement(query);
            ps.setInt(1, informe_id);
            ResultSet rs = ps.executeQuery();

            while (rs.next()){
                resultado = resultado + rs.getFloat("costo");
            }
            
            db.desconectar();
            
        } catch (SQLException e) {
            System.out.println("No se pudo obtener los detalles.");
            System.out.println(e.getMessage());
        }
        return resultado;
    }
    
}
