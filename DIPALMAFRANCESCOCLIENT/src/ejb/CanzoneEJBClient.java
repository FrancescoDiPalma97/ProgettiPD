
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ejb;

import java.util.List;
import java.util.Scanner;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author dipal
 */

public class CanzoneEJBClient {
    public static void main(String[] args) throws NamingException{
        Context ctx=new InitialContext();
        //Ho dichiarato l'oggetto CanzoneEJBRemote  come privato
        CanzoneEJBRemote ejb=(CanzoneEJBRemote)ctx.lookup("java:global/DIPALMAFRANCESCOEJB/CanzoneEJB!ejb.CanzoneEJBRemote"); //Avevo dichiarato la variabile privata
        
         System.out.println("\n Lista delle canzoni: ");
        
        List<Canzone>l1=ejb.printAll();        
        for(Canzone c:l1){
            System.out.println(c);
        }

        
        Scanner in=new Scanner(System.in);
        System.out.println("Inserire la categoria: ");
        String cat=in.nextLine();
        
        System.out.println("\n Lista delle canzoni appartenenti alla categoria " + cat + " : ");
        
        List<Canzone>l2=ejb.printByCat(cat);
        for(Canzone c:l2){
            System.out.println(c);
        }
        
        
        System.out.println("Inserire i voti: ");
        int voti=in.nextInt();

        if(ejb.printByVotes(voti) == null ) //aggiunta controllo
            System.out.println("\n La funzione deve essere chiamata almeno 10 volte per essere stampata ");
        else{    
            System.out.println("\n Lista delle canzoni con voti maggiori di " + voti + " : ");
            List<Canzone>l3=ejb.printByVotes(voti);
            for(Canzone c:l3){
                System.out.println(c);
            }
        }
    }  
}