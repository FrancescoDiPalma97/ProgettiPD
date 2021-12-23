/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jms;

import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSContext;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author dipal
 */

public class CanzoneJMSClient {
   public static void main(String[] args) throws NamingException{
       Context ctx=new InitialContext();
       Destination topic=(Destination)ctx.lookup("jms/javaee7/Topic");
       ConnectionFactory factory=(ConnectionFactory)ctx.lookup("jms/javaee7/ConnectionFactory");
       CanzoneDTO dto=new CanzoneDTO(3,"Bugo e Morgan","Le buone intenzioni, l'educazione. La tua foto profilo, buongiorno e buonasera. E la gratitudine, le circostanze. Bevi se vuoi ma fallo responsabilmente");
       //CanzoneDTO dto=new CanzoneDTO(2,"Piero Pelù","Spingi forte, spingi forte fuori da quel buio. Crescerai aprendo porte Tutti i giorni, stare pronti");
       
       try(JMSContext jctx=factory.createContext()){
           jctx.createProducer().send(topic,dto);
       }
       catch(Exception e){e.printStackTrace();}
   
   
   } 
}