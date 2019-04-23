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
public class M_Informe_Servicio {
    private int id;
    private String fecha_recepcion;
    private String fecha_finalizacion;
    private float costo_total;
    private String estado;
    private int cliente_id;
    private ConexionBD db;
    
    public M_Informe_Servicio() {
        this.id = 0;
        this.fecha_recepcion = "";
        this.fecha_finalizacion = "";
        this.costo_total = 0.0f;
        this.estado = "";
        this.cliente_id = 0;
        db = new ConexionBD();
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFecha_recepcion() {
        return fecha_recepcion;
    }

    public void setFecha_recepcion(String fecha_recepcion) {
        this.fecha_recepcion = fecha_recepcion;
    }

    public float getCosto_total() {
        return costo_total;
    }

    public void setCosto_total(float costo_total) {
        this.costo_total = costo_total;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getCliente_id() {
        return cliente_id;
    }

    public void setCliente_id(int cliente_id) {
        this.cliente_id = cliente_id;
    }

    public String getFecha_finalizacion() {
        return fecha_finalizacion;
    }

    public void setFecha_finalizacion(String fecha_finalizacion) {
        this.fecha_finalizacion = fecha_finalizacion;
    }

       
    
    // METODOS
    public boolean registrar(String fecha_recepcion, String fecha_finalizacion, 
            float costo_total, String estado, int cliente_id){
        try {
            db.conectar();
            String sql = "INSERT INTO informe_servicio (fecha_recepcion, fecha_finalizacion, " + 
                    "costo_total, estado, cliente_id) VALUES (?, ?, ?, ?, ?)" ;
            PreparedStatement ps = db.getConexion().prepareStatement(sql);
            ps.setString(1, fecha_recepcion);
            ps.setString(2, fecha_finalizacion);
            ps.setFloat(3, costo_total);
            ps.setString(4, estado);
            ps.setInt(5, cliente_id);
            
            int i = ps.executeUpdate();
            db.desconectar();
            return i > 0;
            
        } catch (SQLException e) {
            System.out.println("No se pudo registrar el informe_servicio");
            System.out.println(e.getMessage());
            return false;
        }
    }
    
    public boolean editar(int id, String fecha_recepcion, String fecha_finalizacion, int cliente_id){
         try {
            db.conectar();
            String sql = "UPDATE informe_servicio SET " + 
                    "fecha_recepcion = ?, " +
                    "fecha_finalizacion = ?, " +
                    "cliente_id = ? " + "WHERE id = ?";
            PreparedStatement ps = db.getConexion().prepareStatement(sql);
            ps.setString(1, fecha_recepcion);
            ps.setString(2, fecha_finalizacion);
            ps.setInt(3, cliente_id);
            ps.setInt(4, id);
            
            int i = ps.executeUpdate();
            db.desconectar();
            return i > 0;
            
        } catch (SQLException e) {
            System.out.println("No se pudo editar el informe_servicio");
            System.out.println(e.getMessage());
            return false;
        }
    }
    
    public boolean eliminar(int id){
           try {
            db.conectar();
            String sql = "DELETE FROM informe_servicio WHERE id = ?";
            PreparedStatement ps = db.getConexion().prepareStatement(sql);
            ps.setInt(1, id);
            
            int i = ps.executeUpdate();
            db.desconectar();
            return i > 0;
            
        } catch (SQLException e) {
            System.out.println("No se pudo eliminar el informe_servicio");
            System.out.println(e.getMessage());
            return false;
        }
    }
    
    public ArrayList<ArrayList> getInformes(){
        ArrayList<ArrayList> informe_servicios = new ArrayList();
        try {
            db.conectar();
            String query = "SELECT informe_servicio.id, " +
                    "informe_servicio.fecha_recepcion, " + 
                    " informe_servicio.fecha_finalizacion, " + 
                    "informe_servicio.costo_total, informe_servicio.estado, " + 
                    "cliente.nombre FROM informe_servicio, cliente " + 
                    "WHERE informe_servicio.cliente_id = cliente.id " + 
                    "ORDER BY(informe_servicio.id) DESC";
            PreparedStatement ps = db.getConexion().prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            while (rs.next()){
                ArrayList informe_servicio = new ArrayList();
                informe_servicio.add(rs.getInt("id"));
                informe_servicio.add(rs.getString("fecha_recepcion"));
                informe_servicio.add(rs.getString("fecha_finalizacion"));
                informe_servicio.add(rs.getFloat("costo_total"));
                informe_servicio.add(rs.getString("estado"));
                informe_servicio.add(rs.getString("nombre"));
                
                informe_servicios.add(informe_servicio);
            }
            
            db.desconectar();
            
        } catch (SQLException e) {
            System.out.println("No se pudo obtener los informes.");
            System.out.println(e.getMessage());
        }
        return informe_servicios;
    }
    
    
    public boolean actualizarEstado(int id, String estado){
        try {
            db.conectar();
            String sql = "UPDATE informe_servicio SET " + 
                    "estado = ? " + "WHERE id = ?";
            PreparedStatement ps = db.getConexion().prepareStatement(sql);
            ps.setString(1, estado);
            ps.setInt(2, id);
            
            int i = ps.executeUpdate();
            db.desconectar();
            return i > 0;
            
        } catch (SQLException e) {
            System.out.println("No se pudo actualiza el estdao del informe");
            System.out.println(e.getMessage());
            return false;
        }
    }
    
    public boolean actualizarCostoTotal(int id, float total){
        try {
            db.conectar();
            String sql = "UPDATE informe_servicio SET " + 
                    "costo_total = ? " + "WHERE id = ?";
            PreparedStatement ps = db.getConexion().prepareStatement(sql);
            ps.setFloat(1, total);
            ps.setInt(2, id);
            
            int i = ps.executeUpdate();
            db.desconectar();
            return i > 0;
            
        } catch (SQLException e) {
            System.out.println("No se pudo actualiza el costo_total del informe");
            System.out.println(e.getMessage());
            return false;
        }
    }
}

