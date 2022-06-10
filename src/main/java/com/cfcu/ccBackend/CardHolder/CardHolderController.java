package com.cfcu.ccBackend.CardHolder;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.util.JSONPObject;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("cardinfo")
public class CardHolderController {
    private final CardHolderService service;

    public CardHolderController(CardHolderService service) {
      this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<CardHolder>> findAll() {
        List<CardHolder> CardHolders = service.findAll();
        return ResponseEntity.ok().body(CardHolders);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CardHolder> find(@PathVariable("id") int id) {
        // CardHolder CardHolder = service.find(id);
        Optional<CardHolder> CardHolder = service.find(id);
        CardHolder returnCardHolder = null;
        if(CardHolder.isPresent()) {
            returnCardHolder = CardHolder.get();
        } 
        return ResponseEntity.ok().body(returnCardHolder);
        //return ResponseEntity.of(CardHolder);
    }
    
}

