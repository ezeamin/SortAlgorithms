/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritmos;

import com.formdev.flatlaf.FlatLightLaf;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author EZEA2
 */
public class GUIAnalisis extends javax.swing.JFrame {

    /**
     * Creates new form GUIAnalisis
     */
    int v[];
    int n;
    JLabel txtProcesando;
    DefaultTableModel tabla;
    String datos[][];
    
    public GUIAnalisis(int _v[],int _n,JLabel _txtProcesando,String _datos[][]) {
        initComponents();
        FlatLightLaf.setup();
        setLocationRelativeTo(null);
        
        n=_n;
        v=new int[n];
        txtProcesando=_txtProcesando;
        
        //array de datos
        datos=new String[5][7];
        for(int i=0;i<5;i++){
            System.arraycopy(_datos[i], 0, datos[i], 0, 7);
        }
        
        /*datos[0][0]="Bubble";
        datos[0][1]="Insertion";
        datos[0][2]="Binary";
        datos[0][3]="Selection";
        datos[0][4]="Shell";
        datos[0][5]="Merge";
        datos[0][6]="Quick";*/
        
        System.arraycopy(_v,0,v,0,n);
        
        //tabla
        tabla=new DefaultTableModel();
        tabla.addColumn("Metodo");
        tabla.addColumn("Tiempo [s]");
        tabla.addColumn("Comparaciones");
        tabla.addColumn("Tiempo maximo teórico [s]");
        table.setModel(tabla);
        
        datos=new Algoritmos(v,n,datos).comparar();
        conseguirTeoricos();
        cargarDatosTabla();
        
    }
    
    private void cargarDatosTabla(){
        String info[]=new String[4];
        
        for(int i=0;i<7;i++){
            for(int j=0;j<4;j++){
                info[j]=datos[j][i];
                //System.out.printf(""+datos[j][i]+",");
            }
            //System.out.println("");
            tabla.addRow(info);
        }
    }
    
    private void conseguirTeoricos(){
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        btnContinuar = new javax.swing.JButton();
        btnExportar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setText("Resultados:");

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Metodo", "Tiempo [s]", "Cantidad de comparaciones", "Tiempo de operaciones maximas"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Float.class, java.lang.Double.class, java.lang.Float.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table.setAutoscrolls(false);
        table.setFocusable(false);
        table.setRequestFocusEnabled(false);
        table.setRowSelectionAllowed(false);
        table.setShowHorizontalLines(true);
        table.setShowVerticalLines(true);
        jScrollPane1.setViewportView(table);
        if (table.getColumnModel().getColumnCount() > 0) {
            table.getColumnModel().getColumn(0).setMinWidth(120);
            table.getColumnModel().getColumn(0).setMaxWidth(150);
            table.getColumnModel().getColumn(1).setMinWidth(100);
            table.getColumnModel().getColumn(1).setMaxWidth(150);
        }

        btnContinuar.setText("Continuar");
        btnContinuar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnContinuarActionPerformed(evt);
            }
        });

        btnExportar.setText("Exportar");
        btnExportar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExportarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnExportar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnContinuar))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(36, 36, 36)
                            .addComponent(jLabel1))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(52, 52, 52)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 622, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(46, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnContinuar)
                    .addComponent(btnExportar))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnContinuarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnContinuarActionPerformed
        // TODO add your handling code here:
        txtProcesando.setVisible(false);
        dispose();
    }//GEN-LAST:event_btnContinuarActionPerformed

    private void btnExportarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExportarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnExportarActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnContinuar;
    private javax.swing.JButton btnExportar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables
}
