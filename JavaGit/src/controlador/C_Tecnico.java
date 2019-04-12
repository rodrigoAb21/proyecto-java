/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import modelo.M_Tecnico;
import vista.V_Tecnico;

/**
 *
 * @author KAKU
 */
public class C_Tecnico implements ActionListener {
    private M_Tecnico modelo_tecnico;
    private V_Tecnico vista_tecnico;

    public C_Tecnico() {
        this.modelo_tecnico = new M_Tecnico();
        this.vista_tecnico = new V_Tecnico();
        
        initComponent();
    }
    
    public void initComponent(){
        this.vista_tecnico.btn_registrar.addActionListener(this);
        this.vista_tecnico.btn_editar.addActionListener(this);
        this.vista_tecnico.btn_eliminar.addActionListener(this);
        this.vista_tecnico.btn_limpiar.addActionListener(this);
        
        this.vista_tecnico.setVisible(true);
        actualizarTabla();
        
    }
    
    private void actualizarTabla(){
        vista_tecnico.actualizarTabla(modelo_tecnico.getTecnicos());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Registrar 
        if (e.getSource() == vista_tecnico.btn_registrar) {
            modelo_tecnico.setId(Integer.parseInt(vista_tecnico.txt_id.getText()));
            modelo_tecnico.setCi(vista_tecnico.txt_ci.getText());
            modelo_tecnico.setNombre(vista_tecnico.txt_nombre.getText());
            modelo_tecnico.setApellido(vista_tecnico.txt_apellido.getText());
            modelo_tecnico.setEspecialidad(vista_tecnico.txt_especialidad.getText());
            modelo_tecnico.setDireccion(vista_tecnico.txt_direccion.getText());
            modelo_tecnico.setTelefono(vista_tecnico.txt_telefono.getText());
            
            if (modelo_tecnico.registrar()) {
                JOptionPane.showMessageDialog(null, "Se registro un tecnico");
            }else {
                JOptionPane.showMessageDialog(null, "No se pudo registrar un tecnico");
            }
            vista_tecnico.limpiarCampos();
            actualizarTabla();
        } else {
            // EDITAR
            if (e.getSource() == vista_tecnico.btn_editar) {
                modelo_tecnico.setId(Integer.parseInt(vista_tecnico.txt_id.getText()));
                modelo_tecnico.setCi(vista_tecnico.txt_ci.getText());
                modelo_tecnico.setNombre(vista_tecnico.txt_nombre.getText());
                modelo_tecnico.setApellido(vista_tecnico.txt_apellido.getText());
                modelo_tecnico.setEspecialidad(vista_tecnico.txt_especialidad.getText());
                modelo_tecnico.setDireccion(vista_tecnico.txt_direccion.getText());
                modelo_tecnico.setTelefono(vista_tecnico.txt_telefono.getText());

                if (modelo_tecnico.editar()) {
                    JOptionPane.showMessageDialog(null, "Se edito un tecnico");
                }else {
                    JOptionPane.showMessageDialog(null, "No se pudo editar un tecnico");
                }
                vista_tecnico.limpiarCampos();
                actualizarTabla();
            } else {
                // ELIMINAR
                if (e.getSource() == vista_tecnico.btn_eliminar) {
                    modelo_tecnico.setId(Integer.parseInt(vista_tecnico.txt_id.getText()));

                    if (modelo_tecnico.eliminar()) {
                        JOptionPane.showMessageDialog(null, "Se elimino un tecnico");
                    }else {
                        JOptionPane.showMessageDialog(null, "No se pudo eliminar un tecnico");
                    }
                    vista_tecnico.limpiarCampos();
                    actualizarTabla();
                } else {
                    if (e.getSource() == vista_tecnico.btn_limpiar) {
                        vista_tecnico.limpiarCampos();
                    }
                }
            }
        }
        
    }
    
    public static void main(String[] args) {
        C_Tecnico cc = new C_Tecnico();
    }
    
}
