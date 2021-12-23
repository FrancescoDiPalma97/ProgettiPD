
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ejb;

import java.util.HashMap;
import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;
//Ho modificato completamente l'interceptor, gestendolo non più con un contatore ed un'hashmap ma solo con quest'ultima


/**
 *
 * @author dipal
 */

public class LogInterceptor {
    private HashMap <String,Integer> cont= new HashMap <>(); 
    
    @AroundInvoke
    public Object conta(InvocationContext ic) {
        try{
         
            
            if(cont.get(ic.getMethod().getName()) != null)
            {
                 Integer x = (Integer)cont.get(ic.getMethod().getName());
                  cont.replace(ic.getMethod().getName(), x+1);
            }
            else
            {
                cont.put(ic.getMethod().getName(), 1);
            }
   
            if(ic.getMethod().getName().equals("printByVotes") && cont.get(ic.getMethod().getName()) < 10)
                return null;
            
            System.out.println("Il metodo "+ ic.getMethod().getName()+" è stato chiamato "+cont.get(ic.getMethod().getName())+" volte");
            return ic.proceed();
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return null;
    }
}


           
  
