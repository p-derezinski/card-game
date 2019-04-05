package pl.derezinski.card_game.commands;

import pl.derezinski.card_game.game_elements.Player;

public class StatisticsCommand implements Command {

    private final Player player;
    private final String COMMAND_DESCRIPTION = "displays player statistics";

    public StatisticsCommand(Player player) {
        this.player = player;
    }

    @Override
    public void execute() {
        StringBuilder sb = new StringBuilder();
        sb.append("-----------------------\nYour statistics:")
                .append("\n\t--> remaining life count: ").append(player.getLifeCount());
        if (player.getBrownResources() > 0) {
            sb.append("\n\t--> BROWN resources: ").append(player.getBrownResources());
        }
        if (player.getOrangeResources() > 0) {
            sb.append("\n\t--> ORANGE resources: ").append(player.getOrangeResources());
        }
        if (player.getYellowResources() > 0) {
            sb.append("\n\t--> YELLOW resources: ").append(player.getYellowResources());
        }
        if (player.getGreenResources() > 0) {
            sb.append("\n\t--> GREEN resources: ").append(player.getGreenResources());
        }
        sb
                .append("\n\t--> number of remaining cards in the deck: ").append(player.getDeck().size())
                .append("\n\t--> number of cards in the graveyard: ").append(player.getGraveyard().size())
                .append("\n\t--> opponent's remaining life count: ").append(player.getOpponent().getLifeCount());
        System.out.println(sb);
    }

    @Override
    public String toString() {
        return COMMAND_DESCRIPTION;
    }
}
