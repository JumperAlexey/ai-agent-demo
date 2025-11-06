package org.example;

import org.example.AIAgentDemo.Action;
import org.example.AIAgentDemo.RoomState;
import org.example.AIAgentDemo.SimpleReflexAgent;
import org.example.AIAgentDemo.Environment;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AIAgentTest {

    @Test
    void agentShouldCleanWhenRoomIsDirty() {
        SimpleReflexAgent agent = new SimpleReflexAgent();
        RoomState percept = RoomState.DIRTY;
        Action action = agent.decide(percept);
        assertEquals(Action.CLEAN, action);
    }

    @Test
    void agentShouldDoNothingWhenRoomIsClean() {
        SimpleReflexAgent agent = new SimpleReflexAgent();
        RoomState percept = RoomState.CLEAN;
        Action action = agent.decide(percept);
        assertEquals(Action.NOOP, action);
    }

    @Test
    void environmentShouldBecomeCleanAfterCleanAction() {
        Environment env = new Environment(RoomState.DIRTY);
        env.applyAction(Action.CLEAN);
        assertEquals(RoomState.CLEAN, env.getPercept());
    }

    @Test
    void environmentShouldRemainCleanAfterNoop() {
        Environment env = new Environment(RoomState.CLEAN);
        env.applyAction(Action.NOOP);
        assertEquals(RoomState.CLEAN, env.getPercept());
    }
}