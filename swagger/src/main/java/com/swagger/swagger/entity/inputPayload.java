/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swagger.swagger.entity;
/**
 *
 * @author trocha
 * 
 * Entity with array of satelites input json entities
 */
public class inputPayload {
    
    private satelitePayload satelites[];

    public satelitePayload[] getSatelites() {
        return satelites;
    }

    public void setSatelites(satelitePayload[] satelites) {
        this.satelites = satelites;
    }
    
    public String toString(){
        
        String s="";
        
        for(int i = 0; i<satelites.length;i++){
            
            s += satelites[i].toString()+"  //  ";
            
        }
        
        return s;
    }


  
    
    
    
}
