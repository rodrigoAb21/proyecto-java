/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adm_vista;

import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author KAKU
 */
public class V_Trabajo extends javax.swing.JFrame {

    private String estado = "";
    /**
     * Creates new form Vista_Principal
     */
    public V_Trabajo(String estado) {
        initComponents();
        this.estado = estado;
        
        this.setDefaultCloseOperation(2);
        this.setVisible(true);
        this.txt_id.setEditable(false);
        
        if (this.estado.equals("Finalizado")) {
            this.btn_registrar.setEnabled(false);
            this.btn_limpiar.setEnabled(false);
        }
        this.btn_editar.setEnabled(false);
        this.btn_eliminar.setEnabled(false);
        this.btn_cargar_detalle.setEnabled(false);
        this.btn_agregar.setEnabled(false);
        this.btn_quitar.setEnabled(false);
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
        jScrollPane3 = new javax.swing.JScrollPane();
        tabla_detalle = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        selector_herramienta = new javax.swing.JComboBox<>();
        btn_agregar = new javax.swing.JButton();
        btn_quitar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla_trabajos = new javax.swing.JTable();
        btn_cargar_detalle = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        btn_registrar = new javax.swing.JButton();
        btn_editar = new javax.swing.JButton();
        btn_eliminar = new javax.swing.JButton();
        btn_limpiar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        txt_descripcion = new javax.swing.JTextArea();
        txt_costo = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txt_fecha_inicio = new javax.swing.JTextField();
        selector_tecnico = new javax.swing.JComboBox<>();
        txt_fecha_fin = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txt_id = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("GESTIONAR TRABAJOS");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Detalle Trabajo", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N

        tabla_detalle.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane3.setViewportView(tabla_detalle);

        jLabel8.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel8.setText("HERRAMIENTA");

        selector_herramienta.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btn_agregar.setText("AGREGAR");

        btn_quitar.setText("QUITAR");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(selector_herramienta, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(77, 77, 77)
                        .addComponent(btn_agregar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_quitar))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(selector_herramienta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_agregar)
                    .addComponent(btn_quitar))
                .addGap(12, 12, 12)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tabla_trabajos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tabla_trabajos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabla_trabajosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabla_trabajos);

        btn_cargar_detalle.setText("CARGAR DETALLE");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setText("LISTA DE TRABAJOS");

        btn_registrar.setText("REGISTRAR");

        btn_editar.setText("EDITAR");

        btn_eliminar.setText("ELIMINAR");

        btn_limpiar.setText("LIMPIAR");

        jLabel4.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel4.setText("DESCRIPCION");

        txt_descripcion.setColumns(20);
        txt_descripcion.setRows(5);
        jScrollPane4.setViewportView(txt_descripcion);

        jLabel3.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel3.setText("COSTO");

        jLabel2.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel2.setText("F. INICIO");

        jLabel5.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel5.setText("TECNICO");

        txt_fecha_inicio.setText("DD/MM/AAAA");

        selector_tecnico.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        txt_fecha_fin.setText("DD/MM/AAAA");

        jLabel10.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel10.setText("F. FIN");

        jLabel1.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel1.setText("ID");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(490, 490, 490))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel3))
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(122, 122, 122)
                        .addComponent(txt_costo, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(58, 58, 58)
                                .addComponent(selector_tecnico, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(100, 100, 100)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txt_id)
                                    .addComponent(txt_fecha_inicio)
                                    .addComponent(txt_fecha_fin)
                                    .addComponent(jScrollPane4))))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(95, 95, 95)
                        .addComponent(btn_registrar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_editar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_eliminar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_limpiar))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(206, 206, 206)
                        .addComponent(btn_cargar_detalle)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txt_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txt_fecha_inicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txt_fecha_fin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txt_costo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(selector_tecnico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_registrar)
                    .addComponent(btn_editar)
                    .addComponent(btn_eliminar)
                    .addComponent(btn_limpiar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_cargar_detalle)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(29, 29, 29)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tabla_trabajosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabla_trabajosMouseClicked
        DefaultTableModel m = (DefaultTableModel) tabla_trabajos.getModel();
        int fila = tabla_trabajos.getSelectedRow();
        txt_id.setText(m.getValueAt(fila, 0).toString());
        txt_fecha_inicio.setText(m.getValueAt(fila, 1).toString());
        txt_fecha_fin.setText(m.getValueAt(fila, 2).toString());
        txt_costo.setText(m.getValueAt(fila, 3).toString());
        txt_descripcion.setText(m.getValueAt(fila, 4).toString());
        
        
        DefaultComboBoxModel c = (DefaultComboBoxModel) selector_tecnico.getModel();
        for (int i = 0; i < c.getSize(); i++) {
            String tipo[] = selector_tecnico.getItemAt(i).toString().split("-");
            if (m.getValueAt(fila, 5).toString().equals(tipo[1].trim())) {
                selector_tecnico.setSelectedIndex(i);
                break;
            }
        }
        
        if (this.estado.equals("Activo")) {
            btn_registrar.setEnabled(false);
            btn_editar.setEnabled(true);
            btn_eliminar.setEnabled(true);
            btn_cargar_detalle.setEnabled(true);
            btn_agregar.setEnabled(false);
            btn_quitar.setEnabled(false);
        }else{
            btn_registrar.setEnabled(false);
            btn_editar.setEnabled(false);
            btn_eliminar.setEnabled(false);
            btn_cargar_detalle.setEnabled(true);
            btn_agregar.setEnabled(false);
            btn_quitar.setEnabled(false);
            btn_limpiar.setEnabled(false);
        }
        
        limpiarTablaDetalle();
        
    }//GEN-LAST:event_tabla_trabajosMouseClicked
        
    
    // FUNCIONES PROPIAS
    public void limpiarCampos(){
        txt_id.setText("");
        txt_fecha_inicio.setText("");
        txt_fecha_fin.setText("");
        txt_costo.setText("");
        txt_descripcion.setText("");
        
        selector_herramienta.setSelectedIndex(0);
        selector_tecnico.setSelectedIndex(0);
        
        
        btn_registrar.setEnabled(true);
        btn_editar.setEnabled(false);
        btn_eliminar.setEnabled(false);
        btn_cargar_detalle.setEnabled(false);
        btn_agregar.setEnabled(false);
        btn_quitar.setEnabled(false);
        
        limpiarTablaDetalle();
    }
    
     public void limpiarDetalle(){
        selector_herramienta.setSelectedIndex(0);
    }
     
    public void actualizarTablaTrabajos(ArrayList<ArrayList> equipos){
        DefaultTableModel dtm = new DefaultTableModel();
        tabla_trabajos.setModel(dtm);
        dtm.addColumn("ID");
        dtm.addColumn("F. INICIO");
        dtm.addColumn("F. FIN");
        dtm.addColumn("COSTO");
        dtm.addColumn("DESCRIPCION");
        dtm.addColumn("TECNICO");
        
        Object[] fila = new Object[6];
        for (int i = 0; i < equipos.size(); i++) {
            fila[0] = equipos.get(i).get(0);
            fila[1] = equipos.get(i).get(1);
            fila[2] = equipos.get(i).get(2);
            fila[3] = equipos.get(i).get(3);
            fila[4] = equipos.get(i).get(4);
            fila[5] = equipos.get(i).get(5) + " " + equipos.get(i).get(6);
            
            dtm.addRow(fila);
        }
        limpiarTablaDetalle();
    }
    
     public void actualizarTablaDetalle(ArrayList<ArrayList> detalles){
        DefaultTableModel dfm2 = new DefaultTableModel();
        tabla_detalle.setModel(dfm2);
        dfm2.addColumn("HERR_ID");
        dfm2.addColumn("DESCRIPCION");
        dfm2.addColumn("MARCA");
        
        
        Object[] fila = new Object[3];
        for (int i = 0; i < detalles.size(); i++) {
            fila[0] = detalles.get(i).get(0);
            fila[1] = detalles.get(i).get(1);
            fila[2] = detalles.get(i).get(2);
            
            dfm2.addRow(fila);
        }
        
        
         if (this.estado.equals("Activo")) {
            btn_agregar.setEnabled(true);
            btn_quitar.setEnabled(true);
         } else {
            btn_agregar.setEnabled(false);
            btn_quitar.setEnabled(false);
         }
    }
     
    public void limpiarTablaDetalle(){
       selector_herramienta.setSelectedIndex(0);
       DefaultTableModel dfm2 = new DefaultTableModel();
       tabla_detalle.setModel(dfm2);
    }
    
    public void cargarSelectorTecnico(ArrayList<ArrayList> tecnicos) {
        ArrayList t = new ArrayList();
        for (int i = 0; i < tecnicos.size(); i++) {
            t.add(tecnicos.get(i).get(0) + " - " + tecnicos.get(i).get(2) + " " 
                    + tecnicos.get(i).get(3));
        }
        this.selector_tecnico.setModel(new DefaultComboBoxModel(t.toArray()));
    }
    
    public void cargarSelectorHerramienta(ArrayList<ArrayList> herramientas) {
        ArrayList t = new ArrayList();
        for (int i = 0; i < herramientas.size(); i++) {
            t.add(herramientas.get(i).get(0) + ", " + herramientas.get(i).get(1)
                    + ", " + herramientas.get(i).get(2));
        }
        this.selector_herramienta.setModel(new DefaultComboBoxModel(t.toArray()));
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
    public javax.swing.JButton btn_agregar;
    public javax.swing.JButton btn_cargar_detalle;
    public javax.swing.JButton btn_editar;
    public javax.swing.JButton btn_eliminar;
    public javax.swing.JButton btn_limpiar;
    public javax.swing.JButton btn_quitar;
    public javax.swing.JButton btn_registrar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    public javax.swing.JComboBox<String> selector_herramienta;
    public javax.swing.JComboBox<String> selector_tecnico;
    public javax.swing.JTable tabla_detalle;
    public javax.swing.JTable tabla_trabajos;
    public javax.swing.JTextField txt_costo;
    public javax.swing.JTextArea txt_descripcion;
    public javax.swing.JTextField txt_fecha_fin;
    public javax.swing.JTextField txt_fecha_inicio;
    public javax.swing.JTextField txt_id;
    // End of variables declaration//GEN-END:variables
}