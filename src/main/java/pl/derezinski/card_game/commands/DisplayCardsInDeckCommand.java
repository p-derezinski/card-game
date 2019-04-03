package pl.derezinski.card_game.commands;

import pl.derezinski.card_game.game_elements.Player;

public class DisplayCardsInDeckCommand implements Command {

    private final Player player;
    private final String COMMAND_DESCRIPTION = "displays cards in the deck";

    public DisplayCardsInDeckCommand(Player player) {
        this.player = player;
    }

    @Override
    public void execute() {
        System.out.println("-----------------------\nCards in deck:");
        player.getDeck().forEach(System.out::println);
    }

    @Override
    public String toString() {
        return COMMAND_DESCRIPTION;
    }
}
