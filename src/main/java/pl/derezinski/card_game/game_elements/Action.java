package pl.derezinski.card_game.game_elements;

import pl.derezinski.card_game.game_elements.behaviours.OtherBehaviour;

public class Action extends CardWithResourcesCost{

    private OtherBehaviour otherBehaviour;

    public Action() {
    }

    public void performAction() {
        otherBehaviour.action(player);
    }

    public OtherBehaviour getOtherBehaviour() {
        return otherBehaviour;
    }

    public void setOtherBehaviour(OtherBehaviour otherBehaviour) {
        this.otherBehaviour = otherBehaviour;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("-> ").append(cardName).append("\n");
        sb.append("\ttype: ACTION, ");
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
