package com.cfcu.ccBackend.CreditCard;

import org.springframework.data.annotation.Id;

public class CreditCard {
    @Id
    private String cardId;
    private String cardName;
    private String maskedCardNumber;
    private String cardStatus;
    private String cardComment;
    private int cardOnOff = 1;

    public CreditCard() {};

    public CreditCard(
        String id,
        String name,
        String number,
        String status,
        String comment,
        int onOff
    ) {
        this.cardId = id;
        this.cardName = name;
        this.maskedCardNumber = number;
        this.cardStatus = status;
        this.cardComment = comment;
        this.cardOnOff = onOff;
    }

    public void setCardId(String id) {
        this.cardId = id;
    }

    public void setCardName(String name) {
        this.cardName = name;
    }

    public void setMaskedCardNumber(String number) {
        this.maskedCardNumber = number;
    }

    public void setCardStatus(String status) {
        this.cardStatus = status;
    }

    public void setCardComment(String comment) {
        this.cardComment = comment;
    }

    public void setCardOnOff(int onOff) {
        this.cardOnOff = onOff;
    }


    public String getCardId() {
        return cardId;
    }

    public String getCardName() {
        return cardName;
    }

    public String getMaskedCardNumber() {
        return maskedCardNumber;
    }
    

    public String getCardStatus() {
        return cardStatus;
    }

    public String getCardComment() {
        return cardComment;
    }

    public int getCardOnOff() {
        return cardOnOff;
    }

    public CreditCard updateWith(CreditCard creditcard) {
        return new CreditCard(
            this.cardId,
            creditcard.cardName,
            creditcard.maskedCardNumber,
            creditcard.cardStatus,
            creditcard.cardComment,
            creditcard.cardOnOff
        );
    }
}
