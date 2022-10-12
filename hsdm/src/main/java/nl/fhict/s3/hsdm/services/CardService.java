package nl.fhict.s3.hsdm.services;

import nl.fhict.s3.hsdm.models.Card;
import nl.fhict.s3.hsdm.repositories.IHeroCardRepository;
import nl.fhict.s3.hsdm.repositories.IMinionCardRepository;
import nl.fhict.s3.hsdm.repositories.ISpellCardRepository;
import nl.fhict.s3.hsdm.repositories.IWeaponCardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

    public List<Card> getCards(String cardClass, String cardType) {
        List<Card> cardsFiltered = new ArrayList<>();
        List<Card> cards = new ArrayList<>();
        if (cardType.equals("")) {
            cards.addAll(heroCardRepository.findAllHeroCards());
            cards.addAll(minionCardRepository.findAllMinionCards());
            cards.addAll(spellCardRepository.findAllSpellCards());
            cards.addAll(weaponCardRepository.findAllWeaponCards());
            if (cards.isEmpty()) {
                throw new IllegalStateException("There are no cards to display yet!");
            }
            for (Card card : cards) {
                if (card.getCardClass().equals(cardClass) || cardClass.equals("")) {
                    cardsFiltered.add(card);
                }
            }
            return cardsFiltered;
        } else if (cardType.equals("herocard")) {
            cards = heroCardRepository.findAllHeroCards();
            for (Card card : cards) {
                if (card.getCardClass().equals(cardClass) || cardClass.equals("")) {
                    cardsFiltered.add(card);
                }
                return cardsFiltered;
            }
        } else if (cardType.equals("minioncard")) {
            cards = minionCardRepository.findAllMinionCards();
            for (Card card : cards) {
                if (card.getCardClass().equals(cardClass) || cardClass.equals("")) {
                    cardsFiltered.add(card);
                }
                return cardsFiltered;
            }
        } else if (cardType.equals("spellcard")) {
            cards = spellCardRepository.findAllSpellCards();
            for (Card card : cards) {
                if (card.getCardClass().equals(cardClass) || cardClass.equals("")) {
                    cardsFiltered.add(card);
                }
                return cardsFiltered;
            }
        } else if (cardType.equals("weaponcard")) {
            cards = weaponCardRepository.findAllWeaponCards();
            for (Card card : cards) {
                if (card.getCardClass().equals(cardClass) || cardClass.equals("")) {
                    cardsFiltered.add(card);
                }
                return cardsFiltered;
            }
        }
        throw new IllegalStateException("Cards couldn't be found!");
    }

//    cards.addAll(heroCardRepository.findAllHeroCards());
//        cards.addAll(minionCardRepository.findAllMinionCards());
//        cards.addAll(spellCardRepository.findAllSpellCards());
//        cards.addAll(weaponCardRepository.findAllWeaponCards());
//        if(cards.isEmpty()){
//        throw new IllegalStateException("There are no cards to display yet!");
//    }
//        return cards;

//    public List<Card> getCardsByType(String cardType) {
//        if(cardType.equals("herocard")){
//            return heroCardRepository.findAllHeroCards(cardClass);
//        }else if(cardType.equals("minioncard")){
//            return minionCardRepository.findAllMinionCards(cardClass);
//        }else if(cardType.equals("spellcard")){
//            return spellCardRepository.findAllSpellCards(cardClass);
//        }else if (cardType.equals("weaponcard")){
//            return weaponCardRepository.findAllWeaponCards(cardClass);
//        }
//        throw new IllegalStateException("The Cardtype " + cardType + " doesn't exist!");
//    }
}
