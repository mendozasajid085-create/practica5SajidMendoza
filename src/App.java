public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("=== PRUEBAS DE ESCRITORIO PARA ArrayList ===");
        
        // 1. Probar constructores y esVacia
        Lista<String> lista = new ArrayList<>();
        System.out.println("\n--- Creacion de la lista ---");
        System.out.println("Es vacia? " + lista.esVacia() + " (esperado: true)");
        System.out.println("Numero de elementos: " + lista.numElementos() + " (esperado: 0)");

        // 2. Probar agregarElemento y agregarFinal
        System.out.println("\n--- Agregar al final ---");
        lista.agregarElemento("A");
        lista.agregarFinal("B");
        lista.agregarFinal("C");
        imprimirLista(lista); // Esperado: A, B, C

        // 3. Probar agregarInicio
        System.out.println("\n--- Agregar al inicio ---");
        lista.agregarInicio("Z"); 
        imprimirLista(lista); // Esperado: Z, A, B, C

        // 4. Probar agregarPosicion
        System.out.println("\n--- Agregar en posicion especifica ---");
        lista.agregarPosicion("X", 2); // Deberia insertar despues de Z, A -> Z, A, X, B, C
        imprimirLista(lista); // Esperado: Z, A, X, B, C

        // 5. Probar consultar
        System.out.println("\n--- Consultar ---");
        System.out.println("Elemento en pos 0: " + lista.consultar(0) + " (esperado: Z)");
        System.out.println("Elemento en pos 2: " + lista.consultar(2) + " (esperado: X)");

        // 6. Probar eliminarElemento / eliminarElementoFinal
        System.out.println("\n--- Eliminar al final ---");
        String eliminadoFinal = lista.eliminarElemento();
        System.out.println("Eliminado: " + eliminadoFinal + " (esperado: C)");
        imprimirLista(lista); // Esperado: Z, A, X, B

        // 7. Probar eliminarElementoInicio
        System.out.println("\n--- Eliminar al inicio ---");
        String eliminadoInicio = lista.eliminarElementoInicio();
        System.out.println("Eliminado: " + eliminadoInicio + " (esperado: Z)");
        imprimirLista(lista); // Esperado: A, X, B

        // 8. Probar eliminarElementoPosicion
        System.out.println("\n--- Eliminar en posicion especifica ---");
        String eliminadoPos = lista.eliminarElementoPosicion(1);
        System.out.println("Eliminado en pos 1: " + eliminadoPos + " (esperado: X)");
        imprimirLista(lista); // Esperado: A, B

        // 9. Probar Iterator
        System.out.println("\n--- Probar Iterator (for-each) ---");
        lista.agregarFinal("C");
        lista.agregarFinal("D");
        System.out.print("Elementos (Iterator): ");
        for (String elemento : lista) {
            System.out.print(elemento + " ");
        }
        System.out.println("\n(esperado: A B C D)");

        // 10. Probar convertirArreglo
        System.out.println("\n--- Probar convertirArreglo ---");
        Object[] arreglo = lista.convertirArreglo();
        System.out.print("Elementos (Arreglo): ");
        for (Object obj : arreglo) {
            System.out.print(obj + " ");
        }
        System.out.println("\n(esperado: A B C D)");

        // 11. Probar limpiarLista
        System.out.println("\n--- Limpiar lista ---");
        lista.limpiarLista();
        System.out.println("Es vacia? " + lista.esVacia() + " (esperado: true)");
        System.out.println("Numero de elementos: " + lista.numElementos() + " (esperado: 0)");
        
        // 12. Forzar crecimiento del arreglo interno (superando MAX = 5)
        System.out.println("\n--- Forzar crecimiento (mas de 5 elementos) ---");
        for (int i = 1; i <= 10; i++) {
            lista.agregarFinal("Item " + i);
        }
        System.out.println("Numero de elementos: " + lista.numElementos() + " (esperado: 10)");
        
        System.out.println("\n=== FIN DE LAS PRUEBAS ===");
    }

    private static void imprimirLista(Lista<String> lista) {
        System.out.print("Lista actual: [ ");
        for (int i = 0; i < lista.numElementos(); i++) {
            System.out.print(lista.consultar(i));
            if (i < lista.numElementos() - 1) {
                System.out.print(", ");
            }
        }
        System.out.println(" ]");
    }
}
