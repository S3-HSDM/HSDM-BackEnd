package nl.fhict.s3.hsdm.controllers;


import nl.fhict.s3.hsdm.models.*;
import nl.fhict.s3.hsdm.services.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Locale;
import java.util.Optional;

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

    @GetMapping(path="{cardId}")
    public Optional<Card> getCardById(@PathVariable("cardId") Integer cardId){
        return cardService.findCardById(cardId);
    }

    @PostMapping
    public void addNewCard(@RequestParam(required = true) String cardClass,
                           @RequestParam(required = true) String name,
                           @RequestParam(required = true) String image,
                           @RequestParam(required = true) Integer cost,
                           @RequestParam(required = true) String rarity,
                           @RequestParam(required = true) String set,
                           @RequestParam(required = true) String effect,
                           @RequestParam(required = false) String heroPower,
                           @RequestParam(required = false) String heroPowerEffect,
                           @RequestParam(required = false) Integer heroPowerCost,
                           @RequestParam(required = false) Integer attack,
                           @RequestParam(required = false) Integer health,
                           @RequestParam(required = false) String tribe,
                           @RequestParam(required = false) String spellType,
                           @RequestParam(required = false) Integer durability
                           ){
        if(heroPower != null){
            HeroCard newCard = new HeroCard(cardClass,name,image,cost,Rarity.valueOf(rarity.toUpperCase(Locale.ROOT)),set,effect,heroPower,heroPowerEffect,heroPowerCost);
            cardService.addNewHeroCard(newCard);
        } else if(health != null){
            MinionCard newCard = new MinionCard(cardClass,name,image,cost,Rarity.valueOf(rarity.toUpperCase(Locale.ROOT)),set,effect,attack,health,tribe);
            cardService.addNewMinionCard(newCard);
        } else if(spellType != null){
            SpellCard newCard = new SpellCard(cardClass,name,image,cost,Rarity.valueOf(rarity.toUpperCase(Locale.ROOT)),set,effect,spellType);
            cardService.addNewSpellCard(newCard);
        } else if(durability != null){
            WeaponCard newCard = new WeaponCard(cardClass,name,image,cost,Rarity.valueOf(rarity.toUpperCase(Locale.ROOT)),set,effect,attack,durability);
            cardService.addNewWeaponCard(newCard);
        }
    }

    @DeleteMapping(path = "{cardId}")
    public ResponseEntity<String> deleteCard(@PathVariable("cardId") Integer cardId){
        cardService.deleteCard(cardId);
        return ResponseEntity.status(HttpStatus.OK).body("Card " + cardId + " is deleted!");
    }

    @PutMapping(path = "{cardId}")
    public void updateCard(@PathVariable("cardId") Integer cardId,
                           @RequestParam(required = false) String cardClass,
                           @RequestParam(required = false) String name,
                           @RequestParam(required = false) String image,
                           @RequestParam(required = false) Integer cost,
                           @RequestParam(required = false) String rarity,
                           @RequestParam(required = false) String set,
                           @RequestParam(required = false) String effect,
                           @RequestParam(required = false) String heroPower,
                           @RequestParam(required = false) String heroPowerEffect,
                           @RequestParam(required = false) Integer heroPowerCost,
                           @RequestParam(required = false) Integer attack,
                           @RequestParam(required = false) Integer health,
                           @RequestParam(required = false) String tribe,
                           @RequestParam(required = false) String spellType,
                           @RequestParam(required = false) Integer durability
    ){
        if(heroPower != null){
            cardService.updateHeroCard(cardId,cardClass,name,image,cost,Rarity.valueOf(rarity.toUpperCase(Locale.ROOT)),set,effect,heroPower,heroPowerEffect,heroPowerCost);
        } else if(health != null){
            cardService.updateMinionCard(cardId,cardClass,name,image,cost,Rarity.valueOf(rarity.toUpperCase(Locale.ROOT)),set,effect,attack,health,tribe);
        } else if(spellType != null){
            cardService.updateSpellCard(cardId,cardClass,name,image,cost,Rarity.valueOf(rarity.toUpperCase(Locale.ROOT)),set,effect,spellType);
        } else if(durability != null){
            cardService.updateWeaponCard(cardId,cardClass,name,image,cost,Rarity.valueOf(rarity.toUpperCase(Locale.ROOT)),set,effect,attack,durability);
        }
    }
}
