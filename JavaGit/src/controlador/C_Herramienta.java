/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
        
        this.vista_herramienta.setDefaultCloseOperation(2);
        this.vista_herramienta.setVisible(true);
        vista_herramienta.actualizarTabla(modelo_herramienta.getHerramientas());
        
    }
    
        
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if (e.getSource() == vista_herramienta.btn_registrar) {
            // **************** REGISTRAR ****************    
            modelo_herramienta.registrar(
                    vista_herramienta.txt_descripcion.getText(), 
                    vista_herramienta.txt_marca.getText()
            );
            
            vista_herramienta.actualizarTabla(modelo_herramienta.getHerramientas());
            vista_herramienta.limpiarCampos();
            
            
        } else if (e.getSource() == vista_herramienta.btn_editar) {
            // **************** EDITAR ****************
            modelo_herramienta.editar(
                    Integer.parseInt(vista_herramienta.txt_id.getText()), 
                    vista_herramienta.txt_descripcion.getText(), 
                    vista_herramienta.txt_marca.getText()
                );
            
            vista_herramienta.actualizarTabla(modelo_herramienta.getHerramientas());
            vista_herramienta.limpiarCampos();

            
        } else if (e.getSource() == vista_herramienta.btn_eliminar) {
            // **************** ELIMINAR ****************
            modelo_herramienta.eliminar(Integer.parseInt(vista_herramienta.txt_id.getText()));
            
            vista_herramienta.actualizarTabla(modelo_herramienta.getHerramientas());
            vista_herramienta.limpiarCampos();
            
            
        } else if (e.getSource() == vista_herramienta.btn_limpiar) {
            //  **************** LIMPIAR ****************
            vista_herramienta.limpiarCampos();
        }
        
    }
    
    public static void main(String[] args) {
        C_Herramienta c = new C_Herramienta();
    }
}
