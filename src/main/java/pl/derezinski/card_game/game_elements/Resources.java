package pl.derezinski.card_game.game_elements;

import java.util.Objects;

public class Resources extends Card {

    Resources() {
    }

    private Color color;

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Resources resources = (Resources) o;
        return color == resources.color;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), color);
    }

    @Override
    public String toString() {
        return "-> " + cardName + "\n" +
                "\ttype: Resources, color: " + color + "\n" +
                "\t" + cardDescription;
    }
}
