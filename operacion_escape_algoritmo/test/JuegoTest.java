package operacion_escape_algoritmo;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class JuegoTest {

    @Test
    public void testRespuestaCorrecta() {
        Juego juego = new Juego(0, 0, 3);
        Pregunta pregunta = new Pregunta("¿Cuál es el resultado de 3 + 2 * 2 en Java?", 
                                         new String[]{"a) 7", "b) 10", "c) 8", "d) 9"}, 'a');

        juego.procesarRespuesta("a", pregunta);

        assertEquals(1, juego.getScore());
        assertEquals(1, juego.getHabitacion());
        assertEquals(3, juego.getVidas());
    }

    @Test
    public void testRespuestaIncorrecta() {
        Juego juego = new Juego(0, 0, 3);
        Pregunta pregunta = new Pregunta("¿Cuál es el resultado de 3 + 2 * 2 en Java?", 
                                         new String[]{"a) 7", "b) 10", "c) 8", "d) 9"}, 'a');

        juego.procesarRespuesta("b", pregunta);

        assertEquals(0, juego.getScore());
        assertEquals(0, juego.getHabitacion());
        assertEquals(2, juego.getVidas());
    }

    @Test
    public void testRespuestaIncorrectaSinVidas() {
        Juego juego = new Juego(0, 0, 1);
        Pregunta pregunta = new Pregunta("¿Cuál es el resultado de 3 + 2 * 2 en Java?", 
                                         new String[]{"a) 7", "b) 10", "c) 8", "d) 9"}, 'a');

        juego.procesarRespuesta("b", pregunta);

        assertEquals(0, juego.getScore());
        assertEquals(0, juego.getHabitacion());
        assertEquals(0, juego.getVidas());
    }
}

