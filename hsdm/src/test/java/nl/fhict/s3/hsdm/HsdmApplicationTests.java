package nl.fhict.s3.hsdm;

import nl.fhict.s3.hsdm.controllers.CardController;
import nl.fhict.s3.hsdm.models.*;
import nl.fhict.s3.hsdm.repositories.*;
import nl.fhict.s3.hsdm.services.CardService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.doNothing;

@ContextConfiguration(classes = {CardController.class, CardService.class})
@ExtendWith(SpringExtension.class)
class HsdmApplicationTests {
    @Autowired
    private CardController cardController;

    @Autowired
    private CardService cardService;

    @MockBean
    private IHeroCardRepository heroCardRepository;
    @MockBean
    private IMinionCardRepository minionCardRepository;
    @MockBean
    private ISpellCardRepository spellCardRepository;
    @MockBean
    private IWeaponCardRepository weaponCardRepository;


    @Test
    void testGetHeroCardById() throws Exception {
        Integer cardId = 1;
        Optional<Card> heroCard = Optional.of( new HeroCard("TestClass","TestName","TestImage",0,Rarity.valueOf("FREE"),"TestSet","TestEffect","TestHp","TestHpEffect",0));
        when(heroCardRepository.findById(cardId)).thenReturn(heroCard);
        assertEquals(cardController.getCardById(cardId), heroCard);
    }

    @Test
    void testGetMinionCardById() throws Exception {
        Integer cardId = 2;
        Optional<Card> minionCard = Optional.of( new MinionCard("TestClass","TestName","TestImage",0,Rarity.valueOf("FREE"),"TestSet","TestEffect",0,0,"TestTribe"));
        when(heroCardRepository.findById(cardId)).thenReturn(minionCard);
        assertEquals(cardController.getCardById(cardId), minionCard);
    }

    @Test
    void testGetSpellCardById() throws Exception {
        Integer cardId = 3;
        Optional<Card> spellCard = Optional.of( new SpellCard("TestClass","TestName","TestImage",0,Rarity.valueOf("FREE"),"TestSet","TestEffect","TestSpellType"));
        when(heroCardRepository.findById(cardId)).thenReturn(spellCard);
        assertEquals(cardController.getCardById(cardId), spellCard);
    }

    @Test
    void testGetWeaponCardById() throws Exception {
        Integer cardId = 4;
        Optional<Card> weaponCard = Optional.of( new WeaponCard("TestClass","TestName","TestImage",0,Rarity.valueOf("FREE"),"TestSet","TestEffect",0,0));
        when(heroCardRepository.findById(cardId)).thenReturn(weaponCard);
        assertEquals(cardController.getCardById(cardId), weaponCard);
    }

    @Test
    void testGetAllCards() throws Exception {
        Card heroCard = new HeroCard("TestClass","TestName","TestImage",0,Rarity.valueOf("FREE"),"TestSet","TestEffect","TestHp","TestHpEffect",0);
        Card minionCard = new MinionCard("TestClass","TestName","TestImage",0,Rarity.valueOf("FREE"),"TestSet","TestEffect",0,0,"TestTribe");
        Card spellCard = new SpellCard("TestClass","TestName","TestImage",0,Rarity.valueOf("FREE"),"TestSet","TestEffect","TestSpellType");
        Card weaponCard = new WeaponCard("TestClass","TestName","TestImage",0,Rarity.valueOf("FREE"),"TestSet","TestEffect",0,0);
        List<Card> allCards = new ArrayList<Card>();
        allCards.add(heroCard);
        allCards.add(minionCard);
        allCards.add(spellCard);
        allCards.add(weaponCard);
        List<Card> heroCards = new ArrayList<>();
        heroCards.add(heroCard);
        List<Card> minionCards = new ArrayList<>();
        heroCards.add(minionCard);
        List<Card> spellCards = new ArrayList<>();
        heroCards.add(spellCard);
        List<Card> weaponCards = new ArrayList<>();
        heroCards.add(weaponCard);
        when(heroCardRepository.findAllHeroCards()).thenReturn(heroCards);
        when(minionCardRepository.findAllMinionCards()).thenReturn(minionCards);
        when(spellCardRepository.findAllSpellCards()).thenReturn(spellCards);
        when(weaponCardRepository.findAllWeaponCards()).thenReturn(weaponCards);
        assertEquals(cardController.getCards(), allCards);
    }

    @Test
    void testDeleteCard() throws Exception {
        doNothing().when(heroCardRepository).deleteById(1);
        assertEquals(cardController.deleteCard(1), ResponseEntity.status(HttpStatus.OK).body("Card " + 1 + " is deleted!"));
    }
}
