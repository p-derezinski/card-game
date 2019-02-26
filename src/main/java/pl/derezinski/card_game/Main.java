package pl.derezinski.card_game;

import pl.derezinski.card_game.game_elements.Color;
import pl.derezinski.card_game.game_elements.Player;
import pl.derezinski.card_game.game_elements.ResourcesBuilder;

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

        player.getDeck().forEach(System.out::println);
    }

}
