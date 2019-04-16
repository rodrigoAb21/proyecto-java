/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
        
        
        this.vista_equipo.setDefaultCloseOperation(2);
        this.vista_equipo.setVisible(true);
        this.vista_equipo.txt_id.setEditable(false);
        this.vista_equipo.btn_editar.setEnabled(false);
        this.vista_equipo.btn_eliminar.setEnabled(false);
        this.vista_equipo.actualizarTabla(modelo_equipo.getEquipos());
        this.vista_equipo.cargarSelector(modelo_tipo.getTiposAsc());
        
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista_equipo.btn_registrar) {
            // **************** REGISTRAR ****************    
            modelo_equipo.registrar(
                vista_equipo.txt_modelo.getText(),
                vista_equipo.txt_nro_serie.getText(),
                vista_equipo.txt_marca.getText(),
                Integer.parseInt(vista_equipo.selector_tipo.getSelectedItem().toString().split(",")[0])
            );
            
            vista_equipo.cargarSelector(modelo_tipo.getTiposAsc());
            vista_equipo.actualizarTabla(modelo_equipo.getEquipos());
            vista_equipo.limpiarCampos();
            
            
        } else if (e.getSource() == vista_equipo.btn_editar) {
            // **************** EDITAR ****************
            modelo_equipo.editar(
                Integer.parseInt(vista_equipo.txt_id.getText()),
                vista_equipo.txt_modelo.getText(),
                vista_equipo.txt_nro_serie.getText(),
                vista_equipo.txt_marca.getText(),
                Integer.parseInt(vista_equipo.selector_tipo.getSelectedItem().toString().split(",")[0])
            );

            vista_equipo.cargarSelector(modelo_tipo.getTiposAsc());
            vista_equipo.actualizarTabla(modelo_equipo.getEquipos());
            vista_equipo.limpiarCampos();

            
        } else if (e.getSource() == vista_equipo.btn_eliminar) {
            // **************** ELIMINAR ****************
            modelo_equipo.eliminar(Integer.parseInt(vista_equipo.txt_id.getText()));
                    
            vista_equipo.cargarSelector(modelo_tipo.getTiposAsc());
            vista_equipo.actualizarTabla(modelo_equipo.getEquipos());
            vista_equipo.limpiarCampos();
            
            
        } else if (e.getSource() == vista_equipo.btn_limpiar) {
            //  **************** LIMPIAR ****************
            vista_equipo.limpiarCampos();
        }
        
        
    }
    
    public static void main(String[] args) {
        C_Equipo cc = new C_Equipo();
    }
    
}
