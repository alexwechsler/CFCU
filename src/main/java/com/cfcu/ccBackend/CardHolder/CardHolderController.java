package com.cfcu.ccBackend.CardHolder;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
        List<CardHolder> items = service.findAll();
        return ResponseEntity.ok().body(items);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CardHolder> find(@PathVariable("id") int id) {
        Optional<CardHolder> item = service.find(id);
        return ResponseEntity.of(item);
    }
    
}

