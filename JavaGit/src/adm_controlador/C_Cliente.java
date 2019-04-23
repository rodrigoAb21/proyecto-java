/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adm_controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import adm_modelo.M_Cliente;
import adm_vista.V_Cliente;

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
        
        vista_cliente.actualizarTabla(modelo_cliente.getClientes());
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
                
        if (e.getSource() == vista_cliente.btn_registrar) {
            // **************** REGISTRAR ****************    
            modelo_cliente.registrar(
                    vista_cliente.txt_nit.getText(),
                    vista_cliente.txt_nombre.getText(),
                    vista_cliente.txt_direccion.getText(),
                    vista_cliente.txt_telefono.getText()
            );
            
            vista_cliente.actualizarTabla(modelo_cliente.getClientes());
            vista_cliente.limpiarCampos();
            
            
        } else if (e.getSource() == vista_cliente.btn_editar) {
            // **************** EDITAR ****************
            modelo_cliente.editar(
                    Integer.parseInt(vista_cliente.txt_id.getText()),
                    vista_cliente.txt_nit.getText(),
                    vista_cliente.txt_nombre.getText(),
                    vista_cliente.txt_direccion.getText(),
                    vista_cliente.txt_telefono.getText()
            );
            
            vista_cliente.actualizarTabla(modelo_cliente.getClientes());
            vista_cliente.limpiarCampos();
            
            
        } else if (e.getSource() == vista_cliente.btn_eliminar) {
            // **************** ELIMINAR ****************
            modelo_cliente.eliminar(Integer.parseInt(vista_cliente.txt_id.getText()));
            
            vista_cliente.actualizarTabla(modelo_cliente.getClientes());
            vista_cliente.limpiarCampos();
            
            
        } else if (e.getSource() == vista_cliente.btn_limpiar) {
            // **************** LIMPIAR ****************
            vista_cliente.limpiarCampos();
        }
            
        
    }
    
}
