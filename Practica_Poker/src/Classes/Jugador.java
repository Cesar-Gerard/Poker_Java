/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

import java.util.Scanner;

/**
 *
 * @author gerar
 */
public class Jugador {
    //Atributs de classe
    
    String nom;
    Ma actual;

 
//<editor-fold defaultstate="collapsed" desc="Constructors">
    public Jugador(String nom, Ma actual) {
        this.nom = nom;
        this.actual = actual;
    }

    public Jugador(Ma actual) {
        this.actual = actual;
        this.nom="Chuck Norris";
    }
    
 //</editor-fold>


//<editor-fold defaultstate="collapsed" desc="Gettes i Setters">
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Ma getActual() {
        return actual;
    }

    public void setActual(Ma actual) {
        this.actual = actual;
    }
    
//</editor-fold>
    

//<editor-fold defaultstate="collapsed" desc="Métodes Classe">
    public void cartesEnMa(){
        for (int i = 0; i < this.actual.llista_cartes.length; i++) {
                System.out.println(actual.llista_cartes [i].toString ());

            }
    }
    
    
    public void canviar_Carta(Carta canvi[], int posicio[]){
        
        for (int i = 0; i < posicio.length; i++) {
            
             this.actual.llista_cartes[posicio[i]-1]=canvi[i];
                        
        
        }
        
    }
    
           
       //Seleccionar carta
       
       public int [] selecccionarCarta(){
           Scanner entrada = new Scanner(System.in);
           int resultat[]= null;
           String llegir;
           String separats[]=null;
           
           
           
           System.out.println("Quina carta vols intercanviar(Ex:1,2,3) "+this.getNom()+"?");
                      
           llegir = entrada.next();
           
           separats=llegir.split(",");
           resultat = new int[separats.length];
               for (int i = 0; i < separats.length; i++) {
                   resultat[i]=Integer.valueOf(separats[i]);
                   
               }
           
               
               
               
           while(resultat.length>5){
           resultat=null;
           System.out.println("Quina carta vols intercanviar(Ex:1,2,3) "+this.getNom()+"?");
                      
           llegir = entrada.next();
           
           separats=llegir.split(",");
           resultat = new int[separats.length];
               for (int i = 0; i < separats.length; i++) {
                   resultat[i]=Integer.valueOf(separats[i]);
                   
               }   
               
            
           }   
           
           return resultat;
           
           
       }
//</editor-fold>   
}
