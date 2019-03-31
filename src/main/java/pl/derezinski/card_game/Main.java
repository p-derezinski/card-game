package pl.derezinski.card_game;

import pl.derezinski.card_game.game_elements.*;
import pl.derezinski.card_game.game_elements.behaviours.AttackOtherPlayer;
import pl.derezinski.card_game.game_elements.behaviours.DefenceIncreaceShipDefence;

import java.util.Collections;

public class Main {

    public static void main(String[] args) {

        Player player = new Player();

        addCardsToThePlayersDeck(player);

        System.out.println("-----------------------\nCards before shuffle");
        player.getDeck().forEach(System.out::println);

        // sprawdzenie nowych kart Technology
        System.out.println("-----------------------\nTechnology cards");
        Technology technology_1 = (Technology) player.getDeck().get(26);
        technology_1.performAttack();
        technology_1.performDefence();
        technology_1.performAction();
        Technology technology_2 = (Technology) player.getDeck().get(27);
        technology_2.performAttack();
        technology_2.performDefence();
        technology_2.performAction();

        // potasowanie talii
        Collections.shuffle(player.getDeck());
        System.out.println("-----------------------\nCards after shuffle");
        player.getDeck().forEach(System.out::println);

        // pobranie siedmiu kart do ręki gracza
        for (int i = 0; i < 7; i++) {
            player.getHand().add(player.getDeck().remove(0));
        }
        System.out.println("-----------------------\nCards in hand:");
        player.getHand().forEach(System.out::println);

        System.out.println("-----------------------\nCards in deck:");
        player.getDeck().forEach(System.out::println);

    }

    private static void addCardsToThePlayersDeck(Player player) {
        player.getDeck().add(new ResourcesBuilder()
                .cardName("Factory")
                .cardDescription("Provides mass production of all necessary stuff.")
                .color(Color.BROWN)
                .build());
        player.getDeck().add(new ResourcesBuilder()
                .cardName("Shipyard")
                .color(Color.BROWN)
                .build());
        player.getDeck().add(new ResourcesBuilder()
                .cardName("University")
                .cardDescription("The place of studying.")
                .color(Color.ORANGE)
                .build());
        player.getDeck().add(new ResourcesBuilder()
                .cardName("Institute")
                .cardDescription("The place of research and innovation.")
                .color(Color.ORANGE)
                .build());
        player.getDeck().add(new ResourcesBuilder()
                .cardName("Power station")
                .color(Color.YELLOW)
                .build());
        player.getDeck().add(new ResourcesBuilder()
                .cardName("Mine")
                .color(Color.YELLOW)
                .build());
        player.getDeck().add(new ResourcesBuilder()
                .cardName("Farm")
                .color(Color.GREEN)
                .build());
        player.getDeck().add(new ResourcesBuilder()
                .cardName("Training camp")
                .color(Color.GREEN)
                .build());

        player.getDeck().add(new SpaceshipBuilder()
                .cardName("Basic Brown")
                .brownResourcesCost(1)
                .totalResourcesCost(1)
                .attackPower(1)
                .defencePower(1)
                .build());
        player.getDeck().add(new SpaceshipBuilder()
                .cardName("Basic Orange")
                .orangeResourcesCost(1)
                .totalResourcesCost(1)
                .attackPower(1)
                .defencePower(1)
                .build());
        player.getDeck().add(new SpaceshipBuilder()
                .cardName("Basic Yellow")
                .yellowResourcesCost(1)
                .totalResourcesCost(1)
                .attackPower(1)
                .defencePower(1)
                .build());
        player.getDeck().add(new SpaceshipBuilder()
                .cardName("Basic Green")
                .greenResourcesCost(1)
                .totalResourcesCost(1)
                .attackPower(1)
                .defencePower(1)
                .build());
        player.getDeck().add(new SpaceshipBuilder()
                .cardName("Stronger Brown")
                .brownResourcesCost(1)
                .totalResourcesCost(2)
                .attackPower(1)
                .defencePower(2)
                .build());
        player.getDeck().add(new SpaceshipBuilder()
                .cardName("Stronger Orange")
                .orangeResourcesCost(1)
                .totalResourcesCost(2)
                .attackPower(1)
                .defencePower(2)
                .build());
        player.getDeck().add(new SpaceshipBuilder()
                .cardName("Stronger Yellow")
                .yellowResourcesCost(1)
                .totalResourcesCost(2)
                .attackPower(2)
                .defencePower(1)
                .build());
        player.getDeck().add(new SpaceshipBuilder()
                .cardName("Stronger Green")
                .greenResourcesCost(1)
                .totalResourcesCost(2)
                .attackPower(2)
                .defencePower(1)
                .build());
        player.getDeck().add(new SpaceshipBuilder()
                .cardName("Apollo")
                .brownResourcesCost(1)
                .totalResourcesCost(3)
                .attackPower(1)
                .defencePower(3)
                .build());
        player.getDeck().add(new SpaceshipBuilder()
                .cardName("Discovery")
                .orangeResourcesCost(1)
                .totalResourcesCost(3)
                .attackPower(2)
                .defencePower(2)
                .build());
        player.getDeck().add(new SpaceshipBuilder()
                .cardName("Atlantis")
                .yellowResourcesCost(1)
                .totalResourcesCost(3)
                .attackPower(3)
                .defencePower(1)
                .build());
        player.getDeck().add(new SpaceshipBuilder()
                .cardName("Challenger")
                .greenResourcesCost(1)
                .totalResourcesCost(3)
                .attackPower(2)
                .defencePower(2)
                .build());
        player.getDeck().add(new SpaceshipBuilder()
                .cardName("Brown-Orange Ship")
                .brownResourcesCost(1)
                .orangeResourcesCost(1)
                .totalResourcesCost(5)
                .attackPower(2)
                .defencePower(5)
                .build());
        player.getDeck().add(new SpaceshipBuilder()
                .cardName("Brown-Yellow Ship")
                .brownResourcesCost(1)
                .yellowResourcesCost(1)
                .totalResourcesCost(5)
                .attackPower(3)
                .defencePower(4)
                .build());
        player.getDeck().add(new SpaceshipBuilder()
                .cardName("Brown-Green Ship")
                .brownResourcesCost(1)
                .greenResourcesCost(1)
                .totalResourcesCost(5)
                .attackPower(1)
                .defencePower(6)
                .build());
        player.getDeck().add(new SpaceshipBuilder()
                .cardName("Orange-Yellow Ship")
                .orangeResourcesCost(1)
                .yellowResourcesCost(1)
                .totalResourcesCost(5)
                .attackPower(6)
                .defencePower(1)
                .build());
        player.getDeck().add(new SpaceshipBuilder()
                .cardName("Enterprise")
                .cardDescription("Awesome spaceship.")
                .orangeResourcesCost(1)
                .greenResourcesCost(1)
                .totalResourcesCost(5)
                .attackPower(4)
                .defencePower(3)
                .build());
        player.getDeck().add(new SpaceshipBuilder()
                .cardName("Yellow-Green Ship")
                .yellowResourcesCost(1)
                .greenResourcesCost(1)
                .totalResourcesCost(5)
                .attackPower(5)
                .defencePower(2)
                .build());

        player.getDeck().add(new TechnologyBuilder()
                .cardName("Biological weapon")
                .cardDescription("Your opponent loses 2 life points.")
                .orangeResourcesCost(1)
                .totalResourcesCost(1)
                .attackBehaviour(new AttackOtherPlayer())
                .build());
        player.getDeck().add(new TechnologyBuilder()
                .cardName("Spaceship's shield")
                .cardDescription("The defence power of your spaceship is increased by 2 points.")
                .greenResourcesCost(1)
                .totalResourcesCost(1)
                .defenceBehaviour(new DefenceIncreaceShipDefence())
                .build());

        // TODO - dodać kolejne karty
    }

}
