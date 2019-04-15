/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vista.V_Principal;

/**
 *
 * @author rodrigo
 */
public class Principal implements ActionListener {
    V_Principal vista_principal;

    public Principal() {
        vista_principal = new V_Principal();
        initComponent();
    }
    
    private void initComponent(){
        vista_principal.btn_clientes.addActionListener(this);
        vista_principal.btn_tecnicos.addActionListener(this);
        vista_principal.btn_herramientas.addActionListener(this);
        vista_principal.btn_tipos.addActionListener(this);
        vista_principal.btn_equipos.addActionListener(this);
        vista_principal.btn_informes.addActionListener(this);
        
        vista_principal.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista_principal.btn_clientes) {
            new C_Cliente();
        } else if (e.getSource() == vista_principal.btn_tecnicos) {
            new C_Tecnico();
        } else if (e.getSource() == vista_principal.btn_herramientas) {
            new C_Herramienta();
        } else if (e.getSource() == vista_principal.btn_tipos) {
            new C_Tipo();
        } else if (e.getSource() == vista_principal.btn_equipos) {
            new C_Equipo();
        } else if (e.getSource() == vista_principal.btn_informes) {
            new C_Informe_Servicio();
        }
    }
    
    public static void main(String[] args) {
        new Principal();
    }
    
    
}
