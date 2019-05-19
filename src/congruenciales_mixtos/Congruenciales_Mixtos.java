/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package congruenciales_mixtos;

import javax.swing.JOptionPane;

/**
 *
 * @author @Jonathan_Tillaguango_J
 */
public class Congruenciales_Mixtos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Varuable de la exiación Xn+1= (a.Xn+c)mod m => Congruelcial mixta
        int n = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el tamaño de la serie que desea generar", "Congruencial mixto", JOptionPane.INFORMATION_MESSAGE));
        int a = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el multiplicador de la serie", "Congruencial mixto", JOptionPane.INFORMATION_MESSAGE));
        int Xn = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese la semilla (Xn) de la serie", "Congruencial mixto", JOptionPane.INFORMATION_MESSAGE));
        int c = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese la constante aditiva", "Congruencial mixto", JOptionPane.INFORMATION_MESSAGE));
        int modulo = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el módulo de la serie", "Congruencial mixto", JOptionPane.INFORMATION_MESSAGE));
        //Varibles para ejecucion de la formula 
        int count1 = 0, i = 0, j = 0;//Controla el numero de interacciones del programa
        int residue = 0, limit = 0;
        
        //vectores para presentar los resultados
        int[] vecN = new int[n];//psrs presentar los el numero de casos
        double[] vecXn = new double[n];
        double[] vecXnTotal = new double[n];//v
        boolean estado=false;
        int seed=Xn;
        while (count1<=n) {//condicional
            limit = Xn;//limit toma el ultimo valor de la semilla
            residue = ((Xn * a) + c) % modulo;
            //System.out.println("re"+residue);
            Xn = residue;//La semilla toma el resultado del la seria para continuar calculado
            vecN[i] = count1;
            vecXn[i] = limit;
            vecXnTotal[i]=Xn;  
            if(vecXnTotal[i]==seed){break;}
            count1++;
            i++;
           
        }
        //Concatenacion de resultados
        for (int k = 0; k <count1; k++) {
            if (k < 1) {
                System.out.println("___________________________________________________________");
                System.out.println("n\t"+"Xn\t"+"(5Xn+c/m)\t"+"Xn+1\t"+"Numeros Uniformes");
                  System.out.println("___________________________________________________________");
                System.out.println(vecN[k]+"\t"+vecXn[k]+"\t"+vecXn[k]+" + "+vecXnTotal[k]+"/"+modulo+"\t"+vecXnTotal[k]+"\t"+vecXnTotal[k]+"/"+modulo);
                }else{
                System.out.print(vecN[k]+"\t"+vecXn[k]+"\t"+vecXn[k]+" + "+vecXnTotal[k]+"/"+modulo+"\t"+vecXnTotal[k]+"\t"+vecXnTotal[k]+"/"+modulo+"\n");
            }
        }
        System.out.println("___________________________________________________________");
    }
}

