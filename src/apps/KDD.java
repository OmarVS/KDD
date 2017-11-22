/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apps;

import java.util.Scanner;

/**
 *
 * @author omar
 */
public class KDD {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("¿Que desea hacer?\n"+
                            "1) Convertir archivo CombinatedData a .csv\n"+
                            "2) Convertir archivo WebLob a .csv");
        Scanner entradaEscaner = new Scanner (System.in);
        String opcion = entradaEscaner.nextLine ();
        switch (opcion){
            case "1":
                CombinatedData.main(null);
                break;
            case "2":
                WebLog.main(null);
                break;
            default:
                System.out.println("La opcion ingresada no es valida.");
                break;
        }
    }
    
}
