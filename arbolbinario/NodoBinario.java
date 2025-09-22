package arbolbinario;

public class NodoBinario {
    // Atributos privados
    private String valor;  // Nombre del país
    private NodoBinario hijoIzquierdo;
    private NodoBinario hijoDerecho;
    private NodoBinario padre;
    
    // Constructor
    public NodoBinario(String valor) {
        this.valor = valor;
        this.hijoIzquierdo = null;
        this.hijoDerecho = null;
        this.padre = null;
    }
    
    // Getters necesarios
    public String getValor() {
        return valor;
    }
    
    public NodoBinario getHijoIzquierdo() {
        return hijoIzquierdo;
    }
    
    public NodoBinario getHijoDerecho() {
        return hijoDerecho;
    }
    
    public NodoBinario getPadre() {
        return padre;
    }
    
    // Setters para mantener encapsulación
    public void setHijoIzquierdo(NodoBinario hijoIzquierdo) {
        this.hijoIzquierdo = hijoIzquierdo;
    }
    
    public void setHijoDerecho(NodoBinario hijoDerecho) {
        this.hijoDerecho = hijoDerecho;
    }
    
    public void setPadre(NodoBinario padre) {
        this.padre = padre;
    }
    
    // Métodos de utilidad
    public boolean esHoja() {
        return hijoIzquierdo == null && hijoDerecho == null;
    }
    
    public boolean tieneUnHijo() {
        return (hijoIzquierdo != null && hijoDerecho == null) || 
               (hijoIzquierdo == null && hijoDerecho != null);
    }
    
    public boolean tieneDosHijos() {
        return hijoIzquierdo != null && hijoDerecho != null;
    }
    
    // Método auxiliar para operaciones de borrado
    public NodoBinario getUnicoHijo() {
        if (tieneUnHijo()) {
            return (hijoIzquierdo != null) ? hijoIzquierdo : hijoDerecho;
        }
        return null;
    }
}