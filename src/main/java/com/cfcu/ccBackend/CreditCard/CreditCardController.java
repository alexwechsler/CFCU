package com.cfcu.ccBackend.CreditCard;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("cardcontrols/creditcards")
public class CreditCardController {
    private final CreditCardService service;

    public CreditCardController(CreditCardService service) {
      this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<CreditCard>> findAll() {
        List<CreditCard> items = service.findAll();
        return ResponseEntity.ok().body(items);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CreditCard> find(@PathVariable("id") int id) {
        Optional<CreditCard> item = service.find(id);
        return ResponseEntity.of(item);
    }
    
}





