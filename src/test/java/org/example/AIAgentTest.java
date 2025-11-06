import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Юнит-тесты для AI-агента и окружения.
 * Показывают, как проверяется логика принятия решений и взаимодействия с миром.
 */
public class AIAgentTest {

    @Test
    void agentShouldCleanWhenRoomIsDirty() {
        // Given
        SimpleReflexAgent agent = new SimpleReflexAgent();
        RoomState percept = RoomState.DIRTY;

        // When
        Action action = agent.decide(percept);

        // Then
        assertEquals(Action.CLEAN, action, "Агент должен убирать, если комната грязная");
    }

    @Test
    void agentShouldDoNothingWhenRoomIsClean() {
        // Given
        SimpleReflexAgent agent = new SimpleReflexAgent();
        RoomState percept = RoomState.CLEAN;

        // When
        Action action = agent.decide(percept);

        // Then
        assertEquals(Action.NOOP, action, "Агент должен ничего не делать, если комната чистая");
    }

    @Test
    void environmentShouldBecomeCleanAfterCleanAction() {
        // Given
        Environment env = new Environment(RoomState.DIRTY);

        // When
        env.applyAction(Action.CLEAN);

        // Then
        assertEquals(RoomState.CLEAN, env.getPercept(), "После уборки комната должна стать чистой");
    }

    @Test
    void environmentShouldRemainCleanAfterNoop() {
        // Given
        Environment env = new Environment(RoomState.CLEAN);

        // When
        env.applyAction(Action.NOOP);

        // Then
        assertEquals(RoomState.CLEAN, env.getPercept(), "При NOOP чистая комната должна оставаться чистой");
    }
}