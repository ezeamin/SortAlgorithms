/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritmos;

import com.formdev.flatlaf.FlatLightLaf;
import javax.swing.JOptionPane;

/**
 *
 * @author EZEA2
 */
public class GUIPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form GUIPrincipal
     */
    private static int n;
    private int v[];
    String datos[][];
    
    
    public GUIPrincipal(int _n, int _v[]) {
        initComponents();
        FlatLightLaf.setup();
        setLocationRelativeTo(null);
        txtProcesando.setVisible(false);
        
        n=_n;
        v=new int[n];
        
        datos=new String[5][7]; //0=nombre, 1=tiempo, 2=comparaciones, 3=op maximas, 4=seleccionado(1 o 0)
        datos[0][0]="Bubble";
        datos[0][1]="Insertion";
        datos[0][2]="Binary";
        datos[0][3]="Selection";
        datos[0][4]="Shell";
        datos[0][5]="Merge";
        datos[0][6]="Quick";
        
        System.arraycopy(_v, 0, v, 0, n);
        
        new Operaciones().imprimirVector(v,n,txtVector);
        txtCantidad.setText(String.valueOf(n));
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
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtVector = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtCantidad = new javax.swing.JTextArea();
        btnEditar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        btnQuick = new javax.swing.JCheckBox();
        btnBubble = new javax.swing.JCheckBox();
        btnInsertion = new javax.swing.JCheckBox();
        btnBinary = new javax.swing.JCheckBox();
        btnSelection = new javax.swing.JCheckBox();
        btnShell = new javax.swing.JCheckBox();
        btnMerge = new javax.swing.JCheckBox();
        btnAnalizar = new javax.swing.JButton();
        txtProcesando = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Algoritmos de ordenamiento");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setText("Seleccione los metodos a testear:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, -1, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel2.setText("Vector:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, -1, -1));

        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        txtVector.setEditable(false);
        txtVector.setColumns(18);
        txtVector.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        txtVector.setRows(1);
        txtVector.setFocusable(false);
        jScrollPane1.setViewportView(txtVector);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 20, 410, 50));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel3.setText("Cantidad:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 30, -1, -1));

        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane2.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        txtCantidad.setEditable(false);
        txtCantidad.setColumns(20);
        txtCantidad.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        txtCantidad.setRows(1);
        txtCantidad.setFocusable(false);
        jScrollPane2.setViewportView(txtCantidad);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 20, 140, 50));

        btnEditar.setText("Editar vector");
        btnEditar.setFocusPainted(false);
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });
        getContentPane().add(btnEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 20, 120, 50));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 430, 20, 20));

        btnQuick.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        btnQuick.setText("Quick Sort");
        btnQuick.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuickActionPerformed(evt);
            }
        });
        getContentPane().add(btnQuick, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 380, -1, -1));

        btnBubble.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        btnBubble.setText("Bubble Sort");
        btnBubble.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBubbleActionPerformed(evt);
            }
        });
        getContentPane().add(btnBubble, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 140, -1, -1));

        btnInsertion.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        btnInsertion.setText("Insertion Sort");
        btnInsertion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsertionActionPerformed(evt);
            }
        });
        getContentPane().add(btnInsertion, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 180, -1, -1));

        btnBinary.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        btnBinary.setText("Binary Insertion Sort");
        btnBinary.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBinaryActionPerformed(evt);
            }
        });
        getContentPane().add(btnBinary, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 220, -1, -1));

        btnSelection.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        btnSelection.setText("Selection Sort");
        btnSelection.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSelectionActionPerformed(evt);
            }
        });
        getContentPane().add(btnSelection, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 260, -1, -1));

        btnShell.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        btnShell.setText("Shell Sort");
        btnShell.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnShellActionPerformed(evt);
            }
        });
        getContentPane().add(btnShell, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 300, -1, -1));

        btnMerge.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        btnMerge.setText("Merge Sort");
        btnMerge.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMergeActionPerformed(evt);
            }
        });
        getContentPane().add(btnMerge, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 340, -1, -1));

        btnAnalizar.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        btnAnalizar.setText("Analizar");
        btnAnalizar.setFocusPainted(false);
        btnAnalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnalizarActionPerformed(evt);
            }
        });
        getContentPane().add(btnAnalizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 200, 150, 120));

        txtProcesando.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        txtProcesando.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtProcesando.setText("Procesando...");
        getContentPane().add(txtProcesando, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 340, 150, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        // TODO add your handling code here:
        new GUICantidad().setVisible(true);
        //new GUIEditar(n,v).setVisible(true);
        dispose();
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnQuickActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuickActionPerformed
        // TODO add your handling code here:
        datos[4][6]="1";
        if (!btnQuick.isSelected()) datos[4][6]="0";
    }//GEN-LAST:event_btnQuickActionPerformed

    private void btnInsertionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertionActionPerformed
        // TODO add your handling code here:
        datos[4][1]="1";
        if (!btnInsertion.isSelected()) datos[4][1]="0";
    }//GEN-LAST:event_btnInsertionActionPerformed

    private void btnBinaryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBinaryActionPerformed
        // TODO add your handling code here:
        datos[4][2]="1";
        if (!btnBinary.isSelected()) datos[4][2]="0";
    }//GEN-LAST:event_btnBinaryActionPerformed

    private void btnSelectionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelectionActionPerformed
        // TODO add your handling code here:
        datos[4][3]="1";
        if (!btnSelection.isSelected()) datos[4][3]="0";
    }//GEN-LAST:event_btnSelectionActionPerformed

    private void btnShellActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnShellActionPerformed
        // TODO add your handling code here:
        datos[4][4]="1";
        if (!btnShell.isSelected()) datos[4][4]="0";
    }//GEN-LAST:event_btnShellActionPerformed

    private void btnMergeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMergeActionPerformed
        // TODO add your handling code here:
        datos[4][5]="1";
        if (!btnMerge.isSelected()) datos[4][5]="0";
    }//GEN-LAST:event_btnMergeActionPerformed

    private void btnBubbleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBubbleActionPerformed
        // TODO add your handling code here:
        datos[4][0]="1";
        if (!btnBubble.isSelected()) datos[4][0]="0";
    }//GEN-LAST:event_btnBubbleActionPerformed

    private void btnAnalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnalizarActionPerformed
        // TODO add your handling code here:
        boolean error=true;
        for(int i=0;i<7;i++){
            if("1".equals(datos[4][i])) error=false;
        }
        
        if(error){
            JOptionPane.showMessageDialog(null,"Seleccione al menos un algoritmo");
            return;
        }
        
        new GUIAnalisis(v,n,txtProcesando,datos).setVisible(true); //pasar booleanos
    }//GEN-LAST:event_btnAnalizarActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAnalizar;
    private javax.swing.JCheckBox btnBinary;
    private javax.swing.JCheckBox btnBubble;
    private javax.swing.JButton btnEditar;
    private javax.swing.JCheckBox btnInsertion;
    private javax.swing.JCheckBox btnMerge;
    private javax.swing.JCheckBox btnQuick;
    private javax.swing.JCheckBox btnSelection;
    private javax.swing.JCheckBox btnShell;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea txtCantidad;
    private javax.swing.JLabel txtProcesando;
    private javax.swing.JTextArea txtVector;
    // End of variables declaration//GEN-END:variables
}
