/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package administracion.adm_controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import administracion.adm_modelo.M_Tipo;
import administracion.adm_vista.V_Tipo;

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
        
        vista_tipo.actualizarTabla(modelo_tipo.getTipos());
        
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista_tipo.btn_registrar) {
            // Registrar 
            modelo_tipo.registrar(
                vista_tipo.txt_nombre.getText()
            );
            
            vista_tipo.actualizarTabla(modelo_tipo.getTipos());
            vista_tipo.limpiarCampos();
            
            
        } else if (e.getSource() == vista_tipo.btn_editar){
            // EDITAR
            modelo_tipo.editar(
                    Integer.parseInt(vista_tipo.txt_id.getText()),
                    vista_tipo.txt_nombre.getText()
                );
            
            vista_tipo.actualizarTabla(modelo_tipo.getTipos());
            vista_tipo.limpiarCampos();
            
            
        }else if (e.getSource() == vista_tipo.btn_eliminar){
            // ELIMINAR
            modelo_tipo.eliminar(Integer.parseInt(vista_tipo.txt_id.getText()));
            
            vista_tipo.actualizarTabla(modelo_tipo.getTipos());
            vista_tipo.limpiarCampos();
            
            
        } else if (e.getSource() == vista_tipo.btn_limpiar) {
            // LIMPIAR
            vista_tipo.limpiarCampos();
        }
    }
    
  
}
