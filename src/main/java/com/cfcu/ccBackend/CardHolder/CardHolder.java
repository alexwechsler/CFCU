package com.cfcu.ccBackend.CardHolder;

import org.springframework.data.annotation.Id;

import java.util.List;

// import javax.annotation.Generated;
// import javax.persistence.Entity;
// import javax.persistence.GeneratedValue;

// import static javax.persistence.GenerationType.AUTO;

// @Entity
public class CardHolder {
    @Id
    // @GeneratedValue
    private int id;
    private String name;
    private List creditCards;

    public CardHolder() {};

    public CardHolder(        
        int id,
        String name,
        List creditCards
    ) {
        this.id = id;
        this.name = name;
        this.creditCards = creditCards;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCreditCards(List creditCards) {
        this.creditCards = creditCards;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List getCreditCards() {
        return creditCards;
    }

    public CardHolder updateWith(CardHolder cardholder) {
        return new CardHolder(
            this.id,
            cardholder.name,
            cardholder.creditCards
        );
    }
}
