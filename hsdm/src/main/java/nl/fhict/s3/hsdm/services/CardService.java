package nl.fhict.s3.hsdm.services;

import nl.fhict.s3.hsdm.models.*;
import nl.fhict.s3.hsdm.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;

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

    public Optional<Card> findCardById(Integer cardId) {
        return heroCardRepository.findById(cardId);
    }

    public void deleteCard(Integer cardId) {
        heroCardRepository.deleteById(cardId);
    }

    public void addNewHeroCard(HeroCard newCard) {
        heroCardRepository.save(newCard);
    }

    public void addNewMinionCard(MinionCard newCard) {
        minionCardRepository.save(newCard);
    }

    public void addNewSpellCard(SpellCard newCard) {
        spellCardRepository.save(newCard);
    }

    public void addNewWeaponCard(WeaponCard newCard) {
        weaponCardRepository.save(newCard);
    }

    @Transactional
    public void updateHeroCard(Integer cardId,String cardClass, String name, String image, Integer cost, Rarity rarity, String set, String effect, String heroPower, String heroPowerEffect, Integer heroPowerCost) {
        HeroCard card = (HeroCard) heroCardRepository.findById(cardId).orElseThrow(()-> new IllegalStateException("Hero card with id " + cardId + " does not exist!"));
        if(cardClass != null){
            card.setCardClass(cardClass);
        }
        if(name != null){
            card.setName(name);
        }
        if(image != null){
            card.setImage(image);
        }
        if(cost != null){
            card.setCost(cost);
        }
        if(rarity != null){
            card.setRarity(rarity);
        }
        if(set != null){
            card.setSet(set);
        }
        if(effect != null){
            card.setEffect(effect);
        }
        if(heroPower != null){
            card.setHeroPower(heroPower);
        }
        if(heroPowerEffect != null){
            card.setHeroPowerEffect(heroPowerEffect);
        }
        if(heroPowerCost != null){
            card.setHeroPowerCost(heroPowerCost);
        }
    }

    @Transactional
    public void updateMinionCard(Integer cardId,String cardClass, String name, String image, Integer cost, Rarity rarity, String set, String effect, Integer attack, Integer health, String tribe) {
        MinionCard card = (MinionCard) minionCardRepository.findById(cardId).orElseThrow(()-> new IllegalStateException("Minion card with id " + cardId + " does not exist!"));
        if(cardClass != null){
            card.setCardClass(cardClass);
        }
        if(name != null){
            card.setName(name);
        }
        if(image != null){
            card.setImage(image);
        }
        if(cost != null){
            card.setCost(cost);
        }
        if(rarity != null){
            card.setRarity(rarity);
        }
        if(set != null){
            card.setSet(set);
        }
        if(effect != null){
            card.setEffect(effect);
        }
        if(attack != null){
            card.setAttack(attack);
        }
        if(health != null){
            card.setHealth(health);
        }
        if(tribe != null){
            card.setTribe(tribe);
        }
    }

    @Transactional
    public void updateSpellCard(Integer cardId,String cardClass, String name, String image, Integer cost, Rarity rarity, String set, String effect, String spellType) {
        SpellCard card = (SpellCard) spellCardRepository.findById(cardId).orElseThrow(()-> new IllegalStateException("Spell card with id " + cardId + " does not exist!"));
        if(cardClass != null){
            card.setCardClass(cardClass);
        }
        if(name != null){
            card.setName(name);
        }
        if(image != null){
            card.setImage(image);
        }
        if(cost != null){
            card.setCost(cost);
        }
        if(rarity != null){
            card.setRarity(rarity);
        }
        if(set != null){
            card.setSet(set);
        }
        if(effect != null){
            card.setEffect(effect);
        }
        if(spellType != null){
            card.setSpellType(spellType);
        }
    }

    @Transactional
    public void updateWeaponCard(Integer cardId,String cardClass, String name, String image, Integer cost, Rarity rarity, String set, String effect, Integer attack, Integer durability) {
        WeaponCard card = (WeaponCard) weaponCardRepository.findById(cardId).orElseThrow(()-> new IllegalStateException("Weapon card with id " + cardId + " does not exist!"));
        if(cardClass != null){
            card.setCardClass(cardClass);
        }
        if(name != null){
            card.setName(name);
        }
        if(image != null){
            card.setImage(image);
        }
        if(cost != null){
            card.setCost(cost);
        }
        if(rarity != null){
            card.setRarity(rarity);
        }
        if(set != null){
            card.setSet(set);
        }
        if(effect != null){
            card.setEffect(effect);
        }
        if(attack != null){
            card.setAttack(attack);
        }
        if(durability != null){
            card.setDurability(durability);
        }
    }
}
