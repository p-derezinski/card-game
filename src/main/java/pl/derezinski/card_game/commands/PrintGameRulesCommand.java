package pl.derezinski.card_game.commands;

public class PrintGameRulesCommand implements Command {

    private final String COMMAND_DESCRIPTION = "displays rules of the game";

    @Override
    public void execute() {
        StringBuilder sb = new StringBuilder();
        sb
                .append("-----------------------\nRules of the Card Game:")
                .append("\n\t1. Each player starts with 7 cards in the hand and xx cards in the deck.")
                .append("\n\t2. You can play up to one Resources card every turn. This card has to be the first card played that turn.")
                .append("\n\t3. More rules to come!");
        // TODO - more rules
        System.out.println(sb);
    }

    @Override
    public String toString() {
        return COMMAND_DESCRIPTION;
    }
}
