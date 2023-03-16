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
public class Carta <T> {
    private int numero;     // Número de la carta
    private T pal;

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public T getPal() {
        return pal;
    }

    public void setPal(T pal) {
        this.pal = pal;
    }

    public Carta(int numero, T pal) {
        this.numero = numero;
        this.pal = pal;
    }

    @Override
    public String toString() {
        String resultat = "" + numero;
                
        if (pal.getClass().getSimpleName().equals("PalsBarallaEspanyola")) {
            switch (numero) {
                case 1:
                    resultat = "AS";
                    break;
                case 10:
                    resultat = "SOTA";
                    break;
                case 11:
                    resultat = "CAVALL";
                    break;
                case 12:
                    resultat = "REI";
                    break;
                default:
                    resultat = "" + numero;
                    break;
                        
            }
        }
        else {
            switch (numero) {
                case 1:
                    resultat = "AS";
                    break;
                case 11:
                    resultat = "JOTA";
                    break;
                case 12:
                    resultat = "Q";
                    break;
                case 13:
                    resultat = "K";
                    break;
                default:
                    resultat = "" + numero;
                    break;
                        
            }
            
        }
            
     
        return "Carta{" + "carta=" + resultat + ", pal=" + pal + '}';
    }
}
