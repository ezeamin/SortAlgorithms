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
public class GUIOrden extends javax.swing.JFrame {

    /**
     * Creates new form GUIOrden
     */
    int n;
    int v[];
    int opc;
    
    public GUIOrden(int _n,int _v[]) {
        initComponents();
        FlatLightLaf.setup();
        setLocationRelativeTo(null);
        
        n=_n;
        v=new int[n];
        opc=0;
        
        System.arraycopy(_v,0,v,0,n);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        btnDesordenado = new javax.swing.JRadioButton();
        btnOrdenado = new javax.swing.JRadioButton();
        btnOrdenadoInv = new javax.swing.JRadioButton();
        btnContinuar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setText("Elija como continuar");

        buttonGroup1.add(btnDesordenado);
        btnDesordenado.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        btnDesordenado.setSelected(true);
        btnDesordenado.setText("Vector desordenado");
        btnDesordenado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDesordenadoActionPerformed(evt);
            }
        });

        buttonGroup1.add(btnOrdenado);
        btnOrdenado.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        btnOrdenado.setText("Vector ordenado");
        btnOrdenado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOrdenadoActionPerformed(evt);
            }
        });

        buttonGroup1.add(btnOrdenadoInv);
        btnOrdenadoInv.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        btnOrdenadoInv.setText("Vector ordenado inversamente");
        btnOrdenadoInv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOrdenadoInvActionPerformed(evt);
            }
        });

        btnContinuar.setText("Continuar");
        btnContinuar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnContinuarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnOrdenado)
                            .addComponent(btnDesordenado)
                            .addComponent(btnOrdenadoInv))))
                .addContainerGap(54, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnContinuar)
                .addGap(35, 35, 35))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(btnDesordenado)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnOrdenado)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnOrdenadoInv)
                .addGap(28, 28, 28)
                .addComponent(btnContinuar)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnDesordenadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDesordenadoActionPerformed
        // TODO add your handling code here:
        opc=0;
    }//GEN-LAST:event_btnDesordenadoActionPerformed

    private void btnOrdenadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOrdenadoActionPerformed
        // TODO add your handling code here:
        opc=1;
    }//GEN-LAST:event_btnOrdenadoActionPerformed

    private void btnOrdenadoInvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOrdenadoInvActionPerformed
        // TODO add your handling code here:
        opc=2;
    }//GEN-LAST:event_btnOrdenadoInvActionPerformed

    private void btnContinuarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnContinuarActionPerformed
        // TODO add your handling code here:
        if(opc==-1){
            JOptionPane.showMessageDialog(null,"Elija una opcion");
            return;
        }
        
        if(opc!=0){
            v=new Algoritmos(v,n).quickSortFunc(v, 0, n-1);
        }
        
        if(opc==2){
            v=new Operaciones().invertir(v,n);
        }
        
        new GUIPrincipal(n,v).setVisible(true);
        dispose();
    }//GEN-LAST:event_btnContinuarActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnContinuar;
    private javax.swing.JRadioButton btnDesordenado;
    private javax.swing.JRadioButton btnOrdenado;
    private javax.swing.JRadioButton btnOrdenadoInv;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
