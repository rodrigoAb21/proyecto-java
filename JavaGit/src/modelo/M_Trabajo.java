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
public class M_Trabajo {
    private int id;
    private String fecha_inicio;
    private String fecha_fin;
    private float costo;
    private String descripcion;
    private int tecnico_id;
    private int informe_id;
    private int equipo_id;
    private ConexionBD db;

       
    public M_Trabajo() {
        this.id = 0;
        this.fecha_inicio = "";
        this.fecha_fin = "";
        this.costo = 0.0f;
        this.descripcion = "";
        this.tecnico_id = 0;
        this.informe_id = 0;
        this.equipo_id = 0;
        db = new ConexionBD();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFecha_inicio() {
        return fecha_inicio;
    }

    public void setFecha_inicio(String fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public String getFecha_fin() {
        return fecha_fin;
    }

    public void setFecha_fin(String fecha_fin) {
        this.fecha_fin = fecha_fin;
    }

    public float getCosto() {
        return costo;
    }

    public void setCosto(float costo) {
        this.costo = costo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getTecnico_id() {
        return tecnico_id;
    }

    public void setTecnico_id(int tecnico_id) {
        this.tecnico_id = tecnico_id;
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
    
    
    
    
       
    
    // METODOS
    public boolean registrar(String fecha_inicio, String fecha_fin, 
            float costo, String descripcion, int tecnico_id, int informe_id, int equipo_id){
        try {
            db.conectar();
            String sql = "INSERT INTO trabajo (fecha_inicio, fecha_fin, " + 
                    "costo, descripcion, tecnico_id, informe_id, equipo_id) VALUES (?, ?, ?, ?, ?, ?, ?)" ;
            PreparedStatement ps = db.getConexion().prepareStatement(sql);
            ps.setString(1, fecha_inicio);
            ps.setString(2, fecha_fin);
            ps.setFloat(3, costo);
            ps.setString(4, descripcion);
            ps.setInt(5, tecnico_id);
            ps.setInt(6, informe_id);
            ps.setInt(7, equipo_id);
            
            int i = ps.executeUpdate();
            db.desconectar();
            return i > 0;
            
        } catch (SQLException e) {
            System.out.println("No se pudo registrar el trabajo");
            System.out.println(e.getMessage());
            return false;
        }
    }
    
    public boolean editar(int id, String fecha_inicio, String fecha_fin, 
            float costo, String descripcion, int tecnico_id, int informe_id, int equipo_id){
         try {
            db.conectar();
            String sql = "UPDATE trabajo SET " + 
                    "fecha_inicio = ?, " +
                    "fecha_fin = ?, " +
                    "costo = ?, " +
                    "descripcion = ?, " +
                    "tecnico_id = ?, " + 
                    "informe_id = ?, " + 
                    "equipo_id = ? " + 
                    "WHERE id = ?";
            PreparedStatement ps = db.getConexion().prepareStatement(sql);
            ps.setString(1, fecha_inicio);
            ps.setString(2, fecha_fin);
            ps.setFloat(3, costo);
            ps.setString(4, descripcion);
            ps.setInt(5, tecnico_id);
            ps.setInt(6, informe_id);
            ps.setInt(7, equipo_id);
            ps.setInt(8, id);
            
            int i = ps.executeUpdate();
            db.desconectar();
            return i > 0;
            
        } catch (SQLException e) {
            System.out.println("No se pudo editar el trabajo");
            System.out.println(e.getMessage());
            return false;
        }
    }
    
    public boolean eliminar(int id){
           try {
            db.conectar();
            String sql = "DELETE FROM trabajo WHERE id = ?";
            PreparedStatement ps = db.getConexion().prepareStatement(sql);
            ps.setInt(1, id);
            
            int i = ps.executeUpdate();
            db.desconectar();
            return i > 0;
            
        } catch (SQLException e) {
            System.out.println("No se pudo eliminar el trabajo");
            System.out.println(e.getMessage());
            return false;
        }
    }
    
    public ArrayList<ArrayList> getTrabajos(int informe_id, int equipo_id){
        ArrayList<ArrayList> trabajos = new ArrayList();
        try {
            db.conectar();
            String query = "SELECT trabajo.id, trabajo.fecha_inicio, trabajo.fecha_fin, trabajo.costo, trabajo.descripcion, tecnico.nombre, tecnico.apellido  FROM trabajo, tecnico WHERE trabajo.informe_id = " + 
                    informe_id + " and trabajo.equipo_id = " + equipo_id + " and trabajo.tecnico_id = tecnico.id " 
                    + " ORDER BY(id) DESC";
            PreparedStatement ps = db.getConexion().prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            while (rs.next()){
                ArrayList trabajo = new ArrayList();
                trabajo.add(rs.getInt("trabajo.id"));
                trabajo.add(rs.getString("trabajo.fecha_inicio"));
                trabajo.add(rs.getString("trabajo.fecha_fin"));
                trabajo.add(rs.getFloat("trabajo.costo"));
                trabajo.add(rs.getString("trabajo.descripcion"));
                trabajo.add(rs.getString("tecnico.nombre"));
                trabajo.add(rs.getString("tecnico.apellido"));
                
                trabajos.add(trabajo);
            }
            
            db.desconectar();
            
        } catch (SQLException e) {
            System.out.println("No se pudo obtener los informes.");
            System.out.println(e.getMessage());
        }
        return trabajos;
    }
    
}

