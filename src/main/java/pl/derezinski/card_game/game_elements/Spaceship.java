package pl.derezinski.card_game.game_elements;

import pl.derezinski.card_game.game_elements.behaviours.AttackBehaviour;

import java.util.Objects;

public class Spaceship extends CardWithResourcesCost {

    private int attackPower;
    private int defencePower;
    private AttackBehaviour attackBehaviour;
    private Spaceship spaceship;           // TODO - tu będzie przechowywana referencja do statku przeciwnika

    public void performAttack() {
        attackBehaviour.attack();
    }

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

    public AttackBehaviour getAttackBehaviour() {
        return attackBehaviour;
    }

    public void setAttackBehaviour(AttackBehaviour attackBehaviour) {
        this.attackBehaviour = attackBehaviour;
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
        StringBuilder sb = new StringBuilder();
        sb.append("-> ").append(cardName).append("\n");
        sb.append("\ttype: SPACESHIP, ");
        if (brownResourcesCost > 0) {
            sb.append("BROWN resources cost: ").append(brownResourcesCost).append(", ");
        }
        if (orangeResourcesCost > 0) {
            sb.append("ORANGE resources cost: ").append(orangeResourcesCost).append(", ");
        }
        if (yellowResourcesCost > 0) {
            sb.append("YELLOW resources cost: ").append(yellowResourcesCost).append(", ");
        }
        if (greenResourcesCost > 0) {
            sb.append("GREEN resources cost: ").append(greenResourcesCost).append(", ");
        }
        sb.append("total resources cost: ").append(totalResourcesCost).append("\n");
        sb.append("\tattack/defence power: ").append(attackPower).append("/").append(defencePower).append("\n");
        sb.append("\t").append(cardDescription);
        return sb.toString();
    }
}
