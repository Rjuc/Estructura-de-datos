package arbolbinario;

import java.util.List;
import java.util.LinkedList;

public class ArbolBinariodeBusqueda {
    private NodoBinario raiz;
    
    // Constructor
    public ArbolBinariodeBusqueda() {
        this.raiz = null;
    }
    
    // Método público para insertar
    public void insertar(String pais) {
        if (raiz == null) {
            raiz = new NodoBinario(pais);
        } else {
            insertarRecursivo(raiz, pais);
        }
    }
    
    // Método privado recursivo para insertar
    private void insertarRecursivo(NodoBinario nodoActual, String pais) {
        int comparacion = pais.compareTo(nodoActual.getValor());
        
        if (comparacion < 0) {
            // Insertar a la izquierda
            if (nodoActual.getHijoIzquierdo() == null) {
                NodoBinario nuevoNodo = new NodoBinario(pais);
                nodoActual.setHijoIzquierdo(nuevoNodo);
                nuevoNodo.setPadre(nodoActual);
            } else {
                insertarRecursivo(nodoActual.getHijoIzquierdo(), pais);
            }
        } else if (comparacion > 0) {
            // Insertar a la derecha
            if (nodoActual.getHijoDerecho() == null) {
                NodoBinario nuevoNodo = new NodoBinario(pais);
                nodoActual.setHijoDerecho(nuevoNodo);
                nuevoNodo.setPadre(nodoActual);
            } else {
                insertarRecursivo(nodoActual.getHijoDerecho(), pais);
            }
        }
        // Si comparacion == 0, el país ya existe, no insertamos duplicados
    }
    
    // Método público para buscar
    public String buscar(String pais) {
        NodoBinario nodo = buscarNodo(raiz, pais);
        if (nodo != null) {
            return pais + " encontrado";
        } else {
            return pais + " no encontrado";
        }
    }
    
    // Método privado recursivo para buscar nodo
    private NodoBinario buscarNodo(NodoBinario nodoActual, String pais) {
        if (nodoActual == null) {
            return null;
        }
        
        int comparacion = pais.compareTo(nodoActual.getValor());
        
        if (comparacion == 0) {
            return nodoActual;
        } else if (comparacion < 0) {
            return buscarNodo(nodoActual.getHijoIzquierdo(), pais);
        } else {
            return buscarNodo(nodoActual.getHijoDerecho(), pais);
        }
    }
    
    // Método público para borrar
    public boolean borrar(String pais) {
        NodoBinario nodoABorrar = buscarNodo(raiz, pais);
        
        if (nodoABorrar == null) {
            return false; // No se encontró el país
        }
        
        // Caso 1: Nodo es hoja
        if (nodoABorrar.esHoja()) {
            if (nodoABorrar == raiz) {
                raiz = null;
            } else {
                NodoBinario padre = nodoABorrar.getPadre();
                if (padre.getHijoIzquierdo() == nodoABorrar) {
                    padre.setHijoIzquierdo(null);
                } else {
                    padre.setHijoDerecho(null);
                }
            }
        }
        // Caso 2: Nodo tiene un hijo
        else if (nodoABorrar.tieneUnHijo()) {
            NodoBinario hijo = nodoABorrar.getUnicoHijo();
            
            if (nodoABorrar == raiz) {
                raiz = hijo;
                hijo.setPadre(null);
            } else {
                NodoBinario padre = nodoABorrar.getPadre();
                hijo.setPadre(padre);
                
                if (padre.getHijoIzquierdo() == nodoABorrar) {
                    padre.setHijoIzquierdo(hijo);
                } else {
                    padre.setHijoDerecho(hijo);
                }
            }
        }
        // Caso 3: Nodo tiene dos hijos
        else {
            // Encontrar el sucesor inorden (mínimo del subárbol derecho)
            NodoBinario sucesor = encontrarMinimo(nodoABorrar.getHijoDerecho());
            
            // Crear nuevo nodo con el valor del sucesor
            NodoBinario reemplazo = new NodoBinario(sucesor.getValor());
            reemplazo.setHijoIzquierdo(nodoABorrar.getHijoIzquierdo());
            reemplazo.setHijoDerecho(nodoABorrar.getHijoDerecho());
            reemplazo.setPadre(nodoABorrar.getPadre());
            
            // Actualizar referencias de los hijos
            if (nodoABorrar.getHijoIzquierdo() != null) {
                nodoABorrar.getHijoIzquierdo().setPadre(reemplazo);
            }
            if (nodoABorrar.getHijoDerecho() != null) {
                nodoABorrar.getHijoDerecho().setPadre(reemplazo);
            }
            
            // Actualizar referencia del padre o raíz
            if (nodoABorrar == raiz) {
                raiz = reemplazo;
            } else {
                NodoBinario padre = nodoABorrar.getPadre();
                if (padre.getHijoIzquierdo() == nodoABorrar) {
                    padre.setHijoIzquierdo(reemplazo);
                } else {
                    padre.setHijoDerecho(reemplazo);
                }
            }
            
            // Ahora borrar el sucesor de su posición original
            // El sucesor siempre será una hoja o tendrá solo hijo derecho
            if (sucesor.getPadre().getHijoIzquierdo() == sucesor) {
                sucesor.getPadre().setHijoIzquierdo(sucesor.getHijoDerecho());
            } else {
                sucesor.getPadre().setHijoDerecho(sucesor.getHijoDerecho());
            }
            
            if (sucesor.getHijoDerecho() != null) {
                sucesor.getHijoDerecho().setPadre(sucesor.getPadre());
            }
        }
        
        return true;
    }
    
    // Método auxiliar para encontrar el nodo mínimo
    private NodoBinario encontrarMinimo(NodoBinario nodo) {
        while (nodo.getHijoIzquierdo() != null) {
            nodo = nodo.getHijoIzquierdo();
        }
        return nodo;
    }
    
    // Recorrido preorden
    public List<String> recorridoPreorden() {
        List<String> resultado = new LinkedList<>();
        recorridoPreordenRecursivo(raiz, resultado);
        return resultado;
    }
    
    private void recorridoPreordenRecursivo(NodoBinario nodo, List<String> lista) {
        if (nodo != null) {
            lista.add(nodo.getValor());
            recorridoPreordenRecursivo(nodo.getHijoIzquierdo(), lista);
            recorridoPreordenRecursivo(nodo.getHijoDerecho(), lista);
        }
    }
    
    // Recorrido inorden
    public List<String> recorridoInorden() {
        List<String> resultado = new LinkedList<>();
        recorridoInordenRecursivo(raiz, resultado);
        return resultado;
    }
    
    private void recorridoInordenRecursivo(NodoBinario nodo, List<String> lista) {
        if (nodo != null) {
            recorridoInordenRecursivo(nodo.getHijoIzquierdo(), lista);
            lista.add(nodo.getValor());
            recorridoInordenRecursivo(nodo.getHijoDerecho(), lista);
        }
    }
    
    // Recorrido posorden
    public List<String> recorridoPosorden() {
        List<String> resultado = new LinkedList<>();
        recorridoPosordenRecursivo(raiz, resultado);
        return resultado;
    }
    
    private void recorridoPosordenRecursivo(NodoBinario nodo, List<String> lista) {
        if (nodo != null) {
            recorridoPosordenRecursivo(nodo.getHijoIzquierdo(), lista);
            recorridoPosordenRecursivo(nodo.getHijoDerecho(), lista);
            lista.add(nodo.getValor());
        }
    }
    
    // Método para imprimir el árbol de forma jerárquica
    public void imprimir() {
        if (raiz == null) {
            System.out.println("El árbol está vacío");
        } else {
            System.out.println("\nEstructura del Árbol Binario de Búsqueda:");
            imprimirRecursivo(raiz, "", true);
        }
    }
    
    private void imprimirRecursivo(NodoBinario nodo, String prefijo, boolean esUltimo) {
        if (nodo != null) {
            System.out.println(prefijo + (esUltimo ? "└── " : "├── ") + nodo.getValor());
            
            String nuevoPrefijo = prefijo + (esUltimo ? "    " : "│   ");
            
            boolean tieneHijoIzquierdo = nodo.getHijoIzquierdo() != null;
            boolean tieneHijoDerecho = nodo.getHijoDerecho() != null;
            
            if (tieneHijoIzquierdo) {
                imprimirRecursivo(nodo.getHijoIzquierdo(), nuevoPrefijo, !tieneHijoDerecho);
            }
            
            if (tieneHijoDerecho) {
                imprimirRecursivo(nodo.getHijoDerecho(), nuevoPrefijo, true);
            }
        }
    }
}