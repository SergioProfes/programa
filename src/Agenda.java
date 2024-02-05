import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase que realiza una Agenda
 */
public class Agenda {
    private List<Contacto> contactos;

    /**
     * Contructor de la calse
     */
    public Agenda() {
        contactos = new ArrayList<>();
    }

    /**
     * @return Lista de contactos
     */
    public List<Contacto> getContactos() {
        return this.contactos;
    }

    public void setContactos(List<Contacto> contactos) {
        this.contactos = contactos;
    }

    public void insertar(String nombre, String numero) {
        Contacto contacto = new Contacto(nombre, numero);
        this.contactos.add(contacto);
    }

    public String buscar(String nombre) {
        for (int i = 0; i < this.contactos.size(); i++) {
            if (this.contactos.get(i).getNombre().equalsIgnoreCase(nombre)) {
                return this.getContactos().get(i).getNumero();
            }
        }
        return "No se ha encontrado ningún contacto con ese nombre.";
    }

    public int longitud() {
        return this.contactos.size();
    }

    public String ver() {
        String agenda_completa = "";
        for (int i = 0; i < this.contactos.size(); i++) {
            agenda_completa += this.contactos.get(i).toString();
        }
        return agenda_completa;
    }

    public void borrar(String nombre) {
        for (int i = 0; i < this.contactos.size(); i++) {
            if (this.contactos.get(i).getNombre().equalsIgnoreCase(nombre)) {
                this.getContactos().remove(i);
                i--; //borramos el indice para que no dé error si borramos el último número
            }
        }
    }

    public void modificar(String nombre, String numero) {
        for (int i = 0; i < this.contactos.size(); i++) {
            if (this.contactos.get(i).getNombre().equalsIgnoreCase(nombre)) {
                this.getContactos().get(i).setNumero(numero);
                return;
            }
        }
        System.out.println("No hay ningún contacto con este nombre.");
    }

    public String[][] exportar() {
        String[][] lista_contactos = new String[this.contactos.size()][2];
        for (int i = 0; i < lista_contactos.length; i++) {
            lista_contactos[i][0] = this.contactos.get(i).getNombre();
            lista_contactos[i][1] = this.contactos.get(i).getNumero();
        }
        return lista_contactos;
    }

    public void cargar(String ruta) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(ruta));
        String linea = bufferedReader.readLine();
        String[] linea_array;

        while (linea != null) {
            linea_array = linea.split(",");
            insertar(linea_array[0], linea_array[1]);
            linea = bufferedReader.readLine();
        }
        bufferedReader.close();
    }

    public void grabar(String ruta) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(ruta));
        String linea = "";

        for (int i = 0; i < this.contactos.size(); i++) {
            linea = this.contactos.get(i).getNombre() + "," + this.contactos.get(i).getNumero();
            bufferedWriter.write(linea);
            bufferedWriter.newLine();
        }
        bufferedWriter.close();
    }
}
