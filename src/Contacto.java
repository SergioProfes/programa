/**
 * Clase auxiliar para guardar contactos
 * @author desconocido
 * @since 10/01/2024
 */
public class Contacto {
    private String nombre;
    private String numero;

    public Contacto(String nombre, String numero) {
        this.nombre = nombre;
        this.numero = numero;
    }

    /**
     * @return nombre del contacto
     */
    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNumero() {
        return this.numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    /**
     *
     * @return Contacto aplanado
     */
    @Override
    public String toString() {
        return "Nombre: " + this.nombre + "\n" +
                "Número: " + this.numero + "\n";
    }
}
