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
public class M_Tecnico {
    private int id;
    private String ci;
    private String nombre;
    private String apellido;
    private String especialidad;
    private String direccion;
    private String telefono;
    private ConexionBD db;

    public M_Tecnico(int id, String ci, String nombre, String apellido, 
            String especialidad, String direccion, String telefono) {
        this.id = id;
        this.ci = ci;
        this.nombre = nombre;
        this.apellido = apellido;
        this.especialidad = especialidad;
        this.direccion = direccion;
        this.telefono = telefono;
        db = new ConexionBD();
    }

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
    public boolean registrar(){
        try {
            db.conectar();
            String sql = "INSERT INTO tecnico (id, ci, nombre, apellido, " + 
                    "especialidad, direccion, telefono) VALUES (?, ?, ?, ?, ?, ?, ?)" ;
            PreparedStatement ps = db.getConexion().prepareStatement(sql);
            ps.setInt(1, this.id);
            ps.setString(2, this.ci);
            ps.setString(3, this.nombre);
            ps.setString(4, this.apellido);
            ps.setString(5, this.especialidad);
            ps.setString(6, this.direccion);
            ps.setString(7, this.telefono);
            
            int i = ps.executeUpdate();
            db.desconectar();
            return i > 0;
            
        } catch (SQLException e) {
            System.out.println("No se pudo registrar el tecnico");
            System.out.println(e.getMessage());
            return false;
        }
    }
    
    public boolean editar(){
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
            ps.setString(1, this.ci);
            ps.setString(2, this.nombre);
            ps.setString(3, this.apellido);
            ps.setString(4, this.especialidad);
            ps.setString(5, this.direccion);
            ps.setString(6, this.telefono);
            ps.setInt(7, this.id);
            
            int i = ps.executeUpdate();
            db.desconectar();
            return i > 0;
            
        } catch (SQLException e) {
            System.out.println("No se pudo editar el tecnico");
            System.out.println(e.getMessage());
            return false;
        }
    }
    
    public boolean eliminar(){
           try {
            db.conectar();
            String sql = "DELETE FROM tecnico WHERE id = ?";
            PreparedStatement ps = db.getConexion().prepareStatement(sql);
            ps.setInt(1, this.id);
            
            int i = ps.executeUpdate();
            db.desconectar();
            return i > 0;
            
        } catch (SQLException e) {
            System.out.println("No se pudo eliminar el tecnico");
            System.out.println(e.getMessage());
            return false;
        }
    }
    
    public ArrayList<M_Tecnico> getTecnicos(){
        ArrayList<M_Tecnico> tecnicos = new ArrayList<>();
        try {
            db.conectar();
            String query = "SELECT * FROM tecnico ORDER BY(id) DESC";
            PreparedStatement ps = db.getConexion().prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            while (rs.next()){
                M_Tecnico tecnico = new M_Tecnico();
                tecnico.setId(rs.getInt("id"));
                tecnico.setCi(rs.getString("ci"));
                tecnico.setNombre(rs.getString("nombre"));
                tecnico.setApellido(rs.getString("apellido"));
                tecnico.setEspecialidad(rs.getString("especialidad"));
                tecnico.setDireccion(rs.getString("direccion"));
                tecnico.setTelefono(rs.getString("telefono"));
                
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
