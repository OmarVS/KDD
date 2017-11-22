/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apps;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 *
 * @author omar
 */
public class CombinatedData {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try{
            System.out.println("Ingrese nombre del archivo:");
            String archivo;
            Scanner entradaEscaner = new Scanner (System.in);
            archivo = entradaEscaner.nextLine ();
            File entrada=new File(archivo);
            FileReader fr = new FileReader (entrada);
            BufferedReader br = new BufferedReader(fr);
            FileWriter salida=new FileWriter("salida.csv");
            PrintWriter pw = new PrintWriter(salida);
            String linea;
            int valor=0;
            while((linea = br.readLine())!=null){
                if (linea.contains(":")){
                    String datos[]=linea.split(":");
                    valor=Integer.parseInt(datos[0]);
                }
                else {
                    datos=linea.split(",");
                    //String cadena=valor+","+linea;
                    String cadena="\""+valor+"\",\""+datos[0]+"\","+datos[1]+",\""+datos[2]+"\"";
                    pw.println(cadena);
                    System.out.println(cadena);
                }
            }
        }catch(IOException e){}
        
    }
    
}
