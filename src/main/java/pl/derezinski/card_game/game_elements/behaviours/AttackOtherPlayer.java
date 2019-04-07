package pl.derezinski.card_game.game_elements.behaviours;

import pl.derezinski.card_game.game_elements.Player;

public class AttackOtherPlayer implements AttackBehaviour {

    private int attackPower;
    private Player opponent;

    public AttackOtherPlayer(int attackPower) {
        this.attackPower = attackPower;
    }

    @Override
    public void attack() {
        // TODO
        System.out.println("Attacking the opponent. The opponent loses " + attackPower + " life points.");
        opponent.setLifeCount(opponent.getLifeCount() - attackPower);
    }

    public int getAttackPower() {
        return attackPower;
    }

    public void setAttackPower(int attackPower) {
        this.attackPower = attackPower;
    }

    public Player getOpponent() {
        return opponent;
    }

    public void setOpponent(Player opponent) {
        this.opponent = opponent;
    }
}
