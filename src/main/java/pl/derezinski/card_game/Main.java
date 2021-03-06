package pl.derezinski.card_game;

import pl.derezinski.card_game.commands.*;
import pl.derezinski.card_game.game_elements.*;
import pl.derezinski.card_game.game_elements.behaviours.AttackOtherPlayer;
import pl.derezinski.card_game.game_elements.behaviours.DefenceIncreaseShipDefence;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        Player player_1 = new Player();
        Player player_2 = new Player();
        player_1.setOpponent(player_2);
        player_2.setOpponent(player_1);
        Scanner scanner = new Scanner(System.in);
        Map<String, Command> commands_1 = new HashMap<>();
        Map<String, Command> commands_2 = new HashMap<>();
        addCommandsToTheHashMap(commands_1, player_1);
        addCommandsToTheHashMap(commands_2, player_2);

        addCardsToThePlayersDeck(player_1);
        addCardsToThePlayersDeck(player_2);
        //checkingBehaviourOfSomeCards(player_1);
        Collections.shuffle(player_1.getDeck());
        Collections.shuffle(player_2.getDeck());

        // pobranie sześciu kart do ręki gracza (siódma będzie dodana na początku pierwszej tury)
        for (int i = 0; i < 6; i++) {
            player_1.getHand().add(player_1.getDeck().remove(0));
            player_2.getHand().add(player_2.getDeck().remove(0));
        }

        System.out.println("=========================\n====  THE CARD GAME  ====\n=========================");
        Command initialCommand = new PrintAvailableCommandsCommand(commands_1);
        initialCommand.execute();
        while (true) {
            player_1.setCounters(new Counters());
            player_1.setResourcesCounters(new ResourcesCounters(player_1));
            player_1.getHand().add(player_1.getDeck().remove(0));
            System.out.println("-----------------------\n\t\t\t\t-->  Player 1, it is your turn  <--");
            while (!player_1.getCounters().isEndOfTurn()) {
                System.out.print("-----------------------\nChoose a command: ");
                String commandName = scanner.nextLine();
                Command command = commands_1.get(commandName);
                Optional.ofNullable(command).ifPresent(Command::execute);
                isGameOver(player_1, player_2);
            }
            player_2.setCounters(new Counters());
            player_2.setResourcesCounters(new ResourcesCounters(player_2));
            player_2.getHand().add(player_2.getDeck().remove(0));
            System.out.println("-----------------------\n\t\t\t\t-->  Player 2, it is your turn  <--");
            while (!player_2.getCounters().isEndOfTurn()) {
                System.out.print("-----------------------\nChoose a command: ");
                String commandName = scanner.nextLine();
                Command command = commands_2.get(commandName);
                Optional.ofNullable(command).ifPresent(Command::execute);
                isGameOver(player_1, player_2);
            }
        }

//        System.out.println("-----------------------\nCards before shuffle");
//        Command command = commands_1.get("deck");
//        command.execute();
//
//        // potasowanie talii
//        Collections.shuffle(player_1.getDeck());
//        System.out.println("-----------------------\nCards after shuffle");
//        command.execute();
    }

    private static void isGameOver(Player player_1, Player player_2) {
        if (player_1.getLifeCount() <= 0) {
            System.out.println("-----------------------\n\t\t\t\t-->  GAME OVER - Player 2 is the winner!  <--");
            System.exit(0);
        } else if (player_2.getLifeCount() <= 0) {
            System.out.println("-----------------------\n\t\t\t\t-->  GAME OVER - Player 1 is the winner!  <--");
            System.exit(0);
        }
    }

    private static void addCommandsToTheHashMap(Map<String, Command> commands, Player player) {
        //commands.put("exit", () -> System.exit(0));
        commands.put("hand", new DisplayCardsInHandCommand(player));
        commands.put("deck", new DisplayCardsInDeckCommand(player));
        commands.put("table", new DisplayCardsInTableCommand(player));
        commands.put("play card", new CardFromHandToTableCommand(player));
        commands.put("print", new PrintAvailableCommandsCommand(commands));
        commands.put("end", new EndTheTurnCommand(player));
        commands.put("stats", new StatisticsCommand(player));
        commands.put("end game", new EndTheGameCommand(player));
    }

    private static void checkingBehaviourOfSomeCards(Player player) {
        // sprawdzenie zachowania różnych kart
        System.out.println("-----------------------\nTechnology cards");
        Technology technology_1 = (Technology) player.getDeck().get(26);
        System.out.println(technology_1);
        technology_1.performAttack();
        technology_1.performDefence();
        technology_1.performAction();
        Technology technology_2 = (Technology) player.getDeck().get(27);
        System.out.println(technology_2);
        technology_2.performAttack();
        technology_2.performDefence();
        technology_2.performAction();
        Spaceship spaceship_1 = (Spaceship) player.getDeck().get(25);
        System.out.println(spaceship_1);
        spaceship_1.performAttack();
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
                .attackBehaviour(new AttackOtherPlayer(2))
                .build());
        player.getDeck().add(new TechnologyBuilder()
                .cardName("Spaceship's shield")
                .cardDescription("The defence power of your spaceship is increased by 2 points.")
                .greenResourcesCost(1)
                .totalResourcesCost(1)
                .defenceBehaviour(new DefenceIncreaseShipDefence())
                .build());

        // TODO - dodać kolejne karty
    }

}
