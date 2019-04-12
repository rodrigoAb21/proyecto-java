/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import modelo.M_Tipo;
import vista.V_Tipo;

/**
 *
 * @author KAKU
 */
public class C_Tipo implements ActionListener {
    private M_Tipo modelo_tipo;
    private V_Tipo vista_tipo;

    public C_Tipo() {
        this.modelo_tipo = new M_Tipo();
        this.vista_tipo = new V_Tipo();
        
        initComponent();
    }

     public void initComponent(){
        this.vista_tipo.btn_registrar.addActionListener(this);
        this.vista_tipo.btn_editar.addActionListener(this);
        this.vista_tipo.btn_eliminar.addActionListener(this);
        this.vista_tipo.btn_limpiar.addActionListener(this);
        
        this.vista_tipo.setVisible(true);
        actualizarTabla();
        
    }
    
    private void actualizarTabla(){
        vista_tipo.actualizarTabla(modelo_tipo.getTipos());
    }
        
    
    @Override
    public void actionPerformed(ActionEvent e) {
         // Registrar 
        if (e.getSource() == vista_tipo.btn_registrar) {
            modelo_tipo.setId(Integer.parseInt(vista_tipo.txt_id.getText()));
            modelo_tipo.setNombre(vista_tipo.txt_nombre.getText());
            
            if (modelo_tipo.registrar()) {
                JOptionPane.showMessageDialog(null, "Se registro un tipo");
            }else {
                JOptionPane.showMessageDialog(null, "No se pudo registrar un tipo");
            }
            vista_tipo.limpiarCampos();
            actualizarTabla();
        } else {
            // EDITAR
            if (e.getSource() == vista_tipo.btn_editar) {
                modelo_tipo.setId(Integer.parseInt(vista_tipo.txt_id.getText()));
                modelo_tipo.setNombre(vista_tipo.txt_nombre.getText());

                if (modelo_tipo.editar()) {
                    JOptionPane.showMessageDialog(null, "Se edito un tipo");
                }else {
                    JOptionPane.showMessageDialog(null, "No se pudo editar un tipo");
                }
                vista_tipo.limpiarCampos();
                actualizarTabla();
            } else {
                // ELIMINAR
                if (e.getSource() == vista_tipo.btn_eliminar) {
                    modelo_tipo.setId(Integer.parseInt(vista_tipo.txt_id.getText()));

                    if (modelo_tipo.eliminar()) {
                        JOptionPane.showMessageDialog(null, "Se elimino un tipo");
                    }else {
                        JOptionPane.showMessageDialog(null, "No se pudo eliminar un tipo");
                    }
                    vista_tipo.limpiarCampos();
                    actualizarTabla();
                } else {
                    if (e.getSource() == vista_tipo.btn_limpiar) {
                        vista_tipo.limpiarCampos();
                    }
                }
            }
        }
    }
    
    public static void main(String[] args) {
        C_Tipo c = new C_Tipo();
    }
}
