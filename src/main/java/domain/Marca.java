
package domain;

/**
 *
 * @author pc
 */
public class Marca {
     private String nombre;
    private String pais;

    public Marca(String nombre, String pais) {
        this.nombre = nombre;
        this.pais = pais;
    }

    public Marca() {
    }
   
    public Marca(String descripcion) {
        this.nombre = descripcion;
    }

    public String getDescripcion() {
        return nombre;
    }
    
}
