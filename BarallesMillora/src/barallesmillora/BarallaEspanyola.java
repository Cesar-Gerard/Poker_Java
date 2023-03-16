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
public class BarallaEspanyola extends Baralla {
    private final int NUMPERPAL = 12;
    
    
    BarallaEspanyola ()
    {
        super ();
        this.crearBaralla();
        super.barrejar();
    }
    
    public void crearBaralla ()
    {
        this.totalCartes = 48;
        this.cartes = (Carta <PalsBarallaEspanyola> []) new Carta [totalCartes];
        PalsBarallaEspanyola [] pals = PalsBarallaEspanyola.values ();
        
        for (int i = 0; i < pals.length; i++) {
            for (int j = 0; j < NUMPERPAL;j++) {
                cartes [(i * NUMPERPAL) + j] = new Carta (j + 1,pals [i]);
            }
            
        }
        
    }
}
