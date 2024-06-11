package operacion_escape_algoritmo;

import java.util.List;

public class Juego {
    private int score;
    private int habitacion;
    private int vidas;

    public Juego(int score, int habitacion, int vidas) {
        this.score = score;
        this.habitacion = habitacion;
        this.vidas = vidas;
    }

    public int getScore() {
        return score;
    }

    public int getHabitacion() {
        return habitacion;
    }

    public int getVidas() {
        return vidas;
    }

    public void procesarRespuesta(String respuesta, Pregunta pregunta) {
        if (respuesta.equalsIgnoreCase(String.valueOf(pregunta.getRespuestaCorrecta()))) {
            score++;
            habitacion++;
            System.out.println("Respuesta correcta, puedes avanzar!");
            System.out.println("");
        } else {
            vidas = getRespuestaIncorrecta(vidas);
            System.out.println("PIERDES UNA VIDA (te quedan " + vidas + " vidas)");
            if (vidas <= 0) {
                System.out.println("Te has quedado sin vidas. ¡Has perdido!");
            }
        }
    }

    public int getRespuestaIncorrecta(int vidas) {
        System.out.println("Respuesta incorrecta! ");
        return vidas - 1;
    }
}
