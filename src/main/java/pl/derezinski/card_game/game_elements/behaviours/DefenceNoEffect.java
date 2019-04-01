package pl.derezinski.card_game.game_elements.behaviours;

public class DefenceNoEffect implements DefenceBehaviour{

    @Override
    public void defence() {
        System.out.println("This card has no defence functionality.");
    }
}
