package nl.fhict.s3.hsdm.controllers;


import nl.fhict.s3.hsdm.models.Card;
import nl.fhict.s3.hsdm.services.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(path = "api/cards")
public class CardController {

    private final CardService cardService;

    @Autowired
    public CardController(CardService cardService) {
        this.cardService = cardService;
    }

    @GetMapping
    public List<Card> getCards() {
        return cardService.getCards();
    }

    @GetMapping(path = "{cardType}")
    public List<Card> getCardsByType(@PathVariable("cardType") String cardType){
        return cardService.getCardsByType(cardType);
    }


}