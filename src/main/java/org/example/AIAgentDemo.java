/**
 * Демонстрация простого AI-агента (рефлексивного агента-уборщика).
 *
 * Цель: показать, что агент — это не чат, а сущность, которая:
 *   1. Воспринимает окружение (perceives)
 *   2. Принимает решение (decides)
 *   3. Действует (acts)
 *   4. Работает в цикле
 *
 * Версия: автоматическая (без ввода пользователя)
 */

// Состояния комнаты
enum RoomState {
    CLEAN, DIRTY
}

// Действия агента
enum Action {
    CLEAN, NOOP
}

// Простой рефлексивный агент
class SimpleReflexAgent {
    public Action decide(RoomState percept) {
        if (percept == RoomState.DIRTY) {
            return Action.CLEAN;
        } else {
            return Action.NOOP;
        }
    }
}

// Окружение (модель мира)
class Environment {
    private RoomState state;

    public Environment(RoomState initialState) {
        this.state = initialState;
    }

    // Агент "видит" состояние комнаты
    public RoomState getPercept() {
        return state;
    }

    // Агент выполняет действие → мир меняется
    public void applyAction(Action action) {
        if (action == Action.CLEAN) {
            state = RoomState.CLEAN;
        }
        // NOOP ничего не меняет
    }

    // Моделируем "загрязнение" со временем (для динамики)
    public void simulateRandomDirt() {
        if (Math.random() < 0.4) { // 40% шанс стать грязной
            state = RoomState.DIRTY;
        }
    }

    // Визуализация состояния комнаты
    public void draw() {
        String icon = (state == RoomState.DIRTY) ? "🧹❓" : "✨✅";
        System.out.println("   🏠 Комната: [" + icon + "]");
    }
}

// Главный класс — демонстрация
public class AIAgentDemo {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("=========================================");
        System.out.println("🤖 ДЕМОНСТРАЦИЯ: Простой AI-агент-уборщик");
        System.out.println("=========================================");
        System.out.println("Агент работает в цикле: восприятие → решение → действие\n");

        // Инициализация
        Environment env = new Environment(RoomState.DIRTY);
        SimpleReflexAgent agent = new SimpleReflexAgent();

        // Запуск цикла агента (10 шагов)
        for (int step = 1; step <= 10; step++) {
            System.out.println("--- 🕒 Шаг " + step + " ---");

            // 1. Восприятие (Perception)
            RoomState percept = env.getPercept();
            System.out.println("👀 Восприятие: " + percept);
            env.draw();

            // 2. Решение (Decision)
            Action action = agent.decide(percept);
            System.out.println("🧠 Решение: " + action);

            // 3. Действие (Action)
            env.applyAction(action);
            if (action == Action.CLEAN) {
                System.out.println("✅ Агент убрал комнату!");
            } else {
                System.out.println("😴 Агент отдыхает.");
            }

            // 4. Окружение меняется (например, снова пачкается)
            env.simulateRandomDirt();

            System.out.println(); // пустая строка для читаемости
            Thread.sleep(2000); // пауза 2 секунды для наглядности
        }

        System.out.println("🏁 Демонстрация завершена. Агент выполнил свою работу!");
    }
}