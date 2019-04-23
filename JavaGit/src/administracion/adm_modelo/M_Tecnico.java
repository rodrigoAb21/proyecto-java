/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package administracion.adm_modelo;

import utils.ConexionBD;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author KAKU
 */
public class M_Tecnico {
    private int id;
    private String ci;
    private String nombre;
    private String apellido;
    private String especialidad;
    private String direccion;
    private String telefono;
    private ConexionBD db;

    public M_Tecnico() {
        this.id = 0;
        this.ci = "";
        this.nombre = "";
        this.apellido = "";
        this.especialidad = "";
        this.direccion = "";
        this.telefono = "";
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

    public String getCi() {
        return ci;
    }

    public void setCi(String ci) {
        this.ci = ci;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }
    
    
    
    // METODOS
    public boolean registrar(String ci, String nombre, String apellido, 
            String especialidad, String direccion, String telefono){
        try {
            db.conectar();
            String sql = "INSERT INTO tecnico (ci, nombre, apellido, " + 
                    "especialidad, direccion, telefono) VALUES ( ?, ?, ?, ?, ?, ?)" ;
            PreparedStatement ps = db.getConexion().prepareStatement(sql);
            ps.setString(1, ci);
            ps.setString(2, nombre);
            ps.setString(3, apellido);
            ps.setString(4, especialidad);
            ps.setString(5, direccion);
            ps.setString(6, telefono);
            
            int i = ps.executeUpdate();
            db.desconectar();
            return i > 0;
            
        } catch (SQLException e) {
            System.out.println("No se pudo registrar el tecnico");
            System.out.println(e.getMessage());
            return false;
        }
    }
    
    public boolean editar(int id, String ci, String nombre, String apellido, 
            String especialidad, String direccion, String telefono){
         try {
            db.conectar();
            String sql = "UPDATE tecnico SET " + 
                    "ci = ?, " +
                    "nombre = ?, " +
                    "apellido = ?, " +
                    "especialidad = ?, " +
                    "direccion = ?, " +
                    "telefono = ? " + "WHERE id = ?";
            PreparedStatement ps = db.getConexion().prepareStatement(sql);
            ps.setString(1, ci);
            ps.setString(2, nombre);
            ps.setString(3, apellido);
            ps.setString(4, especialidad);
            ps.setString(5, direccion);
            ps.setString(6, telefono);
            ps.setInt(7, id);
            
            int i = ps.executeUpdate();
            db.desconectar();
            return i > 0;
            
        } catch (SQLException e) {
            System.out.println("No se pudo editar el tecnico");
            System.out.println(e.getMessage());
            return false;
        }
    }
    
    public boolean eliminar(int id){
           try {
            db.conectar();
            String sql = "DELETE FROM tecnico WHERE id = ?";
            PreparedStatement ps = db.getConexion().prepareStatement(sql);
            ps.setInt(1, id);
            
            int i = ps.executeUpdate();
            db.desconectar();
            return i > 0;
            
        } catch (SQLException e) {
            System.out.println("No se pudo eliminar el tecnico");
            System.out.println(e.getMessage());
            return false;
        }
    }
    
    public ArrayList<ArrayList> getTecnicos(){
        ArrayList<ArrayList> tecnicos = new ArrayList();
        try {
            db.conectar();
            String query = "SELECT * FROM tecnico ORDER BY(id) DESC";
            PreparedStatement ps = db.getConexion().prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            while (rs.next()){
                ArrayList tecnico = new ArrayList();
                tecnico.add(rs.getInt("id"));
                tecnico.add(rs.getString("ci"));
                tecnico.add(rs.getString("nombre"));
                tecnico.add(rs.getString("apellido"));
                tecnico.add(rs.getString("especialidad"));
                tecnico.add(rs.getString("direccion"));
                tecnico.add(rs.getString("telefono"));
                
                tecnicos.add(tecnico);
            }
            
            db.desconectar();
            
        } catch (SQLException e) {
            System.out.println("No se pudo obtener a los tecnicos.");
            System.out.println(e.getMessage());
        }
        return tecnicos;
    }
    
    public ArrayList<ArrayList> getTecnicosAsc(){
        ArrayList<ArrayList> tecnicos = new ArrayList();
        try {
            db.conectar();
            String query = "SELECT * FROM tecnico ORDER BY(id) ASC";
            PreparedStatement ps = db.getConexion().prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            while (rs.next()){
                ArrayList tecnico = new ArrayList();
                tecnico.add(rs.getInt("id"));
                tecnico.add(rs.getString("ci"));
                tecnico.add(rs.getString("nombre"));
                tecnico.add(rs.getString("apellido"));
                tecnico.add(rs.getString("especialidad"));
                tecnico.add(rs.getString("direccion"));
                tecnico.add(rs.getString("telefono"));
                
                tecnicos.add(tecnico);
            }
            
            db.desconectar();
            
        } catch (SQLException e) {
            System.out.println("No se pudo obtener a los tecnicos.");
            System.out.println(e.getMessage());
        }
        return tecnicos;
    }
}
