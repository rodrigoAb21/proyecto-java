/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.M_Detalle_Trabajo;
import modelo.M_Herramienta;
import modelo.M_Tecnico;
import modelo.M_Trabajo;
import vista.V_Trabajo;

/**
 *
 * @author KAKU
 */
public class C_Trabajo implements ActionListener {
    private M_Trabajo modelo_trabajo;
    private M_Tecnico modelo_tecnico;
    private M_Herramienta modelo_herramienta;
    private M_Detalle_Trabajo modelo_detalle;
    private V_Trabajo vista_trabajo;
    
    private int trabajo_seleccionado = -1;
    private int informe_id;
    private int equipo_id;
    

    public C_Trabajo(int informe_id, int equipo_id) {
        this.modelo_trabajo = new M_Trabajo();
        this.modelo_tecnico = new M_Tecnico();
        this.modelo_herramienta = new M_Herramienta();
        this.modelo_detalle = new M_Detalle_Trabajo();
        this.vista_trabajo = new V_Trabajo();
        this.informe_id = informe_id;
        this.equipo_id = equipo_id;
        
        initComponent();
    }
    
    public void initComponent(){
        //Botones informe
        this.vista_trabajo.btn_registrar.addActionListener(this);
        this.vista_trabajo.btn_editar.addActionListener(this);
        this.vista_trabajo.btn_eliminar.addActionListener(this);
        this.vista_trabajo.btn_limpiar.addActionListener(this);
        this.vista_trabajo.btn_cargar_detalle.addActionListener(this);
        
        
        // Botones Detalle
        this.vista_trabajo.btn_agregar.addActionListener(this);
        this.vista_trabajo.btn_quitar.addActionListener(this);
        
        // Selectores
        this.vista_trabajo.selector_tecnico.addActionListener(this);
        this.vista_trabajo.selector_herramienta.addActionListener(this);
        
        
        this.vista_trabajo.setVisible(true);
        
        vista_trabajo.actualizarTablaTrabajos(modelo_trabajo.getInformes());
        vista_trabajo.cargarSelectorTecnico(modelo_tecnico.getTecnicos());
        vista_trabajo.cargarSelectorHerramienta(modelo_herramienta.getHerramientas());
        
        
    }
    
    private void actualizarVista(){
        vista_trabajo.actualizarTablaTrabajos(modelo_trabajo.getInformes());
        vista_trabajo.cargarSelectorTecnico(modelo_tecnico.getTecnicos());
        vista_trabajo.cargarSelectorHerramienta(modelo_herramienta.getHerramientas());
    }
    
    private void actualizarTablaTrabajos(){
        vista_trabajo.actualizarTablaTrabajos(modelo_trabajo.getInformes());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista_trabajo.btn_registrar) {
            // REGISTRAR
            modelo_trabajo.registrar(
                    Integer.parseInt(vista_trabajo.txt_id.getText()),
                    vista_trabajo.txt_fecha_inicio.getText(),
                    vista_trabajo.txt_fecha_fin.getText(),
                    Integer.parseInt(vista_trabajo.txt_costo.getText()),
                    vista_trabajo.txt_descripcion.getText(),
                    Integer.parseInt(vista_trabajo.selector_tecnico.getSelectedItem().toString().split(",")[0]),
                    this.informe_id,
                    this.equipo_id
            );
            vista_trabajo.actualizarTablaTrabajos(modelo_trabajo.getInformes());
            vista_trabajo.cargarSelectorTecnico(modelo_tecnico.getTecnicos());
            vista_trabajo.cargarSelectorHerramienta(modelo_herramienta.getHerramientas());
            vista_trabajo.limpiarCampos();
            
            
//        } else if (e.getSource() == vista_trabajo.btn_editar) {
//            // EDITAR
//            modelo_trabajo.editar(
//                    Integer.parseInt(vista_trabajo.txt_id.getText()),
//                    vista_trabajo.txt_fecha_inicio.getText(),
//                    vista_trabajo.txt_fecha_fin.getText(),
//                    Integer.parseInt(vista_trabajo.selector_tecnico.getSelectedItem().toString().split(",")[0])
//            );
//            
//            vista_trabajo.limpiarCampos();
//            actualizarVista();
//            
//            
//        } else if (e.getSource() == vista_trabajo.btn_eliminar) {
//            // ELIMINAR
//            modelo_trabajo.anular(Integer.parseInt(vista_trabajo.txt_id.getText()));
//            vista_trabajo.limpiarCampos();
//            actualizarVista();
//            
//            
//        } else if (e.getSource() == vista_trabajo.btn_limpiar) {
//            // LIMPIAR
//            vista_trabajo.limpiarCampos();
//            
//            
//        } else if (e.getSource() == vista_trabajo.btn_agregar) {
//            // AGREGAR DETALLE
//            // Se debe registrar un nuevo detalle servicio y actualizar tabla detalle
//            
//            modelo_detalle.registrar(
//                    this.trabajo_seleccionado,
//                    Integer.parseInt(vista_trabajo.selector_herramienta.getSelectedItem().toString().split(",")[0]),
//                    0f,
//            );
//            
////            recargarDetalle(this.trabajo_seleccionado);
//            
//            
//        } else if (e.getSource() == vista_trabajo.btn_quitar) {
//            // QUITAR DETALLE
//            int fila = vista_trabajo.tabla_detalle.getSelectedRow();
//            if (fila >= 0) {
//                modelo_detalle.eliminar(this.trabajo_seleccionado, Integer.parseInt(vista_trabajo.tabla_detalle.getValueAt(fila, 1).toString()));
////                recargarDetalle(trabajo_seleccionado);
//            }
//            
//        } else if (e.getSource() == vista_trabajo.btn_cargar_detalle) {
//            // CARGAR DETALLE
//            cargarDetalle();
        }
    }
    
//    private void cargarDetalle(){
//        int fila = vista_trabajo.tabla_trabajos.getSelectedRow();
//        if (fila >= 0) {
//            int id = Integer.parseInt(vista_trabajo.tabla_trabajos.getValueAt(fila, 0).toString());
//            this.trabajo_seleccionado = id;
////            actualizarTotal(id);
//            actualizarTablaInforme();
//            vista_trabajo.actualizarTablaDetalle(modelo_detalle.getDetalles(id));
//            
//        }
//        
//    }
    
//     private void recargarDetalle(int id){
//        if (id > 0) {
//            actualizarTotal(id);
//            actualizarTablaInforme();
//            vista_trabajo.actualizarTablaDetalle(modelo_detalle.getDetalles(id));
//        }
//        
//    }
    
    public static void main(String[] args) {
        C_Trabajo cc = new C_Trabajo(1,1);
    }
    
}
