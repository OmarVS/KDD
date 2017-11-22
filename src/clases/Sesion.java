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
public class Sesion {
    private int ID;
    private Fecha inicio;
    
    public Sesion(int ID, Fecha fecha){
        this.ID=ID;
        inicio = fecha;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public Fecha getInicio() {
        return inicio;
    }

    public void setInicio(Fecha inicio) {
        this.inicio = inicio;
    }
    
    public boolean pertenece(Fecha fecha){
        if (fecha.getHoras()<inicio.getHoras()) return false;
        if (fecha.getHoras()==inicio.getHoras()){
            if (fecha.getMinutos()<=(inicio.getMinutos()+30)) return true;
            else return false;
        }
        if (fecha.getHoras()>inicio.getHoras()){
            int minutos=fecha.getMinutos()+60;
            if ((minutos-inicio.getMinutos())<=30) return true;
            else return false;
        }
        return false;
    }
    
}
