package com.cfcu.ccBackend.CreditCard;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface InMemoryCreditCardRepository extends CrudRepository<CreditCard, Integer> {}
