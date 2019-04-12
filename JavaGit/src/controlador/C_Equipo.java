/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import modelo.M_Equipo;
import modelo.M_Tipo;
import vista.V_Equipo;

/**
 *
 * @author KAKU
 */
public class C_Equipo implements ActionListener {
    private M_Equipo modelo_equipo;
    private M_Tipo modelo_tipo;
    private V_Equipo vista_equipo;

    public C_Equipo() {
        this.modelo_equipo = new M_Equipo();
        this.modelo_tipo = new M_Tipo();
        this.vista_equipo = new V_Equipo();
        
        initComponent();
    }
    
    public void initComponent(){
        this.vista_equipo.btn_registrar.addActionListener(this);
        this.vista_equipo.btn_editar.addActionListener(this);
        this.vista_equipo.btn_eliminar.addActionListener(this);
        this.vista_equipo.btn_limpiar.addActionListener(this);
        this.vista_equipo.selector_tipo.addActionListener(this);
        
        
        this.vista_equipo.setVisible(true);
        actualizarVista();
        
        
    }
    
    private void actualizarVista(){
        vista_equipo.actualizarTabla(modelo_equipo.getEquipos());
        vista_equipo.cargarSelector(modelo_tipo.getTiposAsc());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Registrar 
        if (e.getSource() == vista_equipo.btn_registrar) {
            modelo_equipo.setId(Integer.parseInt(vista_equipo.txt_id.getText()));
            modelo_equipo.setModelo(vista_equipo.txt_modelo.getText());
            modelo_equipo.setNro_serie(vista_equipo.txt_nro_serie.getText());
            modelo_equipo.setMarca(vista_equipo.txt_marca.getText());
            
            String tipo[] = vista_equipo.selector_tipo.getSelectedItem().toString().split(",");
            modelo_equipo.setTipo_id(Integer.parseInt(tipo[0]));
            
            if (modelo_equipo.registrar()) {
                JOptionPane.showMessageDialog(null, "Se registro un equipo");
            }else {
                JOptionPane.showMessageDialog(null, "No se pudo registrar un equipo");
            }
            vista_equipo.limpiarCampos();
            actualizarVista();
        } else {
            // EDITAR
            if (e.getSource() == vista_equipo.btn_editar) {
                modelo_equipo.setId(Integer.parseInt(vista_equipo.txt_id.getText()));
                modelo_equipo.setModelo(vista_equipo.txt_modelo.getText());
                modelo_equipo.setNro_serie(vista_equipo.txt_nro_serie.getText());
                modelo_equipo.setMarca(vista_equipo.txt_marca.getText());
                 
                String tipo[] = vista_equipo.selector_tipo.getSelectedItem().toString().split(",");
                modelo_equipo.setTipo_id(Integer.parseInt(tipo[0]));
                
                if (modelo_equipo.editar()) {
                    JOptionPane.showMessageDialog(null, "Se edito un equipo");
                }else {
                    JOptionPane.showMessageDialog(null, "No se pudo editar un equipo");
                }
                vista_equipo.limpiarCampos();
                actualizarVista();
            } else {
                // ELIMINAR
                if (e.getSource() == vista_equipo.btn_eliminar) {
                    modelo_equipo.setId(Integer.parseInt(vista_equipo.txt_id.getText()));

                    if (modelo_equipo.eliminar()) {
                        JOptionPane.showMessageDialog(null, "Se elimino un equipo");
                    }else {
                        JOptionPane.showMessageDialog(null, "No se pudo eliminar un equipo");
                    }
                    vista_equipo.limpiarCampos();
                    actualizarVista();
                } else {
                    if (e.getSource() == vista_equipo.btn_limpiar) {
                        vista_equipo.limpiarCampos();
                    }
                }
            }
        }
        
    }
    
    public static void main(String[] args) {
        C_Equipo cc = new C_Equipo();
    }
    
}
