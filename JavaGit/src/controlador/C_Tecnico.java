/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
        
        this.vista_tecnico.setDefaultCloseOperation(2);
        this.vista_tecnico.setVisible(true);
        vista_tecnico.actualizarTabla(modelo_tecnico.getTecnicos());
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if (e.getSource() == vista_tecnico.btn_registrar) {
            // **************** REGISTRAR ****************
            modelo_tecnico.registrar(
                vista_tecnico.txt_ci.getText(),
                vista_tecnico.txt_nombre.getText(),
                vista_tecnico.txt_apellido.getText(),
                vista_tecnico.txt_especialidad.getText(),
                vista_tecnico.txt_direccion.getText(),
                vista_tecnico.txt_telefono.getText()
            );
            
            vista_tecnico.actualizarTabla(modelo_tecnico.getTecnicos());
            vista_tecnico.limpiarCampos();
            
            
        } else if (e.getSource() == vista_tecnico.btn_editar) {
            // **************** EDITAR ****************
            modelo_tecnico.editar(
                Integer.parseInt(vista_tecnico.txt_id.getText()),
                vista_tecnico.txt_ci.getText(),
                vista_tecnico.txt_nombre.getText(),
                vista_tecnico.txt_apellido.getText(),
                vista_tecnico.txt_especialidad.getText(),
                vista_tecnico.txt_direccion.getText(),
                vista_tecnico.txt_telefono.getText()
            );

            vista_tecnico.actualizarTabla(modelo_tecnico.getTecnicos());
            vista_tecnico.limpiarCampos();
                            
            
        } else if (e.getSource() == vista_tecnico.btn_eliminar) {
            // **************** ELIMINAR ****************
            modelo_tecnico.eliminar(Integer.parseInt(vista_tecnico.txt_id.getText()));
            
            vista_tecnico.actualizarTabla(modelo_tecnico.getTecnicos());
            vista_tecnico.limpiarCampos();
            
            
        } else if (e.getSource() == vista_tecnico.btn_limpiar) {
            // **************** LIMPIAR ****************
            vista_tecnico.limpiarCampos();
        }
        
    }
    
    public static void main(String[] args) {
        C_Tecnico cc = new C_Tecnico();
    }
    
}
