package com.cfcu.ccBackend.CardHolder;

import org.springframework.data.annotation.Id;
import java.util.ArrayList;

public class CardHolder {
    private final int id;
    private final String name;
    private final ArrayList creditCards;

    public CardHolder(
        int id,
        String name,
        ArrayList creditCards
    ) {
        this.id = id;
        this.name = name;
        this.creditCards = creditCards;
    }

    @Id

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public ArrayList getCreditCards() {
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
