package com.cfcu.ccBackend.CreditCard;

import org.springframework.data.annotation.Id;

public class CreditCard {
    private final int id;
    private final String name;
    private final String number;
    private final String status;
    private final String comment;
    private final int onOff;

    public CreditCard(
        int id,
        String name,
        String number,
        String status,
        String comment,
        int i
    ) {
        this.id = id;
        this.name = name;
        this.number = number;
        this.status = status;
        this.comment = comment;
        this.onOff = i;
    }

    @Id

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getNumber() {
        return number;
    }

    public String getStatus() {
        return status;
    }

    public String getComment() {
        return comment;
    }

    public int getOnOff() {
        return onOff;
    }

    public CreditCard updateWith(CreditCard creditcard) {
        return new CreditCard(
            this.id,
            creditcard.name,
            creditcard.number,
            creditcard.status,
            creditcard.comment,
            creditcard.onOff
        );
    }
}
