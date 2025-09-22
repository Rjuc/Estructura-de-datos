package arbolbinario;

import java.util.List;
import java.util.Scanner;

public class ArbolTest {
    
    public static void main(String[] args) {
        System.out.println("===========================================");
        System.out.println("    PRUEBAS DEL ÁRBOL BINARIO DE BÚSQUEDA");
        System.out.println("===========================================\n");
        
        // Ejecutar pruebas automáticas
        ejecutarPruebasAutomaticas();
        
        // Menú interactivo
        menuInteractivo();
    }
    
    private static void ejecutarPruebasAutomaticas() {
        System.out.println(">>> INICIANDO PRUEBAS AUTOMÁTICAS <<<\n");
        
        ArbolBinariodeBusqueda arbol = new ArbolBinariodeBusqueda();
        
        // Prueba 1: Inserción de elementos
        System.out.println("1. PRUEBA DE INSERCIÓN");
        System.out.println("-----------------------");
        String[] paises = {"Colombia", "Aruba", "Panama", "Curazao", "Inglaterra", "Italia"};
        
        for (String pais : paises) {
            arbol.insertar(pais);
            System.out.println("Insertado: " + pais);
        }
        
        System.out.println("\nÁrbol después de las inserciones:");
        arbol.imprimir();
        
        // Prueba 2: Búsqueda exitosa
        System.out.println("\n2. PRUEBA DE BÚSQUEDA");
        System.out.println("----------------------");
        System.out.println("Buscar 'Colombia': " + arbol.buscar("Colombia"));
        System.out.println("Buscar 'Italia': " + arbol.buscar("Italia"));
        
        // Prueba 3: Búsqueda no exitosa
        System.out.println("Buscar 'Brasil' (no existe): " + arbol.buscar("Brasil"));
        
        // Prueba 4: Inserción de duplicado
        System.out.println("\n3. PRUEBA DE INSERCIÓN DUPLICADA");
        System.out.println("---------------------------------");
        System.out.println("Intentando insertar 'Colombia' nuevamente...");
        arbol.insertar("Colombia");
        System.out.println("Verificando que no se duplicó:");
        arbol.imprimir();
        
        // Prueba 5: Recorridos
        System.out.println("\n4. PRUEBA DE RECORRIDOS");
        System.out.println("------------------------");
        
        List<String> preorden = arbol.recorridoPreorden();
        System.out.println("Preorden:  " + preorden);
        
        List<String> inorden = arbol.recorridoInorden();
        System.out.println("Inorden:   " + inorden);
        
        List<String> posorden = arbol.recorridoPosorden();
        System.out.println("Posorden:  " + posorden);
        
        // Prueba 6: Borrado de nodo hoja
        System.out.println("\n5. PRUEBA DE BORRADO - NODO HOJA");
        System.out.println("----------------------------------");
        System.out.println("Borrando 'Aruba' (nodo hoja):");
        boolean borrado = arbol.borrar("Aruba");
        System.out.println("Borrado exitoso: " + borrado);
        arbol.imprimir();
        
        // Prueba 7: Borrado de nodo con un hijo
        System.out.println("\n6. PRUEBA DE BORRADO - NODO CON UN HIJO");
        System.out.println("-----------------------------------------");
        // Primero agregamos un país que cree esta situación
        arbol.insertar("Argentina");
        System.out.println("Insertado 'Argentina' para crear estructura específica");
        arbol.imprimir();
        System.out.println("\nBorrando 'Curazao' (nodo con un hijo):");
        borrado = arbol.borrar("Curazao");
        System.out.println("Borrado exitoso: " + borrado);
        arbol.imprimir();
        
        // Prueba 8: Borrado de nodo con dos hijos
        System.out.println("\n7. PRUEBA DE BORRADO - NODO CON DOS HIJOS");
        System.out.println("-------------------------------------------");
        System.out.println("Borrando 'Colombia' (nodo raíz con dos hijos):");
        borrado = arbol.borrar("Colombia");
        System.out.println("Borrado exitoso: " + borrado);
        arbol.imprimir();
        
        // Prueba 9: Borrado de elemento no existente
        System.out.println("\n8. PRUEBA DE BORRADO - ELEMENTO NO EXISTENTE");
        System.out.println("----------------------------------------------");
        System.out.println("Intentando borrar 'Mexico' (no existe):");
        borrado = arbol.borrar("Mexico");
        System.out.println("Borrado exitoso: " + borrado);
        
        // Prueba 10: Operaciones en árbol vacío
        System.out.println("\n9. PRUEBA CON ÁRBOL VACÍO");
        System.out.println("--------------------------");
        ArbolBinariodeBusqueda arbolVacio = new ArbolBinariodeBusqueda();
        System.out.println("Buscar en árbol vacío: " + arbolVacio.buscar("España"));
        System.out.println("Borrar de árbol vacío: " + arbolVacio.borrar("España"));
        System.out.println("Recorrido inorden de árbol vacío: " + arbolVacio.recorridoInorden());
        arbolVacio.imprimir();
        
        System.out.println("\n>>> PRUEBAS AUTOMÁTICAS COMPLETADAS <<<\n");
    }
    
    private static void menuInteractivo() {
        Scanner scanner = new Scanner(System.in);
        ArbolBinariodeBusqueda arbol = new ArbolBinariodeBusqueda();
        boolean continuar = true;
        
        System.out.println("\n===========================================");
        System.out.println("         MENÚ INTERACTIVO");
        System.out.println("===========================================\n");
        
        while (continuar) {
            System.out.println("\n--- MENÚ DE OPCIONES ---");
            System.out.println("1. Insertar país");
            System.out.println("2. Buscar país");
            System.out.println("3. Borrar país");
            System.out.println("4. Mostrar recorrido preorden");
            System.out.println("5. Mostrar recorrido inorden");
            System.out.println("6. Mostrar recorrido posorden");
            System.out.println("7. Imprimir estructura del árbol");
            System.out.println("8. Insertar países de ejemplo");
            System.out.println("0. Salir");
            System.out.print("\nSeleccione una opción: ");
            
            int opcion = 0;
            try {
                opcion = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Por favor, ingrese un número válido.");
                continue;
            }
            
            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el nombre del país: ");
                    String paisInsertar = scanner.nextLine();
                    arbol.insertar(paisInsertar);
                    System.out.println("País '" + paisInsertar + "' insertado.");
                    break;
                    
                case 2:
                    System.out.print("Ingrese el país a buscar: ");
                    String paisBuscar = scanner.nextLine();
                    System.out.println("Resultado: " + arbol.buscar(paisBuscar));
                    break;
                    
                case 3:
                    System.out.print("Ingrese el país a borrar: ");
                    String paisBorrar = scanner.nextLine();
                    boolean exito = arbol.borrar(paisBorrar);
                    if (exito) {
                        System.out.println("País '" + paisBorrar + "' borrado exitosamente.");
                    } else {
                        System.out.println("País '" + paisBorrar + "' no encontrado.");
                    }
                    break;
                    
                case 4:
                    List<String> preorden = arbol.recorridoPreorden();
                    System.out.println("Recorrido Preorden: " + preorden);
                    break;
                    
                case 5:
                    List<String> inorden = arbol.recorridoInorden();
                    System.out.println("Recorrido Inorden: " + inorden);
                    break;
                    
                case 6:
                    List<String> posorden = arbol.recorridoPosorden();
                    System.out.println("Recorrido Posorden: " + posorden);
                    break;
                    
                case 7:
                    arbol.imprimir();
                    break;
                    
                case 8:
                    System.out.println("Insertando países de ejemplo...");
                    String[] paisesEjemplo = {"España", "Francia", "Alemania", 
                                             "Brasil", "Chile", "Canada"};
                    for (String pais : paisesEjemplo) {
                        arbol.insertar(pais);
                        System.out.println("Insertado: " + pais);
                    }
                    System.out.println("Países de ejemplo insertados.");
                    break;
                    
                case 0:
                    continuar = false;
                    System.out.println("\nGracias por usar el programa. ¡Hasta luego!");
                    break;
                    
                default:
                    System.out.println("Opción no válida. Por favor intente nuevamente.");
            }
        }
        
        scanner.close();
    }
}
