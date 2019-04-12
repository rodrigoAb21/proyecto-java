/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import modelo.M_Herramienta;
import vista.V_Herramienta;

/**
 *
 * @author KAKU
 */
public class C_Herramienta implements ActionListener {
    private M_Herramienta modelo_herramienta;
    private V_Herramienta vista_herramienta;

    public C_Herramienta() {
        this.modelo_herramienta = new M_Herramienta();
        this.vista_herramienta = new V_Herramienta();
        
        initComponent();
    }

     public void initComponent(){
        this.vista_herramienta.btn_registrar.addActionListener(this);
        this.vista_herramienta.btn_editar.addActionListener(this);
        this.vista_herramienta.btn_eliminar.addActionListener(this);
        this.vista_herramienta.btn_limpiar.addActionListener(this);
        
        this.vista_herramienta.setVisible(true);
        actualizarTabla();
        
    }
    
    private void actualizarTabla(){
        vista_herramienta.actualizarTabla(modelo_herramienta.getHerramientas());
    }
        
    
    @Override
    public void actionPerformed(ActionEvent e) {
         // Registrar 
        if (e.getSource() == vista_herramienta.btn_registrar) {
            modelo_herramienta.setId(Integer.parseInt(vista_herramienta.txt_id.getText()));
            modelo_herramienta.setDescripcion(vista_herramienta.txt_descripcion.getText());
            modelo_herramienta.setMarca(vista_herramienta.txt_marca.getText());
            
            if (modelo_herramienta.registrar()) {
                JOptionPane.showMessageDialog(null, "Se registro un herramienta");
            }else {
                JOptionPane.showMessageDialog(null, "No se pudo registrar un herramienta");
            }
            vista_herramienta.limpiarCampos();
            actualizarTabla();
        } else {
            // EDITAR
            if (e.getSource() == vista_herramienta.btn_editar) {
                modelo_herramienta.setId(Integer.parseInt(vista_herramienta.txt_id.getText()));
                modelo_herramienta.setDescripcion(vista_herramienta.txt_descripcion.getText());
                modelo_herramienta.setMarca(vista_herramienta.txt_marca.getText());

                if (modelo_herramienta.editar()) {
                    JOptionPane.showMessageDialog(null, "Se edito un herramienta");
                }else {
                    JOptionPane.showMessageDialog(null, "No se pudo editar un herramienta");
                }
                vista_herramienta.limpiarCampos();
                actualizarTabla();
            } else {
                // ELIMINAR
                if (e.getSource() == vista_herramienta.btn_eliminar) {
                    modelo_herramienta.setId(Integer.parseInt(vista_herramienta.txt_id.getText()));

                    if (modelo_herramienta.eliminar()) {
                        JOptionPane.showMessageDialog(null, "Se elimino un herramienta");
                    }else {
                        JOptionPane.showMessageDialog(null, "No se pudo eliminar un herramienta");
                    }
                    vista_herramienta.limpiarCampos();
                    actualizarTabla();
                } else {
                    if (e.getSource() == vista_herramienta.btn_limpiar) {
                        vista_herramienta.limpiarCampos();
                    }
                }
            }
        }
    }
    
    public static void main(String[] args) {
        C_Herramienta c = new C_Herramienta();
    }
}
