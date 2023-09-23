import java.util.ArrayList;

public class Curso {
    int id_curso, id_sede, horario, duracion, cantidad_estudiates, id_salon;
    ArrayList<String> dias = new ArrayList<String>();
    String nombre_curso;

    public Curso(int id_curso, int id_sede, int horario, int duracion, ArrayList<String> dias, int cantidad_estudiates, String nombre_curso) {
        this.id_curso = id_curso;
        this.id_sede = id_sede;
        this.horario = horario;
        this.duracion = duracion;
        this.dias = dias;
        this.cantidad_estudiates = cantidad_estudiates;
        this.nombre_curso = nombre_curso;
    }

    public int getId_curso() {
        return id_curso;
    }

    public int getId_sede() {
        return id_sede;
    }

    public int getHorario() {
        return horario;
    }

    public int getDuracion() {
        return duracion;
    }

    public ArrayList<String> getDias() {
        return dias;
    }

    public int getCantidad_estudiates() {
        return cantidad_estudiates;
    }

    public int getId_salon() {
        return id_salon;
    }

    public String getNombre_curso() {
        return nombre_curso;
    }


    public void setId_salon(int id_salon) {
        this.id_salon = id_salon;
    }

@Override
public String toString() {
    return "ID: " + id_curso + "\n" +
           "Sede: " + id_sede + "\n" +
           "Nombre Curso: " + nombre_curso + "\n" +
           "Horario: " + horario + "\n" +
           "Dias: " + dias + "\n" + 
           "Salon: " + id_salon + "\n" + 
           "Cantidad Estudiantes: " + cantidad_estudiates;
}



    
}
