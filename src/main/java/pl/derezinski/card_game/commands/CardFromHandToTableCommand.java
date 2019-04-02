package pl.derezinski.card_game.commands;

import pl.derezinski.card_game.game_elements.Card;
import pl.derezinski.card_game.game_elements.Player;

import java.util.Optional;
import java.util.Scanner;

public class CardFromHandToTableCommand implements Command {

    private final Player player;

    public CardFromHandToTableCommand(Player player) {
        this.player = player;
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose a card to play:");
        String chosenCard = scanner.nextLine();
        Optional<Card> card = player.getHand().stream()
                .filter(c -> c.getCardName().equals(chosenCard))
                .findFirst();
        card.ifPresent(c -> player.getTable().add(player.getHand().remove(player.getHand().indexOf(c))));
        card.ifPresent(c -> System.out.println("Card '" + c.getCardName() + "' entered the table."));
        if (!card.isPresent()) {
            System.out.println("There is no such card in your hand.");
        }

        //player.getTable().add(player.getHand().remove(0));
    }
}
