/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package practica_poker;

import Classes.BarallaFrancesa;
import Classes.Carta;
import Classes.Jugador;
import Classes.Ma;
import Classes.PalsBarallaFrancesa;
import java.util.Scanner;

/**
 *
 * @author gerar
 */
public class Practica_Poker {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        BarallaFrancesa b = new BarallaFrancesa ();
          
        
       Ma usuari = new Ma(b.repartirCartes(5));
       Ma rival = new Ma(b.repartirCartes(5));
          

       Jugador tu = new Jugador(inserirJugador(),usuari);
       Jugador Chuck = new Jugador(rival);
       

       System.out.println("------------"+tu.getNom()+"----------");
       tu.cartesEnMa(); 
       if(preguntarcanvi()){
            jugar(tu,b);
            
        }
       
 
       System.out.println("------------Chuck--------------");
       Chuck.cartesEnMa();
       if(preguntarcanvi()){
            jugar(Chuck,b);
            

        }
       
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        
       System.out.println("------------"+tu.getNom()+"----------");
       tu.cartesEnMa();
       System.out.println("------------Chuck--------------");
       Chuck.cartesEnMa();
       
       
        int resultat= tu.getActual().compareTo(Chuck.getActual());
        MissatgeResultat(resultat,tu);
        
        
    }
        
    

    
 //<editor-fold defaultstate="collapsed" desc="Metodes">
    
    
    //Creació de nom de usuari
        public static String inserirJugador(){
            String nom="";
        
            Scanner entrada = new Scanner(System.in);
        
            System.out.println("Benvingut jugador, introdueix el teu nom:");
        
            nom= entrada.next();
            return nom;
       }
        

        
    //Demanar canvi
        
       public static boolean preguntarcanvi(){
           Scanner entrada = new Scanner(System.in);
           int i=0;
           
           
           
        while(i==0){
           System.out.println("Vols canviar alguna carta?(Si,No)");
           
           String resposta=entrada.next();
           
           resposta=resposta.toLowerCase();
           
           if(resposta.equals("si")){
               return true;
               
           }else if(resposta.equals("no")){
               return false;
               
           }else{
               i=0;
           }
         }    
        return false;
                     
       }
       
    
    //Nucli jugable
       public static void jugar(Jugador tu,BarallaFrancesa b){
           
           
           int posicio[]=tu.selecccionarCarta();
            
            Carta intercanvi[] = new Carta [posicio.length];
            System.out.println("-----------"+tu.getNom()+"----------");
            for (int i = 0; i < intercanvi.length; i++) {
                intercanvi[i]=b.segCarta();
                
            }

            
            tu.canviar_Carta(intercanvi, posicio);
            tu.cartesEnMa();
            
       }

        
      //Resultat de la partida 
      private static void MissatgeResultat(int resultat,Jugador tu) {
        switch(resultat){
            case 1:
                System.out.println("Felicitats "+tu.getNom()+" has gunyat a Chuck Norris");
            break;
            
            case 0:
                System.out.println("Perdut");
            break;
            
            case -1:
                System.out.println("Heu quedat empat");
            break;
            
            
        }
    }
       
//</editor-fold>

}
