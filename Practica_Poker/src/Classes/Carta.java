/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

/**
 *
 * @author gerar
 */
public class Carta{
    
    //Atributs de Classe
    private int numero;     // Número de la carta
    private PalsBarallaFrancesa pal;


//<editor-fold defaultstate="collapsed" desc="Getters i Setters">
    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public PalsBarallaFrancesa getPal() {
        return pal;
    }

    public void setPal(PalsBarallaFrancesa pal) {
        this.pal = pal;
    }
//</editor-fold>
    

//Constructors
    public Carta(int numero, PalsBarallaFrancesa pal) {
        this.numero = numero;
        this.pal = pal;
    }
    


//<editor-fold defaultstate="collapsed" desc="Metodes Classe">
    @Override
    public String toString() {
        String resultat = "" + numero;
               
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
            
        
            
     
        return "Carta{" + "carta=" + resultat + ", pal=" + pal + '}';
    }
    
    
    public String dibuixaCarta (int line,int col)
    {
        int i;
        String carta,color,posicio;

        
        posicio = "\033[" + line + ";" + col + "H";

        if (pal == PalsBarallaFrancesa.CORS || pal == PalsBarallaFrancesa.DIAMANTS) {
            color = ColorsText.RED_BOLD_BRIGHT;
        }
        else {
            color = ColorsText.PURPLE_BOLD_BRIGHT;
        }
        
        carta = color + posicio + "┌─────────┐";

        line ++;        
        posicio = "\033[" + line + ";" + col + "H";

        
        if (this.controlaNum().equals ("10"))
            carta += color + posicio + "|" + this.controlaNum() + "       |";
        else
            carta += color + posicio + "|" + this.controlaNum() + "        |";

        
        line ++;
        posicio = "\033[" + line + ";" + col + "H";
        
        for (i = 0; i < 1; i ++) {
            carta += color + posicio + "|         |";
            line ++;
            posicio = "\033[" + line + ";" + col + "H";
        }
        
        carta += color + posicio + "|    " + pal + "    |";
        line ++;
       posicio = "\033[" + line + ";" + col + "H";

        for (i = 0; i < 1; i ++) {
            carta += color + posicio + "|         |";
            line ++;
            posicio = "\033[" + line + ";" + col + "H";
            
        }
        if (this.controlaNum ().equals ("10")) 
            carta += color + posicio + "|       " + this.controlaNum () + "|";
        else
            carta += color + posicio + "|        " + this.controlaNum () + "|";
            
        line ++;
        posicio = "\033[" + line + ";" + col + "H";
        carta += color + posicio + "└─────────┘";
        
        return carta;
        
        
        
    }
    
    public String controlaNum(){
        
        String resultat = String.valueOf(this.numero);
        
        return resultat;
    }
//</editor-fold>
    
       
}
