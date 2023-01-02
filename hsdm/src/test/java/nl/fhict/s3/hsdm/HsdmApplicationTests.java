package nl.fhict.s3.hsdm;

import nl.fhict.s3.hsdm.models.*;
import nl.fhict.s3.hsdm.repositories.*;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Optional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class HsdmApplicationTests {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ICardRepository cardRepository;
    @MockBean
    private IHeroCardRepository heroCardRepository;
    @MockBean
    private IMinionCardRepository minionCardRepository;
    @MockBean
    private ISpellCardRepository spellCardRepository;
    @MockBean
    private IWeaponCardRepository weaponCardRepository;

    @Test
    void addHeroCard() throws Exception {
        Card newCard = new HeroCard();
        Mockito.when(heroCardRepository.save(newCard)).thenReturn(null);
        mockMvc.perform(post("/api/cards?cardClass=TestClass&name=TestName&image=TestImage&cost=5&rarity=Epic&set=TestSet&effect=TestEffect&heroPower=TestHp&heroPowerEffect=TestHpEffect&heroPowerCost=5")
        ).andExpect(status().isOk());
    }

    @Test
    void addMinionCard() throws Exception {
        Card newCard = new MinionCard();
        Mockito.when(minionCardRepository.save(newCard)).thenReturn(null);
        mockMvc.perform(post("/api/cards?cardClass=TestClass&name=TestName&image=TestImage&cost=5&rarity=Epic&set=TestSet&effect=TestEffect&attack=5&health=5&tribe=TestTribe")
        ).andExpect(status().isOk());
    }

    @Test
    void addSpellCard() throws Exception {
        Card newCard = new SpellCard();
        Mockito.when(spellCardRepository.save(newCard)).thenReturn(null);
        mockMvc.perform(post("/api/cards?cardClass=TestClass&name=TestName&image=TestImage&cost=5&rarity=Epic&set=TestSet&effect=TestEffect&spellType=TestSpellType")
        ).andExpect(status().isOk());
    }

    @Test
    void addWeaponCard() throws Exception {
        Card newCard = new WeaponCard();
        Mockito.when(weaponCardRepository.save(newCard)).thenReturn(null);
        mockMvc.perform(post("/api/cards?cardClass=TestClass&name=TestName&image=TestImage&cost=5&rarity=Epic&set=TestSet&effect=TestEffect&attack=5&durability=5")
        ).andExpect(status().isOk());
    }

    @Test
    void deleteCard() throws Exception {
        mockMvc.perform(delete("/api/cards/3")
        ).andExpect(status().isOk());
    }

    @Test
    void getCards() throws Exception {
        mockMvc.perform(get("/api/cards")
        ).andExpect(status().isOk());
    }

}
