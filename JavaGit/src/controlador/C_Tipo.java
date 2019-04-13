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
        vista_tipo.actualizarTabla(modelo_tipo.getTipos());
        
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
         // Registrar 
        if (e.getSource() == vista_tipo.btn_registrar) {
            modelo_tipo.registrar(
                Integer.parseInt(vista_tipo.txt_id.getText()),
                vista_tipo.txt_nombre.getText()
            );
            vista_tipo.actualizarTabla(modelo_tipo.getTipos());
            vista_tipo.limpiarCampos();
        } else {
            // EDITAR
            if (e.getSource() == vista_tipo.btn_editar) {
                modelo_tipo.editar(
                    Integer.parseInt(vista_tipo.txt_id.getText()),
                    vista_tipo.txt_nombre.getText()
                );
                vista_tipo.actualizarTabla(modelo_tipo.getTipos());
                vista_tipo.limpiarCampos();
            } else {
                // ELIMINAR
                if (e.getSource() == vista_tipo.btn_eliminar) {
                    modelo_tipo.eliminar(Integer.parseInt(vista_tipo.txt_id.getText()));
                    vista_tipo.limpiarCampos();
                    vista_tipo.actualizarTabla(modelo_tipo.getTipos());
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
