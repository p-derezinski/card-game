package pl.derezinski.card_game;

import pl.derezinski.card_game.game_elements.*;

import java.util.Collections;

public class Main {

    public static void main(String[] args) {

        Player player = new Player();

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
                .cardName("Apollo")
                .brownResourcesCost(1)
                .totalResourcesCost(3)
                .attackPower(2)
                .defencePower(2)
                .build());
        player.getDeck().add(new SpaceshipBuilder()
                .cardName("Enterprise")
                .cardDescription("Awesome spaceship.")
                .orangeResourcesCost(1)
                .greenResourcesCost(1)
                .totalResourcesCost(5)
                .attackPower(3)
                .defencePower(4)
                .build());

        // TODO - dodać kolejne karty

        System.out.println("-----------------------\nCards before shuffle");
        player.getDeck().forEach(System.out::println);

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

}
