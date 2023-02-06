package nl.tudelft.jpacman.level;

import nl.tudelft.jpacman.points.PointCalculator;
import nl.tudelft.jpacman.points.PointCalculatorLoader;
import nl.tudelft.jpacman.sprite.PacManSprites;

import org.junit.jupiter.api.Test;

public class PlayerCollisionWithPelletTest {
    PointCalculatorLoader loadPoint = new PointCalculatorLoader();
    PointCalculator myPoint = loadPoint.load();
    PlayerCollisions collisionObj = new PlayerCollisions(myPoint);
    PacManSprites pacObj = new PacManSprites();
    PlayerFactory pacFac = new PlayerFactory(pacObj);
    Player testPlayer = pacFac.createPacMan();
    Pellet pelletObj = new Pellet(10, pacObj.getPelletSprite());

    @Test
    void playerCollidesWithPellet() {
        collisionObj.playerVersusPellet(testPlayer, pelletObj);
    }
}
