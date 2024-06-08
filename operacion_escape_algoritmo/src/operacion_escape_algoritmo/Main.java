package operacion_escape_algoritmo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//Clase principal del juego de preguntas y respuestas
public class Main {
	
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int score = 0; // Variable para llevar la cuenta del puntaje
        int habitacion = 0; // Variable para saber en que habitación está
        int vidas = 3; // Variable para saber cuanto intentos tiene el usuario para responder correctamente 
        
        Habitaciones habitaciones = new Habitaciones();

        // Obtener la lista de preguntas
        List<Pregunta> preguntas = obtenerPreguntas();

        // En este bucle se desarrollan todas las preguntas y se obtienen las respuestas del usuario
        for (Pregunta pregunta : preguntas) {
        	System.out.println("Responde a las siguiente pregunta para poder avanzar a la siguiente habitación: ");
            System.out.println(pregunta.getEnunciado());
            for (String opcion : pregunta.getOpciones()) {
                System.out.println(opcion);
            }
            
            System.out.print("¿Cuál es tu respuesta? ");
            
            String respuesta = scanner.nextLine();
            if (respuesta.equalsIgnoreCase(String.valueOf(pregunta.getRespuestaCorrecta()))) {
                score++; // Suma 1 al score
                habitacion++; // Suma 1 a la habitación donde se encuentre
                System.out.println("Respuesta correcta, puedes avanzar!");
                System.out.println("");
            }
            else {
                vidas = getRespuestaIncorrecta(vidas); // Actualiza el valor de vidas
                System.out.println("PIERDES UNA VIDA (te quedan " + vidas +" vidas)");
                if (vidas <= 0) {
                    System.out.println("Te has quedado sin vidas. ¡Has perdido!");
                    break; // Termina el bucle si el jugador se queda sin vidas
                }
            }
            
            
 
            // se asigna la habitación en la que se encuentra actualmente el jugador
            habitaciones.setHabitacion(habitacion);
          
        }

        // Muestra el resultado final del jugador
        System.out.println("Has completado el cuestionario.");
        System.out.println("Tu puntaje es: " + score + " de " + preguntas.size() + ".");
        
        if(preguntas.size() == habitaciones.getHabitacion()){
        	System.out.println("¡Felicitaciones, has escapado!");        	
        } else {
        	System.out.println("La habitacion en la que quedaste es: " + habitaciones.getHabitacion() + ".");        	
        }

        scanner.close();
    }

    private static int getRespuestaIncorrecta(int vidas) {
		// TODO Auto-generated method stub
    	 System.out.println("Respuesta incorrecta! ");
    	
    	 return vidas - 1; // Resta 1 a vidas y devuelve el nuevo valor
		
	}

	// Método para crear y devolver la lista de preguntas
    public static List<Pregunta> obtenerPreguntas() {
        List<Pregunta> preguntas = new ArrayList<>(); // Crear una lista para almacenar las preguntas
        
        // Aquí se Añaden las preguntas a la lista
        preguntas.add(new Pregunta("¿Cuál es el resultado de 3 + 2 * 2 en Java?", 
                new String[]{"a) 7", "b) 10", "c) 8", "d) 9"}, 'a'));
        
        preguntas.add(new Pregunta("¿Qué palabra clave se utiliza para crear una subclase en Java?", 
                new String[]{"a) super", "b) this", "c) extends", "d) implements"}, 'c'));
        
        preguntas.add(new Pregunta("¿Cuál es el tipo de dato que devuelve el método compareTo en Java?", 
                new String[]{"a) boolean", "b) int", "c) double", "d) char"}, 'b'));
        
        preguntas.add(new Pregunta("¿Qué operador se usa para comparar dos valores en Java?", 
                new String[]{"a) =", "b) ==", "c) !=", "d) <>"}, 'b'));
        
        preguntas.add(new Pregunta("¿Qué interfaz debe implementarse para ordenar los objetos de una colección en Java?", 
                new String[]{"a) Serializable", "b) Comparable", "c) Comparator", "d) Iterable"}, 'b'));

        
        // Retorno de la lista de preguntas
        return preguntas;
    }
   
    
}
