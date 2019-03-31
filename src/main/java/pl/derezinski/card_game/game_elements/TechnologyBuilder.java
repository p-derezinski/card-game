package pl.derezinski.card_game.game_elements;

import pl.derezinski.card_game.game_elements.behaviours.*;

import java.util.Optional;

public class TechnologyBuilder {

    private String cardName;
    private String cardDescription;
    private int brownResourcesCost;
    private int orangeResourcesCost;
    private int yellowResourcesCost;
    private int greenResourcesCost;
    private int totalResourcesCost;
    private AttackBehaviour attackBehaviour;
    private DefenceBehaviour defenceBehaviour;
    private OtherBehaviour otherBehaviour;

    public TechnologyBuilder cardName(String cardName) {
        this.cardName = cardName;
        return this;
    }

    public TechnologyBuilder cardDescription(String cardDescription) {
        this.cardDescription = cardDescription;
        return this;
    }

    public TechnologyBuilder brownResourcesCost(int brownResourcesCost) {
        this.brownResourcesCost = brownResourcesCost;
        return this;
    }

    public TechnologyBuilder orangeResourcesCost(int orangeResourcesCost) {
        this.orangeResourcesCost = orangeResourcesCost;
        return this;
    }

    public TechnologyBuilder yellowResourcesCost(int yellowResourcesCost) {
        this.yellowResourcesCost = yellowResourcesCost;
        return this;
    }

    public TechnologyBuilder greenResourcesCost(int greenResourcesCost) {
        this.greenResourcesCost = greenResourcesCost;
        return this;
    }

    public TechnologyBuilder totalResourcesCost(int totalResourcesCost) {
        this.totalResourcesCost = totalResourcesCost;
        return this;
    }

    public TechnologyBuilder attackBehaviour(AttackBehaviour attackBehaviour) {
        this.attackBehaviour = attackBehaviour;
        return this;
    }

    public TechnologyBuilder defenceBehaviour(DefenceBehaviour defenceBehaviour) {
        this.defenceBehaviour = defenceBehaviour;
        return this;
    }

    public TechnologyBuilder otherBehaviour(OtherBehaviour otherBehaviour) {
        this.otherBehaviour = otherBehaviour;
        return this;
    }

    public Technology build() {
        Technology technology = new Technology();
        technology.setCardName(cardName);
        technology.setCardDescription(Optional
                .ofNullable(cardDescription)
                .orElse("No decsription provided."));
        technology.setBrownResourcesCost(brownResourcesCost);
        technology.setOrangeResourcesCost(orangeResourcesCost);
        technology.setYellowResourcesCost(yellowResourcesCost);
        technology.setGreenResourcesCost(greenResourcesCost);
        technology.setTotalResourcesCost(totalResourcesCost);
        technology.setAttackBehaviour(Optional
                .ofNullable(attackBehaviour)
                .orElse(new AttackNoEffect()));
        technology.setDefenceBehaviour(Optional
                .ofNullable(defenceBehaviour)
                .orElse(new DefenceNoEffect()));
        technology.setOtherBehaviour(Optional
                .ofNullable(otherBehaviour)
                .orElse(new OtherNoEffect()));
        return technology;
    }

}
