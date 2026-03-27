/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.aa_uc2_00000267068;

public class Busquedas {

    // BÚSQUEDA LINEAL - O(n)
    public static int busquedaLineal(int[] arr, int target) {
        int n = arr.length;                           // 1 asignación

        for (int i = 0; i < n; i++) {                // 1 + n comp + n incr
            if (arr[i] == target) {                  // 1 comparación
                return i;
            }
        }
        return -1;
        // T(n) = 2n + 2 = O(n)
    }

    // BÚSQUEDA BINARIA - O(log n)  → requiere arreglo ordenado
    public static int busquedaBinaria(int[] arr, int target) {
        int izquierda = 0;                            // 1 asignación
        int derecha = arr.length - 1;                // 1 asignación

        while (izquierda <= derecha) {               // 1 comparación → log₂(n) veces
            int medio = izquierda + (derecha - izquierda) / 2; // 4 ops

            if (arr[medio] == target) {              // 1 comparación
                return medio;
            }
            if (arr[medio] < target) {              // 1 comparación
                izquierda = medio + 1;              // 1 asignación
            } else {
                derecha = medio - 1;                // 1 asignación
            }
        }
        return -1;
        // T(n) = 5·log₂(n) + 3 = O(log n)
    }
}
    
