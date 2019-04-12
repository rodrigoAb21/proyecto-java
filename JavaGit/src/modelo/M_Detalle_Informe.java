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

    public M_Detalle_Informe(int informe_id, int equipo_id, float costo, String observacion) {
        this.informe_id = informe_id;
        this.equipo_id = equipo_id;
        this.costo = costo;
        this.observacion = observacion;
        this.db =  new ConexionBD();
    }

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
    public boolean registrar(){
        try {
            db.conectar();
            String sql = "INSERT INTO detalle_informe (informe_id, equipo_id," + 
                    " costo, observacion) VALUES (?, ?, ?, ?)" ;
            PreparedStatement ps = db.getConexion().prepareStatement(sql);
            ps.setInt(1, this.informe_id);
            ps.setInt(2, this.equipo_id);
            ps.setFloat(3, this.costo);
            ps.setString(4, this.observacion);
            
            int i = ps.executeUpdate();
            db.desconectar();
            return i > 0;
            
        } catch (SQLException e) {
            System.out.println("No se pudo registrar el detalle");
            System.out.println(e.getMessage());
            return false;
        }
    }
    
    public boolean editar(){
         try {
            db.conectar();
            String sql = "UPDATE detalle_informe SET " + 
                    "costo = ?, " +
                    "observacion = ? " + "WHERE informe_id = ? AND equipo_id = ?";
            PreparedStatement ps = db.getConexion().prepareStatement(sql);
            ps.setFloat(1, this.costo);
            ps.setString(2, this.observacion);
            ps.setInt(3, this.informe_id);
            ps.setInt(4, this.equipo_id);
            
            int i = ps.executeUpdate();
            db.desconectar();
            return i > 0;
            
        } catch (SQLException e) {
            System.out.println("No se pudo editar el detalle");
            System.out.println(e.getMessage());
            return false;
        }
    }
    
    public boolean eliminar(){
           try {
            db.conectar();
            String sql = "DELETE FROM detalle_informe WHERE informe_id = ? AND equipo_id = ?";
            PreparedStatement ps = db.getConexion().prepareStatement(sql);
            ps.setInt(1, this.informe_id);
            ps.setInt(2, this.equipo_id);
            
            int i = ps.executeUpdate();
            db.desconectar();
            return i > 0;
            
        } catch (SQLException e) {
            System.out.println("No se pudo eliminar el detalle");
            System.out.println(e.getMessage());
            return false;
        }
    }
    
    public ArrayList<M_Detalle_Informe> getDetalles(int informe_id){
        ArrayList<M_Detalle_Informe> detalles = new ArrayList<>();
        try {
            db.conectar();
            String query = "SELECT * FROM detalle_informe WHERE informe_id = ? ORDER BY(equipo_id) DESC";
            PreparedStatement ps = db.getConexion().prepareStatement(query);
            ps.setInt(1, informe_id);
            ResultSet rs = ps.executeQuery();

            while (rs.next()){
                M_Detalle_Informe detalle_informe = new M_Detalle_Informe();
                detalle_informe.setInforme_id(rs.getInt("informe_id"));
                detalle_informe.setEquipo_id(rs.getInt("equipo_id"));
                detalle_informe.setCosto(rs.getFloat("costo"));
                detalle_informe.setObservacion(rs.getString("observacion"));
                
                detalles.add(detalle_informe);
            }
            
            db.desconectar();
            
        } catch (SQLException e) {
            System.out.println("No se pudo obtener los detalles.");
            System.out.println(e.getMessage());
        }
        return detalles;
    }
    
     public ArrayList<M_Detalle_Informe> getDetallesAsc(int informe_id){
        ArrayList<M_Detalle_Informe> detalles = new ArrayList<>();
        try {
            db.conectar();
            String query = "SELECT * FROM detalle_informe WHERE informe_id = ? ORDER BY(equipo_id) ASC";
            PreparedStatement ps = db.getConexion().prepareStatement(query);
            ps.setInt(1, informe_id);
            ResultSet rs = ps.executeQuery();

            while (rs.next()){
                M_Detalle_Informe detalle_informe = new M_Detalle_Informe();
                detalle_informe.setInforme_id(rs.getInt("informe_id"));
                detalle_informe.setEquipo_id(rs.getInt("equipo_id"));
                detalle_informe.setCosto(rs.getFloat("costo"));
                detalle_informe.setObservacion(rs.getString("observacion"));
                
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
            String query = "SELECT * FROM detalle_informe WHERE informe_id = ? ORDER BY(equipo_id) ASC";
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

