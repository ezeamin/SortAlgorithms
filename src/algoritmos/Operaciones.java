/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritmos;

import javax.swing.JTextArea;

/**
 *
 * @author EZEA2
 */
public class Operaciones {
    int n;
    int v[];
    
    /*Invertir(int _v[],int _n){
        n=_n;
        System.arraycopy(_v, 0, v, 0, n);
    }*/
    
    public void imprimirVector(int _v[],int _n,JTextArea txtVector){
        n=_n;
        v=new int[n];
        
        System.arraycopy(_v, 0, v, 0, n);
        
        String vector="";

        vector+="V[";
        for(int i=0;i<n;i++){
            vector+=v[i];
            if(i!=n-1) vector+=",";
        }
        vector+="]";
        
        txtVector.setText(vector);
    }
    
    public String imprimirVectorSout(int _v[],int _n){
        n=_n;
        v=new int[n];
        
        System.arraycopy(_v, 0, v, 0, n);
        
        String vector="";

        vector+="V[";
        for(int i=0;i<n;i++){
            vector+=v[i];
            if(i!=n-1) vector+=",";
        }
        vector+="]";
        
        return vector;
    }
    
    public int[] invertir(int _v[],int _n){
        n=_n;
        v=new int[n];
        
        System.arraycopy(_v, 0, v, 0, n);
        
        int aux;
	
	for(int i=0;i<n/2;i++){
		aux=v[i];
		v[i]=v[n-i-1];
		v[n-i-1]=aux;
	}
        
        return v;
    }
    
    public String recorte(double num){
        if(num>1000000) return Double.toString(num);
        String tiempo=Double.toString(num);
        int i;
        for(i=0;i<tiempo.length();i++){
            if(tiempo.charAt(i)=='.'){
                break;
            }
        }
        //System.out.println(""+tiempo);
        return tiempo.substring(0,i);
        
    }
}
