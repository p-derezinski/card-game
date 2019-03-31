package pl.derezinski.card_game.game_elements.behaviours;

public class AttackNoEffect implements AttackBehaviour {

    @Override
    public void attack() {
        System.out.println("This card has no attack functionality.");
    }
}
