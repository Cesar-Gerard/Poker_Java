/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


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

    
    public int ordenarCartes_i_Retorna_Valor(Ma ordenar){
        List<Carta> ordre = Arrays.asList(ordenar.llista_cartes);
        List<Carta> resultat=ordre.stream().sorted(Comparator.comparingInt(Carta::getNumero).reversed()).collect(Collectors.toList());
        
        return resultat.get(0).getNumero();
    }
    
    
    
    public List<Carta> ordenarCartes(Ma ordenar){
        List<Carta> ordre = Arrays.asList(ordenar.llista_cartes);
        List<Carta> resultat=ordre.stream().sorted(Comparator.comparingInt(Carta::getNumero).reversed()).collect(Collectors.toList());
        
        return resultat;
    }
     
    @Override
    public int compareTo(Ma o) {
        this.setValor(EvaluarMa(this));
        o.setValor(EvaluarMa(o));
        
        int comparacio=comprovarValor(this.getValor(),o.getValor(),this,o);
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
            System.out.println("Escala Reial");
            return 9;
        }else if(Escala_Color(entrada)){
            System.out.println("Escala Color");
            return 8;
        }else if(Poquer(entrada)){
            System.out.println("Poquer");
            return 7;
        }
        else if(Full_House(entrada)){
            System.out.println("Full House");
            return 6;
        }else if(Color(entrada)){
            System.out.println("Color");
            return 5;
            
        }else if(Escala(entrada)){
            System.out.println("Escala");
            return 4;
        }
        else if(Trio(entrada)){
            System.out.println("Trio");
            return 3;
        }
        else if(DoblePar(entrada)){        
            System.out.println("Doble Par");
            return 2;
        }
        else if(Par(entrada)){
            System.out.println("Par");
            return 1;
        }
        else{
            System.out.println("Carta Alta");
            return 0;
        }
        
    }
     
    //Compara els valors de la ma del jugador i el rival
    private int comprovarValor(int jugador, int Chuck,Ma tu,Ma chuck) {
        if(jugador>Chuck){
            return 1;
        }else if(Chuck>jugador){
            return 0;
        }else if(jugador == Chuck){
                if(Desempat(tu,chuck)==1){
                    return 1;
                }else if (Desempat(tu,chuck)==0){
                    return 0;
                }else{
                    return -1;
                }
                
            
        }else{
            return 2;
        } 
    }
    
    //En cas de empat compara les cartes depenent 
    private int Desempat(Ma tu, Ma chuck) {
        int resultat=-1;
        int val1=0,val2=0;
        List<Carta> primera= null;
        List<Carta> segona=null; 
        
        List<Integer> v1=null;
        List<Integer> v2=null;
        
        switch(tu.getValor()){
            case 6,8,4:
                 val1=ordenarCartes_i_Retorna_Valor(tu);
                 val2=ordenarCartes_i_Retorna_Valor(chuck);
                 
                 if(val1>val2){
                     resultat= 1;
                 }else if(val1<val2){
                     resultat=0;
                 }else if(val1==val2){
                     resultat=-1;
                 }  
            break;
            
            case 0:
                    
                    primera= ordenarCartes(tu);
                    segona= ordenarCartes(chuck);
                    
                   resultat= CartaAlta(primera,segona);
            break;
            
            
            case 2:
                
                v1=ValorDosParelles(tu);
                v2 = ValorDosParelles(chuck);
                
                if(v1.get(0)>v2.get(0)){
                    resultat=1;
                }else if( v1.get(0)< v2.get(0)){
                    resultat=0;
                }else{
                    
                    if(v1.get(1)>v2.get(1)){
                        resultat=1;
                    }else if( v1.get(1)< v2.get(1)){
                        resultat=0;
                    }else{
                        resultat=-1;
                    }
                    
                }
                
                
            break;
            
            
            case 1:
                v1=ValorPar(tu);
                v2 =ValorPar(chuck);
                
                if(v1.get(0)>v2.get(0)){
                    resultat=1;
                }else if( v1.get(0)< v2.get(0)){
                    resultat=0;
                }else{
                   
                    v1.remove(v1.get(0));
                    v2.remove(v2.get(0));
                    
                    
                    Collections.sort(v1, Collections.reverseOrder());
                    Collections.sort(v2,Collections.reverseOrder());
                     
                   
                    
                    
                    if(v1.get(0)>v2.get(0)){
                        resultat=1;
                    }else if( v1.get(0)< v2.get(0)){
                        resultat=0;
                    }else{
                        if(v1.get(1)>v2.get(1)){
                            resultat=1;
                        }else if( v1.get(1)< v2.get(1)){
                            resultat=0;
                        }else{
                            if(v1.get(2)>v2.get(2)){
                                resultat=1;
                            }else if( v1.get(2)< v2.get(2)){
                                resultat=0;
                            }else{
                                resultat=-1;
                            }
                        }
                    }
                }
            break;
            
            case 3:
                val1=ValorTrio(tu);
                val2=ValorTrio(chuck);
                
                if(val1>val2){
                    resultat=1;
                }else if(val1 <val2){
                    resultat=0;
                }else{
                    resultat=-1;
                }
                
            break;
            
           
        }
       
        return resultat;
        
    }

 

 //<editor-fold defaultstate="collapsed" desc="Trio">
    private boolean Trio(Ma entrada){
     int compt1=0;
     int compt2=0;
     int compt3=0;
     
     List<Carta> par = ordenarCartes(entrada);
     
     int val1= par.get(0).getNumero();
     int val2=0;
     int val3=0;
     
     
     
        for (int i = 0; i < par.size(); i++) {
            
            if(par.get(i).getNumero()==val1){
                compt1++;
            }else{
                if(compt2==0){
                    val2=par.get(i).getNumero();
                    compt2++;
                }else{
                    if(par.get(i).getNumero()==val2){
                        compt2++;
                    }else{                       
                        if(compt3==0){
                            val3=par.get(i).getNumero();
                            compt3++;
                        }else if(par.get(i).getNumero()==val3){
                          compt3++;
                        }
                    }
                      
                }
            }
            
        }
        
        if((compt1==3 && compt2==1 && compt3 ==1) || (compt2==3 && compt1==1 && compt3 ==1) || (compt3==3 && compt2==1 && compt1 ==1)){
            return true;
        }else{
            return false;
        }
     
    }    
    
    
    
    
    private int ValorTrio(Ma entrada){
     int compt1=0;
     int compt2=0;
     int compt3=0;
     
     List<Carta> par = ordenarCartes(entrada);
     
     int val1= par.get(0).getNumero();
     int val2=0;
     int val3=0;
     
     
     
        for (int i = 0; i < par.size(); i++) {
            
            if(par.get(i).getNumero()==val1){
                compt1++;
            }else{
                if(compt2==0){
                    val2=par.get(i).getNumero();
                    compt2++;
                }else{
                    if(par.get(i).getNumero()==val2){
                        compt2++;
                    }else{                       
                        if(compt3==0){
                            val3=par.get(i).getNumero();
                            compt3++;
                        }else{
                          compt3++;
                        }
                    }
                      
                }
            }
            
        }
        
        int resultat=0;
        
        if(compt1==3){
            resultat=val1;
        }
        else if(compt2==3){
            resultat=val2;
        }
        else if(compt3==3){
            resultat=val3;
        }
        
        return resultat;
    }
    
//</editor-fold>    
    
//<editor-fold defaultstate="collapsed" desc="Par">
    private boolean Par(Ma entrada){
     int compt1=0;
     int compt2=0;
     int compt3=0;
     int compt4=0;
     
     List<Carta> par = ordenarCartes(entrada);
     
     int val1= par.get(0).getNumero();
     int val2=0;
     int val3=0;
     int val4=0;
     
     
     
        for (int i = 0; i < par.size(); i++) {
            
            if(par.get(i).getNumero()==val1){
                compt1++;
            }else{
                if(compt2==0){
                    val2=par.get(i).getNumero();
                    compt2++;
                }else{
                    if(par.get(i).getNumero()==val2){
                        compt2++;
                    }else{
                        
                        if(compt3==0){
                            val3=par.get(i).getNumero();
                            compt3++;
                        }else{
                            if(par.get(i).getNumero()==val3){
                                compt3++;
                            }else{
                                if(compt4==0){
                                    val4=par.get(i).getNumero();
                                    compt4++;
                                }else{
                                    if(par.get(i).getNumero()==val4){
                                        compt4++;
                                    }
                                }
                            }
                        }
                    }
                      
                }
            }
            
        }
        
        if(compt1==2 || compt2==2 || compt3==2 || compt4==2){
            return true;
        }else{
            return false;
        }
     
    }    
    
    
    private List<Integer> ValorPar(Ma entrada){
        int compt1=0;
     int compt2=0;
     int compt3=0;
     int compt4=0;
     
     List<Carta> par = ordenarCartes(entrada);
     
     int val1= par.get(0).getNumero();
     int val2=0;
     int val3=0;
     int val4=0;
     
     
     
        for (int i = 0; i < par.size(); i++) {
            
            if(par.get(i).getNumero()==val1){
                compt1++;
            }else{
                if(compt2==0){
                    val2=par.get(i).getNumero();
                    compt2++;
                }else{
                    if(par.get(i).getNumero()==val2){
                        compt2++;
                    }else{
                        
                        if(compt3==0){
                            val3=par.get(i).getNumero();
                            compt3++;
                        }else{
                            if(par.get(i).getNumero()==val3){
                                compt3++;
                            }else{
                                if(compt4==0){
                                    val4=par.get(i).getNumero();
                                    compt4++;
                                }else{
                                    
                                        compt4++;
                                    
                                }
                             
                            }
                        }
                    }
                      
                }
            }
            
        }
        
        List<Integer> resultat = new ArrayList<Integer>();
        
        
        if(compt1==2){
            resultat.add(val1);
            resultat.add(val2);
            resultat.add(val3);
            resultat.add(val4);
        }else if(compt2==2){
            resultat.add(val2);
            resultat.add(val1);
            resultat.add(val3);
            resultat.add(val4);
        }else if(compt3==2){
            resultat.add(val3);
            resultat.add(val2);
            resultat.add(val1);
            resultat.add(val4);
            
        }else if(compt4==2){
            resultat.add(val4);
            resultat.add(val3);
            resultat.add(val2);
            resultat.add(val1);
        }
        
        
        
        
        return resultat;
        
    }

    
//</editor-fold> 

//<editor-fold defaultstate="collapsed" desc="DoblePar">
    private boolean DoblePar(Ma entrada){
     int compt1=0;
     int compt2=0;
     int compt3=0;
     
     List<Carta> doblepar = ordenarCartes(entrada);
     
     int val1= doblepar.get(0).getNumero();
     int val2=0;
     int val3=0;
     
     
     
        for (int i = 0; i < doblepar.size(); i++) {
            
            if(doblepar.get(i).getNumero()==val1){
                compt1++;
            }else{
                if(compt2==0){
                    val2=doblepar.get(i).getNumero();
                    compt2++;
                }else{
                    if(doblepar.get(i).getNumero()==val2){
                        compt2++;
                    }else{
                        if(val3==0){
                            compt3++;
                            val3=doblepar.get(i).getNumero();
                        }
                        else if(doblepar.get(i).getNumero()==val3){
                         compt3++;   
                        }
                        
                    }
                }
            }
            
        }
        
        if((compt1==2 && compt2==2) || (compt3==2 && compt1==2) || (compt2==2 && compt3==2)){
            return true;
        }else{
            return false;
        }
     
    }    
    
    
    
    private List<Integer> ValorDosParelles(Ma tu){
     int compt1=0;
     int compt2=0;
     int compt3=0;
     
     List<Carta> doblepar = ordenarCartes(tu);
     
     int val1= doblepar.get(0).getNumero();
     int val2=0;
     int val3 =0;
     
     
        for (int i = 0; i < doblepar.size(); i++) {
            
            if(doblepar.get(i).getNumero()==val1){
                compt1++;
            }else{
                if(compt2==0){
                    val2=doblepar.get(i).getNumero();
                    compt2++;
                }else{
                    if(doblepar.get(i).getNumero()==val2){
                        compt2++;
                    }else{
                        val3=doblepar.get(i).getNumero();
                        compt3++;
                    }
                }
            }
            
        }
        
        
        List<Integer> resultat = new ArrayList<Integer>();
        
        if((compt1==2)){
            resultat.add(val1);
        }
        if (compt2 ==2){
            resultat.add(val2);
        }
        if(compt3==2){  
            resultat.add(val3);
        }
        
        return resultat;
    }
    
//</editor-fold> 
    
//<editor-fold defaultstate="collapsed" desc="CartaAlta">
    private int CartaAlta(List<Carta> primera, List<Carta> segona){
     
        if(primera.get(0).getNumero()>segona.get(0).getNumero()){
            return 1;
        }else if(primera.get(0).getNumero()<segona.get(0).getNumero()){
            return 0;
        }else if(primera.get(0).getNumero()==segona.get(0).getNumero()){
            if(primera.get(1).getNumero()>segona.get(1).getNumero()){
                return 1;
            }else if(primera.get(1).getNumero()<segona.get(1).getNumero()){
                return 0;
            }else{
                return -1;
            }
            
        }
        return 2;
    }    
    
//</editor-fold>  

//<editor-fold defaultstate="collapsed" desc="Escala">
    private boolean Escala(Ma comparar){
      int compt=1;
        
       
               
            List<Carta> ordenada = ordenarCartes(comparar); 
            
            for (int i = 1; i < ordenada.size(); i++) {
                
                if(ordenada.get(i).getNumero()==ordenada.get(i-1).getNumero()-1){
                    compt++;
                }
                
            }
        
        
       
        if(compt ==llista_cartes.length){
            return true;
        }else{
            return false;
        }
    }    
    
//</editor-fold>  
     
//<editor-fold defaultstate="collapsed" desc="Póquer">
    private boolean Poquer(Ma comparar){
       int comv1=0;
        int comv2=0;
        
        int ref = comparar.llista_cartes[0].getNumero();
        int ref2=0;
        
        for (int i = 0; i < comparar.llista_cartes.length; i++) {
            if(comparar.llista_cartes[i].getNumero()==ref){
                comv1++;
            }else{
                if(comv2==0){
                    ref2 = comparar.llista_cartes[i].getNumero();
                    comv2++;
                }else if(comv2!=0 && comparar.llista_cartes[i].getNumero()==ref2){
                    comv2++;
                }
            }
            
        }
        
        if(comv1==4 && comv2==1){
            return true;
        }else{
            return false;
        }
    }    
    
//</editor-fold>   
    
//<editor-fold defaultstate="collapsed" desc="Escala_Color">
    private boolean Escala_Color(Ma comparar){
      int compt=1;
        
        if(compararPalReial(comparar.llista_cartes)){
               
            List<Carta> ordenada = ordenarCartes(comparar); 
            
            for (int i = 1; i < ordenada.size(); i++) {
                
                if(ordenada.get(i).getNumero()==ordenada.get(i-1).getNumero()-1){
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
    
//</editor-fold>   
   
//<editor-fold defaultstate="collapsed" desc="Color">
    private boolean Color(Ma comparar){
        if(compararPalReial(comparar.llista_cartes)){
            return true;
        }else{
            return false;
        }
    }    
    
//</editor-fold>
    
//<editor-fold defaultstate="collapsed" desc="Full_House"> 
    private boolean Full_House(Ma comparar){
        int comv1=0;
        int comv2=0;
        
        int ref = comparar.llista_cartes[0].getNumero();
        int ref2=0;
        
        for (int i = 0; i < comparar.llista_cartes.length; i++) {
            if(comparar.llista_cartes[i].getNumero()==ref){
                comv1++;
            }else{
                if(comv2==0){
                    ref2 = comparar.llista_cartes[i].getNumero();
                    comv2++;
                }else if(comv2!=0 && comparar.llista_cartes[i].getNumero()==ref2){
                    comv2++;
                }
            }
            
        }
        
        if(comv1==3 && comv2==2){
            return true;
        }else{
            return false;
        }
        
        
    }
    
//</editor-fold>
    
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
        if(entrada.controlaNum().equals("14") || entrada.controlaNum().equals("10") || entrada.controlaNum().equals("11") || entrada.controlaNum().equals("12") || entrada.controlaNum().equals("13")){
            return true;
        }      
        return false;
    }

    
//</editor-fold>

    
}
