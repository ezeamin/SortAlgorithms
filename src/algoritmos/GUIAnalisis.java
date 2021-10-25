/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritmos;

import com.formdev.flatlaf.FlatLightLaf;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import static java.lang.Math.log;
import static java.lang.Math.pow;
import java.text.DecimalFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
    int posMaxPuntaje,posMinPuntaje;
    JLabel txtProcesando;
    DefaultTableModel tabla;
    String datos[][];
    
    public GUIAnalisis(int _v[],int _n,JLabel _txtProcesando,String _datos[][]) {
        txtProcesando=_txtProcesando;
        txtProcesando.setVisible(true);
        
        initComponents();
        FlatLightLaf.setup();
        setLocationRelativeTo(null);
        
        n=_n;
        v=new int[n];

        //array de datos
        datos=new String[5][7];
        for(int i=0;i<5;i++){
            System.arraycopy(_datos[i], 0, datos[i], 0, 7);
        }
        
        System.arraycopy(_v,0,v,0,n);
        
        //tabla
        tabla=new DefaultTableModel();
        tabla.addColumn("Metodo");
        tabla.addColumn("Tiempo [s]");
        tabla.addColumn("Comparaciones");
        tabla.addColumn("Op. máximas teóricas");
        table.setModel(tabla);
        
        datos=new Algoritmos(v,n,datos).comparar();
        conseguirTeoricos();
        cargarDatosTabla();
        detectarMejor();
    }
    
    private void detectarMejor(){
        int punt[][]=new int[4][7];
        for(int i=0;i<7;i++){
            punt[0][i]=i;
        }
        
        //ordenar tiempo
        double tiempo[][]=new double[3][7];
        for(int i=0;i<7;i++){
            tiempo[0][i]=i;
            try{
                tiempo[1][i]=Double.parseDouble(datos[1][i]);
            }
            catch(Exception e){
                tiempo[1][i]=Double.NaN;
            }
            
        }
        
        double aux1,aux2;

        for (int i=0;i<7-1;i++){
            for (int j=0;j<7-i-1;j++){
                if(Double.isNaN(tiempo[1][j])) continue;
                if (tiempo[1][j]>tiempo[1][j+1]){
                    // swap arr[j+1] and arr[j]
                    aux1=tiempo[0][j];
                    aux2=tiempo[1][j];
                    tiempo[0][j]=tiempo[0][j+1];
                    tiempo[1][j]=tiempo[1][j+1];
                    tiempo[0][j+1]=aux1;
                    tiempo[1][j+1]=aux2;
                }
            }
        }
        
        int k=100;
        for(int i=0;i<7;i++){
            if(!Double.isNaN(tiempo[1][i])) tiempo[2][i]=k;
            else tiempo[2][i]=Double.NaN;
            
            if(i!=6 && tiempo[1][i]!=tiempo[1][i+1] && !Double.isNaN(tiempo[1][i])) k-=14;
        }
        
        for(int i=0;i<7;i++){
            for(int j=0;j<7;j++){
                if(tiempo[0][i]==j){
                    if(!Double.isNaN(tiempo[1][i])) punt[1][j]=(int)tiempo[2][i];
                    else punt[1][j]=(int) Float.NaN;
                    break;
                }
            }
        }
        
        //ordenar comparaciones
        double comp[][]=new double[3][7];
        for(int i=0;i<7;i++){
            comp[0][i]=i;
            try{
                comp[1][i]=Double.parseDouble(datos[2][i]);
            }
            catch(Exception e){
                comp[1][i]=Double.NaN;
            }
            
        }

        for (int i=0;i<7-1;i++){
            for (int j=0;j<7-i-1;j++){
                if(Double.isNaN(comp[1][j])) continue;
                if (comp[1][j]>comp[1][j+1]){
                    // swap arr[j+1] and arr[j]
                    aux1=comp[0][j];
                    aux2=comp[1][j];
                    comp[0][j]=comp[0][j+1];
                    comp[1][j]=comp[1][j+1];
                    comp[0][j+1]=aux1;
                    comp[1][j+1]=aux2;
                }
            }
        }
        
        k=100;
        for(int i=0;i<7;i++){
            comp[2][i]=k;
            
            if(i!=6 && comp[1][i]!=comp[1][i+1] && !Double.isNaN(comp[1][i])) k-=14;
        }
        
        for(int i=0;i<7;i++){
            for(int j=0;j<7;j++){
                if(comp[0][i]==j){
                    if(!Double.isNaN(comp[1][i])) punt[2][j]=(int)comp[2][i];
                    else punt[2][j]=(int) Float.NaN;
                    
                    if(!Double.isNaN(comp[1][i]))punt[3][j]=punt[1][j]+punt[2][j];
                    else punt[3][j]=(int) Float.NaN;
                    break;
                }
            }
        }
        
        System.out.println("");
        for(int i=0;i<7;i++){
            for(int j=0;j<4;j++){
                System.out.printf(punt[j][i]+" | ");
            }
            System.out.println("");
        }
        System.out.println("");
        
        //obtener mejor y peor puntaje
        int p=0;
        while(punt[3][p]==(int)Double.NaN){
            p++;
        }
        
        double maxPuntaje=punt[3][p];
        posMaxPuntaje=p;
        double minPuntaje=punt[3][p];
        posMinPuntaje=p;

        
        for(int i=p+1;i<7;i++){
            if(punt[3][i]==(int)Double.NaN) continue;
            
            if(punt[3][i]<maxPuntaje){
                maxPuntaje=punt[3][i];
                posMaxPuntaje=i;
                continue;
            }
            if(punt[3][i]>minPuntaje){
                minPuntaje=punt[3][i];
                posMinPuntaje=i;
            }
        }

        txtMejorAlgoritmo.setText(datos[0][posMinPuntaje]);
        txtPeorAlgoritmo.setText(datos[0][posMaxPuntaje]);
    }
    
    private void cargarDatosTabla(){
        String info[]=new String[4];
        
        for(int i=0;i<7;i++){
            for(int j=0;j<4;j++){
                //if(j==3) info[j]=String.format("%6.3E",datos[j][i]);
                info[j]=datos[j][i];
                //System.out.printf(""+datos[j][i]+",");
            }
            //System.out.println("");
            tabla.addRow(info);
        }
    }
    
    private void conseguirTeoricos(){
        if("1".equals(datos[4][0])) datos[3][0]=new Operaciones().recorte(pow(n,2));
        if("1".equals(datos[4][1])) datos[3][1]=new Operaciones().recorte(pow(n,2)/4);
        if("1".equals(datos[4][2])) datos[3][2]=new Operaciones().recorte(n*(n-1)/2);
        if("1".equals(datos[4][3])) datos[3][3]=new Operaciones().recorte(pow(n,2));
        if("1".equals(datos[4][4])) datos[3][4]=new Operaciones().recorte(n*pow(log(n),2));
        if("1".equals(datos[4][5])) datos[3][5]=new Operaciones().recorte(n*log(n));
        if("1".equals(datos[4][6])) {
            datos[3][6]=new Operaciones().recorte(pow(n,2));
            datos[3][6]+=" | ";
            datos[3][6]+=new Operaciones().recorte(n*log(n));
        }
    }
    
    private void guardarDatos() throws FileNotFoundException, IOException{
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("datos.txt"));
            boolean newLine=true;
            
            for(int i=0;i<7;i++){
                for(int j=0;j<4;j++){
                    if(j==0 && datos[1][i]==null){
                        newLine=false;
                        break;
                    }
                    if(j==3 && i==6) bw.write("("+datos[j][i] + ((j==3) ? "" : " | ")+")");
                    else bw.write(datos[j][i] + ((j==3) ? "" : " | "));
                }
                if(newLine) bw.newLine();
                else newLine=true;
                
            }
            
            bw.newLine();
            bw.write("Mejor: "+datos[0][posMaxPuntaje]);
            bw.newLine();
            bw.write("Peor: "+datos[0][posMinPuntaje]);
            bw.flush();
            JOptionPane.showMessageDialog(null,"Guardado exitosamente");
        }
        catch (IOException e) {
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
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
        jLabel2 = new javax.swing.JLabel();
        txtMejorAlgoritmo = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtPeorAlgoritmo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Resultados - Algoritmos de ordenamiento");

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

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setText("El algoritmo de mejor rendimiento (Recursos-Tiempo) fue:");

        txtMejorAlgoritmo.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtMejorAlgoritmo.setText("Algoritmo");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setText("El algoritmo de peor rendimiento (Recursos-Tiempo) fue:");

        txtPeorAlgoritmo.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtPeorAlgoritmo.setText("Algoritmo");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(jLabel1))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtMejorAlgoritmo))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 654, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtPeorAlgoritmo)))))
                .addContainerGap(43, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnExportar)
                .addGap(18, 18, 18)
                .addComponent(btnContinuar)
                .addGap(43, 43, 43))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtMejorAlgoritmo)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(txtPeorAlgoritmo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnExportar)
                    .addComponent(btnContinuar))
                .addGap(19, 19, 19))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnContinuarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnContinuarActionPerformed
        // TODO add your handling code here:
        txtProcesando.setVisible(false);
        dispose();
    }//GEN-LAST:event_btnContinuarActionPerformed

    private void btnExportarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExportarActionPerformed
        try {
            guardarDatos();
        } catch (IOException ex) {
            Logger.getLogger(GUIAnalisis.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnExportarActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnContinuar;
    private javax.swing.JButton btnExportar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable table;
    private javax.swing.JLabel txtMejorAlgoritmo;
    private javax.swing.JLabel txtPeorAlgoritmo;
    // End of variables declaration//GEN-END:variables
}
