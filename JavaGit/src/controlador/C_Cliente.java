/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import modelo.M_Cliente;
import vista.V_Cliente;

/**
 *
 * @author KAKU
 */
public class C_Cliente implements ActionListener {
    private M_Cliente modelo_cliente;
    private V_Cliente vista_cliente;

    public C_Cliente() {
        this.modelo_cliente = new M_Cliente();
        this.vista_cliente = new V_Cliente();
        
        initComponent();
    }
    
    public void initComponent(){
        this.vista_cliente.btn_registrar.addActionListener(this);
        this.vista_cliente.btn_editar.addActionListener(this);
        this.vista_cliente.btn_eliminar.addActionListener(this);
        this.vista_cliente.btn_limpiar.addActionListener(this);
        
        this.vista_cliente.setVisible(true);
        actualizarTabla();
        
    }
    
    private void actualizarTabla(){
        vista_cliente.actualizarTabla(modelo_cliente.getClientes());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        // **************** REGISTRAR ****************
        if (e.getSource() == vista_cliente.btn_registrar) {
            
            modelo_cliente.registrar(
                    Integer.parseInt(vista_cliente.txt_id.getText()),
                    vista_cliente.txt_nit.getText(),
                    vista_cliente.txt_nombre.getText(),
                    vista_cliente.txt_direccion.getText(),
                    vista_cliente.txt_telefono.getText()
            );
            vista_cliente.actualizarTabla(modelo_cliente.getClientes());
            vista_cliente.limpiarCampos();
        } else {
            
            // ***************  EDITAR  ****************
            if (e.getSource() == vista_cliente.btn_editar) {
                
                modelo_cliente.editar(
                        Integer.parseInt(vista_cliente.txt_id.getText()),
                        vista_cliente.txt_nit.getText(),
                        vista_cliente.txt_nombre.getText(),
                        vista_cliente.txt_direccion.getText(),
                        vista_cliente.txt_telefono.getText()
                );
                vista_cliente.actualizarTabla(modelo_cliente.getClientes());
                vista_cliente.limpiarCampos();
            } else {
                
                // ***************  ELIMINAR  ****************
                if (e.getSource() == vista_cliente.btn_eliminar) {
                    modelo_cliente.eliminar(Integer.parseInt(vista_cliente.txt_id.getText()));
                    actualizarTabla();
                    vista_cliente.limpiarCampos();
                } else {
                    
                    // ***************  LIMPIAR  ****************
                    if (e.getSource() == vista_cliente.btn_limpiar) {
                        vista_cliente.limpiarCampos();
                    }
                }
            }
        }
        
    }
    
    public static void main(String[] args) {
        C_Cliente cc = new C_Cliente();
    }
    
}
