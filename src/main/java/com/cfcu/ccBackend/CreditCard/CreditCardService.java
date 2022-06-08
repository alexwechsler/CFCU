package com.cfcu.ccBackend.CreditCard;

import org.springframework.data.map.repository.config.EnableMapRepositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
// import java.util.Date;


import java.util.List;
import java.util.Optional;
import java.util.Random;
@Service
@EnableMapRepositories

public class CreditCardService {
    private final CrudRepository<CreditCard, Integer> repository;

    public CreditCardService(CrudRepository<CreditCard, Integer> repository) {
        this.repository = repository;
        this.repository.saveAll(defaultCreditCards());
    }

    private static List<CreditCard> defaultCreditCards() {
        return List.of(
            new CreditCard(001, "Rewards Card", "3214786590815432", "", "", 1),
            new CreditCard(002, "Cash Back Card", "1234876509875678", "", "", 1),
            new CreditCard(003, "Debit Card", "0987676545637657", "", "", 1)
        );
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
                randomId(),
                creditcard.getName(),
                creditcard.getNumber(),
                creditcard.getStatus(),
                creditcard.getComment(),
                creditcard.getOnOff()
        );
        return repository.save(copy);
    }

    public int randomId() {
        Random rand = new Random();
        return rand.nextInt(50);
    }

    public Optional<CreditCard> update( int id, CreditCard newCard) {
        // Only update an item if it can be found first.
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

