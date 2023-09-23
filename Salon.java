import java.util.ArrayList;

public class Salon {


    int id_salon, id_sede, nivel, capacidad,filaMatriz,columnaMatriz;
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

    
    public ArrayList<Curso> getCursos() {
        return cursos;
    } 

    public void setFilaMatriz(int filaMatriz){
        this.filaMatriz = filaMatriz;
    }

    public int getFilaMatriz(){
        return filaMatriz;
    }

    public void setcolumnaMatriz(int columnaMatriz){
        this.columnaMatriz = columnaMatriz;
    }

    public int getcolumnaMatriz(){
        return columnaMatriz;
    }
    
    
    @Override
    public String toString() {
        return "Salón de ID: " + id_salon + ", se encuentra en el edificio " + edificio + " en la sede con ID " + id_sede + " en el nivel " + nivel +  " con capcidad de " + capacidad + " personas.";
    }


    
    
}
