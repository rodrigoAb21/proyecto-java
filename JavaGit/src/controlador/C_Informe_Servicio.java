/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import modelo.M_Informe_Servicio;
import modelo.M_Cliente;
import modelo.M_Detalle_Informe;
import modelo.M_Equipo;
import vista.V_Informe_Servicio;

/**
 *
 * @author KAKU
 */
public class C_Informe_Servicio implements ActionListener {
    private M_Informe_Servicio modelo_informe_servicio;
    private M_Cliente modelo_cliente;
    private M_Equipo modelo_equipo;
    private M_Detalle_Informe modelo_detalle;
    private V_Informe_Servicio vista_informe_servicio;
    
    private int informe_seleccionado = -1;
    private int detalle_seleccionado = -1;
    

    public C_Informe_Servicio() {
        this.modelo_informe_servicio = new M_Informe_Servicio();
        this.modelo_cliente = new M_Cliente();
        this.modelo_equipo = new M_Equipo();
        this.modelo_detalle = new M_Detalle_Informe();
        this.vista_informe_servicio = new V_Informe_Servicio();
        
        initComponent();
    }
    
    public void initComponent(){
        //Botones informe
        this.vista_informe_servicio.btn_registrar.addActionListener(this);
        this.vista_informe_servicio.btn_editar.addActionListener(this);
        this.vista_informe_servicio.btn_eliminar.addActionListener(this);
        this.vista_informe_servicio.btn_limpiar.addActionListener(this);
        this.vista_informe_servicio.btn_cargar_detalle.addActionListener(this);
        this.vista_informe_servicio.btn_finalizar.addActionListener(this);
        
        // Botones Detalle
        this.vista_informe_servicio.btn_agregar.addActionListener(this);
        this.vista_informe_servicio.btn_quitar.addActionListener(this);
        
        // Selectores
        this.vista_informe_servicio.selector_cliente.addActionListener(this);
        this.vista_informe_servicio.selector_equipo.addActionListener(this);
        
        
        this.vista_informe_servicio.setVisible(true);
        this.vista_informe_servicio.txt_costo_total.setEditable(false);
        this.vista_informe_servicio.txt_estado.setEditable(false);
        actualizarVista();
        
        
    }
    
    private void actualizarVista(){
        vista_informe_servicio.actualizarTablaInformes(modelo_informe_servicio.getInformes());
        vista_informe_servicio.cargarSelectorCliente(modelo_cliente.getClientesAsc());
        vista_informe_servicio.cargarSelectorEquipo(modelo_equipo.getEquipos());
    }
    
    private void actualizarTablaInforme(){
        vista_informe_servicio.actualizarTablaInformes(modelo_informe_servicio.getInformes());
    }
    
    private void actualizarTotal(int informe_id){
        modelo_informe_servicio.actualizarCostoTotal(informe_id, modelo_detalle.calcularTotal(informe_id));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista_informe_servicio.btn_registrar) {
            // REGISTRAR
            modelo_informe_servicio.setId(Integer.parseInt(vista_informe_servicio.txt_id.getText()));
            modelo_informe_servicio.setFecha_recepcion(vista_informe_servicio.txt_fecha_recepcion.getText());
            modelo_informe_servicio.setFecha_finalizacion(vista_informe_servicio.txt_fecha_finalizacion.getText());
            modelo_informe_servicio.setCosto_total(0f);
            modelo_informe_servicio.setEstado("Activo");

            String cliente[] = vista_informe_servicio.selector_cliente.getSelectedItem().toString().split(",");
            modelo_informe_servicio.setCliente_id(Integer.parseInt(cliente[0]));

            if (modelo_informe_servicio.registrar()) {
                JOptionPane.showMessageDialog(null, "Se registro un equipo");
            }else {
                JOptionPane.showMessageDialog(null, "No se pudo registrar un equipo");
            }
            vista_informe_servicio.limpiarCampos();
            actualizarVista();
        } else if (e.getSource() == vista_informe_servicio.btn_editar) {
            // EDITAR
            modelo_informe_servicio.setId(Integer.parseInt(vista_informe_servicio.txt_id.getText()));
            modelo_informe_servicio.setFecha_recepcion(vista_informe_servicio.txt_fecha_recepcion.getText());
            modelo_informe_servicio.setFecha_finalizacion(vista_informe_servicio.txt_fecha_finalizacion.getText());
            modelo_informe_servicio.setEstado(vista_informe_servicio.txt_estado.getText());

            String tipo[] = vista_informe_servicio.selector_cliente.getSelectedItem().toString().split(",");
            modelo_informe_servicio.setCliente_id(Integer.parseInt(tipo[0]));

            if (modelo_informe_servicio.editar()) {
                JOptionPane.showMessageDialog(null, "Se edito un equipo");
            }else {
                JOptionPane.showMessageDialog(null, "No se pudo editar un equipo");
            }
            vista_informe_servicio.limpiarCampos();
            actualizarVista();
        } else if (e.getSource() == vista_informe_servicio.btn_eliminar) {
            // ELIMINAR
            modelo_informe_servicio.setId(Integer.parseInt(vista_informe_servicio.txt_id.getText()));

            if (modelo_informe_servicio.eliminar()) {
                JOptionPane.showMessageDialog(null, "Se elimino un equipo");
            }else {
                JOptionPane.showMessageDialog(null, "No se pudo eliminar un equipo");
            }
            vista_informe_servicio.limpiarCampos();
            actualizarVista();
        } else if (e.getSource() == vista_informe_servicio.btn_limpiar) {
            // LIMPIAR
            vista_informe_servicio.limpiarCampos();
        } else if (e.getSource() == vista_informe_servicio.btn_agregar) {
            // AGREGAR DETALLE
            // Se debe registrar un nuevo detalle servicio y actualizar tabla detalle
            modelo_detalle.setInforme_id(this.informe_seleccionado);
            String equipo[] = vista_informe_servicio.selector_equipo.getSelectedItem().toString().split(",");
            modelo_detalle.setEquipo_id(Integer.parseInt(equipo[0]));

            modelo_detalle.setCosto(0f);
            modelo_detalle.setObservacion(vista_informe_servicio.txt_observacion.getText().toString());
            modelo_detalle.registrar();
            recargarDetalle(this.informe_seleccionado);
        } else if (e.getSource() == vista_informe_servicio.btn_quitar) {
            // QUITAR DETALLE
            int fila = vista_informe_servicio.tabla_detalle.getSelectedRow();
            if (fila >= 0) {
                int equipo_id = Integer.parseInt(vista_informe_servicio.tabla_detalle.getValueAt(fila, 1).toString());
                modelo_detalle.setInforme_id(this.informe_seleccionado);
                modelo_detalle.setEquipo_id(equipo_id);
                modelo_detalle.eliminar();
                recargarDetalle(informe_seleccionado);
            }
        } else if (e.getSource() == vista_informe_servicio.btn_cargar_detalle) {
            // CARGAR DETALLE
            cargarDetalle();
        }
    }
    
    private void cargarDetalle(){
        int fila = vista_informe_servicio.tabla_servicios.getSelectedRow();
        if (fila >= 0) {
            int id = Integer.parseInt(vista_informe_servicio.tabla_servicios.getValueAt(fila, 0).toString());
            this.informe_seleccionado = id;
            actualizarTotal(id);
            actualizarTablaInforme();
            vista_informe_servicio.actualizarTablaDetalle(modelo_detalle.getDetalles(id));
            
        }
        
    }
    
     private void recargarDetalle(int id){
        if (id > 0) {
            actualizarTotal(id);
            actualizarTablaInforme();
            vista_informe_servicio.actualizarTablaDetalle(modelo_detalle.getDetalles(id));
        }
        
    }
    
    public static void main(String[] args) {
        C_Informe_Servicio cc = new C_Informe_Servicio();
    }
    
}
