// public class codigoBasura {
    
//     // Definir el número de días y horas
//     int numDias = 6; 
//     int numHoras = 15; 

//     // Crear la matriz
//     String[][] matrizHorasDias = new String[numDias + 1][numHoras + 1] ;

//     // Llenar la matriz
//     for (int dia = 0; dia <= numDias; dia++) {
//         for (int hora = 0; hora <= numHoras; hora++) {
//             if (dia == 0 && hora == 0) {
//                 matrizHorasDias[dia][hora] = ""; // Esquina superior vacía
//             } else if (dia == 0) {
//                 matrizHorasDias[dia][hora] = "Hora " + (hora+6); // Primera fila con horas
//             } else if (hora == 0) {
//                 matrizHorasDias[dia][hora] = "Día " + dia; // Primera columna con días
//             } else {
//                 matrizHorasDias[dia][hora] = "libre"; // Resto de las celdas
//             }
//         }
//     }

//     // Imprimir la matriz
//     for (int fila = 0; fila <= numDias; fila++) {
//         for (int columna = 0; columna <= numHoras; columna++) {
//             System.out.print(matrizHorasDias[fila][columna] + "\t");
//         }
//         System.out.println(); // Saltar a la siguiente línea después de cada fila
//     }
// }
