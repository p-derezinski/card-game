package pl.derezinski.card_game.game_elements;

import java.util.Objects;

public class Resources extends Card {

    private Color color;

    Resources() {
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void increasePlayerColorResources(Player player) {
        if (color.equals(Color.BROWN)) {
            player.setBrownResources(player.getBrownResources() + 1);
        } else if (color.equals(Color.ORANGE)) {
            player.setOrangeResources(player.getOrangeResources() + 1);
        } else if (color.equals(Color.YELLOW)) {
            player.setYellowResources(player.getYellowResources() + 1);
        } else if (color.equals(Color.GREEN)) {
            player.setGreenResources(player.getGreenResources() + 1);
        }
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
                "\ttype: RESOURCES, color: " + color + "\n" +
                "\t" + cardDescription;
    }
}
