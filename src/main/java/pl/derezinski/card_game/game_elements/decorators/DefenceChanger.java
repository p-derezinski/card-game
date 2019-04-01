package pl.derezinski.card_game.game_elements.decorators;

import pl.derezinski.card_game.game_elements.Spaceship;
import pl.derezinski.card_game.game_elements.behaviours.DefenceBehaviour;

/**
 * TODO
 * w czasie trwania gry, gdy gracz będzie "dekorował" kartę statek kartą technologia osłona,
 * defenceBehaviour karty technologia zostanie zmienione z DefenceIncreaseShipDefence na DefenceChanger
 */

public class DefenceChanger extends SpaceshipDecorator {

    public DefenceChanger(Spaceship spaceship) {
        this.spaceship = spaceship;
    }

}
