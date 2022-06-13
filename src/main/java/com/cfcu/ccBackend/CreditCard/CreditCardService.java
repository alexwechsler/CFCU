package com.cfcu.ccBackend.CreditCard;

import org.springframework.data.map.repository.config.EnableMapRepositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

import java.util.List;
import java.util.Optional;
import java.util.Random;
@Service
@EnableMapRepositories

public class CreditCardService {
    private final CrudRepository<CreditCard, Integer> repository;

    public CreditCardService(CrudRepository<CreditCard, Integer> repository) {
        this.repository = repository;
    }

    public List<CreditCard> findAll() {
        List<CreditCard> list = new ArrayList<>();
        Iterable<CreditCard> items = repository.findAll();
        items.forEach(list::add);
        return list;
    }

    public Optional<CreditCard> find(int id) {
        return repository.findById(id);
    }

    public CreditCard create(CreditCard creditcard) {
        CreditCard copy = new CreditCard(
                creditcard.getCardId(),
                creditcard.getCardHolderId(),
                creditcard.getCardName(),
                creditcard.getMaskedCardNumber(),
                creditcard.getCardStatus(),
                creditcard.getCardComment(),
                creditcard.getCardOnOff()
        );
        return repository.save(copy);
    }

    // Not efficient, the repo doesn't provide a lookup
    // by other fields. Ok for such a small project but I would
    // use a hashmap if this had millions of records. 
    public List<CreditCard> findByCardHolder(Long id) {
        List<CreditCard> cards = findAll();
        CreditCard[] cardArray = cards.toArray(new CreditCard[0]);
        ArrayList<CreditCard> cardList = new ArrayList<>();
        for (int i = 0; i < cardArray.length; i++) {
            if (cardArray[i].getCardHolderId() == id) {
                cardList.add(cardArray[i]);
            }
        }
        return cardList;
    }

    public Integer randomId() {
        Random rand = new Random();
        int i = rand.nextInt(50);
        return i;
    }

    public Optional<CreditCard> update( int id, CreditCard newCard) {
        return repository.findById(id)
                .map(oldItem -> {
                    CreditCard updated = oldItem.updateWith(newCard);
                   return repository.save(updated);
                });
    }

    public void delete(int id) {
        repository.deleteById(id);
    }
    
}

