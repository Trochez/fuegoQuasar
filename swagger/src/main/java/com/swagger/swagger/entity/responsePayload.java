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
 *  Entity with with recovered message and located position
 */
public class responsePayload {
    
    private Float position[];
    private String message;

    public Float[] getPosition() {
        return position;
    }

    public void setPosition(Float[] position) {
        this.position = position;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    
}
