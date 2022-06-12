package com.cfcu.ccBackend.CreditCard;

import org.springframework.data.annotation.Id;

public class CreditCard {
    @Id
    private Integer cardId;
    private Long cardHolderId;
    private String cardName;
    private String maskedCardNumber;
    private String cardStatus;
    private String cardComment;
    private Boolean cardOnOff = true;

    public CreditCard() {};

    public CreditCard(
        Integer id,
        Long cardHolderId,
        String name,
        String number,
        String status,
        String comment,
        Boolean onOff
    ) {
        this.cardId = id;
        this.cardHolderId = cardHolderId;
        this.cardName = name;
        this.maskedCardNumber = number;
        this.cardStatus = status;
        this.cardComment = comment;
        this.cardOnOff = onOff;
    }

    public void setCardId(Integer id) {
        this.cardId = id;
    }

    public void setCardHolderId(Long cardHolderId) {
        this.cardHolderId = cardHolderId;
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

    public void setCardOnOff(Boolean onOff) {
        this.cardOnOff = onOff;
    }


    public Integer getCardId() {
        return cardId;
    }

    public Long getCardHolderId() {
        return cardHolderId;
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

    public Boolean getCardOnOff() {
        return cardOnOff;
    }

    public CreditCard updateWith(CreditCard creditcard) {
        return new CreditCard(
            this.cardId,
            creditcard.cardHolderId,
            creditcard.cardName,
            creditcard.maskedCardNumber,
            creditcard.cardStatus,
            creditcard.cardComment,
            creditcard.cardOnOff
        );
    }
}
