/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.sql.DataSourceDefinition;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;

/**
 *
 * @author dipal
 */

@Singleton
@Startup
@DataSourceDefinition(
                        className = "org.apache.derby.jdbc.ClientDataSource",
                        user = "app",
                        password = "app",
                        databaseName = "EsameDB",
                        name = "java:global/jdbc/EsameDS",
                        properties = {"connectionAttributes=;create=true;"} //Ho mancato gli apici 
)

public class CanzoneDatabasePopulator {
    @Inject 
    private CanzoneEJB ejb;
    
    private Canzone c1,c2,c3;
    
     @PostConstruct
    public void popolaDB(){
        c1=new Canzone(1,"Diodato", "Pop", "Sai che cosa penso, Che non dovrei pensare, Che se poi penso sono un animale. E se ti penso tu sei un'anima",false,1000);
        c2=new Canzone(2,"Piero Pelù","Rock","Spingi forte, spingi forte fuori da quel buio. Crescerai aprendo porte Tutti i giorni, stare pronti",false,13);
        c3=new Canzone(3,"Bugo e Morgan", "Pop", "Le buone intenzioni, l'educazione. La tua foto profilo, buongiorno e buonasera. E la gratitudine, le circostanze. Bevi se vuoi ma fallo responsabilmente",false,5000);
        ejb.addCanzone(c1);
        ejb.addCanzone(c2);
        ejb.addCanzone(c3);
    }
    
    @PreDestroy
    public void destroyDB(){
        ejb.removeCanzone(c1);
        ejb.removeCanzone(c2);
        ejb.removeCanzone(c3);
    }
}
