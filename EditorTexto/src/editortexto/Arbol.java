/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package editortexto;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Joshua
 */
class Nodo{
    Texto texto;
    Nodo izquierda;
    Nodo derecha;
    
    public Nodo(Texto palabra){
        this.texto=palabra;
        
    }
}
public class Arbol {
    Nodo cabeza;
    
    /*public Arbol(Nodo cabeza){
        this.cabeza=cabeza;
    }*/
    public void insertar(Nodo a) {
    cabeza = insertarRecursivo(cabeza, a);
}
    private Nodo insertarRecursivo(Nodo actual, Nodo a) {
    if (actual == null) {
        return a;
    }

    if (a.texto.palabra.compareTo(actual.texto.palabra) < 0) {
        actual.izquierda = insertarRecursivo(actual.izquierda, a);
    } else if (a.texto.palabra.compareTo(actual.texto.palabra) >= 0) {
        actual.derecha = insertarRecursivo(actual.derecha, a);
    } else {
       System.out.println("error");
    }
return actual;
    }
    
   public List<Texto> buscar(String palabraBuscada) {
    List<Texto> coincidencias = new ArrayList<>();
    buscarPostOrden(cabeza, palabraBuscada, coincidencias);
    return coincidencias;
}

private void buscarPostOrden(Nodo actual, String palabraBuscada, List<Texto> coincidencias) {
    if (actual != null) {
        buscarPostOrden(actual.izquierda, palabraBuscada, coincidencias);
        buscarPostOrden(actual.derecha, palabraBuscada, coincidencias);
        if (actual.texto.palabra.equals(palabraBuscada)) {
            coincidencias.add(actual.texto);
        }
    }
}
}
