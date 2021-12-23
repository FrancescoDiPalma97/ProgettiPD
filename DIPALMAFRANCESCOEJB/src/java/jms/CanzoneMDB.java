/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jms;



import javax.jms.Message;
import javax.jms.MessageListener;
import ejb.Canzone;
import javax.enterprise.event.Event;
import ejb.CanzoneEJB;
import javax.ejb.MessageDriven;
import javax.inject.Inject;


/**
 *
 * @author dipal
 */


@MessageDriven(mappedName="jms/javaee7/Topic")
public class CanzoneMDB implements MessageListener{

    @Inject 
    CanzoneEJB ejb;
    
    
    @Inject
    Event<Canzone> event;
    
    @Inject
    Event<String> event2;//Ho cambiato tipo all'evento in modo da distinguerlo dall'altro
    
    
     //Ho chiamato il metodo "modifica", invece di onMessage
    public void onMessage(Message message) {
      //Mancato Try-Catch
        try{
            
            CanzoneDTO dto=message.getBody(CanzoneDTO.class);
            Canzone c=ejb.printById( dto.getId());
            //Usato sempre == per confronto con stringhe
            if(c.getIncipt().equals(dto.getIncipt())){
                if(c.getNome().equals("Bugo e Morgan") && dto.getNome().equals("Bugo e Morgan")){ //Ho spostato il controllo del nome all'interno del controllo dell'incipt, cambiando leggermente la struttura nidificata if-else, eliminando il controllo dell'incipt("Le brutte intenzioni... ") poichè glielo avevo già passato precedentemente..
                    c.setCantato(true);
                    c.setNome("Morgan");
                    ejb.updateCanzone(c);
                    event2.fire("Bugo");
                } 
                else{
                     c.setCantato(true);
                     ejb.updateCanzone(c);
                     event.fire(c);
                }   
            }
  
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    
    
}