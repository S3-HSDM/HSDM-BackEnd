package nl.fhict.s3.hsdm;

import nl.fhict.s3.hsdm.controllers.CardController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@TestPropertySource(properties = {
        "spring.datasource.url=jdbc:mysql://localhost:3306/hsdm"
})
class HsdmApplicationTests {
    @Autowired
    private MockMvc mockMvc;

    @Test
    void addHeroCard() throws Exception {
        mockMvc.perform(post("/api/cards?cardClass=TestClass&name=TestName&image=TestImage&cost=5&rarity=Epic&set=TestSet&effect=TestEffect&heroPower=TestHp&heroPowerEffect=TestHpEffect&heroPowerCost=5")
        ).andExpect(status().isOk());
    }

    @Test
    void addMinionCard() throws Exception {
        mockMvc.perform(post("/api/cards?cardClass=TestClass&name=TestName&image=TestImage&cost=5&rarity=Epic&set=TestSet&effect=TestEffect&attack=5&health=5&tribe=TestTribe")
        ).andExpect(status().isOk());
    }

    @Test
    void addSpellCard() throws Exception {
        mockMvc.perform(post("/api/cards?cardClass=TestClass&name=TestName&image=TestImage&cost=5&rarity=Epic&set=TestSet&effect=TestEffect&spellType=TestSpellType")
        ).andExpect(status().isOk());
    }

    @Test
    void addWeaponCard() throws Exception {
        mockMvc.perform(post("/api/cards?cardClass=TestClass&name=TestName&image=TestImage&cost=5&rarity=Epic&set=TestSet&effect=TestEffect&attack=5&durability=5")
        ).andExpect(status().isOk());
    }

    @Test
    void editWeaponCard() throws Exception {
        mockMvc.perform(put("/api/cards/3?cardClass=TestClass&name=TestName&image=TestImage&cost=8&rarity=Epic&set=TestSet&effect=TestEffect&attack=8&durability=8")
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
