package pl.derezinski.card_game.game_elements;

import java.util.Objects;

public abstract class Card {

    protected String cardName;
    protected String cardDescription;

    public String getCardName() {
        return cardName;
    }

    public void setCardName(String cardName) {
        this.cardName = cardName;
    }

    public String getCardDescription() {
        return cardDescription;
    }

    public void setCardDescription(String cardDescription) {
        this.cardDescription = cardDescription;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card) o;
        return Objects.equals(cardName, card.cardName) &&
                Objects.equals(cardDescription, card.cardDescription);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cardName, cardDescription);
    }

}
