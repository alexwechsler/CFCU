package com.cfcu.ccBackend.CreditCard;

import org.springframework.http.HttpHeaders;

import java.util.HashMap;
import java.util.Optional;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.client.RestTemplate;

import org.json.JSONObject;



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
        Boolean result = false;
        
        // For this project we only have 1 user, but the user Id should be passed via GQL as well.
        CreditCard cc = new CreditCard(id, (long) 1, name, number, status, comment, onOff);
        Optional<CreditCard> updatedCreditCard = service.update(id, cc);
        
        String uri = "https://anypoint.mulesoft.com/mocking/api/v1/links/2107a7ca-f0f9-4894-93f3-a6f18e9c9f63/cardcontrols/onoff/" + id;
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.set("API-Key","C5F5A63C-E604-47AA-A7CC-B01F95FFBF09");
        
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> httpEntity = new HttpEntity<>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(uri, HttpMethod.POST, httpEntity, String.class);
        System.out.println(response.getBody());

        String issue_uri = "https://anypoint.mulesoft.com/mocking/api/v1/links/2107a7ca-f0f9-4894-93f3-a6f18e9c9f63/cardcontrols/reportcardissue"; 

        HashMap<String, String> hashmap = new HashMap<>();
        hashmap.put("cardId", cc.getCardId().toString());
        hashmap.put("cardStatus", cc.getCardStatus());
        hashmap.put("comment", cc.getCardComment()); 
        
        JSONObject payload = new JSONObject(hashmap);
        HttpEntity<String> httpEntity2 = new HttpEntity<>(payload.toString(), headers);
        ResponseEntity<String> cardUpdateResult = restTemplate.postForEntity(issue_uri, httpEntity2, String.class); 
        System.out.println(cardUpdateResult.getBody());


        if (updatedCreditCard.isPresent()) {
            result = true;
        }            
        return result;
    }
}
