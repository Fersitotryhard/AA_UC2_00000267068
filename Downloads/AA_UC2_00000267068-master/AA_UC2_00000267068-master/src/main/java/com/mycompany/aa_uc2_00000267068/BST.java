package com.mycompany.aa_uc2_00000267068;

// Clase que representa cada nodo del árbol
class Nodo {
    int valor;
    Nodo izq;
    Nodo der;

    public Nodo(int valor) {
        this.valor = valor;
        this.izq = null;
        this.der = null;
    }
}

public class BST {

    Nodo raiz;

    // Método público para iniciar la inserción desde la raíz
    public void insertar(int valor) {
        raiz = insertarRecursivo(raiz, valor);
    }

    // Navega el árbol recursivamente para insertar en la posición correcta
    private Nodo insertarRecursivo(Nodo actual, int valor) {
        if (actual == null) {
            return new Nodo(valor);
        }
        if (valor < actual.valor) {
            actual.izq = insertarRecursivo(actual.izq, valor);
        } else if (valor > actual.valor) {
            actual.der = insertarRecursivo(actual.der, valor);
        }
        return actual;
    }

    // Método público para buscar un valor en el árbol
    public boolean buscar(int clave) {
        return buscarRecursivo(raiz, clave);
    }

    // Navega el árbol recursivamente comparando valores hasta encontrar o descartar
    private boolean buscarRecursivo(Nodo actual, int clave) {
        if (actual == null) return false;
        if (clave == actual.valor) return true;
        if (clave < actual.valor) {
            return buscarRecursivo(actual.izq, clave);
        } else {
            return buscarRecursivo(actual.der, clave);
        }
    }

    // Método público para eliminar un nodo del árbol
    public void eliminar(int valor) {
        raiz = eliminarRecursivo(raiz, valor);
    }

    // Navega y elimina el nodo; si tiene dos hijos usa el sucesor inorden (mínimo del subárbol derecho)
    private Nodo eliminarRecursivo(Nodo actual, int valor) {
        if (actual == null) return null;

        if (valor < actual.valor) {
            actual.izq = eliminarRecursivo(actual.izq, valor);
        } else if (valor > actual.valor) {
            actual.der = eliminarRecursivo(actual.der, valor);
        } else {
            // Caso 1: Sin hijos
            if (actual.izq == null && actual.der == null) return null;
            // Caso 2: Un solo hijo
            if (actual.izq == null) return actual.der;
            if (actual.der == null) return actual.izq;
            // Caso 3: Dos hijos - se usa el sucesor inorden (mínimo del subárbol derecho)
            actual.valor = encontrarMinimo(actual.der);
            actual.der = eliminarRecursivo(actual.der, actual.valor);
        }
        return actual;
    }

    // Encuentra el valor mínimo de un subárbol navegando siempre a la izquierda
    private int encontrarMinimo(Nodo actual) {
        int min = actual.valor;
        while (actual.izq != null) {
            min = actual.izq.valor;
            actual = actual.izq;
        }
        return min;
    }

    // Método público para iniciar el recorrido inorden desde la raíz
    public void inorden() {
        inordenRecursivo(raiz);
        System.out.println();
    }

    // Recorre izquierda → nodo → derecha, imprimiendo los valores en orden ascendente
    private void inordenRecursivo(Nodo actual) {
        if (actual == null) return;
        inordenRecursivo(actual.izq);
        System.out.print(actual.valor + " ");
        inordenRecursivo(actual.der);
    }

    public static void main(String[] args) {

        BST arbol = new BST();

        // Insertar los valores uno por uno
        arbol.insertar(50);
        arbol.insertar(30);
        arbol.insertar(70);
        arbol.insertar(20);
        arbol.insertar(40);
        arbol.insertar(60);
        arbol.insertar(80);

        // Imprimir inorden ANTES de eliminar
        System.out.println("Recorrido inorden antes de eliminar:");
        arbol.inorden();

        // Eliminar el nodo 50 (raíz con dos hijos, se reemplaza con su sucesor: 60)
        arbol.eliminar(50);

        // Imprimir inorden DESPUÉS de eliminar
        System.out.println("Recorrido inorden despues de eliminar el 50:");
        arbol.inorden();

        // Buscar los valores 30, 50 y 60
        int[] valores = {30, 50, 60};
        for (int v : valores) {
            if (arbol.buscar(v)) {
                System.out.println(v + ": Encontrado");
            } else {
                System.out.println(v + ": No encontrado");
            }
        }
    }
}