package operacion_escape_algoritmo;

/**
 * Clase que representa las habitaciones.
 */
public class Habitaciones {
    private int habitacion;

    /**
     * Constructor por defecto de la clase Habitaciones.
     * Inicializa la habitación a 0.
     */
    public Habitaciones() {
        this.habitacion = 0;
    }

    /**
     * Obtiene el número de habitación.
     *
     * @return El número de habitación.
     */
    public int getHabitacion() {
        return habitacion;
    }

    /**
     * Establece el número de habitación.
     *
     * @param habitacion El número de habitacion a establecer.
     */
    public void setHabitacion(int habitacion) {
        this.habitacion = habitacion;
    }
}
