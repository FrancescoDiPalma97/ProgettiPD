/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jms;

import java.io.Serializable;

/**
 *
 * @author dipal
 */
public class CanzoneDTO implements Serializable{
    private int id;
    private String nome;
    private String incipt;

    public CanzoneDTO(int id, String nome, String incipt) {
        this.id = id;
        this.nome = nome;
        this.incipt = incipt;
    }

    public CanzoneDTO(){
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getIncipt() {
        return incipt;
    }

    public void setIncipt(String incipt) {
        this.incipt = incipt;
    }
    
    
}
