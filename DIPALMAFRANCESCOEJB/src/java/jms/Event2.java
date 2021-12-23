/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jms;

import ejb.Canzone;
import javax.enterprise.event.Observes;

/**
 *
 * @author dipal
 */
public class Event2 {
    public void stampa(@Observes String s){//Cambiato tipo di oggetto 
        System.out.println("Dov'è Bugo?!");
    }
}