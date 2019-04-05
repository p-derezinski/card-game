package pl.derezinski.card_game.commands;

import pl.derezinski.card_game.game_elements.Player;

public class EndTheGameCommand implements Command{

    private final Player player;
    private final String COMMAND_DESCRIPTION = "you give up and it ends the game";

    public EndTheGameCommand(Player player) {
        this.player = player;
    }

    @Override
    public void execute() {
        player.setLifeCount(0);
    }

    @Override
    public String toString() {
        return COMMAND_DESCRIPTION;
    }
}
