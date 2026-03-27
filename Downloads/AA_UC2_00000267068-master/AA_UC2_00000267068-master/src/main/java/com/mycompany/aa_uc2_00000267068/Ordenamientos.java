/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.aa_uc2_00000267068;

public class Ordenamientos {

    // BUBBLE SORT - O(n²)
    public static void bubbleSort(int[] arr) {
        int n = arr.length;                           // 1 asignación

        for (int i = 0; i < n - 1; i++) {            // 1 + n comparaciones + (n-1) incrementos
            for (int j = 0; j < n - 1 - i; j++) {    // 1 + n(n-1)/2 comp + n(n-1)/2 incr

                if (arr[j] > arr[j + 1]) {            // 1 comparación por iteración
                    int temp = arr[j];                // 1 asignación
                    arr[j] = arr[j + 1];             // 1 asignación
                    arr[j + 1] = temp;               // 1 asignación
                }
            }
        }
        // T(n) ≈ (5/2)n² = O(n²)
    }

    // SELECTION SORT - O(n²)
    public static void selectionSort(int[] arr) {
        int n = arr.length;                           // 1 asignación

        for (int i = 0; i < n - 1; i++) {            // 1 + n comp + (n-1) incr
            int minIdx = i;                           // 1 asignación → (n-1) veces

            for (int j = i + 1; j < n; j++) {        // 1 + n(n-1)/2 comp
                if (arr[j] < arr[minIdx]) {           // 1 comparación
                    minIdx = j;                       // 1 asignación (peor caso)
                }
            }
            int temp = arr[minIdx];                   // 1 asignación
            arr[minIdx] = arr[i];                    // 1 asignación
            arr[i] = temp;                           // 1 asignación
        }
        // T(n) ≈ n²/2 + (5/2)n = O(n²)
    }

    // INSERTION SORT - O(n²) peor caso / O(n) mejor caso
    public static void insertionSort(int[] arr) {
        int n = arr.length;                           // 1 asignación

        for (int i = 1; i < n; i++) {                // 1 + (n-1) comp + (n-1) incr
            int key = arr[i];                         // 1 asignación
            int j = i - 1;                           // 1 asignación

            while (j >= 0 && arr[j] > key) {         // 2 comparaciones por iteración
                arr[j + 1] = arr[j];                 // 1 asignación
                j = j - 1;                           // 1 asignación
            }
            arr[j + 1] = key;                        // 1 asignación
        }
        // T(n) peor caso  ≈ n²/2 + (3/2)n = O(n²)
        // T(n) mejor caso = 4n - 3         = O(n)
    }

    // AUXILIAR: imprimir arreglo
    public static void imprimirArreglo(int[] arr, String label) {
        System.out.print(label + ": [ ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) System.out.print(", ");
        }
        System.out.println(" ]");
    }
    
    // MERGE SORT - O(n log n) peor caso / O(n log n) mejor caso
public static void mergeSort(int[] arr, int left, int right) {
    if (left < right) {                          // 1 comparacion
        int mid = (left + right) / 2;            // 1 suma + 1 division + 1 asignacion = 3 ops
        mergeSort(arr, left, mid);               // T(n/2)
        mergeSort(arr, mid + 1, right);          // T(n/2)
        merge(arr, left, mid, right);            // O(n)
    }
    // T(n) = 2T(n/2) + O(n) = O(n log n)
}

public static void merge(int[] arr, int left, int mid, int right) {
    int n1 = mid - left + 1;                    // 2 ops
    int n2 = right - mid;                       // 1 op

    int[] L = new int[n1];                      // 1 op
    int[] R = new int[n2];                      // 1 op

    for (int i = 0; i < n1; i++)               // n1 iteraciones
        L[i] = arr[left + i];                  // 1 asignacion por iteracion

    for (int j = 0; j < n2; j++)               // n2 iteraciones
        R[j] = arr[mid + 1 + j];              // 1 asignacion por iteracion

    int i = 0, j = 0, k = left;               // 3 asignaciones

    while (i < n1 && j < n2) {                // n iteraciones en total
        if (L[i] <= R[j]) {                    // 1 comparacion
            arr[k] = L[i]; i++;               // 1 asignacion + 1 incremento
        } else {
            arr[k] = R[j]; j++;               // 1 asignacion + 1 incremento
        }
        k++;                                   // 1 incremento
    }

    while (i < n1) { arr[k] = L[i]; i++; k++; }  // copia restantes de L
    while (j < n2) { arr[k] = R[j]; j++; k++; }  // copia restantes de R

    // T(n) peor caso = O(n)
}
}
