package nl.tudelft.jpacman.level;

import nl.tudelft.jpacman.npc.Ghost;
import nl.tudelft.jpacman.points.PointCalculator;
import nl.tudelft.jpacman.points.PointCalculatorLoader;
import static org.assertj.core.api.Assertions.assertThat;
import nl.tudelft.jpacman.sprite.PacManSprites;
import nl.tudelft.jpacman.npc.ghost.GhostFactory;

import org.junit.jupiter.api.Test;

public class PlayerCollidesWithGhostBinkyTest {
    PointCalculatorLoader loadPoint = new PointCalculatorLoader();
    PointCalculator myPoint = loadPoint.load();
    PlayerCollisions collisionObj = new PlayerCollisions(myPoint);
    PacManSprites pacObj = new PacManSprites();
    PlayerFactory pacFac = new PlayerFactory(pacObj);
    Player testPlayer = pacFac.createPacMan();
    GhostFactory ghostObj = new GhostFactory(pacObj);
    Ghost testGhostBlink = ghostObj.createBlinky();

    @Test
    void playerCollidesWithGhost() {
        collisionObj.playerVersusGhost(testPlayer, testGhostBlink);
        assertThat(testPlayer.getKiller()).isEqualTo(testGhostBlink);
        assertThat(testPlayer.isAlive()).isFalse();
    }
}
