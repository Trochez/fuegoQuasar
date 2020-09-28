/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swagger.swagger.entity;

/**
 *
 * @author root
 * 
 * Entity to define some static parameters of satelites (position and name)
 * Also distance editable parameter to define source distance
 */
public class satelite {
    
    private Float x;
    private Float y;
    private Float distance;
    private String name;
    public satelite(String name, Float x, Float y){
        
        this.name=name;
        this.x=x;
        this.y=y;
        
    }
    
    public Float getX(){
        return this.x;
    }
    
    public Float getY(){
        return this.y;
    }
    
    public String getName(){
        return this.name;
    }
    
    public void setX(Float x){
        this.x = x;
    }
    
    public void setY(Float y){
        this.y = y;
    }
    
     public void setName(String name){
        this.name = name;
    }
     
     public Float getDistance(){
        return distance;
    }
    
     public void setDistance(Float distance){
        this.distance = distance;
    }
    
}
