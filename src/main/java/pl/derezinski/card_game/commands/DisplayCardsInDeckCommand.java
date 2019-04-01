package pl.derezinski.card_game.commands;

import pl.derezinski.card_game.game_elements.Player;

public class DisplayCardsInDeckCommand implements Command {

    private final Player player;

    public DisplayCardsInDeckCommand(Player player) {
        this.player = player;
    }

    @Override
    public void execute() {
        player.getDeck().forEach(System.out::println);
    }
}
