/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ucll.costcalculator.controllers;

import cost.domain.Cost;
import facade.CostCalculatorFacade;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import owner.domain.Owner;
import static owner.domain.Owner_.email;

/**
 *
 * @author arnea
 */
@RestController
@RequestMapping("/cost")
public class CostController {

    @Autowired
    CostCalculatorFacade costFacade;

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void saveCost(@RequestBody Cost cost) {
        costFacade.addCost(cost);
    }
    
    @RequestMapping(method = RequestMethod.POST, value="/byemail", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public List<Cost> getCostsByEmail(@RequestBody Owner owner){
        System.out.println("email:" +owner.getEmail());
        return costFacade.getCostsByEmail(owner.getEmail());
    }
    
    @RequestMapping(method = RequestMethod.GET, value="allcosts", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Cost> getCostsByEmail(){
        return costFacade.getAllCosts();
    }

}