package com.cfcu.ccBackend.CardHolder;



import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpEntity;

import java.io.IOException;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpMethod;

import org.springframework.web.client.RestTemplate;

import com.cfcu.ccBackend.CreditCard.CreditCard;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.cfcu.ccBackend.CreditCard.CreditCardService;

@Controller
public class CardHolderGraphqlController {
    private final CardHolderService service;
    private CreditCardService cardService;

    public CardHolderGraphqlController(CardHolderService service, CreditCardService cardService) {
      this.service = service;
      this.cardService = cardService;
    }

    @QueryMapping
    public CardHolder CardHolder(@Argument Integer id) throws IOException {
        CardHolder result = null;

        if(service.count() == 0) {
            result = initCardHolder(id);
        } else {
            result = service.find(id).get();
        }
        return result;
    }

    private CardHolder initCardHolder(int id) throws JsonMappingException, JsonProcessingException {
        String uri = "https://anypoint.mulesoft.com/mocking/api/v1/links/2107a7ca-f0f9-4894-93f3-a6f18e9c9f63/cardInfo/" + id;

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.set("API-Key","C5F5A63C-E604-47AA-A7CC-B01F95FFBF09");

        HttpEntity<String> httpEntity = new HttpEntity<>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(uri, HttpMethod.GET, httpEntity, String.class);
        System.out.println(response.getBody());
        ObjectMapper mapper = new ObjectMapper();
        
        JsonNode jsonNode = mapper.readTree(response.getBody());
        ArrayNode cardArrayNode = (ArrayNode) jsonNode.get("cards");
        System.out.println(cardArrayNode.toString());
        CreditCard[] cardlist = mapper.readValue(cardArrayNode.toString(), CreditCard[].class);

        CardHolder cardHolder = new CardHolder(
            service.count() + 1, 
            jsonNode.get("cardHolder").asText(),
            cardService,
            cardlist
        );
        service.create(cardHolder);
        return cardHolder;
    }
}
