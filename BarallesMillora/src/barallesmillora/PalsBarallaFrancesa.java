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
public enum PalsBarallaFrancesa {
    DIAMANTS("♦"),
    PIQUES("♠"),
    CORS("♥"),
    TREVOLS("♣");
    
    private String car_unicode;

    private PalsBarallaFrancesa(String car_unicode) {
        this.car_unicode = car_unicode;
    }

    public String getCar_unicode() {
        return car_unicode;
    }
    
    
    
}
