/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Alfredo
 */
public class AdministradorModel {
    int id;

    public AdministradorModel(int id) {
        this.id = id;
    }

    public AdministradorModel() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Administrador{" + "id=" + id + '}';
    }
    
}
