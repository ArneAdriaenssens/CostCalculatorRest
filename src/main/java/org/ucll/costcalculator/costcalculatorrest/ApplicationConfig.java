/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ucll.costcalculator.costcalculatorrest;

import common.RepositoryTypes;
import facade.CostCalculatorFacade;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@ComponentScan("org.ucll.costcalculator.controllers")
@EnableWebMvc
public class ApplicationConfig {

    @Bean
    public CostCalculatorFacade costFacade() {
        return new CostCalculatorFacade(RepositoryTypes.DB);
    }
}
