/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws;

import java.util.Scanner;

/**
 *
 * @author dipal
 */
public class CanzoneWSClient {
    public static void main(String[] args){
        
        ws.CanzoneWS service = new ws.CanzoneWS();
        ws.CanzoneEJB port = service.getCanzoneEJBPort();
        //Ho iniettato un oggetto DTO... ho sbagliato completamente ad interpretare la traccia
        Scanner in=new Scanner(System.in);
        System.out.println("Inserire id della canzone che si vuole modificare: ");
        int id=in.nextInt();
        Canzone c = port.printById(id);
        System.out.println("Inserire i voti della canzone che si vuole modificare: ");
        int v=in.nextInt();
        c.setVotiRicevuti(v);
        port.updateCanzone(c);
      
    }
}
