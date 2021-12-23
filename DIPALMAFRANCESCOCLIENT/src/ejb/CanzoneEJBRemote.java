/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author dipal
 */

@Remote
public interface CanzoneEJBRemote {
    public void addCanzone(Canzone c);
    public void updateCanzone(Canzone c);
    public void removeCanzone(Canzone c);
    public Canzone printById(int id);
    public List<Canzone> printByCat(String cat);
    public List<Canzone> printAll();
    public List<Canzone> printByVotes(int v);
   
    
}