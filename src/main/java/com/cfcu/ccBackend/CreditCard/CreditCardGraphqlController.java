package com.cfcu.ccBackend.CreditCard;

import java.util.Optional;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Controller;



@Controller
public class CreditCardGraphqlController {
    private final CreditCardService service;

    public CreditCardGraphqlController(CreditCardService service) {
        this.service = service;
    }
     
    @MutationMapping
    public Boolean updateCreditCard(
        @Argument Integer id, 
        @Argument String name, 
        @Argument String number, 
        @Argument String status, 
        @Argument String comment, 
        @Argument Boolean onOff
        ) {
        // System.out.println("WE ARE IN THE UPDATE CREDIT CARD // UPDATE CREDIT CARD RESOLVER!");
        Boolean result = false;
        // NEED TO CHANGE THIS HARD CODED VAL.
        CreditCard cc = new CreditCard(id, (long) 1, name, number, status, comment, onOff);
        System.out.println(id + " " + name + " " + number + " " + status + " " + comment + " " + onOff);
        Optional<CreditCard> updatedCreditCard = service.update(id, cc);
        if (updatedCreditCard.isPresent()) {
            result = true;
        }            
        return result;
    }
}
