package pl.derezinski.card_game.game_elements;

import java.util.Objects;

public abstract class CardWithResourcesCost extends Card{

    protected int brownResourcesCost;
    protected int orangeResourcesCost;
    protected int yellowResourcesCost;
    protected int greenResourcesCost;
    protected int totalResourcesCost = brownResourcesCost + orangeResourcesCost + yellowResourcesCost + greenResourcesCost;

    public int getBrownResourcesCost() {
        return brownResourcesCost;
    }

    public void setBrownResourcesCost(int brownResourcesCost) {
        this.brownResourcesCost = brownResourcesCost;
    }

    public int getOrangeResourcesCost() {
        return orangeResourcesCost;
    }

    public void setOrangeResourcesCost(int orangeResourcesCost) {
        this.orangeResourcesCost = orangeResourcesCost;
    }

    public int getYellowResourcesCost() {
        return yellowResourcesCost;
    }

    public void setYellowResourcesCost(int yellowResourcesCost) {
        this.yellowResourcesCost = yellowResourcesCost;
    }

    public int getGreenResourcesCost() {
        return greenResourcesCost;
    }

    public void setGreenResourcesCost(int greenResourcesCost) {
        this.greenResourcesCost = greenResourcesCost;
    }

    public int getTotalResourcesCost() {
        return totalResourcesCost;
    }

    public void setTotalResourcesCost(int totalResourcesCost) {
        this.totalResourcesCost = totalResourcesCost;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        CardWithResourcesCost that = (CardWithResourcesCost) o;
        return brownResourcesCost == that.brownResourcesCost &&
                orangeResourcesCost == that.orangeResourcesCost &&
                yellowResourcesCost == that.yellowResourcesCost &&
                greenResourcesCost == that.greenResourcesCost &&
                totalResourcesCost == that.totalResourcesCost;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), brownResourcesCost, orangeResourcesCost, yellowResourcesCost, greenResourcesCost, totalResourcesCost);
    }
}
