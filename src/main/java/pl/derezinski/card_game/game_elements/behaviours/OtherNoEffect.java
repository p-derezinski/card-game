package pl.derezinski.card_game.game_elements.behaviours;

import pl.derezinski.card_game.game_elements.Player;

public class OtherNoEffect implements OtherBehaviour {

    @Override
    public void action(Player player) {
        System.out.println("This card has no additional functionality.");
    }
}
