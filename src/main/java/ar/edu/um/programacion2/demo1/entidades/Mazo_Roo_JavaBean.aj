// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package ar.edu.um.programacion2.demo1.entidades;

import ar.edu.um.programacion2.demo1.entidades.Carta;
import ar.edu.um.programacion2.demo1.entidades.Mazo;
import java.util.Set;

privileged aspect Mazo_Roo_JavaBean {
    
    public String Mazo.getNombre() {
        return this.nombre;
    }
    
    public void Mazo.setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public Set<Carta> Mazo.getCartas() {
        return this.cartas;
    }
    
    public void Mazo.setCartas(Set<Carta> cartas) {
        this.cartas = cartas;
    }
    
}