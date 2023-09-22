import java.util.*;
import java.io.*;

public class Sistema{
    public static void main(String[] args ) throws InterruptedException  {
        int menu, opc;
        String[] dias = {"Lunes","Martes","Miércoles","Jueves","Viernes","Sábado"};
        Integer[] horas = {7,8,9,10,11,12,13,14,15,16,17,18,19,20,21};

        ArrayList<Curso> cursos = new ArrayList<Curso>();
        ArrayList<Salon> salones = new ArrayList<Salon>();
        Scanner scan = new Scanner(System.in); 
        boolean primeraLinea= true , continuar=true;

        String[][] matrizSalon = new String[horas.length][dias.length];

        String salonesCSV = "salones.csv";
        String cursosCSV = "cursos.csv";
        
        System.out.println("BIENVENIO AL SISTEMA DE GESTIÓN DE SALONES\nSus documentos se están cargando...");
        Thread.sleep(1000);

        try (BufferedReader br = new BufferedReader(new FileReader(salonesCSV))) {
            String linea;

            while ((linea = br.readLine()) != null) {
                
                if (primeraLinea) {
                    // Saltar la primera línea (encabezados)
                    primeraLinea = false;
                    continue;
                }

                // Dividir la línea en columnas utilizando la coma como separador
                String[] columnas = linea.split(",");
        
                if (columnas.length == 5) {
                    String id_sede = columnas[0];
                    String edificio = columnas[1];
                    String nivel = columnas[2];
                    String id_salon = columnas[3];
                    String capacidad = columnas[4];
        
                    // Crear un objeto Salon y agregarlo a la lista
                    salones.add(new Salon(Integer.valueOf(id_salon), Integer.valueOf(id_sede), Integer.valueOf(nivel), Integer.valueOf(capacidad), edificio.charAt(0)));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (BufferedReader br = new BufferedReader(new FileReader(cursosCSV))) {
            String linea;
            primeraLinea= true;

            while ((linea = br.readLine()) != null) {
                
                if (primeraLinea) {
                    // Saltar la primera línea (encabezados)
                    primeraLinea = false;
                    continue;
                }

                // Dividir la línea en columnas utilizando la coma como separador
                String[] columnas = linea.split(",");
        
                if (columnas.length == 7) {
                    String id_curso = columnas[0];
                    String id_sede = columnas[1];
                    String nombre_curso = columnas[2];
                    String horario = columnas[3];
                    String duracion = columnas[4];
                    String stringDias = columnas[5];
                    String[] valoresDias = stringDias.split(";");
                    ArrayList<String> diasCursos = new ArrayList<>(Arrays.asList(valoresDias));

                    String cantidad_estudiante = columnas[6];
        
                    // Crear un objeto Salon y agregarlo a la lista
                    cursos.add(new Curso(Integer.valueOf(id_curso),Integer.valueOf(id_sede),Integer.valueOf(horario),Integer.valueOf(duracion), diasCursos ,Integer.valueOf(cantidad_estudiante),nombre_curso));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Archivo " + salonesCSV + " y archivo " + cursosCSV + " han sido cargados de forma exitosa");
        //MENU DE OPCIONES
        
        while(continuar){
            System.out.println("Seleccione una opcion para continuar:\n1) Consultar un salón\n2) Consultar un curso\n3) Asignar salon\n4) Ver el informe\n5) Salir");
            menu = scan.nextInt();
            scan.nextLine();

            switch(menu){
                case 1:
                    System.out.println("BIENVENIDO A CONSULTAR UN SALON");
                    
                    break;
                case 2:
                    System.out.println("BIENVENIDO A CONSULTAR UN CURSO");
                    break;
                case 3:
                    System.out.println("BIENVENIDO A LA ASIGNACION DE SALON");
                    break;
                case 4:
                    System.out.println("BIENVENIDO AL INFORME");
                    System.out.println("Porfavor seleccione una opción");
                    break;
                case 5:
                    System.out.println("Saliendo del programa....");
                    continuar=false;
                    break;
            }
        }

        scan.close();
    }
}