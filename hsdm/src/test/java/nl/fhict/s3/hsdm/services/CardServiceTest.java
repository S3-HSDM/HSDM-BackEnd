package nl.fhict.s3.hsdm.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;

import nl.fhict.s3.hsdm.models.Card;
import nl.fhict.s3.hsdm.models.HeroCard;
import nl.fhict.s3.hsdm.models.MinionCard;
import nl.fhict.s3.hsdm.models.Rarity;
import nl.fhict.s3.hsdm.models.SpellCard;
import nl.fhict.s3.hsdm.models.WeaponCard;
import nl.fhict.s3.hsdm.repositories.IHeroCardRepository;
import nl.fhict.s3.hsdm.repositories.IMinionCardRepository;
import nl.fhict.s3.hsdm.repositories.ISpellCardRepository;
import nl.fhict.s3.hsdm.repositories.IWeaponCardRepository;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {CardService.class})
@ExtendWith(SpringExtension.class)
class CardServiceTest {
    @Autowired
    private CardService cardService;

    @MockBean
    private IHeroCardRepository iHeroCardRepository;

    @MockBean
    private IMinionCardRepository iMinionCardRepository;

    @MockBean
    private ISpellCardRepository iSpellCardRepository;

    @MockBean
    private IWeaponCardRepository iWeaponCardRepository;

    /**
     * Method under test: {@link CardService#deleteCard(Integer)}
     */
    @Test
    void testDeleteCard() {
        doNothing().when(iHeroCardRepository).deleteById((Integer) any());
        cardService.deleteCard(123);
        verify(iHeroCardRepository).deleteById((Integer) any());
    }

    /**
     * Method under test: {@link CardService#deleteCard(Integer)}
     */
    @Test
    void testDeleteCard2() {
        doThrow(new IllegalStateException("foo")).when(iHeroCardRepository).deleteById((Integer) any());
        assertThrows(IllegalStateException.class, () -> cardService.deleteCard(123));
        verify(iHeroCardRepository).deleteById((Integer) any());
    }

    /**
     * Method under test: {@link CardService#addNewHeroCard(HeroCard)}
     */
    @Test
    void testAddNewHeroCard() {
        HeroCard heroCard = new HeroCard();
        heroCard.setCardClass("Card Class");
        heroCard.setCost(1);
        heroCard.setEffect("Effect");
        heroCard.setHeroPower("Hero Power");
        heroCard.setHeroPowerCost(1);
        heroCard.setHeroPowerEffect("Hero Power Effect");
        heroCard.setId(1);
        heroCard.setImage("Image");
        heroCard.setName("Name");
        heroCard.setRarity(Rarity.Free);
        heroCard.setSet("Set");
        when(iHeroCardRepository.save((HeroCard) any())).thenReturn(heroCard);

        HeroCard heroCard1 = new HeroCard();
        heroCard1.setCardClass("Card Class");
        heroCard1.setCost(1);
        heroCard1.setEffect("Effect");
        heroCard1.setHeroPower("Hero Power");
        heroCard1.setHeroPowerCost(1);
        heroCard1.setHeroPowerEffect("Hero Power Effect");
        heroCard1.setId(1);
        heroCard1.setImage("Image");
        heroCard1.setName("Name");
        heroCard1.setRarity(Rarity.Free);
        heroCard1.setSet("Set");
        cardService.addNewHeroCard(heroCard1);
        verify(iHeroCardRepository).save((HeroCard) any());
        assertEquals("Card Class", heroCard1.getCardClass());
        assertEquals("Set", heroCard1.getSet());
        assertEquals(Rarity.Free, heroCard1.getRarity());
        assertEquals("Name", heroCard1.getName());
        assertEquals("Image", heroCard1.getImage());
        assertEquals(1, heroCard1.getId().intValue());
        assertEquals("Hero Power Effect", heroCard1.getHeroPowerEffect());
        assertEquals(1, heroCard1.getHeroPowerCost().intValue());
        assertEquals("Hero Power", heroCard1.getHeroPower());
        assertEquals("Effect", heroCard1.getEffect());
        assertEquals(1, heroCard1.getCost().intValue());
    }

    /**
     * Method under test: {@link CardService#addNewHeroCard(HeroCard)}
     */
    @Test
    void testAddNewHeroCard2() {
        when(iHeroCardRepository.save((HeroCard) any())).thenThrow(new IllegalStateException("foo"));

        HeroCard heroCard = new HeroCard();
        heroCard.setCardClass("Card Class");
        heroCard.setCost(1);
        heroCard.setEffect("Effect");
        heroCard.setHeroPower("Hero Power");
        heroCard.setHeroPowerCost(1);
        heroCard.setHeroPowerEffect("Hero Power Effect");
        heroCard.setId(1);
        heroCard.setImage("Image");
        heroCard.setName("Name");
        heroCard.setRarity(Rarity.Free);
        heroCard.setSet("Set");
        assertThrows(IllegalStateException.class, () -> cardService.addNewHeroCard(heroCard));
        verify(iHeroCardRepository).save((HeroCard) any());
    }

    /**
     * Method under test: {@link CardService#addNewMinionCard(MinionCard)}
     */
    @Test
    void testAddNewMinionCard() {
        MinionCard minionCard = new MinionCard();
        minionCard.setAttack(1);
        minionCard.setCardClass("Card Class");
        minionCard.setCost(1);
        minionCard.setEffect("Effect");
        minionCard.setHealth(1);
        minionCard.setId(1);
        minionCard.setImage("Image");
        minionCard.setName("Name");
        minionCard.setRarity(Rarity.Free);
        minionCard.setSet("Set");
        minionCard.setTribe("Tribe");
        when(iMinionCardRepository.save((MinionCard) any())).thenReturn(minionCard);

        MinionCard minionCard1 = new MinionCard();
        minionCard1.setAttack(1);
        minionCard1.setCardClass("Card Class");
        minionCard1.setCost(1);
        minionCard1.setEffect("Effect");
        minionCard1.setHealth(1);
        minionCard1.setId(1);
        minionCard1.setImage("Image");
        minionCard1.setName("Name");
        minionCard1.setRarity(Rarity.Free);
        minionCard1.setSet("Set");
        minionCard1.setTribe("Tribe");
        cardService.addNewMinionCard(minionCard1);
        verify(iMinionCardRepository).save((MinionCard) any());
        assertEquals(1, minionCard1.getAttack().intValue());
        assertEquals("Tribe", minionCard1.getTribe());
        assertEquals("Set", minionCard1.getSet());
        assertEquals(Rarity.Free, minionCard1.getRarity());
        assertEquals("Name", minionCard1.getName());
        assertEquals("Image", minionCard1.getImage());
        assertEquals(1, minionCard1.getId().intValue());
        assertEquals(1, minionCard1.getHealth().intValue());
        assertEquals("Effect", minionCard1.getEffect());
        assertEquals(1, minionCard1.getCost().intValue());
        assertEquals("Card Class", minionCard1.getCardClass());
    }

    /**
     * Method under test: {@link CardService#addNewMinionCard(MinionCard)}
     */
    @Test
    void testAddNewMinionCard2() {
        when(iMinionCardRepository.save((MinionCard) any())).thenThrow(new IllegalStateException("foo"));

        MinionCard minionCard = new MinionCard();
        minionCard.setAttack(1);
        minionCard.setCardClass("Card Class");
        minionCard.setCost(1);
        minionCard.setEffect("Effect");
        minionCard.setHealth(1);
        minionCard.setId(1);
        minionCard.setImage("Image");
        minionCard.setName("Name");
        minionCard.setRarity(Rarity.Free);
        minionCard.setSet("Set");
        minionCard.setTribe("Tribe");
        assertThrows(IllegalStateException.class, () -> cardService.addNewMinionCard(minionCard));
        verify(iMinionCardRepository).save((MinionCard) any());
    }

    /**
     * Method under test: {@link CardService#addNewSpellCard(SpellCard)}
     */
    @Test
    void testAddNewSpellCard() {
        SpellCard spellCard = new SpellCard();
        spellCard.setCardClass("Card Class");
        spellCard.setCost(1);
        spellCard.setEffect("Effect");
        spellCard.setId(1);
        spellCard.setImage("Image");
        spellCard.setName("Name");
        spellCard.setRarity(Rarity.Free);
        spellCard.setSet("Set");
        spellCard.setSpellType("Spell Type");
        when(iSpellCardRepository.save((SpellCard) any())).thenReturn(spellCard);

        SpellCard spellCard1 = new SpellCard();
        spellCard1.setCardClass("Card Class");
        spellCard1.setCost(1);
        spellCard1.setEffect("Effect");
        spellCard1.setId(1);
        spellCard1.setImage("Image");
        spellCard1.setName("Name");
        spellCard1.setRarity(Rarity.Free);
        spellCard1.setSet("Set");
        spellCard1.setSpellType("Spell Type");
        cardService.addNewSpellCard(spellCard1);
        verify(iSpellCardRepository).save((SpellCard) any());
        assertEquals("Card Class", spellCard1.getCardClass());
        assertEquals("Spell Type", spellCard1.getSpellType());
        assertEquals("Set", spellCard1.getSet());
        assertEquals(Rarity.Free, spellCard1.getRarity());
        assertEquals("Name", spellCard1.getName());
        assertEquals("Image", spellCard1.getImage());
        assertEquals(1, spellCard1.getId().intValue());
        assertEquals("Effect", spellCard1.getEffect());
        assertEquals(1, spellCard1.getCost().intValue());
    }

    /**
     * Method under test: {@link CardService#addNewSpellCard(SpellCard)}
     */
    @Test
    void testAddNewSpellCard2() {
        when(iSpellCardRepository.save((SpellCard) any())).thenThrow(new IllegalStateException("foo"));

        SpellCard spellCard = new SpellCard();
        spellCard.setCardClass("Card Class");
        spellCard.setCost(1);
        spellCard.setEffect("Effect");
        spellCard.setId(1);
        spellCard.setImage("Image");
        spellCard.setName("Name");
        spellCard.setRarity(Rarity.Free);
        spellCard.setSet("Set");
        spellCard.setSpellType("Spell Type");
        assertThrows(IllegalStateException.class, () -> cardService.addNewSpellCard(spellCard));
        verify(iSpellCardRepository).save((SpellCard) any());
    }

    /**
     * Method under test: {@link CardService#addNewWeaponCard(WeaponCard)}
     */
    @Test
    void testAddNewWeaponCard() {
        WeaponCard weaponCard = new WeaponCard();
        weaponCard.setAttack(1);
        weaponCard.setCardClass("Card Class");
        weaponCard.setCost(1);
        weaponCard.setDurability(1);
        weaponCard.setEffect("Effect");
        weaponCard.setId(1);
        weaponCard.setImage("Image");
        weaponCard.setName("Name");
        weaponCard.setRarity(Rarity.Free);
        weaponCard.setSet("Set");
        when(iWeaponCardRepository.save((WeaponCard) any())).thenReturn(weaponCard);

        WeaponCard weaponCard1 = new WeaponCard();
        weaponCard1.setAttack(1);
        weaponCard1.setCardClass("Card Class");
        weaponCard1.setCost(1);
        weaponCard1.setDurability(1);
        weaponCard1.setEffect("Effect");
        weaponCard1.setId(1);
        weaponCard1.setImage("Image");
        weaponCard1.setName("Name");
        weaponCard1.setRarity(Rarity.Free);
        weaponCard1.setSet("Set");
        cardService.addNewWeaponCard(weaponCard1);
        verify(iWeaponCardRepository).save((WeaponCard) any());
        assertEquals(1, weaponCard1.getAttack().intValue());
        assertEquals("Set", weaponCard1.getSet());
        assertEquals(Rarity.Free, weaponCard1.getRarity());
        assertEquals("Name", weaponCard1.getName());
        assertEquals("Image", weaponCard1.getImage());
        assertEquals(1, weaponCard1.getId().intValue());
        assertEquals("Effect", weaponCard1.getEffect());
        assertEquals(1, weaponCard1.getDurability().intValue());
        assertEquals(1, weaponCard1.getCost().intValue());
        assertEquals("Card Class", weaponCard1.getCardClass());
    }

    /**
     * Method under test: {@link CardService#addNewWeaponCard(WeaponCard)}
     */
    @Test
    void testAddNewWeaponCard2() {
        when(iWeaponCardRepository.save((WeaponCard) any())).thenThrow(new IllegalStateException("foo"));

        WeaponCard weaponCard = new WeaponCard();
        weaponCard.setAttack(1);
        weaponCard.setCardClass("Card Class");
        weaponCard.setCost(1);
        weaponCard.setDurability(1);
        weaponCard.setEffect("Effect");
        weaponCard.setId(1);
        weaponCard.setImage("Image");
        weaponCard.setName("Name");
        weaponCard.setRarity(Rarity.Free);
        weaponCard.setSet("Set");
        assertThrows(IllegalStateException.class, () -> cardService.addNewWeaponCard(weaponCard));
        verify(iWeaponCardRepository).save((WeaponCard) any());
    }
}

