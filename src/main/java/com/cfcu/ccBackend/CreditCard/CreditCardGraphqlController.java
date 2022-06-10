package com.cfcu.ccBackend.CreditCard;

import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Controller;

@Controller
public class CreditCardGraphqlController {
    
    @MutationMapping
    public boolean updateCreditCard(int id, String name, String number, String status, String comment, boolean onOff) {
        return true;
    }
}
