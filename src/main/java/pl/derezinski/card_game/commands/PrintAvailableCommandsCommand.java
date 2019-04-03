package pl.derezinski.card_game.commands;

import pl.derezinski.card_game.game_elements.Player;

import java.util.Map;

public class PrintAvailableCommandsCommand implements Command {

    private final Player player;
    private final String COMMAND_DESCRIPTION = "displays available commands";
    private final Map<String, Command> commands;

    public PrintAvailableCommandsCommand(Player player, Map<String, Command> commands) {
        this.player = player;
        this.commands = commands;
    }

    @Override
    public void execute() {
        System.out.println("-----------------------\nAvailable commands:");
        commands.forEach((s, c) -> System.out.println(" - '" + s + "' - " + c.toString()));
    }

    @Override
    public String toString() {
        return COMMAND_DESCRIPTION;
    }
}
