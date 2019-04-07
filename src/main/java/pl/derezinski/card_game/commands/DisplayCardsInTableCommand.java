package pl.derezinski.card_game.commands;

import pl.derezinski.card_game.game_elements.Player;

public class DisplayCardsInTableCommand implements Command {

    private final Player player;
    private final String COMMAND_DESCRIPTION = "displays cards in the table";

    public DisplayCardsInTableCommand(Player player) {
        this.player = player;
    }

    @Override
    public void execute() {
        System.out.println("-----------------------\nCards in the table:");
        player.getTable().forEach(System.out::println);
    }

    @Override
    public String toString() {
        return COMMAND_DESCRIPTION;
    }
}
