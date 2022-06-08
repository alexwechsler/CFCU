package com.cfcu.ccBackend.CardHolder;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface InMemoryCardHolderRepository extends CrudRepository<CardHolder, Integer> {}