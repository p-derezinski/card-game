package pl.derezinski.card_game.game_elements.behaviours;

import pl.derezinski.card_game.game_elements.Player;

public class OtherDrawCards implements OtherBehaviour {

    private int numberOfCardsToDraw;

    public OtherDrawCards(int numberOfCardsToDraw) {
        this.numberOfCardsToDraw = numberOfCardsToDraw;
    }

    @Override
    public void action(Player player) {
        System.out.println("You are drawing " + numberOfCardsToDraw + " cards.");
        for (int i = 0; i < numberOfCardsToDraw; i++) {
            player.getHand().add(player.getDeck().remove(0));
        }
    }

    public int getNumberOfCardsToDraw() {
        return numberOfCardsToDraw;
    }

    public void setNumberOfCardsToDraw(int numberOfCardsToDraw) {
        this.numberOfCardsToDraw = numberOfCardsToDraw;
    }
}
