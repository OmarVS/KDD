/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apps;

import clases.*;
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
public class WebLog {

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
            int cont=1;
            String linea;
            linea = br.readLine();
            String datos[]=linea.split(",");
            IP ip=new IP(datos[0],datos[1],datos[2]);
            Sesion sesion=new Sesion(cont,ip.getFecha());
            pw.println(ip.getIP()+","+sesion.getID()+","+ip.getInstancia());
            while((linea = br.readLine())!=null){
                datos=linea.split(",");
                if(datos[0].equals(ip.getIP())){
                    if (sesion.pertenece(new Fecha(datos[1]))){
                        ip.setFecha(new Fecha(datos[1]));
                        ip.setInstancia(datos[2]);
                        pw.println(ip.getIP()+","+sesion.getID()+","+ip.getInstancia());
                        System.out.println(ip.getIP()+","+sesion.getID()+","+ip.getInstancia());
                    }
                    else{
                        cont++;
                        ip.setFecha(new Fecha(datos[1]));
                        ip.setInstancia(datos[2]);
                        sesion.setID(cont);
                        sesion.setInicio(new Fecha(datos[1]));
                        pw.println(ip.getIP()+","+sesion.getID()+","+ip.getInstancia());
                        System.out.println(ip.getIP()+","+sesion.getID()+","+ip.getInstancia());
                    }
                }
                else{
                    cont=1;
                    ip.setIP(datos[0]);
                    ip.setFecha(new Fecha(datos[1]));
                    ip.setInstancia(datos[2]);
                    sesion.setID(cont);
                    sesion.setInicio(ip.getFecha());
                    pw.println(ip.getIP()+","+sesion.getID()+","+ip.getInstancia());
                    System.out.println(ip.getIP()+","+sesion.getID()+","+ip.getInstancia());
                }
            }
            fr.close();
            pw.close();
        }catch(IOException e){}
    }
    
}
