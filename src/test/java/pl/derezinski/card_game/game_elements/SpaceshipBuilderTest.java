package pl.derezinski.card_game.game_elements;

import org.junit.Test;

import static org.junit.Assert.*;

public class SpaceshipBuilderTest {

    @Test
    public void should_build_spaceship_when_details_are_defined_including_two_resources_colors() {
        // given
        String cardName = "Enterprise";
        String cardDescription = "Awesome spaceship.";
        int orangeResourcesCost = 1;
        int greenResourcesCost = 1;
        int totalResourcesCost = 5;
        int attackPower = 3;
        int defencePower = 4;
        // when
        Spaceship card = new SpaceshipBuilder()
                .cardName(cardName)
                .cardDescription(cardDescription)
                .orangeResourcesCost(orangeResourcesCost)
                .greenResourcesCost(greenResourcesCost)
                .totalResourcesCost(totalResourcesCost)
                .attackPower(attackPower)
                .defencePower(defencePower)
                .build();
        // then
        assertNotNull(card);
        assertEquals(cardName, card.getCardName());
        assertEquals(cardDescription, card.getCardDescription());
        assertEquals(0, card.getBrownResourcesCost());
        assertEquals(orangeResourcesCost, card.getOrangeResourcesCost());
        assertEquals(0, card.getYellowResourcesCost());
        assertEquals(greenResourcesCost, card.getGreenResourcesCost());
        assertEquals(totalResourcesCost, card.getTotalResourcesCost());
        assertEquals(attackPower, card.getAttackPower());
        assertEquals(defencePower, card.getDefencePower());
    }

}