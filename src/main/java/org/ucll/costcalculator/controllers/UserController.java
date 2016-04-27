/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ucll.costcalculator.controllers;

import facade.CostCalculatorFacade;
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
        System.out.println("Jaha");
        //costFacade.addUser(owner);
    }

}
