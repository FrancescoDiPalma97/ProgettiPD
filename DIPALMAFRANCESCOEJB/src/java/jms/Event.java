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
public class Event {
    public void stampa(@Observes Canzone c){
        System.out.println("La canzone è stata modificata");
    }
    
}
