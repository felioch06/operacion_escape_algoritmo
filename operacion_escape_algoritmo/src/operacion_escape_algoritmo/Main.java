package operacion_escape_algoritmo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Clase principal que maneja el flujo del juego operacion escape algoritmico.
 */
public class Main {
    /**
     * Método principal que inicia el juego operacion escape algoritmico.
     *
     * @param args Argumentos de la línea de comandos (no se utilizan).
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int score = 0; // Variable para llevar la cuenta del puntaje
        int habitacion = 0; // Variable para saber en qué habitación está
        int vidas = 3; // Variable para saber cuántos intentos tiene el usuario para responder correctamente
        int tiempoLimiteMinutos = 1; // Variable que define el límite de tiempo del jugador
        long tiempoInicial = System.currentTimeMillis() / 1000; // Variable que define el tiempo inicial
        
        Habitaciones habitaciones = new Habitaciones();

        // Obtener la lista de preguntas
        List<Pregunta> preguntas = obtenerPreguntas();

        // En este bucle se desarrollan todas las preguntas y se obtienen las respuestas del usuario
        for (Pregunta pregunta : preguntas) {
            // Se hace la conversión en segundos y el tiempo restante en segundos
            long tiempoTranscurridoSegundos = (System.currentTimeMillis() / 1000) - tiempoInicial;
            
            System.out.println(tiempoTranscurridoSegundos);
            int tiempoRestanteSegundos = (int) ((tiempoLimiteMinutos * 60) - tiempoTranscurridoSegundos);
            
            // Se valida si el tiempo se ha agotado
            if (tiempoRestanteSegundos <= 0) {
                System.out.println("Te has quedado sin tiempo. ¡Has perdido!");
                break; // Termina el bucle si se acaba el tiempo
            }
            
            System.out.println("Tiempo restante: " + tiempoRestanteSegundos + " segundos");
            
            System.out.println("Responde a la siguiente pregunta para poder avanzar a la siguiente habitación:");
            // Se imprime el enunciado y las opciones correspondientes
            System.out.println(pregunta.getEnunciado());
            for (String opcion : pregunta.getOpciones()) {
                System.out.println(opcion);
            }
            
            System.out.print("¿Cuál es tu respuesta? ");
            
            // Se espera y almacena la respuesta ingresada por el usuario
            String respuesta = scanner.nextLine();
            if (respuesta.equalsIgnoreCase(String.valueOf(pregunta.getRespuestaCorrecta()))) {
                score++; // Suma 1 al score
                habitacion++; // Suma 1 a la habitación donde se encuentre
                System.out.println("Respuesta correcta, puedes avanzar!");
                System.out.println("");
            } else {
                vidas = getRespuestaIncorrecta(vidas); // Actualiza el valor de vidas
                tiempoInicial -= 5; // Reducir 5 segundos del tiempo
                System.out.println("Respuesta incorrecta! PIERDES UNA VIDA (te quedan " + vidas + " vidas)");
                if (vidas <= 0) {
                    System.out.println("Te has quedado sin vidas. ¡Has perdido!");
                    break; // Termina el bucle si el jugador se queda sin vidas
                }
            }
            
            // Se asigna la habitación en la que se encuentra actualmente el jugador
            habitaciones.setHabitacion(habitacion);
        }

        // Muestra el resultado final del jugador
        System.out.println("Has completado el cuestionario.");
        System.out.println("Tu puntaje es: " + score + " de " + preguntas.size() + ".");
        
        if (preguntas.size() == habitaciones.getHabitacion()) {
            System.out.println("¡Felicitaciones, has escapado!");
        } else {
            System.out.println("La habitación en la que quedaste es: " + habitaciones.getHabitacion() + ".");
        }

        scanner.close();
    }

    /**
     * Actualiza y devuelve el numero de vidas restantes después de una respuesta incorrecta.
     *
     * @param vidas El numero actual de vidas.
     * @return El nuevo numero de vidas.
     */
    private static int getRespuestaIncorrecta(int vidas) {
        System.out.println("Respuesta incorrecta! ");
        return vidas - 1; // Resta 1 a vidas y devuelve el nuevo valor
    }

    /**
     * Crea y devuelve una lista de preguntas.
     *
     * @return Una lista de preguntas.
     */
    public static List<Pregunta> obtenerPreguntas() {
        List<Pregunta> preguntas = new ArrayList<>(); // Crear una lista para almacenar las preguntas
        
        // Aquí se añaden las preguntas a la lista
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
