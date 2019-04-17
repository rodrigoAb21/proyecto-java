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
    private String estado = "";
    

    public C_Informe_Servicio() {
        this.modelo_informe_servicio = new M_Informe_Servicio();
        this.modelo_detalle = new M_Detalle_Informe();
        this.modelo_cliente = new M_Cliente();
        this.modelo_equipo = new M_Equipo();
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
        this.vista_informe_servicio.btn_actualizar.addActionListener(this);
        
        // Botones Detalle
        this.vista_informe_servicio.btn_agregar.addActionListener(this);
        this.vista_informe_servicio.btn_quitar.addActionListener(this);
        this.vista_informe_servicio.btn_trabajos.addActionListener(this);
        
        vista_informe_servicio.cargarSelectorCliente(modelo_cliente.getClientesAsc());
        vista_informe_servicio.cargarSelectorEquipo(modelo_equipo.getEquiposAsc());
        vista_informe_servicio.actualizarTablaInformes(modelo_informe_servicio.getInformes());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista_informe_servicio.btn_registrar) {
            // REGISTRAR
            modelo_informe_servicio.registrar(
                    vista_informe_servicio.txt_fecha_recepcion.getText(),
                    vista_informe_servicio.txt_fecha_finalizacion.getText(),
                    0f,
                    "Activo",
                    Integer.parseInt(vista_informe_servicio.selector_cliente.getSelectedItem().toString().split(",")[0])
            );
            
            vista_informe_servicio.actualizarTablaInformes(modelo_informe_servicio.getInformes());
            vista_informe_servicio.limpiarCampos();
            
            
            
            
        } else if (e.getSource() == vista_informe_servicio.btn_editar) {
            // EDITAR
            modelo_informe_servicio.editar(
                    Integer.parseInt(vista_informe_servicio.txt_id.getText()),
                    vista_informe_servicio.txt_fecha_recepcion.getText(),
                    vista_informe_servicio.txt_fecha_finalizacion.getText(),
                    Integer.parseInt(vista_informe_servicio.selector_cliente.getSelectedItem().toString().split(",")[0])
            );
            
            vista_informe_servicio.actualizarTablaInformes(modelo_informe_servicio.getInformes());
            vista_informe_servicio.limpiarCampos();
            
            
            
            
        } else if (e.getSource() == vista_informe_servicio.btn_eliminar) {
            // ELIMINAR
            modelo_informe_servicio.eliminar(Integer.parseInt(vista_informe_servicio.txt_id.getText()));
            
            vista_informe_servicio.actualizarTablaInformes(modelo_informe_servicio.getInformes());
            vista_informe_servicio.limpiarCampos();
            
            
            
            
        } else if (e.getSource() == vista_informe_servicio.btn_finalizar) {
            // FINALIZAR SERVICIO
            modelo_informe_servicio.actualizarEstado(Integer.parseInt(vista_informe_servicio.txt_id.getText()), "Finalizado");

            vista_informe_servicio.actualizarTablaInformes(modelo_informe_servicio.getInformes());
            vista_informe_servicio.limpiarCampos();

            
            
            
        } else if (e.getSource() == vista_informe_servicio.btn_limpiar) {
            // LIMPIAR
            vista_informe_servicio.limpiarCampos();
            
            
            
            
        // *****************************************************************************************
        // ***************************METODOS DETALLLE**********************************************
        // *****************************************************************************************
        // *****************************************************************************************
        
        } else if (e.getSource() == vista_informe_servicio.btn_cargar_detalle) {
            // CARGAR DETALLE
            int fila = vista_informe_servicio.tabla_servicios.getSelectedRow();
            if (fila >= 0) {
                int id = Integer.parseInt(vista_informe_servicio.tabla_servicios.getValueAt(fila, 0).toString());
                this.informe_seleccionado = id;
                this.estado = vista_informe_servicio.tabla_servicios.getValueAt(fila, 4).toString();
                
                
                vista_informe_servicio.actualizarTablaInformes(modelo_informe_servicio.getInformes());
                vista_informe_servicio.actualizarTablaDetalle(modelo_detalle.getDetalles(id));   
            }
            
            
            
                        
        } else if (e.getSource() == vista_informe_servicio.btn_agregar) {
            // AGREGAR DETALLE
            modelo_detalle.registrar(
                    this.informe_seleccionado,
                    Integer.parseInt(vista_informe_servicio.selector_equipo.getSelectedItem().toString().split(",")[0]),
                    0f,
                    vista_informe_servicio.txt_observacion.getText().toString()        
            );
            
            if (informe_seleccionado > 0) {
                vista_informe_servicio.actualizarTablaInformes(modelo_informe_servicio.getInformes());
                vista_informe_servicio.actualizarTablaDetalle(modelo_detalle.getDetalles(informe_seleccionado));
            }
            vista_informe_servicio.limpiarDetalle();
            
            
            
            
        } else if (e.getSource() == vista_informe_servicio.btn_quitar) {
            // QUITAR DETALLE
            int fila = vista_informe_servicio.tabla_detalle.getSelectedRow();
            if (fila >= 0) {
                modelo_detalle.eliminar(this.informe_seleccionado, Integer.parseInt(vista_informe_servicio.tabla_detalle.getValueAt(fila, 1).toString()));
                
                if (informe_seleccionado > 0) {
                    vista_informe_servicio.actualizarTablaInformes(modelo_informe_servicio.getInformes());
                    vista_informe_servicio.actualizarTablaDetalle(modelo_detalle.getDetalles(informe_seleccionado));
                }
                vista_informe_servicio.limpiarDetalle();
            }
            
            
            
            
        } else if (e.getSource() == vista_informe_servicio.btn_trabajos){
            // GESTIONAR TRABAJOS            
            int fila = vista_informe_servicio.tabla_detalle.getSelectedRow();
            if (fila >= 0) {
                new C_Trabajo(this.informe_seleccionado, Integer.parseInt(vista_informe_servicio.tabla_detalle.getValueAt(fila, 1).toString()), this.estado);
                this.vista_informe_servicio.btn_actualizar.setEnabled(true);
            }
        
            
            
            
        } else if (e.getSource() == vista_informe_servicio.btn_actualizar){
            // ACTUALIZAR TABLAS
            vista_informe_servicio.actualizarTablaInformes(modelo_informe_servicio.getInformes());
            vista_informe_servicio.actualizarTablaDetalle(modelo_detalle.getDetalles(informe_seleccionado));
            vista_informe_servicio.limpiarCampos();
            
            
            
            
        }
    }
    
}
