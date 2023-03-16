/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

/**
 *
 * @author Usuari
 */
public class BarallaFrancesa extends Baralla {
    private final int NUMPERPAL = 13;
    
    
    public BarallaFrancesa ()
    {
        super ();
        this.crearBaralla();
        super.barrejar();
    }
    
    public void crearBaralla ()
    {
        this.totalCartes = 52;
        this.cartes = (Carta[]) new Carta [totalCartes];
        PalsBarallaFrancesa [] pals = PalsBarallaFrancesa.values ();
        
        for (int i = 0; i < pals.length; i++) {
            for (int j = 0; j < NUMPERPAL;j++) {
                cartes [(i * NUMPERPAL) + j] = new Carta (j + 1,pals [i]);
            }
            
        }
        
    }    
}
