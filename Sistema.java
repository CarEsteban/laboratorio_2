import java.util.*;


import java.io.*;

public class Sistema{
    public static void main(String[] args ) throws InterruptedException  {
        int menu, opc, idCurso, numeroDia=0;
        String searchEdificio, idSede,searchNivel,idSalon;
        String[] dias = {"","Lunes","Martes","Mie","Jueves","Viernes","Sábado"};
        Integer[] horas = {0,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21};


        ArrayList<Curso> cursos = new ArrayList<Curso>();
        ArrayList<Salon> salones = new ArrayList<Salon>();
        Scanner scan = new Scanner(System.in); 
        boolean primeraLinea= true , continuar=true, encontrado=false;

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
            ArrayList<String> diasCursos;
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
                    String dia = columnas[5];
                    

                    String cantidad_estudiante = columnas[6];
        
                    // Crear un objeto Salon y agregarlo a la lista
                    cursos.add(new Curso(Integer.valueOf(id_curso),Integer.valueOf(id_sede),Integer.valueOf(horario),Integer.valueOf(duracion), dia ,Integer.valueOf(cantidad_estudiante),nombre_curso));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Archivo " + salonesCSV + " y archivo " + cursosCSV + " han sido cargados de forma exitosa");
        //MENU DE OPCIONES
        
        while(continuar){
            System.out.println("Seleccione una opcion para continuar:\n1) Asignar salon\n2) Consultar un curso\n3) Consultar un salón\n4) Ver el informe\n5) Salir");
            menu = scan.nextInt();
            scan.nextLine();

            switch(menu){
                case 2:
                    System.out.println("BIENVENIDO A CONSULTAR UN CURSO");
                    System.out.println("Porfavor ingrese el ID del curso para ver la información");
                    idCurso = scan.nextInt();
                    scan.nextLine();

                    System.out.println(cursos.get(idCurso-1).toString());


                    break;
                case 1:

                    System.out.println("BIENVENIDO A LA ASIGNACION DE SALON");
                    System.out.println("Ingrese el ID del curso a asignar:");
                    int idCursoAsignar = scan.nextInt();
                    scan.nextLine();
                
                    Curso cursoAsignar = null;
                    for (Curso curso : cursos) {
                        if (curso.getId_curso() == idCursoAsignar) {
                            cursoAsignar = curso;
                            break;
                        }
                    }
                
                    if (cursoAsignar != null) {
                        System.out.println("Ingrese el ID del salón:");
                        int idSalonAsignar = scan.nextInt();
                        scan.nextLine();
                
                        // Buscar el salón por ID
                        Salon salonAsignar = null;
                        for (Salon salon : salones) {
                            if (salon.getId_salon() == idSalonAsignar) {
                                salonAsignar = salon;
                                break;
                            }
                        }
                
                        if (salonAsignar != null) {
                            System.out.println("La hora de inicio será : " + cursoAsignar.getHorario());
                            int horaAsignar = cursoAsignar.getHorario();
                
                            System.out.println("Los dias de la semana serán: "+cursoAsignar.getDia());
                            String diaAsignar = cursoAsignar.getDia();
                
                            if (horaAsignar >= 7 && horaAsignar <= 21) {
                
                                int filaMatriz = horaAsignar - 6; 
                                if (diaAsignar.equals("lunes")) {
                                    numeroDia = 1;
                                } else if (diaAsignar.equals("martes")) {
                                    numeroDia = 2;
                                } else if (diaAsignar.equals("miercoles")) {
                                    numeroDia = 3;
                                } else if (diaAsignar.equals("jueves")) {
                                    numeroDia = 4;
                                } else if (diaAsignar.equals("viernes")) {
                                    numeroDia = 5;
                                } else if (diaAsignar.equals("sabado")) {
                                    numeroDia = 6;
                                } else {
                                    System.out.println("Nombre del día no válido.");
                                }
                                int columnaMatriz = numeroDia;
                
                                matrizSalon[filaMatriz][columnaMatriz] = cursoAsignar.getNombre_curso();
                
                                System.out.println("Curso asignado exitosamente.");
                            } else {
                                System.out.println("Hora o día ingresados no válidos.");
                            }
                        } else {
                            System.out.println("Salón no encontrado.");
                        }
                    } else {
                        System.out.println("Curso no encontrado.");
                    }
                    break;
                
                case 3:
                    System.out.println("BIENVENIDO A CONSULTAR UN SALON");
                    System.out.println("Ingrese el ID de la sede");
                    idSede = String.valueOf(scan.nextInt());
                    scan.nextLine();
                    System.out.println("Ingrese el ID del salon");
                    idSalon = String.valueOf(scan.nextInt());
                    scan.nextLine();
                    System.out.println("Ingrese el edificio");
                    searchEdificio = scan.nextLine();
                    System.out.println("Ingrese el nivel del salon");
                    searchNivel = String.valueOf(scan.nextInt());
                    scan.nextLine();

                    if (idSede.isEmpty() || idSalon.isEmpty() || searchEdificio.isEmpty() || searchNivel.isEmpty()) {
                        System.out.println("Por favor, ingrese valores válidos para la búsqueda.");
                    } else {        
                        try (BufferedReader br = new BufferedReader(new FileReader(salonesCSV))) {
                            String linea;
                            int x = 0;
                            int indexSalon = -1;

                            // Leer el archivo línea por línea
                            while ((linea = br.readLine()) != null) {
                                String[] columnas = linea.split(",");

                                if (columnas.length == 5 &&
                                    columnas[0].trim().equals(idSede) &&
                                    columnas[1].trim().equals(searchEdificio) &&
                                    columnas[2].trim().equals(searchNivel) &&
                                    columnas[3].trim().equals(idSalon)) 
                                {
                                    encontrado = true;
                                    indexSalon = x;
                                    break; 
                                }
                                x++;
                            }

                            if (indexSalon != -1) {
                                    System.out.println("Salón encontrado:\n\t" + salones.get(indexSalon-1).toString());
                                   
                    
                                // Llenar la matriz
                                for (int i = 0; i < horas.length; i++) {
                                    for (int j = 0; j < dias.length; j++) {
                                        if (i == 0 && j == 0) {
                                            matrizSalon[i][j] = ""; 
                                        } else if (i == 0) {
                                            matrizSalon[i][j] = dias[j]; 
                                        } else if (j == 0) {
                                            matrizSalon[i][j] = "Hora " + horas[i]; 
                                        } else {
                                            matrizSalon[i][j] = "libre"; 
                                        }
                                    }
                                }
                                // Imprimir la matriz
                                for (int i = 0; i < horas.length; i++) {
                                    for (int j = 0; j < dias.length; j++) {
                                        System.out.print(matrizSalon[i][j] + "\t");
                                    }
                                    System.out.println(); // Saltar a la siguiente línea después de cada fila
                                }
                            }else{
                                System.out.println("Salón no encontrado.");
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                    }
                        
                    
                    break;
                
                
                case 4:
                    System.out.println("BIENVENIDO AL INFORME");
                    System.out.println("Seleccione una opción:\n" + "1. Listado de cursos que no se les pudo asignar salón.\n" +
                                                                    "2. Listado de cursos a los que sí se les pudo asignar salón.\n" +
                                                                    "3. Exportar resultado: Se podrá exportar un archivo, en donde se encuentre la relación salón - curso.\n" +
                                                                    "4. Salir\n" +
                                                                    "Ingrese el número de opción:");
                    
                    menu = scan.nextInt();scan.nextLine();

                    switch (menu) {
                        case 1:
                            System.out.println("CURSOS SIN SALON");
                            for (int i = 0; i < cursos.size(); i++) {
                                if(cursos.get(i).getId_salon() == 0 ){
                                    System.out.println(cursos.get(i).getNombre_curso());
                                }
                            }
                            break;
                        case 2:
                            System.out.println("CURSOS CON SALON");
                            for (int i = 0; i < cursos.size(); i++) {
                                if(cursos.get(i).getId_salon() != 0 ){
                                    System.out.println(cursos.get(i).getNombre_curso());
                                }
                            }
                            break;
                        case 3:
                            System.out.println("EXPORTAR CSV");
                            try (BufferedWriter writer = new BufferedWriter(new FileWriter("exportacion.csv"))) {
                                
                                writer.write("Salon,Cursos\n");
                            
                                for (Salon salon : salones) {
                                    int id = salon.getId_salon(); 
                                    ArrayList<Curso> curs = salon.getCursos(); 
                            
                                    // Escribir los valores en el archivo CSV
                                    writer.write(id + "," + curs + "\n");
                                }

                                
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            
                            break;
                        case 4:
                            break;
                        default:
                            System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
                            break;
                    }
                    
                    
                    
                    break;
                case 5:
                    System.out.println("Saliendo del programa....");
                    continuar=false;
                    break;
                default:
                    System.out.println("Opcion no valida");
                    break;
            }

            System.out.println("Desea regresar al menu? 1)Si 2)No");
            opc = scan.nextInt();
            scan.nextLine();
            if(opc==1){
                continuar=true;
            }else if(opc==2){
                System.out.println("Saliendo del programa....");
                continuar=false;
            }else{
                System.out.println("opcion no valida");
                continuar=false;
            }

        }

        scan.close();
    }
}