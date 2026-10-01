package main;

import caretaker.Historial;
import memento.Memento;
import originator.Editor;

public class Main {
    public static void main(String[] args) {
        Editor editor = new Editor();
        Historial historial = new Historial();

        editor.setContenido("Hola");
        System.out.println("Contenido actual: \"" + editor.getContenido() + "\"");
        historial.guardarEstado(editor.guardar());
        System.out.println("-> Estado guardado");

        editor.setContenido("Hola, mundo");
        System.out.println("Contenido actual: \"" + editor.getContenido() + "\"");
        historial.guardarEstado(editor.guardar());
        System.out.println("-> Estado guardado");

        editor.setContenido("Hola, mundo. Adiós");
        System.out.println("Contenido actual: \"" + editor.getContenido() + "\"");

        restaurarUltimo(editor, historial);
        System.out.println("Contenido actual: \"" + editor.getContenido() + "\"");

        editor.setContenido(editor.getContenido() + ". Nueva modificación");
        System.out.println("Contenido tras nueva modificación: \"" + editor.getContenido() + "\"");

        // Restaura de nuevo (queda "Hola") y luego intenta con el historial vacío
        restaurarUltimo(editor, historial);
        System.out.println("Contenido actual: \"" + editor.getContenido() + "\"");
        restaurarUltimo(editor, historial);
    }

    private static void restaurarUltimo(Editor editor, Historial historial) {
        Memento memento = historial.obtenerUltimoEstado();
        if (memento == null) {
            System.out.println("-> No hay estados guardados para restaurar");
            return;
        }
        editor.restaurar(memento);
        System.out.println("-> Estado restaurado");
    }
}
