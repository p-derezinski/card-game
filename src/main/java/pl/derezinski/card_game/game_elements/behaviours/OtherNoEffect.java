package pl.derezinski.card_game.game_elements.behaviours;

public class OtherNoEffect implements OtherBehaviour {

    @Override
    public void action() {
        System.out.println("This card has no additional functionality.");
    }
}
