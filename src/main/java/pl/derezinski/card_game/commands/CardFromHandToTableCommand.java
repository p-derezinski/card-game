package pl.derezinski.card_game.commands;

import pl.derezinski.card_game.game_elements.*;

import java.util.Optional;
import java.util.Scanner;

public class CardFromHandToTableCommand implements Command {

    private final Player player;
    private final String COMMAND_DESCRIPTION = "allows to play a card from the hand to the table";

    public CardFromHandToTableCommand(Player player) {
        this.player = player;
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("-----------------------\nPlaying a card:");
        System.out.print("Choose a card to play: ");
        String chosenCard = scanner.nextLine();
        Optional<Card> card = player.getHand().stream()
                .filter(c -> c.getCardName().equals(chosenCard))
                .findFirst();
        if (card.isPresent()) {

            if (card.get() instanceof Resources) {
                if (player.getCounters().getNumberOfResourcesPerTurn() > 0 & !player.getCounters().isHasCardWithResourcesCostBeenPlayed()) {
                    card.ifPresent(c -> player.getTable().add(player.getHand().remove(player.getHand().indexOf(c))));
                    card.ifPresent(c -> System.out.println("Card '" + c.getCardName() + "' entered the table."));
                    player.getCounters().setNumberOfResourcesPerTurn(player.getCounters().getNumberOfResourcesPerTurn() - 1);
                    Resources resources = (Resources) card.get();
                    resources.increasePlayerColorResources(player);
                    player.setResourcesCounters(new ResourcesCounters(player));
                } else {
                    System.out.println("You can't play more Resources cards this turn.");
                }

            } else if (card.get() instanceof CardWithResourcesCost){
                int brown = ((CardWithResourcesCost) card.get()).getBrownResourcesCost();
                int orange = ((CardWithResourcesCost) card.get()).getOrangeResourcesCost();
                int yellow = ((CardWithResourcesCost) card.get()).getYellowResourcesCost();
                int green = ((CardWithResourcesCost) card.get()).getGreenResourcesCost();
                int total = ((CardWithResourcesCost) card.get()).getTotalResourcesCost();
                if (player.getResourcesCounters().getBrownResources() < brown ||
                    player.getResourcesCounters().getOrangeResources() < orange ||
                    player.getResourcesCounters().getYellowResources() < yellow ||
                    player.getResourcesCounters().getGreenResources() < green ||
                    player.getResourcesCounters().getTotalResources() < total) {
                    System.out.println("You don't have enough resources to play this card.");
                } else {
                    player.getResourcesCounters().setBrownResources(player.getResourcesCounters().getBrownResources() - brown);
                    player.getResourcesCounters().setOrangeResources(player.getResourcesCounters().getOrangeResources() - orange);
                    player.getResourcesCounters().setYellowResources(player.getResourcesCounters().getYellowResources() - yellow);
                    player.getResourcesCounters().setGreenResources(player.getResourcesCounters().getGreenResources() - green);
                    player.getResourcesCounters().setTotalResources(player.getResourcesCounters().getTotalResources() - total);
                    player.getCounters().setHasCardWithResourcesCostBeenPlayed(true);
                    if (card.get() instanceof Action) {
                        card.ifPresent(c -> System.out.print("Card '" + c.getCardName() + "' was played. "));
                        ((Action) card.get()).performAction();
                        card.ifPresent(c -> player.getGraveyard().add(player.getHand().remove(player.getHand().indexOf(c))));
                    } else {
                        card.ifPresent(c -> player.getTable().add(player.getHand().remove(player.getHand().indexOf(c))));
                        card.ifPresent(c -> System.out.println("Card '" + c.getCardName() + "' entered the table."));
                    }
                }
            }
        } else {
            System.out.println("There is no such card in your hand.");
        }

        //player.getTable().add(player.getHand().remove(0));
    }

    @Override
    public String toString() {
        return COMMAND_DESCRIPTION;
    }
}
