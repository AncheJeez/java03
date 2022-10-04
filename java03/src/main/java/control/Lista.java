/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import Modelo.*;
/*
2.- Controlador: desarrolla una Lista con las siguieres características:
    2.1.- Genérica: podrá almacenar cualquier objeto.
    2.2.- Permitirá insertar, modificar y borrar objetos almacenados.
    2.3.- Podrá recorrerse los elementos (objetos) de la lista de uno en uno, en ambos sentidos.
    2.4.- Debe instanciarse, no habrá métodos estáticos:
        Ayuda: clase nodo.
    2.5.- Otras consideraciones que se darán en la explicación.
*/
public class Lista <T> {
    
    /*ATRIBUTOS*/
    private static Nodo inicio;
    private Nodo actual;
    
    /*CONSTRUCTORES*/
    public Lista(){
        inicio = null;
        this.actual = null;
    }
    
    /**
     * @return the inicio
     */
    public static Nodo getInicio() {
        return inicio;
    }

    /**
     * @param aInicio the inicio to set
     */
    public static void setInicio(Nodo aInicio) {
        inicio = aInicio;
    }

    /**
     * @return the actual
     */
    public Nodo getActual() {
        return actual;
    }

    /**
     * @param actual the actual to set
     */
    public void setActual(Nodo actual) {
        this.actual = actual;
    }
    
    /*METODO INSERTAR*/
    public void insertar(T nd){
        Nodo n = new Nodo(nd);
        
        if(getInicio() == null){
            setInicio(n);
        }
        else{
            Nodo aux = getInicio();
            while(aux.getSiguiente() != null){
                aux = aux.getSiguiente();
            }
            n.setAnterior(aux);
            aux.setSiguiente(n);
        }
    }
}
