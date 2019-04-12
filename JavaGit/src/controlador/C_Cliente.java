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
        // Registrar 
        if (e.getSource() == vista_cliente.btn_registrar) {
            modelo_cliente.setId(Integer.parseInt(vista_cliente.txt_id.getText()));
            modelo_cliente.setNit(vista_cliente.txt_nit.getText());
            modelo_cliente.setNombre(vista_cliente.txt_nombre.getText());
            modelo_cliente.setDireccion(vista_cliente.txt_direccion.getText());
            modelo_cliente.setTelefono(vista_cliente.txt_telefono.getText());
            
            if (modelo_cliente.registrar()) {
                System.out.println("Se registro un cliente");
            }else {
                System.out.println("No se pudo registrar un cliente");
            }
            vista_cliente.limpiarCampos();
            actualizarTabla();
        } else {
            // EDITAR
            if (e.getSource() == vista_cliente.btn_editar) {
                modelo_cliente.setId(Integer.parseInt(vista_cliente.txt_id.getText()));
                modelo_cliente.setNit(vista_cliente.txt_nit.getText());
                modelo_cliente.setNombre(vista_cliente.txt_nombre.getText());
                modelo_cliente.setDireccion(vista_cliente.txt_direccion.getText());
                modelo_cliente.setTelefono(vista_cliente.txt_telefono.getText());

                if (modelo_cliente.editar()) {
                    System.out.println("Se edito un cliente");
                }else {
                    System.out.println("No se pudo editar un cliente");
                }
                vista_cliente.limpiarCampos();
                actualizarTabla();
            } else {
                // ELIMINAR
                if (e.getSource() == vista_cliente.btn_eliminar) {
                    modelo_cliente.setId(Integer.parseInt(vista_cliente.txt_id.getText()));

                    if (modelo_cliente.eliminar()) {
                        JOptionPane.showMessageDialog(null, "Se elimino un cliente");
                    }else {
                        JOptionPane.showMessageDialog(null, "No se pudo eliminar un cliente");
                    }
                    vista_cliente.limpiarCampos();
                    actualizarTabla();
                } else {
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
