/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.aa_uc2_00000267068;

/**
 *
 * @author User
 */

public class AA_UC2_00000267068 {

    public static void main(String[] args) {

        System.out.println("=================================================");
        System.out.println("   ANALISIS DE ALGORITMOS DE ORDENAMIENTO");
        System.out.println("=================================================\n");

        int[] original = {64, 34, 25, 12, 22, 11, 90};

        // BUBBLE SORT - O(n^2)
        System.out.println("--- BUBBLE SORT ---");
        int[] arr1 = original.clone();
        Ordenamientos.imprimirArreglo(arr1, "Antes");
        Ordenamientos.bubbleSort(arr1);
        Ordenamientos.imprimirArreglo(arr1, "Despues");

        // SELECTION SORT - O(n^2)
        System.out.println("\n--- SELECTION SORT ---");
        int[] arr2 = original.clone();
        Ordenamientos.imprimirArreglo(arr2, "Antes");
        Ordenamientos.selectionSort(arr2);
        Ordenamientos.imprimirArreglo(arr2, "Despues");

        // INSERTION SORT - O(n^2) peor caso / O(n) mejor caso
        System.out.println("\n--- INSERTION SORT ---");
        int[] arr3 = original.clone();
        Ordenamientos.imprimirArreglo(arr3, "Antes");
        Ordenamientos.insertionSort(arr3);
        Ordenamientos.imprimirArreglo(arr3, "Despues");

        System.out.println("\n=================================================");
        System.out.println("           FIN DE LA DEMOSTRACION");
        System.out.println("=================================================");
        
        // MERGE SORT - O(n log n)
        System.out.println("\n--- MERGE SORT ---");
        int[] arr4 = original.clone();
        Ordenamientos.imprimirArreglo(arr4, "Antes");
        Ordenamientos.mergeSort(arr4, 0, arr4.length - 1);
        Ordenamientos.imprimirArreglo(arr4, "Despues");
    } 
}
