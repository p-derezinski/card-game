package pl.derezinski.card_game.game_elements.behaviours;

import pl.derezinski.card_game.game_elements.Player;

public class OtherSpyOpponentsHand implements OtherBehaviour {

    @Override
    public void action(Player player) {
        System.out.println("You are looking into your opponent's hand.");
        player.getOpponent().getHand().forEach(System.out::println);
    }
}
