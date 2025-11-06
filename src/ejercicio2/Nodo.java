package ejercicio2;

class Nodo {
    Cancion dato;
    Nodo next;
    Nodo prev;

    Nodo(Cancion c) {
        this.dato = c;
        this.next = this; // circular por defecto
        this.prev = this;
    }
}
