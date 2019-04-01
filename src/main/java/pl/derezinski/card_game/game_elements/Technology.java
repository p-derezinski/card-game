package pl.derezinski.card_game.game_elements;

import pl.derezinski.card_game.game_elements.behaviours.AttackBehaviour;
import pl.derezinski.card_game.game_elements.behaviours.DefenceBehaviour;
import pl.derezinski.card_game.game_elements.behaviours.OtherBehaviour;

public class Technology extends CardWithResourcesCost {

    private AttackBehaviour attackBehaviour;
    private DefenceBehaviour defenceBehaviour;
    private OtherBehaviour otherBehaviour;

    Technology() {
    }

    public void performAttack() {
        attackBehaviour.attack();
    }

    public void performDefence() {
        defenceBehaviour.defence();
    }

    public void performAction() {
        otherBehaviour.action();
    }

    public void setAttackBehaviour(AttackBehaviour attackBehaviour) {
        this.attackBehaviour = attackBehaviour;
    }

    public void setDefenceBehaviour(DefenceBehaviour defenceBehaviour) {
        this.defenceBehaviour = defenceBehaviour;
    }

    public void setOtherBehaviour(OtherBehaviour otherBehaviour) {
        this.otherBehaviour = otherBehaviour;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("-> ").append(cardName).append("\n");
        sb.append("\ttype: TECHNOLOGY, ");
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
        sb.append("\t").append(cardDescription);
        return sb.toString();
    }
}
