/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Alfredo
 */
public class EspecialidadModel {
    int id;
    String nombre;

    public EspecialidadModel(String nombre) {
        this.nombre = nombre;
    }

    public EspecialidadModel() {
        
    }

    public EspecialidadModel(int id, String cirujanomod) {
        this.id = id;
        this.nombre = cirujanomod;
    }

    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "EspecialidadModel{" + "id=" + id + ", nombre=" + nombre + '}';
    }
    
    
}
