package nl.fhict.s3.hsdm.controllers;

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

@ContextConfiguration(classes = {CardController.class})
@ExtendWith(SpringExtension.class)
class CardControllerTest {
    @Autowired
    private CardController cardController;

    @MockBean
    private CardService cardService;

    /**
     * Method under test: {@link CardController#addNewCard(String, String, String, Integer, String, String, String, String, String, Integer, Integer, Integer, String, String, Integer)}
     */
    @Test
    void testAddNewCard() throws Exception {
        MockHttpServletRequestBuilder paramResult = MockMvcRequestBuilders.get("/").param("cardClass", "foo");
        MockHttpServletRequestBuilder requestBuilder = paramResult.param("cost", String.valueOf(1))
                .param("effect", "foo")
                .param("image", "foo")
                .param("name", "foo")
                .param("rarity", "foo")
                .param("set", "foo");
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(cardController).build().perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().isNotFound());
    }

    /**
     * Method under test: {@link CardController#deleteCard(Integer)}
     */
    @Test
    void testDeleteCard() throws Exception {
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/{cardId}", 123);
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(cardController).build().perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().isNotFound());
    }

    /**
     * Method under test: {@link CardController#getCardById(Integer)}
     */
    @Test
    void testGetCardById() throws Exception {
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/{cardId}", 123);
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(cardController).build().perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().isNotFound());
    }

    /**
     * Method under test: {@link CardController#getCards()}
     */
    @Test
    void testGetCards() throws Exception {
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/");
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(cardController).build().perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().isNotFound());
    }

    /**
     * Method under test: {@link CardController#updateCard(Integer, String, String, String, Integer, String, String, String, String, String, Integer, Integer, Integer, String, String, Integer)}
     */
    @Test
    void testUpdateCard() throws Exception {
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.put("/{cardId}", 123);
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(cardController).build().perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().isNotFound());
    }
}

