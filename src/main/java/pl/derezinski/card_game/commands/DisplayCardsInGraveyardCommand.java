package pl.derezinski.card_game.commands;

import pl.derezinski.card_game.game_elements.Player;

public class DisplayCardsInGraveyardCommand implements Command {

    private final Player player;
    private final String COMMAND_DESCRIPTION = "displays cards in the graveyard";

    public DisplayCardsInGraveyardCommand(Player player) {
        this.player = player;
    }

    @Override
    public void execute() {
        System.out.println("-----------------------\nCards in graveyard:");
        player.getGraveyard().forEach(System.out::println);
    }

    @Override
    public String toString() {
        return COMMAND_DESCRIPTION;
    }
}
