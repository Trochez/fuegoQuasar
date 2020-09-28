/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swagger.swagger.operations;

import static com.swagger.swagger.staticvars.staticsvars.Kenobi;
import static com.swagger.swagger.staticvars.staticsvars.Sato;
import static com.swagger.swagger.staticvars.staticsvars.Skywalker;
/**
 *
 * @author root
 * 
 * Entity to make operations:
 * * Get position with distance to each satelite
 * *Get message with arrays of each satelite
 */
public class operations {
    
    /**
     * 
     * Get position method.
     * 
     *This method get the position of the source with the next expression
     * With pitagoras theorem, we can represent the distance with each satelite of the next equation system
     *
     * (a) (x-x1)²+(y-y1)²=d1²
     * (b) (x-x2)²+(y-y2)²=d2²
     * (c) (x-x3)²+(y-y3)²=d3²
     * 
     * If expand each equation and subtract (a)-(b) and (b)-(c) we will get two equation with the next structure
     * 
     * (1) Ax+ By = C
     * (2) Dx + Ey = F
     * 
     * as result:
     * 
     * x=(CE−FB)/(EA−BD)
     * y=(CD−AF)/(BD−AE)
     * 
     * with the previous system, we can get X and Y
     * 
     * @param distances array with distance between source and each satelite
     * @return Float array with coordinates
     */
       
    public static Float[] GetLocation(Float ... distances){
                
         Float location[] = new Float[2];
        
         if(distances.length<3){
             return null;
         }
        
         Float x,y;
        
         Kenobi.setDistance(distances[0]);
         Skywalker.setDistance(distances[1]);
         Sato.setDistance(distances[2]);
               
         x = (float)((Math.pow(Kenobi.getDistance(),2)-Math.pow(Skywalker.getDistance(),2)+
                 Math.pow(Skywalker.getX(),2)+Math.pow(Skywalker.getY(),2)-
                 Math.pow(Kenobi.getX(),2)-Math.pow(Kenobi.getY(),2))*
                 (2*Sato.getY()-2*Skywalker.getY())-
                 
                 (Math.pow(Skywalker.getDistance(),2)-Math.pow(Sato.getDistance(),2)-
                 Math.pow(Skywalker.getX(),2)-Math.pow(Skywalker.getY(),2)+
                 Math.pow(Sato.getX(),2)+Math.pow(Sato.getY(),2))*
                 (2*Skywalker.getY()-2*Kenobi.getY()))/
                 
                 ((2*Skywalker.getX()-2*Kenobi.getX())*
                 (2*Sato.getY()-2*Skywalker.getY())-
                 (2*Sato.getX()-2*Skywalker.getX())*
                 (2*Skywalker.getY()-2*Kenobi.getY()));
        
         System.out.println("x operations  "+String.valueOf(x));
        
         y = (float)((Math.pow(Kenobi.getDistance(),2)-Math.pow(Skywalker.getDistance(),2)+
                 Math.pow(Skywalker.getX(),2)+Math.pow(Skywalker.getY(),2)-
                 Math.pow(Kenobi.getX(),2)-Math.pow(Kenobi.getY(),2))*
                 (2*Sato.getX()-2*Skywalker.getX())-
                 
                 (Math.pow(Skywalker.getDistance(),2)-Math.pow(Sato.getDistance(),2)+
                 Math.pow(Sato.getX(),2)+Math.pow(Sato.getY(),2)-
                 Math.pow(Skywalker.getX(),2)-Math.pow(Skywalker.getY(),2))*
                 (2*Skywalker.getX()-2*Kenobi.getX()))/
                 
                 ((2*Skywalker.getY()-2*Kenobi.getY())*
                 (2*Sato.getX()-2*Skywalker.getX())-
                 (2*Sato.getY()-2*Skywalker.getY())*
                 (2*Skywalker.getX()-2*Kenobi.getX()));
        
         System.out.println("y operations  "+String.valueOf(y));
        
         location[0] = x;
         location[1] = y;
                 
         return location;
        
    }
    
    /**
     * 
     * To recovered message process.
     * 
     * First check size of parameter array, if this length is less than 3 return null
     * Remove all empty String in the start arrays.
     * Put empty String in the shorter arrays until all array has the same length.
     * Iterate all arrays and compare the words in each array, if the word is not empty, concatenates it in the String response.
     * If the response String isn't empty, add blank space before concatenates the word
     * In the end of iteration, the response String contain the message
     * 
     * @param messages array of String arrays with words that each satelite received
     * @return String with recovered message
     */
    
    public static String GetMessage(String[] ... messages){
        
        String message = "";
        
        if(messages.length<3){
            return null;
        } 
        
        int size = 0;
        
        for(int i=0;i<messages.length;i++){
            
            messages[i] = removeBeginEmpties(messages[i]);

            if(size< messages[i].length){
                size= messages[i].length;
            }
        }
        
         if(size == 0){
            return null;
        }
         
         for(int i=0;i<messages.length;i++){
                          
             messages[i] = arrayWithBlanks(messages[i],size-messages[i].length);
          
        }
                 
                       
        for(int i = 0;i<size;i++){
            
            if(!messages[1][i].equals("")){
                
                if(message.length() == 0){
                    message+= messages[1][i];
                }
                else {
                    message+=" "+ messages[1][i];
                }
                
            }
            else if(!messages[2][i].equals("")){
                
                if(message.length() == 0){
                    message+= messages[2][i];
                }
                else {
                    message+=" "+messages[2][i];
                }
                
            }
            else{
                
                if(message.length() == 0){
                    message+= messages[0][i];
                }
                else {
                    message+=" "+messages[0][i];
                }
                
            }
            
        }
        
        System.out.println("mensaje !!!   "+message);
        
        return message;
    }
    
    
    /**
     * 
     * @param s array message
     * @return new array message without empty strings in the start
     */
    private static String[] removeBeginEmpties(String s[]){
        
        int sizeless = 0;
        
        for(String w:s){
            if(w.equals("")){
                sizeless++;
            }
            else{
                break;
            }
        }
        
        String out[] = new String[s.length-sizeless];
        
        for(int i = sizeless;i<s.length;i++){
            
            out[i-sizeless] = s[i];
                        
        }
        
        return out;
        
    }
    
    /**
     * 
     * @param s array message
     * @param diffSize number of empty String to add
     * @return  new array message with empty string in the start
     */
    private static String[] arrayWithBlanks(String s[],int diffSize){
        
        String out[] = new String [s.length+diffSize];
        
        for(int i = 0; i<diffSize;i++){
        
            out[i] = "";
        
        }
                
        for(int i = 0; i<s.length;i++){
        
            out[i+diffSize] = s[i];
        
        }
        
        
        
        return out;
    }
    
}
