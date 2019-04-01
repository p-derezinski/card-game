package pl.derezinski.card_game.commands;

import pl.derezinski.card_game.game_elements.Player;

public class DisplayCardsInHandCommand implements Command {

    private final Player player;

    public DisplayCardsInHandCommand(Player player) {
        this.player = player;
    }

    @Override
    public void execute() {
        player.getHand().forEach(System.out::println);
    }
}
