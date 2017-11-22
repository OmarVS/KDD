/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

/**
 *
 * @author omar
 */
public class IP {
    private String IP;
    private Fecha fecha;
    private String instancia;
    
    public IP(String IP, String fecha, String instancia){
        this.IP=IP;
        this.fecha=new Fecha(fecha);
        this.instancia=instancia;
    }

    public String getIP() {
        return IP;
    }

    public void setIP(String IP) {
        this.IP = IP;
    }

    public Fecha getFecha() {
        return fecha;
    }

    public void setFecha(Fecha fecha) {
        this.fecha = fecha;
    }

    public String getInstancia() {
        return instancia;
    }

    public void setInstancia(String instancia) {
        this.instancia = instancia;
    }
    
    public String toString(){
        return getIP()+","+getFecha().toString()+","+getInstancia();
    }
}
