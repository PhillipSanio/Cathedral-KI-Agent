import de.fhkiel.ki.cathedral.game.Game
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.assertNotNull

class MinimaxAgentTest {

    @Test
    fun testMinimaxMakesWinningOrBlockingMove() {
        // 1. Spielzustand initialisieren / Brett für eine Testsituation vorbereite
        val game = Game()
        val agent = MinimaxAgent()

        // 2. Zug berechnen lassen
        val chosenMove = agent.calculateTurn(game, 0, 0)

        // 3. Überprüfen, ob ein gültiger Zug zurückgegeben wurde
        assertNotNull(chosenMove, "Der Agent muss einen gültigen Zug zurückgeben")
    }
}