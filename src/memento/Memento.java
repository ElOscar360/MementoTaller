package memento;

/**
 * Guarda una copia inmutable del estado del Editor.
 * No tiene setters, por lo que el Historial no puede modificarlo.
 */
public final class Memento {
    private final String contenido;

    public Memento(String contenido) {
        this.contenido = contenido;
    }

    public String getContenido() {
        return contenido;
    }
}
