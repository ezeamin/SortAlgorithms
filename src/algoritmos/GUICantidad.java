/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritmos;

import com.formdev.flatlaf.FlatLightLaf;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JOptionPane;

/**
 *
 * @author EZEA2
 */
public class GUICantidad extends javax.swing.JFrame {

    /**
     * Creates new form GUI
     */
    private int n;
    
    private Algoritmos main;
    
    public GUICantidad() {
        FlatLightLaf.setup();
        initComponents();
        setLocationRelativeTo(null);
        n=0;

        Action action = new AbstractAction(){ //para detectar el enter
            @Override
            public void actionPerformed(ActionEvent e)
            {
                btnEnviarActionPerformed(e);
            }
        };
        txtCantidad.addActionListener(action);
    }
    
    /*private void guardarDatos() throws FileNotFoundException{
        try{
            FileOutputStream file = new FileOutputStream("cantidad.dat");
            ObjectOutputStream outputFile = new ObjectOutputStream(file);
            
            outputFile.writeInt(n);
            
            outputFile.close();
        }
        catch(IOException e){
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
    }*/
    
    public static void main(String args[]) {
       
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUICantidad().setVisible(true);
            }
        });
        
//        
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
        txtCantidad = new javax.swing.JTextField();
        btnEnviar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setText("Ingrese la cantidad de elementos");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 360, 60));

        txtCantidad.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        txtCantidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCantidadActionPerformed(evt);
            }
        });
        getContentPane().add(txtCantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 110, 110, 50));

        btnEnviar.setText("Enviar");
        btnEnviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEnviarActionPerformed(evt);
            }
        });
        getContentPane().add(btnEnviar, new org.netbeans.lib.awtextra.AbsoluteConstraints(152, 190, 90, -1));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 280, 20, 20));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtCantidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCantidadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCantidadActionPerformed

    private void btnEnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnviarActionPerformed
        // TODO add your handling code here:
        
        try{
            n=Integer.parseInt(txtCantidad.getText());
            if(n<=0){
                JOptionPane.showMessageDialog(null,"Ingrese un valor valido");
                return;
            }
            if(n>100000){
                JOptionPane.showMessageDialog(null,"Ingrese un valor menor que 100.000");
                return;
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,"Ingrese un valor valido");
            return;
        }
        
        /*try {
            guardarDatos();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(GUICantidad.class.getName()).log(Level.SEVERE, null, ex);
        }*/
        
        new GUIGenerar(n).setVisible(true);
        dispose();
    }//GEN-LAST:event_btnEnviarActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEnviar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField txtCantidad;
    // End of variables declaration//GEN-END:variables
}
