/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import static ejb.Canzone.PRINTALL;
import static ejb.Canzone.PRINTBYCAT;
import static ejb.Canzone.PRINTBYID;
import static ejb.Canzone.PRINTBYVOTES;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 *
 * @author dipal
 */
@Entity
@NamedQueries({
    @NamedQuery(name=PRINTBYID,query="SELECT c FROM Canzone c WHERE c.id=?1"),
    @NamedQuery(name=PRINTBYCAT,query="SELECT c FROM Canzone c WHERE c.categoria=?1"),
    @NamedQuery(name=PRINTALL,query="SELECT c FROM Canzone c"),
    @NamedQuery(name=PRINTBYVOTES,query="SELECT c FROM Canzone c WHERE c.voti_ricevuti>?1")
})
    


public class Canzone implements Serializable {

   
    @Id
    private int id;
    private String nome; //Nome del Cantante, il nome del brano non l'ho considerato...
    private String categoria;
    private String incipt;
    private boolean cantato;
    private int voti_ricevuti;

    public Canzone(int id, String nome, String categoria, String incipt, boolean cantato, int voti_ricevuti) {
        this.id = id;
        this.nome = nome;
        this.categoria = categoria;
        this.incipt = incipt;
        this.cantato = cantato;
        this.voti_ricevuti = voti_ricevuti;
    }
    
    
    
    public Canzone(){
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getCategoria() {
        return categoria;
    }

    public String getIncipt() {
        return incipt;
    }

    public boolean isCantato() {
        return cantato;
    }

    public int getVoti_ricevuti() {
        return voti_ricevuti;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public void setIncipt(String incipt) {
        this.incipt = incipt;
    }

    public void setCantato(boolean cantato) {
        this.cantato = cantato;
    }

    public void setVoti_ricevuti(int voti_ricevuti) {
        this.voti_ricevuti = voti_ricevuti;
    }

    @Override
    public String toString() {
        return "Canzone{" + "id=" + id + ", nome=" + nome + ", categoria=" + categoria + ", incipt=" + incipt + ", cantato=" + cantato + ", voti_ricevuti=" + voti_ricevuti + '}';
    }

    public static final String PRINTBYID="printById";
    public static final String PRINTBYCAT="printByCat";
    public static final String PRINTALL="printAll";
    public static final String PRINTBYVOTES="printByVotes";
    
}