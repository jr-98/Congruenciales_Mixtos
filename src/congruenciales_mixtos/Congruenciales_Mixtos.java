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
        boolean estado = false;
        int cont = 0;
        ///matrices
        Double[] matriz;
        Double[] matriza;
        Double[] matrizb;
        int seed = Xn;
        while (count1 <= 200) {//condicional
            limit = Xn;//limit toma el ultimo valor de la semilla
            residue = ((Xn * a) + c) % modulo;
            //System.out.println("re"+residue);
            Xn = residue;//La semilla toma el resultado del la seria para continuar calculado
            vecN[i] = count1;
            vecXn[i] = limit;
            vecXnTotal[i] = Xn;
            if (vecXnTotal[i] == seed) {
                break;
            }
            count1++;
            i++;

        }
        //Concatenacion de resultados
        for (int k = 0; k < count1; k++) {
            if (k < 1) {
                System.out.println("___________________________________________________________");
                System.out.println("___________________________________________________________");
                System.out.println(vecN[k] + "\t" + vecXn[k] + "\t" + vecXn[k] + " + " + vecXnTotal[k] + "/" + modulo + "\t" + vecXnTotal[k] + "\t" + vecXnTotal[k] + "/" + modulo);
            } else {
                System.out.print(vecN[k] + "\t" + vecXn[k] + "\t" + vecXn[k] + " + " + vecXnTotal[k] + "/" + modulo + "\t" + vecXnTotal[k] + "\t" + vecXnTotal[k] + "/" + modulo + "\n");
            }
        }
        int limite = 200;
        System.out.println("___________________________________________________________"); //Creamos dos vectores y generamos pares por su posicion de la
        matriza = new Double[limite - 1];
        matrizb = new Double[limite - 1];
        for (int k = 0; k < limite; k++) {
            //System.out.println(matriz.length); 
            //System.out.println(matriz[n]); 
            if (k < limite - 1) {
                matriza[k] = vecXnTotal[k];
                matrizb[k] = vecXnTotal[k + 1];
            }
        }
        String parejas = "<html><body>";
        for (int k = 0; k < limite - 1; k++) {
            //System.out.println(matriz.length); 
            //System.out.println(matriza[n]+""+matrizb[n]); 
            //parejas+= "<br>"+matriza[n]+"       "+matrizb[n];
            parejas += "<br>[" + matriza[k] + "],[" + matrizb[k] + "]";
        }
        parejas += "</body></html>";
        System.out.println(" parejas\n" + parejas + "\n");

        //Creamos la matriz la cual se va a calcular el numero de repeticiones 
        //por ahora lo llenamos de ceros
        int[] matrizZ = new int[25];
        for (int k = 0; k < 25; k++) {
            matrizZ[k] = 0;
        }

        //Ahora llenamos el numero de repeticiones se ha considerado una matriz
        //de 5*5
        for (int k = 0; k < limite - 1; k++) {
            //nos devuelve la posicion en X
            int x1 = devuelvePosicion(matriza[k]);
            //nos devuelve la posicion en Y
            int y1 = devuelvePosicion(matrizb[k]);
            //nos devuelve la posicion enumerados de 0 a 24 cuadros
            int pos = x1 + y1 * (5);
            //aumentamos un valor de acuerdo a la posicion que se calculo
            matrizZ[pos] += 1;
        }

        String serie = "<html><body>F Obs";
        int cont = 1;
        for (int k = 0; k < 25; k++) {
            System.out.println(matrizZ[k]);
            serie += "<br>" + cont + "[" + matrizZ[k] + "]";
            cont++;
        }
        serie += "</body></html>";
        lblFO.setText(serie);

//                    for (int n=0; n<25; n++){
//                        System.out.println(matrizZ[n]); 
//                    }
        //Calculamos el valor de la frecuencia esperada
        double freEsperada = ((double) limite - 1) / 25;
        //Calculamos el valor de la frecuencia esperada
        lblFE.setText("Frecuencia Esperada: " + freEsperada);

        //Creamos un vector el cual va a tomar los valores correspondientes
        //al chi cuadrada
        Double[] chiCuadrado = new Double[25];
        String serieChi = "<html><body>Serie Chi";
        int cont2 = 1;
        for (int k = 0; k < 25; k++) {
            chiCuadrado[k] = ((freEsperada - matrizZ[k]) * (freEsperada - matrizZ[k])) / freEsperada;
            serieChi += "<br>" + cont2 + "[" + chiCuadrado[k] + "]";
            cont2++;
        }
        serieChi += "</body></html>";
        lblChiSerie.setText(serieChi);

//                    for (int n=0; n<25; n++){
//                        chiCuadrado[n]=((freEsperada-matrizZ[n])*(freEsperada-matrizZ[n]))/freEsperada;
//                    }
        //Realizamos la suma del del vector el cual tiene los valores del chi-cudrada
        double sumaChiCuadrado = 0;
        for (int k = 0; k < 25; k++) {
            //System.out.println(matrizZ[n]); 
            sumaChiCuadrado += chiCuadrado[k];

        }
        //Realizamos la verificacion con respecto al valor de la tabla de chi-cuadrada
        lblChi.setText("Suma chi-cuadrada: " + sumaChiCuadrado);
        if (sumaChiCuadrado <= 36.415) {
            lblDependencia.setText("Se acepta la dependencia: " + sumaChiCuadrado + " es menor a: " + 36.415);
        } else {
            lblDependencia.setText("Se rechaza la dependencia: " + sumaChiCuadrado + " es mayor a: " + 36.415);
        }
    }

}
