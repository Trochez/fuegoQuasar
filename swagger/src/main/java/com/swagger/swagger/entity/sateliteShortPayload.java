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
 * Entity to represent short satelite payload with same information that the other payload entity without name
 */
public class sateliteShortPayload {
    
    private Float distance;
    private String message[];

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
    
    
    
}
