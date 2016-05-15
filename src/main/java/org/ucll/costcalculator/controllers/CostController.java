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

/**
 *
 * @author arnea
 */
@RestController
@RequestMapping("/cost")
public class CostController {

    @Autowired
    CostCalculatorFacade costFacade;

    @RequestMapping(method = RequestMethod.POST, value = "/save", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void saveCost(@RequestBody Cost cost) {
        costFacade.addCost(cost);
    }
    
    @RequestMapping(method = RequestMethod.POST, value="/byEmail", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public List<Cost> getCostsByEmail(@RequestBody Owner owner){
        return costFacade.getCostsByEmail(owner.getEmail());
    }
    
    @RequestMapping(method = RequestMethod.GET, value="/allCosts", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Cost> getCostsByEmail(){
        return costFacade.getAllCosts();
    }
    
    @RequestMapping(method = RequestMethod.POST, value = "/deleteCost")
    public void deleteCostById(@RequestBody Cost cost){
        costFacade.deleteCost(cost);
    }
    
    @RequestMapping(method = RequestMethod.POST, value = "/updateCost")
    public void updateCost(@RequestBody Cost costNew){
        costFacade.updateCost(costNew);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/getCostById")
    public void getCostById(@RequestBody Cost costNew){
        costFacade.getCostById(costNew.getId());
    }
    
}
