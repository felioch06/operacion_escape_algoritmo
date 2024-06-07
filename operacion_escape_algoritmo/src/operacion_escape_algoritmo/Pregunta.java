package operacion_escape_algoritmo;

//Clase que representa una pregunta
public class Pregunta {
	private String enunciado;  // Variable que almacena el enunciado de la pregunta
    private String[] opciones; // Variable que almacena las opciones de respuesta
    private char respuestaCorrecta; // Variable que almacena la respuesta correcta

    // Constructor de la clase Pregunta
    public Pregunta(String enunciado, String[] opciones, char respuestaCorrecta) {
        this.enunciado = enunciado;
        this.opciones = opciones;
        this.respuestaCorrecta = respuestaCorrecta;
    }
    
    // Métodos getter para obtener los valores de los atributos
    public String getEnunciado() {
        return enunciado;
    }
    
    public String[] getOpciones() {
        return opciones;
    }

    public char getRespuestaCorrecta() {
        return respuestaCorrecta;
    }
    
}
