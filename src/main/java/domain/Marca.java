/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

/**
 *
 * @author Fernando Elias
 */
public class Marca {
     private String nombre;
    private String pais;

    public Marca(String nombre, String pais) {
        this.nombre = nombre;
        this.pais = pais;
    }

    

    public Marca(String descripcion) {
        this.nombre = descripcion;
    }

    public String getDescripcion() {
        return nombre;
    }
}
