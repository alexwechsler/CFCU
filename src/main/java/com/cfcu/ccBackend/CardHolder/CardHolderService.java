package com.cfcu.ccBackend.CardHolder;

import com.cfcu.ccBackend.CreditCard.CreditCardService;

import org.springframework.data.map.repository.config.EnableMapRepositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
@EnableMapRepositories

public class CardHolderService {
    private final CrudRepository<CardHolder, Integer> repository;
    private CreditCardService cardService;

    public CardHolderService(CrudRepository<CardHolder, Integer> repository, CreditCardService cardService) {
        this.repository = repository;
        this.cardService = cardService;
    }

    public List<CardHolder> findAll() {
        List<CardHolder> list = new ArrayList<>();
        Iterable<CardHolder> items = repository.findAll();
        items.forEach(list::add);
        return list;
    }

    public int count(){
        return (int)repository.count();
    }

    public Optional<CardHolder> find(int id) {
        return repository.findById(id);
    }

    public CardHolder create(CardHolder cardHolder) {
        CardHolder copy = new CardHolder(
            cardHolder.getId(), 
            cardHolder.getName(),
            cardHolder.getCardService(),
            cardHolder.getCreditCards() 
        );
        return repository.save(copy);
    }

    public int randomId() {
        Random rand = new Random();
        return rand.nextInt(50);
    }

    public Optional<CardHolder> update( int id, CardHolder newCardHolder) {
        return repository.findById(id)
                .map(oldItem -> {
                    CardHolder updated = oldItem.updateWith(newCardHolder);
                   return repository.save(updated);
                });
    }

    public void delete(int id) {
        repository.deleteById(id);
    }
    
}


