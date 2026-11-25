/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.listadoble;

/**
 *
 * @author leonel
 */


public class Listadoble {
    private int tamanio;
    private nododoble cabeza;
    private nododoble cola;

    public Listadoble() {
        tamanio = 0;
        cabeza = null;
        cola = null;
    }

    public boolean estaVacia() {
        return cabeza == null && cola == null;
    }

    public int getTamanio() {
        return tamanio;
    }

    public boolean buscar(int dato) {
        nododoble aux = cabeza;
        while (aux != null) {
            if (aux.getDato() == dato) {
                return true;
            }
            aux = aux.getSiguiente();
        }
        return false;
    }

    @Override
    public String toString() {
        String res = "null";
        nododoble aux = cabeza;
        while (aux != null) {
            res += "[" + aux.getDato() + "]<->";
            aux = aux.getSiguiente();
        }
        res += "null";
        return res;
    }

    public String imprimirReversa() {
        String res = "null";
        nododoble aux = cola;
        while (aux != null) {
            res += "[" + aux.getDato() + "]<->";
            aux = aux.getAnterior();
        }
        res += "null";
        return res;
    }

    public nododoble obtenerNodo(int pos) {
        if (pos <= 0 || pos > tamanio) {
            throw new IllegalStateException("Valor fuera de rango");
        }
        nododoble aux = cabeza;
        for (int i = 1; i < pos; i++) {
            aux = aux.getSiguiente();
        }
        return aux;
    }

    public void actualizar(int pos, int valor) {
        nododoble val = obtenerNodo(pos);
        val.setDato(valor);
    }

    public void insertarInicio(int valor) {
        nododoble nuevo = new nododoble(valor);

        if (estaVacia()) {
            cabeza = nuevo;
            cola = nuevo;
        } else {
            nuevo.setSiguiente(cabeza);
            cabeza.setAnterior(nuevo);
            cabeza = nuevo;
        }
        tamanio++;
    }

    public void insertarfinal(int valor) {
        nododoble nuevo = new nododoble(valor);

        if (estaVacia()) {
            cabeza = nuevo;
            cola = nuevo;
        } else {
            cola.setSiguiente(nuevo);
            nuevo.setAnterior(cola);
            cola = nuevo;
        }
        tamanio++;
    }

    public int eliminarInicio() {
        if (estaVacia()) {
            throw new IllegalStateException("No se puede eliminar con la lista vacia");
        }

        int dato = cabeza.getDato();

        if (cabeza == cola) {
            cabeza = null;
            cola = null;
        } else {
            cabeza = cabeza.getSiguiente();
            cabeza.setAnterior(null);
        }

        tamanio--;
        return dato;
    }

    public void insertarEnPosicion(int pos, int dato) {
        if (pos <= 0 || pos > tamanio + 1) {
            throw new IllegalStateException("Posicion fuera de rango: " + pos);
        }

        if (pos == 1) {
            insertarInicio(dato);
            return;
        }

        if (pos == tamanio + 1) {
            insertarfinal(dato);
            return;
        }

        nododoble actual = obtenerNodo(pos);
        nododoble anteriorNodo = actual.getAnterior();
        nododoble nuevo = new nododoble(dato);

        nuevo.setAnterior(anteriorNodo);
        nuevo.setSiguiente(actual);
        anteriorNodo.setSiguiente(nuevo);
        actual.setAnterior(nuevo);

        tamanio++;
    }

    public boolean eliminarUltimo() {
        if (estaVacia()) {
            return false;
        }

        if (cabeza == cola) {
            cabeza = null;
            cola = null;
        } else {
            cola = cola.getAnterior();
            cola.setSiguiente(null);
        }

        tamanio--;
        return true;
    }

    public int eliminarEnPosicion(int pos) {
        if (estaVacia() || pos <= 0 || pos > tamanio) {
            throw new IllegalStateException("Posicion fuera de rango o lista vacia: " + pos);
        }

        if (pos == 1) {
            return eliminarInicio();
        }

        if (pos == tamanio) {
            int dato = cola.getDato();
            eliminarUltimo();
            return dato;
        }

        nododoble actual = obtenerNodo(pos);
        int dato = actual.getDato();

        nododoble ant = actual.getAnterior();
        nododoble sig = actual.getSiguiente();

        ant.setSiguiente(sig);
        sig.setAnterior(ant);

        actual.setAnterior(null);
        actual.setSiguiente(null);

        tamanio--;
        return dato;
    }

    public boolean eliminarPorValor(int x) {
        if (estaVacia()) {
            return false;
        }

        nododoble aux = cabeza;
        int pos = 1;

        while (aux != null) {
            if (aux.getDato() == x) {
                eliminarEnPosicion(pos);
                return true;
            }
            aux = aux.getSiguiente();
            pos++;
        }

        return false;
    }

    public void insertarOrdenado(int dato) {
        if (estaVacia() || dato <= cabeza.getDato()) {
            insertarInicio(dato);
            return;
        }

        if (dato >= cola.getDato()) {
            insertarfinal(dato);
            return;
        }

        nododoble aux = cabeza.getSiguiente();
        while (aux != null && aux.getDato() < dato) {
            aux = aux.getSiguiente();
        }

        nododoble anteriorNodo = aux.getAnterior();
        nododoble nuevo = new nododoble(dato);

        nuevo.setAnterior(anteriorNodo);
        nuevo.setSiguiente(aux);
        anteriorNodo.setSiguiente(nuevo);
        aux.setAnterior(nuevo);

        tamanio++;
    }
}