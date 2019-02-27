package pl.derezinski.card_game;

import pl.derezinski.card_game.game_elements.Color;
import pl.derezinski.card_game.game_elements.Player;
import pl.derezinski.card_game.game_elements.ResourcesBuilder;

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
