package operacion_escape_algoritmo;

/**
 * Clase que representa una pregunta.
 */
public class Pregunta {
    private String enunciado;  // Variable que almacena el enunciado de la pregunta
    private String[] opciones; // Variable que almacena las opciones de respuesta
    private char respuestaCorrecta; // Variable que almacena la respuesta correcta

    /**
     * Constructor de la clase Pregunta.
     *
     * @param enunciado El enunciado de la pregunta.
     * @param opciones Las opciones de respuesta.
     * @param respuestaCorrecta La respuesta correcta.
     */
    public Pregunta(String enunciado, String[] opciones, char respuestaCorrecta) {
        this.enunciado = enunciado;
        this.opciones = opciones;
        this.respuestaCorrecta = respuestaCorrecta;
    }

    /**
     * Obtiene el enunciado de la pregunta.
     *
     * @return El enunciado de la pregunta.
     */
    public String getEnunciado() {
        return enunciado;
    }

    /**
     * Obtiene las opciones de respuesta para la pregunta dada.
     *
     * @return Un arreglo de opciones de respuesta.
     */
    public String[] getOpciones() {
        return opciones;
    }

    /**
     * Obtiene la respuesta correcta.
     *
     * @return La respuesta correcta.
     */
    public char getRespuestaCorrecta() {
        return respuestaCorrecta;
    }
}
