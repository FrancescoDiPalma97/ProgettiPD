/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ejb;

import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author dipal
 */

public class CanzoneDatabaseProducer {
    @Produces
    @PersistenceContext(unitName="EsamePU") //Ho scritto PersistentContext invece di PersistenceContext
    private EntityManager em;
}
