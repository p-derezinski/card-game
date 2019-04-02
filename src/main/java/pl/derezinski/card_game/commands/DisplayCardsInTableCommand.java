package pl.derezinski.card_game.commands;

import pl.derezinski.card_game.game_elements.Player;

public class DisplayCardsInTableCommand implements Command {

    private final Player player;

    public DisplayCardsInTableCommand(Player player) {
        this.player = player;
    }

    @Override
    public void execute() {
        player.getTable().forEach(System.out::println);
    }
}
