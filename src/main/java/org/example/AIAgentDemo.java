package org.example;

/**
 * Демонстрация простого AI-агента (рефлексивного агента-уборщика).
 */
public class AIAgentDemo {

    // Состояния комнаты
    public enum RoomState {
        CLEAN, DIRTY
    }

    // Действия агента
    public enum Action {
        CLEAN, NOOP
    }

    // Простой рефлексивный агент
    public static class SimpleReflexAgent {
        public Action decide(RoomState percept) {
            if (percept == RoomState.DIRTY) {
                return Action.CLEAN;
            } else {
                return Action.NOOP;
            }
        }

    // Окружение (модель мира)
    public static class Environment {
        private RoomState state;

        public Environment(RoomState initialState) {
            this.state = initialState;
        }

        public RoomState getPercept() {
            return state;
        }

        public void applyAction(Action action) {
            if (action == Action.CLEAN) {
                state = RoomState.CLEAN;
            }
        }

        public void simulateRandomDirt() {
            if (Math.random() < 0.4) {
                state = RoomState.DIRTY;
            }
        }

        public void draw() {
            String icon = (state == RoomState.DIRTY) ? "🧹❓" : "✨✅";
            System.out.println("   🏠 Комната: [" + icon + "]");
        }
    }

    // Главный метод — демонстрация
    public static void main(String[] args) throws InterruptedException {
        System.out.println("=========================================");
        System.out.println("🤖 ДЕМОНСТРАЦИЯ: Простой AI-агент-уборщик");
        System.out.println("=========================================");

        Environment env = new Environment(RoomState.DIRTY);
        SimpleReflexAgent agent = new SimpleReflexAgent();

        for (int step = 1; step <= 5; step++) {
            System.out.println("--- 🕒 Шаг " + step + " ---");
            RoomState percept = env.getPercept();
            System.out.println("👀 Восприятие: " + percept);
            env.draw();

            Action action = agent.decide(percept);
            System.out.println("🧠 Решение: " + action);

            env.applyAction(action);
            if (action == Action.CLEAN) {
                System.out.println("✅ Агент убрал комнату!");
            } else {
                System.out.println("😴 Агент отдыхает.");
            }

            env.simulateRandomDirt();
            System.out.println();
            Thread.sleep(1500);
        }
    }
}