package nl.fhict.s3.hsdm.services;

import nl.fhict.s3.hsdm.models.Card;
import nl.fhict.s3.hsdm.models.SpellCard;
import nl.fhict.s3.hsdm.repositories.IHeroCardRepository;
import nl.fhict.s3.hsdm.repositories.IMinionCardRepository;
import nl.fhict.s3.hsdm.repositories.ISpellCardRepository;
import nl.fhict.s3.hsdm.repositories.IWeaponCardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Service
public class CardService {

    private final IWeaponCardRepository weaponCardRepository;
    private final IHeroCardRepository heroCardRepository;
    private final IMinionCardRepository minionCardRepository;
    private final ISpellCardRepository spellCardRepository;

    @Autowired
    public CardService(ISpellCardRepository spellCardRepository, IHeroCardRepository heroCardRepository, IWeaponCardRepository weaponCardRepository, IMinionCardRepository minionCardRepository) {
        this.weaponCardRepository = weaponCardRepository;
        this.heroCardRepository = heroCardRepository;
        this.minionCardRepository = minionCardRepository;
        this.spellCardRepository = spellCardRepository;
    }

    public List<Card> getCards() {
        List<Card> cards = new ArrayList<>();
        List<Card> cardsSorted = new ArrayList<>();
        cards.addAll(heroCardRepository.findAllHeroCards());
        cards.addAll(minionCardRepository.findAllMinionCards());
        cards.addAll(spellCardRepository.findAllSpellCards());
        cards.addAll(weaponCardRepository.findAllWeaponCards());
        if(cards.isEmpty()){
            throw new IllegalStateException("There are no cards to display yet!");
        }
        for (int cost = 0; cost < 100; cost++) {
            for (Card card : cards) {
                if(card.getCost() == cost){
                    cardsSorted.add(card);
                }
            }
        }
        return cardsSorted;
    }

    public List<Card> getCardsByType(String cardType) {
        if(cardType.equals("herocard")){
            return heroCardRepository.findAllHeroCards();
        }else if(cardType.equals("minioncard")){
            return minionCardRepository.findAllMinionCards();
        }else if(cardType.equals("spellcard")){
            return spellCardRepository.findAllSpellCards();
        }else if (cardType.equals("weaponcard")){
            return weaponCardRepository.findAllWeaponCards();
        }
        throw new IllegalStateException("The Cardtype " + cardType + " doesn't exist!");
    }
}
