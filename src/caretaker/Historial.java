package caretaker;

import memento.Memento;
import java.util.Stack;

/** Caretaker: solo almacena Mementos, nunca toca el Editor. */
public class Historial {
    private final Stack<Memento> estados = new Stack<>();

    public void guardarEstado(Memento memento) {
        estados.push(memento);
    }

    /** Devuelve y retira el último estado guardado, o null si no hay ninguno. */
    public Memento obtenerUltimoEstado() {
        if (estados.isEmpty()) {
            return null;
        }
        return estados.pop();
    }

    public boolean estaVacio() {
        return estados.isEmpty();
    }
}
