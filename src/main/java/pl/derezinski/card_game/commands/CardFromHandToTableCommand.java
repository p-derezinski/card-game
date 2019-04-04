package pl.derezinski.card_game.commands;

import pl.derezinski.card_game.game_elements.Card;
import pl.derezinski.card_game.game_elements.Player;
import pl.derezinski.card_game.game_elements.Resources;

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
                if (player.getCounters().getNumberOfResourcesPerTurn() > 0) {
                    card.ifPresent(c -> player.getTable().add(player.getHand().remove(player.getHand().indexOf(c))));
                    card.ifPresent(c -> System.out.println("Card '" + c.getCardName() + "' entered the table."));
                    player.getCounters().setNumberOfResourcesPerTurn(player.getCounters().getNumberOfResourcesPerTurn() - 1);
                } else {
                    System.out.println("You can't play more Resources cards this turn.");
                }
            } else {
                card.ifPresent(c -> player.getTable().add(player.getHand().remove(player.getHand().indexOf(c))));
                card.ifPresent(c -> System.out.println("Card '" + c.getCardName() + "' entered the table."));
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
