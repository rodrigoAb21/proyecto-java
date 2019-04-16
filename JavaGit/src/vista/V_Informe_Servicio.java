/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author KAKU
 */
public class V_Informe_Servicio extends javax.swing.JFrame {

    /**
     * Creates new form Vista_Principal
     */
    public V_Informe_Servicio() {
        initComponents();
        
        
        this.setDefaultCloseOperation(2);
        this.setVisible(true);
        this.txt_id.setEditable(false);
        this.txt_costo_total.setEditable(false);
        this.txt_estado.setEditable(false);
        
        this.btn_editar.setEnabled(false);
        this.btn_eliminar.setEnabled(false);
        this.btn_cargar_detalle.setEnabled(false);
        this.btn_agregar.setEnabled(false);
        this.btn_quitar.setEnabled(false);
        this.btn_trabajos.setEnabled(false);
        this.btn_actualizar.setEnabled(false);
        this.btn_finalizar.setEnabled(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        selector_equipo = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        txt_observacion = new javax.swing.JTextArea();
        btn_agregar = new javax.swing.JButton();
        btn_quitar = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tabla_detalle = new javax.swing.JTable();
        btn_trabajos = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        txt_estado = new javax.swing.JTextField();
        txt_costo_total = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        selector_cliente = new javax.swing.JComboBox<>();
        txt_fecha_finalizacion = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txt_fecha_recepcion = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txt_id = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla_servicios = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        btn_cargar_detalle = new javax.swing.JButton();
        btn_finalizar = new javax.swing.JButton();
        btn_registrar = new javax.swing.JButton();
        btn_editar = new javax.swing.JButton();
        btn_eliminar = new javax.swing.JButton();
        btn_limpiar = new javax.swing.JButton();
        btn_actualizar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("GESTIONAR INFORMES DE SERVICIO");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Detalle Informe de Servicio", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N

        jLabel8.setText("EQUIPO");

        jLabel9.setText("OBSERVACION");

        selector_equipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        txt_observacion.setColumns(20);
        txt_observacion.setRows(5);
        jScrollPane2.setViewportView(txt_observacion);

        btn_agregar.setText("AGREGAR");

        btn_quitar.setText("QUITAR");

        tabla_detalle.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane3.setViewportView(tabla_detalle);

        btn_trabajos.setText("GESTIONAR TRABAJOS");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 260, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btn_agregar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_quitar)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(selector_equipo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(104, 104, 104)
                .addComponent(btn_trabajos)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(selector_equipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_agregar)
                    .addComponent(btn_quitar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 163, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_trabajos)
                .addGap(6, 6, 6))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel4.setText("ESTADO");

        jLabel3.setText("COSTO TOTAL");

        jLabel2.setText("F. RECEPCION");

        selector_cliente.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel10.setText("F. FINALIZACION");

        jLabel5.setText("CLIENTE");

        jLabel1.setText("ID");

        tabla_servicios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tabla_servicios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabla_serviciosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabla_servicios);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setText("LISTA DE INFORMES DE SERVICIOS");

        btn_cargar_detalle.setText("CARGAR DETALLE");

        btn_finalizar.setText("FINALIZAR ");

        btn_registrar.setText("REGISTRAR");

        btn_editar.setText("EDITAR");

        btn_eliminar.setText("ELIMINAR");

        btn_limpiar.setText("LIMPIAR");

        btn_actualizar.setText("ACTUALIZAR");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 528, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel6))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel2)
                                            .addComponent(jLabel1))
                                        .addGap(32, 32, 32)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txt_id)
                                            .addComponent(txt_fecha_recepcion)))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel10)
                                            .addComponent(jLabel3)
                                            .addComponent(jLabel4)
                                            .addComponent(jLabel5))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(selector_cliente, 0, 184, Short.MAX_VALUE)
                                            .addComponent(txt_fecha_finalizacion)
                                            .addComponent(txt_costo_total)
                                            .addComponent(txt_estado)))))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(50, 50, 50)
                                .addComponent(btn_registrar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_editar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_eliminar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_limpiar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_finalizar)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(157, 157, 157)
                .addComponent(btn_cargar_detalle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_actualizar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txt_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(jLabel2))
                    .addComponent(txt_fecha_recepcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txt_fecha_finalizacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(txt_costo_total, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_estado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(selector_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_registrar)
                    .addComponent(btn_editar)
                    .addComponent(btn_eliminar)
                    .addComponent(btn_limpiar)
                    .addComponent(btn_finalizar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_cargar_detalle)
                    .addComponent(btn_actualizar))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tabla_serviciosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabla_serviciosMouseClicked
        DefaultTableModel m = (DefaultTableModel) tabla_servicios.getModel();
        int fila = tabla_servicios.getSelectedRow();
        txt_id.setText(m.getValueAt(fila, 0).toString());
        txt_fecha_recepcion.setText(m.getValueAt(fila, 1).toString());
        txt_fecha_finalizacion.setText(m.getValueAt(fila, 2).toString());
        txt_costo_total.setText(m.getValueAt(fila, 3).toString());
        txt_estado.setText(m.getValueAt(fila, 4).toString());
        
        DefaultComboBoxModel c = (DefaultComboBoxModel) selector_cliente.getModel();
        for (int i = 0; i < c.getSize(); i++) {
            String tipo[] = selector_cliente.getItemAt(i).toString().split(",");
            if (m.getValueAt(fila, 5).toString().equals(tipo[0])) {
                selector_cliente.setSelectedIndex(i);
                break;
            }
        }
        
        btn_actualizar.setEnabled(false);
        
        switch (txt_estado.getText()) {
            case "Activo":
                btn_registrar.setEnabled(false);
                btn_editar.setEnabled(true);
                btn_eliminar.setEnabled(true);
                btn_cargar_detalle.setEnabled(true);
                btn_agregar.setEnabled(false);
                btn_quitar.setEnabled(false);
                btn_trabajos.setEnabled(false);
                btn_limpiar.setEnabled(true);
                btn_finalizar.setEnabled(true);
                break;
            case "Finalizado":
                btn_registrar.setEnabled(false);
                btn_editar.setEnabled(false);
                btn_eliminar.setEnabled(true);
                btn_cargar_detalle.setEnabled(true);
                btn_agregar.setEnabled(false);
                btn_quitar.setEnabled(false);
                btn_trabajos.setEnabled(false);
                btn_limpiar.setEnabled(true);
                btn_finalizar.setEnabled(false);
                break;  
        }
    }//GEN-LAST:event_tabla_serviciosMouseClicked
        
    
    // FUNCIONES PROPIAS
    public void limpiarCampos(){
        txt_id.setText("");
        txt_fecha_recepcion.setText("");
        txt_fecha_finalizacion.setText("");
        txt_costo_total.setText("");
        txt_estado.setText("");
        
        btn_registrar.setEnabled(true);
        btn_editar.setEnabled(false);
        btn_eliminar.setEnabled(false);
        btn_cargar_detalle.setEnabled(false);
        btn_agregar.setEnabled(false);
        btn_quitar.setEnabled(false);
        btn_trabajos.setEnabled(false);
        btn_finalizar.setEnabled(false);
    }
    
    public void actualizarTablaInformes(ArrayList<ArrayList> equipos){
        DefaultTableModel dtm = new DefaultTableModel();
        tabla_servicios.setModel(dtm);
        dtm.addColumn("ID");
        dtm.addColumn("F. RECEPCION");
        dtm.addColumn("F. FINALIZACION");
        dtm.addColumn("COSTO TOTAL");
        dtm.addColumn("ESTADO");
        dtm.addColumn("CLIENTE");
        
        Object[] fila = new Object[6];
        for (int i = 0; i < equipos.size(); i++) {
            fila[0] = equipos.get(i).get(0);
            fila[1] = equipos.get(i).get(1);
            fila[2] = equipos.get(i).get(2);
            fila[3] = equipos.get(i).get(3);
            fila[4] = equipos.get(i).get(4);
            fila[5] = equipos.get(i).get(5);
            
            dtm.addRow(fila);
        }
        
        btn_actualizar.setEnabled(false);
    }
    
     public void actualizarTablaDetalle(ArrayList<ArrayList> detalles){
        DefaultTableModel dfm2 = new DefaultTableModel();
        tabla_detalle.setModel(dfm2);
        dfm2.addColumn("INFORME_ID");
        dfm2.addColumn("EQUIPO_ID");
        dfm2.addColumn("COSTO");
        dfm2.addColumn("OBSERVACION");
        
        Object[] fila = new Object[4];
        for (int i = 0; i < detalles.size(); i++) {
            fila[0] = detalles.get(i).get(0);
            fila[1] = detalles.get(i).get(1);
            fila[2] = detalles.get(i).get(2);
            fila[3] = detalles.get(i).get(3);
            
            dfm2.addRow(fila);
        }
        
        switch (txt_estado.getText()) {
            case "Activo":
                btn_agregar.setEnabled(true);
                btn_quitar.setEnabled(true);
                btn_trabajos.setEnabled(true);
                break;
            case "Finalizado":
                btn_agregar.setEnabled(false);
                btn_quitar.setEnabled(false);
                btn_trabajos.setEnabled(true);
                break;  
        }
        
        
        
        
    }
    
    public void cargarSelectorCliente(ArrayList<ArrayList> clientes) {
        ArrayList t = new ArrayList();
        for (int i = 0; i < clientes.size(); i++) {
            t.add(clientes.get(i).get(0) + ", " + clientes.get(i).get(2));
        }
        this.selector_cliente.setModel(new DefaultComboBoxModel(t.toArray()));
    }
    
    public void cargarSelectorEquipo(ArrayList<ArrayList> equipos) {
        ArrayList t = new ArrayList();
        for (int i = 0; i < equipos.size(); i++) {
            t.add(equipos.get(i).get(0) + ", " + equipos.get(i).get(1));
        }
        this.selector_equipo.setModel(new DefaultComboBoxModel(t.toArray()));
    }
    
    
    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Windows".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(V_Cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(V_Cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(V_Cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(V_Cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new V_Cliente().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btn_actualizar;
    public javax.swing.JButton btn_agregar;
    public javax.swing.JButton btn_cargar_detalle;
    public javax.swing.JButton btn_editar;
    public javax.swing.JButton btn_eliminar;
    public javax.swing.JButton btn_finalizar;
    public javax.swing.JButton btn_limpiar;
    public javax.swing.JButton btn_quitar;
    public javax.swing.JButton btn_registrar;
    public javax.swing.JButton btn_trabajos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    public javax.swing.JComboBox<String> selector_cliente;
    public javax.swing.JComboBox<String> selector_equipo;
    public javax.swing.JTable tabla_detalle;
    public javax.swing.JTable tabla_servicios;
    public javax.swing.JTextField txt_costo_total;
    public javax.swing.JTextField txt_estado;
    public javax.swing.JTextField txt_fecha_finalizacion;
    public javax.swing.JTextField txt_fecha_recepcion;
    public javax.swing.JTextField txt_id;
    public javax.swing.JTextArea txt_observacion;
    // End of variables declaration//GEN-END:variables
}
