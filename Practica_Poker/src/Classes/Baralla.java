 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.util.Random;

/**
 *
 * @author Usuari
 */
public abstract class Baralla <T> {
    protected Carta  cartes [];
    protected int totalCartes;
    private int segCarta;
    private int numCartesRestants;
    
    public abstract void crearBaralla ();
    
    Baralla ()
    {
        segCarta = 0;
    }

    public void mostrarBaralla ()
    {
        for (Carta c: cartes) {
            System.out.println(c.toString());
        }
    }
    
    public void cartaActual ()
    {
        System.out.println("La carta actual és: " + cartes [segCarta].toString ());
    }    
    
    public Carta segCarta ()
    {
        Carta c = null;

        if (this.segCarta == totalCartes) {
            System.out.println("S'ha arribat a l'última carta");
        }
        else {
            c = cartes [this.segCarta];
            this.segCarta ++;
        }

        return c;
    }  

    public int cartesDisponibles ()
    {
        return (totalCartes - segCarta);
    }    
    
    
    public Carta [] repartirCartes (int num_cartes)
    {
        if (numCartesRestants > this.cartesDisponibles()) {
            System.out.println("No es poden repartir tantes cartes");

            return (null);
        }
        else {
            Carta [] donarCartes = new Carta [num_cartes];

            for (int i = 0; i < donarCartes.length; i++) {
                donarCartes [i] = this.segCarta ();

            }

            return (donarCartes);
        }
    }    
 
    public void cartesJugades ()
    {
        if (this.segCarta == 0) {
            System.out.println("No ha sortit cap carta");
        }
        else {
            for (int i = 0; i < this.segCarta; i++) {
                System.out.println(cartes [i].toString ());

            }
        }
    }    
    
    
    public void barrejar ()
    {
        int aleatori = 0;
        Carta c;
        Random r1 = new Random ();
        
        for (int i = 0; i < 500; i++) {
            for (int j = 0; j < cartes.length; j++) {
                aleatori = r1.nextInt(totalCartes);
                
                // Intercanvi de valors entre les cartes trobades
                
                c = cartes [j];
                cartes [j] = cartes [aleatori];
                cartes [aleatori] = c;
            }
            
        }
    }    
}
