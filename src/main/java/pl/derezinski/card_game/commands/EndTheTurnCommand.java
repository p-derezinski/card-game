package pl.derezinski.card_game.commands;

import pl.derezinski.card_game.game_elements.Player;

public class EndTheTurnCommand implements Command{

    private final Player player;
    private final String COMMAND_DESCRIPTION = "ends the current turn";

    public EndTheTurnCommand(Player player) {
        this.player = player;
    }

    @Override
    public void execute() {
        System.out.println("-----------------------\nEnd of turn.");
        player.getCounters().setEndOfTurn(true);
    }

    @Override
    public String toString() {
        return COMMAND_DESCRIPTION;
    }
}
