/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swagger.swagger.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 *
 * @author trocha
 * 
 * Entity to represent satelite payload with message, name and distance
 */

@ApiModel("Model satelitePayload")
public class satelitePayload {
    
    @ApiModelProperty(value = "the satelite's name", required = true)
    private String name;
    
    @ApiModelProperty(value = "the satelite's distance to emisor", required = true)
    private Float distance;
    
    @ApiModelProperty(value = "the received message", required = true)
    private String message[];
    
    public satelitePayload(String name, Float distance, String message[]){
        this.name = name;
        this.distance = distance;
        this.message = message;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getDistance() {
        return distance;
    }

    public void setDistance(Float distance) {
        this.distance = distance;
    }

    public String[] getMessage() {
        return message;
    }

    public void setMessage(String[] message) {
        this.message = message;
    }
    
    public String toString(){
        
        String s = null;
        
        s = "name : "+name+" distance : "+distance+" mesage : "+message;
        
        return s;
        
        
    }
   
    
    
    
}
