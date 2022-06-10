package com.cfcu.ccBackend.CardHolder;

import com.cfcu.ccBackend.CreditCard.CreditCard;
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

    public CardHolderService(CrudRepository<CardHolder, Integer> repository) {
        this.repository = repository;
        this.repository.saveAll(defaultCardHolders());
    }

    private static List<CardHolder> defaultCardHolders() {
        ArrayList creditcards = new ArrayList<CreditCard>();
            creditcards.add(new CreditCard("001", "Rewards Card", "3214786590815432", "", "", 1));
            creditcards.add(new CreditCard("002", "Cash Back Card", "1234876509875678", "", "", 1));
            creditcards.add(new CreditCard("003", "Debit Card", "0987676545637657", "", "", 1));

        return List.of(
            new CardHolder(001, "Connor", creditcards),
            new CardHolder(002,"Alex", creditcards)
            // new CardHolder(001, "Connor", creditcards),
            // new CardHolder(002,"Alex", creditcards)
        );
    }

    public List<CardHolder> findAll() {
        List<CardHolder> list = new ArrayList<>();
        Iterable<CardHolder> items = repository.findAll();
        items.forEach(list::add);
        return list;
    }

    public Optional<CardHolder> find(int id) {
        // System.out.println("Id: " + id);
        // System.out.println("Repo:" + repository);
        Optional<CardHolder> r = repository.findById(id);
        // System.out.println("R:" + r);
        return r;
    }

    public CardHolder create(CardHolder cardHolder) {
        CardHolder copy = new CardHolder(
            randomId(), 
            cardHolder.getName(),
            cardHolder.getCreditCards() 
        );
        return repository.save(copy);
    }

    public int randomId() {
        Random rand = new Random();
        return rand.nextInt(50);
    }

    public Optional<CardHolder> update( int id, CardHolder newCardHolder) {
        // Only update an item if it can be found first.
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


