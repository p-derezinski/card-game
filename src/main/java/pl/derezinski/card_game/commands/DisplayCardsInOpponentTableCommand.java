package pl.derezinski.card_game.commands;

import pl.derezinski.card_game.game_elements.Player;

public class DisplayCardsInOpponentTableCommand implements Command {

    private final Player opponent;
    private final String COMMAND_DESCRIPTION = "displays cards in the opponent's table";

    public DisplayCardsInOpponentTableCommand(Player opponent) {
        this.opponent = opponent;
    }

    @Override
    public void execute() {
        System.out.println("-----------------------\nCards in the opponent's table:");
        opponent.getTable().forEach(System.out::println);
    }

    @Override
    public String toString() {
        return COMMAND_DESCRIPTION;
    }
}
