/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ucll.costcalculator.controllers;

import facade.CostCalculatorFacade;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import owner.domain.Owner;

/**
 *
 * @author arnea
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    CostCalculatorFacade costFacade;

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void register(@RequestBody Owner owner) {
        costFacade.addUser(owner);
    }
    
    @RequestMapping(method = RequestMethod.GET, value = "/getAll", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Owner> getAllOwners(){
        return costFacade.getAllUsers();
    }
    
    @RequestMapping(method = RequestMethod.POST, value = "/getByEmail", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Owner getOwnerByEmail(@RequestBody Owner owner){
        return costFacade.getUserByEmail(owner.getEmail());
    }
    
    @RequestMapping(method=RequestMethod.POST, value = "/deleteUser", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteOwner(@RequestBody Owner owner){
        costFacade.deleteUser(owner); 
    }

}
