/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package barallesmillora;

/**
 *
 * @author Usuari
 */
public class BarallesMillora {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        BarallaFrancesa b = new BarallaFrancesa ();
        
       // b.mostrarBaralla();
        b.repartirCartes(5);
        
        b.cartesJugades();
        
        
        
        /*BarallaEspanyola e = new BarallaEspanyola ();
        
        e.mostrarBaralla ();*/
    }
    
}
