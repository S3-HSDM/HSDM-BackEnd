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

    /**
     * Method under test: {@link CardController#addNewCard(String, String, String, Integer, String, String, String, String, String, Integer, Integer, Integer, String, String, Integer)}
     */
    @Test
    void testGetHeroCardById() throws Exception {
        Optional<Card> heroCard = Optional.of( new HeroCard("TestClass","TestName","TestImage",0,Rarity.valueOf("FREE"),"TestSet","TestEffect","TestHp","TestHpEffect",0));
        when(heroCardRepository.findById(1)).thenReturn(heroCard);
        assertEquals(cardController.getCardById(1), heroCard);
    }

    @Test
    void testGetMinionCardById() throws Exception {
        Optional<Card> minionCard = Optional.of( new MinionCard("TestClass","TestName","TestImage",0,Rarity.valueOf("FREE"),"TestSet","TestEffect",0,0,"TestTribe"));
        when(heroCardRepository.findById(2)).thenReturn(minionCard);
        assertEquals(cardController.getCardById(2), minionCard);
    }

    @Test
    void testGetSpellCardById() throws Exception {
        Optional<Card> spellCard = Optional.of( new SpellCard("TestClass","TestName","TestImage",0,Rarity.valueOf("FREE"),"TestSet","TestEffect","TestSpellType"));
        when(heroCardRepository.findById(3)).thenReturn(spellCard);
        assertEquals(cardController.getCardById(3), spellCard);
    }

    @Test
    void testGetWeaponCardById() throws Exception {
        Optional<Card> weaponCard = Optional.of( new WeaponCard("TestClass","TestName","TestImage",0,Rarity.valueOf("FREE"),"TestSet","TestEffect",0,0));
        when(heroCardRepository.findById(4)).thenReturn(weaponCard);
        assertEquals(cardController.getCardById(4), weaponCard);
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
