import java.util.ArrayList;

public class Salon {


    int id_salon, id_sede, nivel, capacidad;
    char edificio;
    ArrayList<Curso> cursos;


    public Salon(int id_salon, int id_sede, int nivel, int capacidad, char edificio) {
        this.id_salon = id_salon;
        this.id_sede = id_sede;
        this.nivel = nivel;
        this.capacidad = capacidad;
        this.edificio = edificio;
    }


    public int getId_salon() {
        return id_salon;
    }


    public int getId_sede() {
        return id_sede;
    }


    public int getNivel() {
        return nivel;
    }


    public int getCapacidad() {
        return capacidad;
    }


    public char getEdificio() {
        return edificio;
    }


    public void setCursos(ArrayList<Curso> cursos) {
        this.cursos = cursos;
    }

    
    @Override
    public String toString() {
        return "Salon [id_salon=" + id_salon + ", id_sede=" + id_sede + ", nivel=" + nivel + ", capacidad=" + capacidad
                + ", edificio=" + edificio + ", cursos=" + cursos + "]";
    }
    
}
