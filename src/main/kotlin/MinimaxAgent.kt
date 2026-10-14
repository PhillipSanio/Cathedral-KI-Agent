import de.fhkiel.ki.cathedral.ai.Agent
import de.fhkiel.ki.cathedral.game.Board
import de.fhkiel.ki.cathedral.game.Building
import de.fhkiel.ki.cathedral.game.Color
import de.fhkiel.ki.cathedral.game.Direction
import de.fhkiel.ki.cathedral.game.Game
import de.fhkiel.ki.cathedral.game.Placement
import de.fhkiel.ki.cathedral.game.Position
import de.fhkiel.ki.cathedral.game.Turn
import de.fhkiel.ki.cathedral.game.Turnable
import java.util.Optional



class MinimaxAgent : Agent {
    override fun name(): String {
        return "KI Agent"
    }

    //Sammelt alle noch platzierbaren Spielsteine aus Game.
    override fun calculateTurn(game: Game, timeForTurn: Int, timeBonus: Int): Optional<Placement> {
        val placableBuildings = game.getPlacableBuildings()

        //Geht jeden Stein einzeln drauf, prüft nach legalen Spielzügen und sammelt diese in einer Liste
        val allPossiblePlacements = mutableListOf<Placement>()
        for (building in placableBuildings) {
            allPossiblePlacements.addAll(building.getPossiblePlacements(game))
        }

        //Abbruch des Zuges, sollte kein legaler Move vorhanden sein
        if (allPossiblePlacements.isEmpty()) {
            return Optional.empty()
        }

        //In diesem Block geht die KI jeden legalen Spielzug durch, bewertet diese und wählt am Ende den besten.
        var bestPlacement: Placement? = null
        var bestScore = Int.MIN_VALUE

        //Test von jedem legalen Zug
        for (placement in allPossiblePlacements) {
            //Spiel wird zum Testen dupliziert, damit das echte Spiel nicht verändert wird
            val clonedGame = game.copy()

            //Zug wird im Duplikat durchgeführt
            clonedGame.takeTurn(placement)

            //Score
            //Holt den aktuellen Score aus dem Duplikat
            val gameScore = clonedGame.score()
            //Holt den Score des aktuellen Spielers aus der Map (oder 0 als Fallback)
            val score = gameScore[clonedGame.currentPlayer] ?: 0

            //Wenn der Zug den aktuellen Bestwert übertrifft, diesen als neuen Rekord speichern
            if (score > bestScore) {
                bestScore = score
                bestPlacement = placement
            }
        }

        return Optional.ofNullable(bestPlacement?: allPossiblePlacements.first())
    }
    }


