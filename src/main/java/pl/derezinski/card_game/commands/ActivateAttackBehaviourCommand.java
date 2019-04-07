package pl.derezinski.card_game.commands;

import pl.derezinski.card_game.game_elements.*;
import pl.derezinski.card_game.game_elements.behaviours.AttackBehaviour;
import pl.derezinski.card_game.game_elements.behaviours.AttackOtherPlayer;

import java.util.Optional;
import java.util.Scanner;

public class ActivateAttackBehaviourCommand implements Command {

    private final Player player;
    private final Player opponent;
    private final String COMMAND_DESCRIPTION = "activates the attack behaviour of the chosen card";

    public ActivateAttackBehaviourCommand(Player player, Player opponent) {
        this.player = player;
        this.opponent = opponent;
    }

    // TODO - poprawić tę klasę
    // TODO - zadbać o to, żeby tylko raz na turę można bylo zaatakować statkiem

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("-----------------------\nAttack!");
        System.out.print("Choose a card to perform attack: ");
        String chosenCard = scanner.nextLine();
        Optional<Card> card = player.getTable().stream()
                .filter(c -> c.getCardName().equals(chosenCard))
                .findFirst();
        if (card.isPresent()) {

            if (card.get() instanceof Spaceship) {
                AttackBehaviour attackBehaviour = ((Spaceship) card.get()).getAttackBehaviour();
                if (attackBehaviour instanceof AttackOtherPlayer) {
                    ((AttackOtherPlayer) attackBehaviour).setOpponent(opponent);
                }
                //(AttackOtherPlayer)(((Spaceship) card.get()).getAttackBehaviour())
                ((Spaceship) card.get()).performAttack();
//                if (player.getCounters().getNumberOfResourcesPerTurn() > 0 & !player.getCounters().isHasCardWithResourcesCostBeenPlayed()) {
//                    card.ifPresent(c -> player.getTable().add(player.getHand().remove(player.getHand().indexOf(c))));
//                    card.ifPresent(c -> System.out.println("Card '" + c.getCardName() + "' entered the table."));
//                    player.getCounters().setNumberOfResourcesPerTurn(player.getCounters().getNumberOfResourcesPerTurn() - 1);
//                    Resources resources = (Resources) card.get();
//                    resources.increasePlayerColorResources(player);
//                    player.setResourcesCounters(new ResourcesCounters(player));
//                } else {
//                    System.out.println("You can't play more Resources cards this turn.");
//                }

            } else {
                System.out.println("This card does not have the ability to attack.");
                // TODO - może już na etapie Optionala sprawdzać, czy karta ma taką funkcjonalność
            }
        } else {
            System.out.println("There is no such card in the table.");
        }
    }

    @Override
    public String toString() {
        return COMMAND_DESCRIPTION;
    }
}
