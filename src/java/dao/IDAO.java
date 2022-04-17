/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.util.List;

/**
 *
 * @author Alfredo
 */
public interface IDAO<T,K> {
    
    void insetar(T a);
    void modificar(T a);
    void eliminar(T a);
    List<T> obtenerTodos();
    T obtener(K id);
    
}
