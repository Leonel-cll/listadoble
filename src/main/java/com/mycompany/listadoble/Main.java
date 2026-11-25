/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.listadoble;

/**
 *
 * @author leonel
 */
public class Main {
    public static void main(String[] args) {
        Listadoble lista = new Listadoble();

        System.out.println("=== 1. PRUEBA insertarOrdenado ===");
        lista.insertarOrdenado(30);
        lista.insertarOrdenado(10);
        lista.insertarOrdenado(50);
        lista.insertarOrdenado(20);
        lista.insertarOrdenado(40);
        System.out.println("Adelante: " + lista);
        System.out.println("Reversa : " + lista.imprimirReversa());

        System.out.println("\n=== 2. PRUEBA insertarEnPosicion ===");
        lista.insertarEnPosicion(1, 5);
        lista.insertarEnPosicion(4, 25);
        lista.insertarEnPosicion(lista.getTamanio() + 1, 60);
        System.out.println("Adelante: " + lista);
        System.out.println("Reversa : " + lista.imprimirReversa());

        System.out.println("\n=== 3. PRUEBA eliminarPorValor ===");
        System.out.println("Eliminar 25: " + lista.eliminarPorValor(25));
        System.out.println("Eliminar 999: " + lista.eliminarPorValor(999));
        System.out.println("Adelante: " + lista);

        System.out.println("\n=== 4. PRUEBA eliminarEnPosicion ===");
        System.out.println("Eliminado en pos 1: " + lista.eliminarEnPosicion(1));
        System.out.println("Eliminado en pos 3: " + lista.eliminarEnPosicion(3));
        System.out.println("Adelante: " + lista);

        System.out.println("\n=== 5. PRUEBA eliminarUltimo ===");
        System.out.println("Eliminar ultimo: " + lista.eliminarUltimo());
        System.out.println("Adelante: " + lista);
        System.out.println("Reversa : " + lista.imprimirReversa());
    }
}

