# AI Agent Demo (Java + JUnit 5 + GitHub Actions + JaCoCo)

Демонстрация работы AI-агента с полным циклом тестирования и CI/CD.

## Структура
- Код: `src/main/java/org/example/AIAgentDemo.java`
- Тесты: `src/test/java/org/example/AIAgentTest.java`
- Отчёт о покрытии: публикуется в `/docs`

## Отчёт о покрытии
📊 **Live-отчёт**: [https://ваш-логин.github.io/ai-agent-demo/](https://ваш-логин.github.io/ai-agent-demo/)

> После каждого `git push` в `main` отчёт автоматически обновляется.


SimpleReflexAgent
20 строка

public Action decide(RoomState percept) {
if (percept == RoomState.DIRTY) {
return Action.CLEAN;
} else {
return Action.NOOP;
}
}

public Action decide(RoomState percept) {
// 🐞 БАГ: агент всегда ничего не делает!
return Action.NOOP;
}

git add .
git commit -m "Introduce bug: agent ignores dirty room"
git push

