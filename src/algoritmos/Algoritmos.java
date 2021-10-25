/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritmos;

/**
 *
 * @author EZEA2
 */
public class Algoritmos {
    
    int v[];
    double vDouble[];
    int ordenado[];
    int n;
    double contador;
    String datos[][];
    
    Algoritmos(int _v[],int _n,String _datos[][]){
        n=_n;
        v=new int[n];
        ordenado=new int[n];
        datos=new String[5][7];
        System.arraycopy(_v,0,v,0,n);
        
        for(int i=0;i<5;i++){
            System.arraycopy(_datos[i], 0, datos[i], 0, 7);
        }
    }
    
    Algoritmos(int _v[],int _n){
        n=_n;
        v=new int[n];
        ordenado=new int[n];
        datos=new String[5][7];
        System.arraycopy(_v,0,v,0,n);
    }
    
    Algoritmos(double _v[],int _n){
        n=_n;
        vDouble=new double[n];
        ordenado=new int[n];
        datos=new String[5][7];
        System.arraycopy(_v,0,vDouble,0,n);
    }
    
    public String[][] comparar(){
        if("1".equals(datos[4][0])){
            ordenado=bubble();
            System.out.println("Bubble: "+new Operaciones().imprimirVectorSout(ordenado, n));
        }
        if("1".equals(datos[4][1])){
            ordenado=insertion();
            System.out.println("Insertion: "+new Operaciones().imprimirVectorSout(ordenado, n));
        }
        if("1".equals(datos[4][2])){
            ordenado=binary();
            System.out.println("Binary: "+new Operaciones().imprimirVectorSout(ordenado, n));
        }
        if("1".equals(datos[4][3])){
            ordenado=selection();
            System.out.println("Selection: "+new Operaciones().imprimirVectorSout(ordenado, n));
        }
        if("1".equals(datos[4][4])){
            ordenado=shell();
            System.out.println("Shell: "+new Operaciones().imprimirVectorSout(ordenado, n));
        }
        if("1".equals(datos[4][5])){
            ordenado=merge();
            System.out.println("Merge: "+new Operaciones().imprimirVectorSout(ordenado, n));
        }
        if("1".equals(datos[4][6])){
            ordenado=quick();
            System.out.println("Quick: "+new Operaciones().imprimirVectorSout(ordenado, n));
        }
        
        return datos;
    }
    
    public int[] bubble(){
        int aux;
        contador=0;
        int temp[]=new int[n];
        System.arraycopy(v,0,temp,0,n);
        
        double inicio = System.currentTimeMillis();
        for (int i=0;i<n-1;i++){
            for (int j=0;j<n-i-1;j++){
                contador++;
                if (temp[j]>temp[j+1]){
                    // swap arr[j+1] and arr[j]
                    aux=temp[j];
                    temp[j]=temp[j+1];
                    temp[j+1]=aux;
                }
            }
        }
        double fin = System.currentTimeMillis();
        
        datos[1][0]=Double.toString((double) ((fin - inicio)/1000));
        datos[2][0]=new Operaciones().recorte(contador);

        return temp;
    }
    
    public int[] insertion(){
        int key,j;
        contador=0;
        int temp[]=new int[n];
        System.arraycopy(v,0,temp,0,n);
 
        double inicio = System.currentTimeMillis();
        for(int i=1;i<n;++i){
            key=temp[i];
            j=i-1;
 
            /* Move elements of arr[0..i-1], that are
               greater than key, to one position ahead
               of their current position */
            contador++; //por lo menos compara 1 vez
            while(j>=0 && temp[j]>key){
                contador++;
                temp[j+1]=temp[j];
                j=j-1;
            }
            temp[j+1]=key;
        }
        double fin = System.currentTimeMillis();
        
        datos[1][1]=Double.toString((double) ((fin - inicio)/1000));
        datos[2][1]=new Operaciones().recorte(contador);
        
        return temp;
    }
   
    public int binarySearch(int a[],int item,int low,int high){
        while(low<=high) {
            int mid=low+(high-low)/2;
            contador++;
            if(item==a[mid]) return mid+1;
            else if(item>a[mid]){
                contador++;
                low=mid+1;
            }
            else{
                contador++;
                high=mid-1;
            }
        }

        return low;
    }
 
// Function to sort an array a[] of size 'n'
    public int[] insertionSort(int a[],int n){
        int i,loc,j,selected;

        for(i=1;i<n;++i){
            j=i-1;
            selected=a[i];

            // find location where selected should be inseretd
            loc=binarySearch(a,selected,0,j);

            // Move all elements after location to create space
            while(j>=loc){
                a[j+1]=a[j];
                j--;
            }
            a[j+1]=selected;
        }
        return a;
    }
    
    public int[] binary(){
        int temp[]=new int[n];
        contador=0;
        System.arraycopy(v,0,temp,0,n);
        
        double inicio = System.currentTimeMillis();
        temp=insertionSort(temp,n);
        double fin = System.currentTimeMillis();
        
        datos[1][2]=Double.toString((double) ((fin - inicio)/1000));
        datos[2][2]=new Operaciones().recorte(contador);
        return temp;
    }
    
    public int[] selection(){
        int temp[]=new int[n];
        contador=0;
        System.arraycopy(v,0,temp,0,n);
 
        double inicio = System.currentTimeMillis();
        for (int i=0;i<n-1;i++){
            // Find the minimum element in unsorted array
            int min_idx = i;
            for(int j=i+1;j<n;j++){
                contador++;
                if (temp[j]<temp[min_idx]) min_idx=j;
            }
 
            // Swap the found minimum element with the first
            // element
            int aux = temp[min_idx];
            temp[min_idx] = temp[i];
            temp[i] = aux;
        }
        double fin = System.currentTimeMillis();
        
        datos[1][3]=Double.toString((double) ((fin - inicio)/1000));
        datos[2][3]=new Operaciones().recorte(contador);
        
        return temp;
    }
    
    public int[] shell(){
        int temp[]=new int[n];
        contador=0;
        boolean entry=false;
        System.arraycopy(v,0,temp,0,n);
 
        double inicio = System.currentTimeMillis();
        for (int gap=n/2;gap>0;gap/=2){
            // Do a gapped insertion sort for this gap size.
            // The first gap elements a[0..gap-1] are already
            // in gapped order keep adding one more element
            // until the entire array is gap sorted
            for(int i=gap;i<n;i+=1){
                // add a[i] to the elements that have been gap
                // sorted save a[i] in temp and make a hole at
                // position i
                int aux=temp[i];
 
                // shift earlier gap-sorted elements up until
                // the correct location for a[i] is found
                int j;
                contador+=2;
                for (j=i;j>=gap && temp[j-gap]>aux;j-=gap){
                    contador+=2; //2 comparaciones en el for
                    temp[j]=temp[j-gap];
                    entry=true;
                }
                if(entry) contador-=2;
 
                // put temp (the original a[i]) in its correct
                // location
                temp[j]=aux;
            }
        }
        double fin = System.currentTimeMillis();
        
        datos[1][4]=Double.toString((double) ((fin - inicio)/1000));
        datos[2][4]=new Operaciones().recorte(contador);
        
        return temp;
    }
        
    public void mergeUtil2(int arr[],int l,int m,int r){
        // Find sizes of two subarrays to be merged
        int n1=m-l+1;
        int n2=r-m;
  
        /* Create temp arrays */
        int L[]=new int[n1];
        int R[]=new int[n2];
  
        /*Copy data to temp arrays*/
        for(int i=0;i<n1;++i){
            L[i]=arr[l+i];
        }
            
        for(int j=0;j<n2;++j){
            R[j]=arr[m+1+j];
        }
            
        /* Merge the temp arrays */
  
        // Initial indexes of first and second subarrays
        int i=0,j=0;
  
        // Initial index of merged subarray array
        int k=l;
        while(i<n1 && j<n2){
            contador++;
            if(L[i]<=R[j]){
                arr[k]=L[i];
                i++;
            }
            else {
                arr[k]=R[j];
                j++;
            }
            k++;
        }
  
        /* Copy remaining elements of L[] if any */
        while(i<n1){
            arr[k]=L[i];
            i++;
            k++;
        }
  
        /* Copy remaining elements of R[] if any */
        while(j<n2){
            arr[k]=R[j];
            j++;
            k++;
        }
    }    
        
    public int[] mergeUtil1(int temp[],int l, int r){
        if (l<r) {
            // Find the middle point
            int m=l+(r-l)/2;
  
            // Sort first and second halves
            mergeUtil1(temp,l,m);
            mergeUtil1(temp,m+1,r);
  
            // Merge the sorted halves
            mergeUtil2(temp,l,m,r);
        }
        return temp;
    }
    
    public int[] merge(){
        int temp[]=new int[n];
        contador=0;
        System.arraycopy(v,0,temp,0,n);
        
        double inicio = System.currentTimeMillis();
        temp=mergeUtil1(temp,0,n-1);
        double fin = System.currentTimeMillis();
        
        datos[1][5]=Double.toString((double) ((fin - inicio)/1000));
        datos[2][5]=new Operaciones().recorte(contador);
        return temp;
    }

    /* This function takes last element as pivot, places
       the pivot element at its correct position in sorted
       array, and places all smaller (smaller than pivot)
       to left of pivot and all greater elements to right
       of pivot */
    public int partition(int[] arr,int low,int high){

        // pivot
        int pivot=arr[high]; 

        // Index of smaller element and
        // indicates the right position
        // of pivot found so far
        int i=(low-1); 

        for(int j=low;j<=high-1;j++){

            // If current element is smaller 
            // than the pivot
            contador++;
            if (arr[j] < pivot){

                // Increment index of 
                // smaller element
                i++; 
                
                int aux = arr[i];
                arr[i] = arr[j];
                arr[j] = aux;
            }
        }
        
        int aux = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = aux;
        
        return(i + 1);
    }

    /* The main function that implements QuickSort
              arr[] --> Array to be sorted,
              low --> Starting index,
              high --> Ending index
     */
    public int[] quickSortFunc(int[] arr, int low, int high){
        if (low < high) {

            // pi is partitioning index, arr[p]
            // is now at right place 
            int pi = partition(arr, low, high);

            // Separately sort elements before
            // partition and after partition
            quickSortFunc(arr, low, pi - 1);
            quickSortFunc(arr, pi + 1, high);
        }
        
        return arr;
    }
    
    public int[] quick(){
        int temp[]=new int[n];
        contador=0;
        System.arraycopy(v,0,temp,0,n);
        
        double inicio = System.currentTimeMillis();
        temp=quickSortFunc(temp,0,n-1);
        double fin = System.currentTimeMillis();
        
        datos[1][6]=Double.toString((double) ((fin - inicio)/1000));
        datos[2][6]=new Operaciones().recorte(contador);
        return temp;
    }
}
