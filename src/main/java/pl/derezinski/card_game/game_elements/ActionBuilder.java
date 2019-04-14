package pl.derezinski.card_game.game_elements;

import pl.derezinski.card_game.game_elements.behaviours.*;

import java.util.Optional;

public class ActionBuilder {

    private String cardName;
    private String cardDescription;
    private int brownResourcesCost;
    private int orangeResourcesCost;
    private int yellowResourcesCost;
    private int greenResourcesCost;
    private int totalResourcesCost;
    private OtherBehaviour otherBehaviour;

    public ActionBuilder cardName(String cardName) {
        this.cardName = cardName;
        return this;
    }

    public ActionBuilder cardDescription(String cardDescription) {
        this.cardDescription = cardDescription;
        return this;
    }

    public ActionBuilder brownResourcesCost(int brownResourcesCost) {
        this.brownResourcesCost = brownResourcesCost;
        return this;
    }

    public ActionBuilder orangeResourcesCost(int orangeResourcesCost) {
        this.orangeResourcesCost = orangeResourcesCost;
        return this;
    }

    public ActionBuilder yellowResourcesCost(int yellowResourcesCost) {
        this.yellowResourcesCost = yellowResourcesCost;
        return this;
    }

    public ActionBuilder greenResourcesCost(int greenResourcesCost) {
        this.greenResourcesCost = greenResourcesCost;
        return this;
    }

    public ActionBuilder totalResourcesCost(int totalResourcesCost) {
        this.totalResourcesCost = totalResourcesCost;
        return this;
    }

    public ActionBuilder otherBehaviour(OtherBehaviour otherBehaviour) {
        this.otherBehaviour = otherBehaviour;
        return this;
    }

    public Action build() {
        Action action = new Action();
        action.setCardName(cardName);
        action.setCardDescription(Optional
                .ofNullable(cardDescription)
                .orElse("No decsription provided."));
        action.setBrownResourcesCost(brownResourcesCost);
        action.setOrangeResourcesCost(orangeResourcesCost);
        action.setYellowResourcesCost(yellowResourcesCost);
        action.setGreenResourcesCost(greenResourcesCost);
        action.setTotalResourcesCost(totalResourcesCost);
        action.setOtherBehaviour(Optional
                .ofNullable(otherBehaviour)
                .orElse(new OtherNoEffect()));
        return action;
    }
}
