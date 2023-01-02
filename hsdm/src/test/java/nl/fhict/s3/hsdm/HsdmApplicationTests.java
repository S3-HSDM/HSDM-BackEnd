package nl.fhict.s3.hsdm;

import nl.fhict.s3.hsdm.controllers.CardController;
import nl.fhict.s3.hsdm.models.*;
import nl.fhict.s3.hsdm.repositories.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;


import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class HsdmApplicationTests {

    @Autowired
    private CardController cardController;

    @MockBean
    private IHeroCardRepository heroCardRepository;

    @Test
    public void testFindCardById() throws Exception {
        Optional<Card> card = Optional.of( new HeroCard("TestClass","TestName","TestImage",0,Rarity.valueOf("FREE"),"TestSet","TestEffect","TestHp","TestHpEffect",0));
        when(heroCardRepository.findById(1)).thenReturn(card);
        assertTrue(cardController.getCardById(1).equals(card));
    }
}
