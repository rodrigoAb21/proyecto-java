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
public class M_Equipo {
    private int id;
    private String modelo;
    private String nro_serie;
    private String marca;
    private int tipo_id;
    private ConexionBD db;

    public M_Equipo(int id, String modelo, String nro_serie, String marca, int tipo_id) {
        this.id = id;
        this.modelo = modelo;
        this.nro_serie = nro_serie;
        this.marca = marca;
        this.tipo_id = tipo_id;
        this.db = new ConexionBD();
    }
    
    public M_Equipo() {
        this.id = 0;
        this.modelo = "";
        this.nro_serie = "";
        this.marca = "";
        this.tipo_id = 0;
        db = new ConexionBD();
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getNro_serie() {
        return nro_serie;
    }

    public void setNro_serie(String nro_serie) {
        this.nro_serie = nro_serie;
    }

    public int getTipo_id() {
        return tipo_id;
    }

    public void setTipo_id(int tipo_id) {
        this.tipo_id = tipo_id;
    }

   
    
    
    // METODOS
    public boolean registrar(){
        try {
            db.conectar();
            String sql = "INSERT INTO equipo (id, modelo, nro_serie, marca" + 
                    ", tipo_id) VALUES (?, ?, ?, ?, ?)" ;
            PreparedStatement ps = db.getConexion().prepareStatement(sql);
            ps.setInt(1, this.id);
            ps.setString(2, this.modelo);
            ps.setString(3, this.nro_serie);
            ps.setString(4, this.marca);
            ps.setInt(5, this.tipo_id);
            
            int i = ps.executeUpdate();
            db.desconectar();
            return i > 0;
            
        } catch (SQLException e) {
            System.out.println("No se pudo registrar el equipo");
            System.out.println(e.getMessage());
            return false;
        }
    }
    
    public boolean editar(){
         try {
            db.conectar();
            String sql = "UPDATE equipo SET " + 
                    "modelo = ?, " +
                    "nro_serie = ?, " +
                    "marca = ?, " +
                    "tipo_id = ? " + "WHERE id = ?";
            PreparedStatement ps = db.getConexion().prepareStatement(sql);
            ps.setString(1, this.modelo);
            ps.setString(2, this.nro_serie);
            ps.setString(3, this.marca);
            ps.setInt(4, this.tipo_id);
            ps.setInt(5, this.id);
            
            int i = ps.executeUpdate();
            db.desconectar();
            return i > 0;
            
        } catch (SQLException e) {
            System.out.println("No se pudo editar el equipo");
            System.out.println(e.getMessage());
            return false;
        }
    }
    
    public boolean eliminar(){
           try {
            db.conectar();
            String sql = "DELETE FROM equipo WHERE id = ?";
            PreparedStatement ps = db.getConexion().prepareStatement(sql);
            ps.setInt(1, this.id);
            
            int i = ps.executeUpdate();
            db.desconectar();
            return i > 0;
            
        } catch (SQLException e) {
            System.out.println("No se pudo eliminar el equipo");
            System.out.println(e.getMessage());
            return false;
        }
    }
    
    public ArrayList<M_Equipo> getEquipos(){
        ArrayList<M_Equipo> equipos = new ArrayList<>();
        try {
            db.conectar();
            String query = "SELECT * FROM equipo ORDER BY(id) DESC";
            PreparedStatement ps = db.getConexion().prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            while (rs.next()){
                M_Equipo equipo = new M_Equipo();
                equipo.setId(rs.getInt("id"));
                equipo.setModelo(rs.getString("modelo"));
                equipo.setNro_serie(rs.getString("nro_serie"));
                equipo.setMarca(rs.getString("marca"));
                equipo.setTipo_id(rs.getInt("tipo_id"));
                
                equipos.add(equipo);
            }
            
            db.desconectar();
            
        } catch (SQLException e) {
            System.out.println("No se pudo obtener los equipos.");
            System.out.println(e.getMessage());
        }
        return equipos;
    }
    
}

