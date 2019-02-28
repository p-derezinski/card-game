package pl.derezinski.card_game.game_elements;

import org.junit.Test;

import static org.junit.Assert.*;

public class ResourcesBuilderTest {

    @Test
    public void should_build_resources_when_resources_details_are_defined() {
        // given
        String cardName = "Institute";
        String cardDescription = "The place of research and innovation.";
        Color color = Color.ORANGE;
        // when
        Resources card = new ResourcesBuilder()
                .cardName(cardName)
                .cardDescription(cardDescription)
                .color(color)
                .build();
        // then
        assertNotNull(card);
        assertEquals(cardName, card.getCardName());
        assertEquals(cardDescription, card.getCardDescription());
        assertEquals(color, card.getColor());
    }

}