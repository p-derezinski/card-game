package pl.derezinski.card_game.game_elements;

import pl.derezinski.card_game.game_elements.behaviours.AttackBehaviour;
import pl.derezinski.card_game.game_elements.behaviours.AttackOtherPlayer;

import java.util.Optional;

public class SpaceshipBuilder {

    private String cardName;
    private String cardDescription;
    private int brownResourcesCost;
    private int orangeResourcesCost;
    private int yellowResourcesCost;
    private int greenResourcesCost;
    private int totalResourcesCost;
    private int attackPower;
    private int defencePower;
    private AttackBehaviour attackBehaviour;

    public SpaceshipBuilder cardName(String cardName) {
        this.cardName = cardName;
        return this;
    }

    public SpaceshipBuilder cardDescription(String cardDescription) {
        this.cardDescription = cardDescription;
        return this;
    }

    public SpaceshipBuilder brownResourcesCost(int brownResourcesCost) {
        this.brownResourcesCost = brownResourcesCost;
        return this;
    }

    public SpaceshipBuilder orangeResourcesCost(int orangeResourcesCost) {
        this.orangeResourcesCost = orangeResourcesCost;
        return this;
    }

    public SpaceshipBuilder yellowResourcesCost(int yellowResourcesCost) {
        this.yellowResourcesCost = yellowResourcesCost;
        return this;
    }

    public SpaceshipBuilder greenResourcesCost(int greenResourcesCost) {
        this.greenResourcesCost = greenResourcesCost;
        return this;
    }

    public SpaceshipBuilder totalResourcesCost(int totalResourcesCost) {
        this.totalResourcesCost = totalResourcesCost;
        return this;
    }

    public SpaceshipBuilder attackPower(int attackPower) {
        this.attackPower = attackPower;
        return this;
    }

    public SpaceshipBuilder defencePower(int defencePower) {
        this.defencePower = defencePower;
        return this;
    }

    public SpaceshipBuilder attackBehaviour(AttackBehaviour attackBehaviour) {
        this.attackBehaviour = attackBehaviour;
        return this;
    }

    public Spaceship build() {
        Spaceship spaceship = new Spaceship();
        spaceship.setCardName(cardName);
        spaceship.setCardDescription(Optional
                .ofNullable(cardDescription)
                .orElse("No decsription provided."));
        spaceship.setBrownResourcesCost(brownResourcesCost);
        spaceship.setOrangeResourcesCost(orangeResourcesCost);
        spaceship.setYellowResourcesCost(yellowResourcesCost);
        spaceship.setGreenResourcesCost(greenResourcesCost);
        spaceship.setTotalResourcesCost(totalResourcesCost);
        spaceship.setAttackPower(attackPower);
        spaceship.setDefencePower(defencePower);
        spaceship.setAttackBehaviour(Optional
                .ofNullable(attackBehaviour)
                .orElse(new AttackOtherPlayer(attackPower)));
        return spaceship;
    }

}
