/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
        this.vista_informe_servicio.btn_trabajos.addActionListener(this);
        
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
    

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista_informe_servicio.btn_registrar) {
            // REGISTRAR
            modelo_informe_servicio.registrar(
                    Integer.parseInt(vista_informe_servicio.txt_id.getText()),
                    vista_informe_servicio.txt_fecha_recepcion.getText(),
                    vista_informe_servicio.txt_fecha_finalizacion.getText(),
                    0f,
                    "Activo",
                    Integer.parseInt(vista_informe_servicio.selector_cliente.getSelectedItem().toString().split(",")[0])
            );
            vista_informe_servicio.limpiarCampos();
            actualizarVista();
            
            
        } else if (e.getSource() == vista_informe_servicio.btn_editar) {
            // EDITAR
            modelo_informe_servicio.editar(
                    Integer.parseInt(vista_informe_servicio.txt_id.getText()),
                    vista_informe_servicio.txt_fecha_recepcion.getText(),
                    vista_informe_servicio.txt_fecha_finalizacion.getText(),
                    Integer.parseInt(vista_informe_servicio.selector_cliente.getSelectedItem().toString().split(",")[0])
            );
            
            vista_informe_servicio.limpiarCampos();
            actualizarVista();
            
            
        } else if (e.getSource() == vista_informe_servicio.btn_eliminar) {
            // ELIMINAR
            modelo_informe_servicio.anular(Integer.parseInt(vista_informe_servicio.txt_id.getText()));
            vista_informe_servicio.limpiarCampos();
            actualizarVista();
            
            
        } else if (e.getSource() == vista_informe_servicio.btn_limpiar) {
            // LIMPIAR
            vista_informe_servicio.limpiarCampos();
            
            
        } else if (e.getSource() == vista_informe_servicio.btn_agregar) {
            // AGREGAR DETALLE
            // Se debe registrar un nuevo detalle servicio y actualizar tabla detalle
            
            modelo_detalle.registrar(
                    this.informe_seleccionado,
                    Integer.parseInt(vista_informe_servicio.selector_equipo.getSelectedItem().toString().split(",")[0]),
                    0f,
                    vista_informe_servicio.txt_observacion.getText().toString()        
            );
            
            recargarDetalle(this.informe_seleccionado);
            
            
        } else if (e.getSource() == vista_informe_servicio.btn_quitar) {
            // QUITAR DETALLE
            int fila = vista_informe_servicio.tabla_detalle.getSelectedRow();
            if (fila >= 0) {
                modelo_detalle.eliminar(this.informe_seleccionado, Integer.parseInt(vista_informe_servicio.tabla_detalle.getValueAt(fila, 1).toString()));
                recargarDetalle(informe_seleccionado);
            }
            
        } else if (e.getSource() == vista_informe_servicio.btn_cargar_detalle) {
            // CARGAR DETALLE
            cargarDetalle();
        } else if (e.getSource() == vista_informe_servicio.btn_trabajos){
            int fila = vista_informe_servicio.tabla_detalle.getSelectedRow();
            if (fila >= 0) {
                new C_Trabajo(this.informe_seleccionado, Integer.parseInt(vista_informe_servicio.tabla_detalle.getValueAt(fila, 1).toString()));
            }
            
        }
    }
    
    private void cargarDetalle(){
        int fila = vista_informe_servicio.tabla_servicios.getSelectedRow();
        if (fila >= 0) {
            int id = Integer.parseInt(vista_informe_servicio.tabla_servicios.getValueAt(fila, 0).toString());
            this.informe_seleccionado = id;
            vista_informe_servicio.actualizarTablaInformes(modelo_informe_servicio.getInformes());
            vista_informe_servicio.actualizarTablaDetalle(modelo_detalle.getDetalles(id));
            
        }
        
    }
    
     private void recargarDetalle(int id){
        if (id > 0) {
            vista_informe_servicio.actualizarTablaInformes(modelo_informe_servicio.getInformes());
            vista_informe_servicio.actualizarTablaDetalle(modelo_detalle.getDetalles(id));
        }
        
    }
    
    public static void main(String[] args) {
        C_Informe_Servicio cc = new C_Informe_Servicio();
    }
    
}
