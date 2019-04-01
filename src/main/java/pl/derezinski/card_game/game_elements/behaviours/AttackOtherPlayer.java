package pl.derezinski.card_game.game_elements.behaviours;

public class AttackOtherPlayer implements AttackBehaviour {

    private int attackPower;

    public AttackOtherPlayer(int attackPower) {
        this.attackPower = attackPower;
    }

    @Override
    public void attack() {
        // TODO
        System.out.println("Attacking another player. The attacked player loses " + attackPower + " life points.");
    }

    public int getAttackPower() {
        return attackPower;
    }

    public void setAttackPower(int attackPower) {
        this.attackPower = attackPower;
    }
}
