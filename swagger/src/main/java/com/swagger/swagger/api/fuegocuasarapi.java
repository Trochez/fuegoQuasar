/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swagger.swagger.api;

import com.swagger.swagger.entity.inputPayload;
import com.swagger.swagger.entity.responsePayload;
import com.swagger.swagger.entity.satelitePayload;
import com.swagger.swagger.entity.sateliteShortPayload;
import static com.swagger.swagger.operations.operations.GetLocation;
import static com.swagger.swagger.operations.operations.GetMessage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.LinkedHashMap;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


/**
 *
 * @author root
 */
@RestController
@RequestMapping("/fuegoQuasar")
@Api(value = "fuegoQuasar microservice", description = "This API has tirlateration and message reconstruction functions")
public class fuegocuasarapi {
    
    private LinkedHashMap<String,satelitePayload> satelites = new LinkedHashMap<>();

    
    /**
     *
     * Metodo que responde peticiones post recibiendo como parámetro un objeto json con 
     * la iformación obtenida por cada satélite
     * 
     * @param satelites Object with satelites data
     * @param res HttpServletResponse object to response http code
     * @return object with source position and message recovered
     */
    @PostMapping("/topsecret")
    @ApiOperation(value = "Return position and source's message ", notes = "Return position and source's message ")
    public responsePayload topsecret(@RequestBody inputPayload satelites,HttpServletResponse res){
        
        if(satelites.getSatelites().length<3){
            System.out.println("less than 3 satelites");
            res.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return null;
        }
        
        for(satelitePayload sp:satelites.getSatelites()){
            this.satelites.put(sp.getName(), sp);
        }
        
        responsePayload rp = new responsePayload();
        
        rp.setPosition( GetLocation(satelites.getSatelites()[0].getDistance(),satelites.getSatelites()[1].getDistance(),satelites.getSatelites()[2].getDistance()));        
        
        rp.setMessage(GetMessage(satelites.getSatelites()[0].getMessage(),satelites.getSatelites()[1].getMessage(),satelites.getSatelites()[2].getMessage()));
        
        return rp;
    }
    
    /**
     *
     * Metodo que responde peticiones post recibiendo como parámetro un objeto json con 
     * la información obtenida por un satélite y como variable de path el nombre del satélite que recibió
     * la información
     * En caso de no tener la infomración de los tres satélites, informa mediante un mensaje
     * que la información no es suficiente
     * 
     * @param satelite Object with satelite data without name
     * @param satelite_name String path parameter with satelite name
     * @return object with source position and message recovered if its posible to get
     */
    @RequestMapping(path="/topsecret_split/{satelite_name}", method = POST)
    @ApiOperation(value = "Return position and source's message ", notes = "Return position and source's message ")
    public Object topsecret_splitPost(@RequestBody sateliteShortPayload satelite,@PathVariable("satelite_name") String satelite_name){
        
        satelitePayload sp = new satelitePayload(satelite_name,satelite.getDistance(),satelite.getMessage());
        
        this.satelites.put(satelite_name, sp);
        
        if(this.satelites.size()<3){
            return "ERROR: La información no es suficiente" ;
        }
            
        responsePayload rp = new responsePayload();


        rp.setPosition( GetLocation(this.satelites.get("Kenobi").getDistance(),this.satelites.get("Skywalker").getDistance(),
          this.satelites.get("Sato").getDistance()));        

        rp.setMessage(GetMessage(this.satelites.get("Kenobi").getMessage(),this.satelites.get("Skywalker").getMessage(),
                this.satelites.get("Sato").getMessage()));

        return rp;
        
    }
    
    
    /**
     *
     * Metodo que responde peticiones get recibiendo como parámetros la distancia del satélite a la fuente y
     * el mensaje obtenido por el satélite, como variable de path, recibe el nombre del satélite que recibió
     * la información
     * En caso de no tener la infomración de los tres satélites, informa mediante un mensaje
     * que la información no es suficiente
     * 
     * @param distance distance between source and satelite
     * @param message String array with received words
     * @param satelite_name String path parameter with satelite name
     * @return object with source position and message recovered if its posible to get
     */
    @RequestMapping(path="/topsecret_split/{satelite_name}", method = GET)
    @ApiOperation(value = "Return position and source's message ", notes = "Return position and source's message ")
    public Object topsecret_splitGet(@RequestParam  Float distance,@RequestParam String message[],@PathVariable("satelite_name") String satelite_name){
        
        satelitePayload sp = new satelitePayload(satelite_name,distance,message);
        
        this.satelites.put(satelite_name, sp);
        
        if(this.satelites.size()<3){
            return "ERROR: La información no es suficiente" ;
        }
        
        responsePayload rp = new responsePayload();
        
        rp.setPosition( GetLocation(this.satelites.get("Kenobi").getDistance(),this.satelites.get("Skywalker").getDistance(),
            this.satelites.get("Sato").getDistance()));        

        rp.setMessage(GetMessage(this.satelites.get("Kenobi").getMessage(),this.satelites.get("Skywalker").getMessage(),
            this.satelites.get("Sato").getMessage()));
        
        return rp;
    }
    
    
    
    
}
