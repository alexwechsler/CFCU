package com.cfcu.ccBackend.CardHolder;

import org.springframework.data.annotation.Id;

import com.cfcu.ccBackend.CreditCard.CreditCard;
import com.cfcu.ccBackend.CreditCard.CreditCardService;

import java.util.ArrayList;
import java.util.List;

public class CardHolder {
    private CreditCardService cardService;
    
    @Id
    private int id;
    private String name;
    private List<CreditCard> creditCards = new ArrayList<CreditCard>();
    

    public CardHolder() {};

    public CardHolder(        
        int id,
        String name,
        CreditCardService cardService,
        CreditCard[] creditCards
    ) {
        this.id = id;
        this.name = name;
        this.cardService = cardService;
        this.setCreditCards(creditCards);
        // this.creditCards = Arrays.asList(creditCards);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCreditCards(CreditCard[] cardlist) {
        for(int i = 0; i < cardlist.length; i++) {
            cardlist[i].setCardHolderId((long)this.getId()); 
            CreditCard card = cardService.create(cardlist[i]);
            this.creditCards.add(card);
         }
        
    }

    public CreditCardService getCardService(){
        return cardService;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public CreditCard[] getCreditCards() {
        List<CreditCard> creditCards = cardService.findByCardHolder((long) this.getId());
        return creditCards.toArray(new CreditCard[0]);
        // return this.creditCards.toArray(new CreditCard[0]);
    }

    public CardHolder updateWith(CardHolder cardholder) {
        return new CardHolder(
            this.id,
            cardholder.name,
            cardholder.cardService,
            cardholder.getCreditCards()
        );
    }
}
