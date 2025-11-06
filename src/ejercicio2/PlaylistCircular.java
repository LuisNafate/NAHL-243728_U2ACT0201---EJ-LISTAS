package ejercicio2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PlaylistCircular {
    private Nodo actual;   // apunta a la canción “actual”
    private int size;

    public int size() { return size; }
    public boolean estaVacia() { return size == 0; }

    // Para podr agregar canciones
    public void agregar(Cancion c) {
        Nodo nuevo = new Nodo(c);
        if (actual == null) {
            actual = nuevo;
        } else {
            Nodo sig = actual.next;
            actual.next = nuevo;
            nuevo.prev = actual;
            nuevo.next = sig;
            sig.prev = nuevo;
        }
        size++;
    }

    // asi nos vamos a la siguiente / anterior
    public Cancion siguiente() {
        if (estaVacia()) return null;
        actual = actual.next;
        return actual.dato;
    }

    public Cancion anterior() {
        if (estaVacia()) return null;
        actual = actual.prev;
        return actual.dato;
    }

    // eliminar la canción actual
    public Cancion eliminarActual() {
        if (estaVacia()) return null;
        Cancion salida = actual.dato;

        if (size == 1) {
            actual = null;
        } else {
            Nodo a = actual.prev;
            Nodo s = actual.next;
            a.next = s;
            s.prev = a;
            actual = s;
        }
        size--;
        return salida;
    }

    // es para mostrar la canción actual y listar todas
    public Cancion actual() {
        return estaVacia() ? null : actual.dato;
    }

    public List<Cancion> listar() {
        List<Cancion> res = new ArrayList<>();
        if (estaVacia()) return res;
        Nodo p = actual;
        do {
            res.add(p.dato);
            p = p.next;
        } while (p != actual);
        return res;
    }

    // Modo aleatorio
    public List<Cancion> ordenAleatorioSinRepetir() {
        List<Cancion> copia = listar();
        Collections.shuffle(copia);
        return copia;
    }
}
