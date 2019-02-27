package pl.derezinski.card_game.game_elements;

import java.util.Objects;

public class Spaceship extends CardWithResourcesCost {

    private int attackPower;
    private int defencePower;

    public int getAttackPower() {
        return attackPower;
    }

    public void setAttackPower(int attackPower) {
        this.attackPower = attackPower;
    }

    public int getDefencePower() {
        return defencePower;
    }

    public void setDefencePower(int defencePower) {
        this.defencePower = defencePower;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Spaceship spaceship = (Spaceship) o;
        return attackPower == spaceship.attackPower &&
                defencePower == spaceship.defencePower;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), attackPower, defencePower);
    }

    @Override
    public String toString() {
        //TODO - dokończyć metodę, StringBuilder, koszt ma się wyświetlać tylko gdt jest większy od 0
//        return "-> " + cardName + "\n" +
//                "\ttype: Spaceship, color: " + color + "\n" +
//                "\t" + cardDescription;
        return "Spaceship{" +
                "attackPower=" + attackPower +
                ", defencePower=" + defencePower +
                ", brownResourcesCost=" + brownResourcesCost +
                ", orangeResourcesCost=" + orangeResourcesCost +
                ", yellowResourcesCost=" + yellowResourcesCost +
                ", greenResourcesCost=" + greenResourcesCost +
                ", totalResourcesCost=" + totalResourcesCost +
                ", cardDescription='" + cardDescription + '\'' +
                '}';
    }
}
