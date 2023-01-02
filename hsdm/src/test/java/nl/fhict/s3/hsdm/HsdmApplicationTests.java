package nl.fhict.s3.hsdm;

import nl.fhict.s3.hsdm.controllers.CardController;
import nl.fhict.s3.hsdm.models.*;
import nl.fhict.s3.hsdm.repositories.*;
import nl.fhict.s3.hsdm.services.CardService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;


import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

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
    void testAddNewCard() throws Exception {
        Optional<Card> card = Optional.of( new HeroCard("TestClass","TestName","TestImage",0,Rarity.valueOf("FREE"),"TestSet","TestEffect","TestHp","TestHpEffect",0));
        when(heroCardRepository.findById(1)).thenReturn(card);

        assertTrue(cardController.getCardById(1).equals(card));

    }
}
