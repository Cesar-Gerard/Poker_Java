/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

/**
 *
 * @author gerar
 */
public class Ma implements Comparable<Ma>{

//Atributs de classe
    public Carta [] llista_cartes;
    public int valor;
   
//Constructor
    public Ma(Carta[] llista_cartes) {
        this.llista_cartes = llista_cartes;
        valor=0;
    }

    
 //<editor-fold defaultstate="collapsed" desc="Getters i Setters">
    public Carta[] getLlista_cartes() {
        return llista_cartes;
    }

    public void setLlista_cartes(Carta[] llista_cartes) {
        this.llista_cartes = llista_cartes;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    
 //</editor-fold>

    
    public void pintar(){
        for (int i = 0; i < llista_cartes.length; i++) {
            llista_cartes[i].dibuixaCarta(i, i+1);
            
        }
    }

    @Override
    public int compareTo(Ma o) {
        this.setValor(EvaluarMa(this));
        o.setValor(EvaluarMa(o));
        
        int comparacio=comprovarValor(this.getValor(),o.getValor());
        int resultat=0;
        
        
        switch(comparacio){
            case 0://Perdre
                resultat=0;
            break;
            
            case 1://Guanyar
                resultat=1;
            break;
            
            case -1://Empat
                resultat=-1;
            
        }
        
        return resultat;
    }

    
    //Comprova quin es el valor de la Ma 
    private int EvaluarMa(Ma entrada){
        if(EscalaReial(entrada)){
            return 7;
        }else{
            return 0;
        }
        
    }
    
    
      //Compara els valors de la ma del jugador i el rival
    private int comprovarValor(int jugador, int Chuck) {
        if(jugador>Chuck){
            return 1;
        }else if(Chuck>jugador){
            return 0;
        }else if(jugador == Chuck){
            return -1;
        }else{
            return 2;
        } 
    }
    
//<editor-fold defaultstate="collapsed" desc="Escala Reial">
    
    
    
    
    //Comprova si totes les cartes de una ma comparteixen Pals
    private boolean compararPalReial(Carta [] llista){
        
        int numcartes=0;
        
        PalsBarallaFrancesa referencia = llista[0].getPal();
        
        
        
        
        for (int i = 0; i < llista.length; i++) {
            if(llista[i].getPal().equals(referencia)){
                numcartes++;
            }
        }
        
        if(numcartes==llista.length){
            return true;
        }else{
            return false;
        }
        
        
    }
    
    //Comprova si la ma es Escala Reial o no
    private boolean EscalaReial(Ma comparar){
        
        int compt=0;
        
        if(compararPalReial(comparar.llista_cartes)){
              
            for (int i = 0; i < comparar.llista_cartes.length; i++) {
                
                if(comprovarValorEscalaReial(comparar.llista_cartes[i])){
                    compt++;
                }
                
            }
        }
        
      
        if(compt ==llista_cartes.length){
            return true;
        }else{
            return false;
        }
        
    }
    
    
    //Comprova que es compleixin les condicions de numero de carta per a l'Escala Reial
    private boolean comprovarValorEscalaReial(Carta entrada){
        if(entrada.controlaNum().equals("1") || entrada.controlaNum().equals("10") || entrada.controlaNum().equals("11") || entrada.controlaNum().equals("12") || entrada.controlaNum().equals("13")){
            return true;
        }      
        return false;
    }

    
//</editor-fold>
    
  

      
}
