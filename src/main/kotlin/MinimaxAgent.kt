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

        //Erster Zug aus Liste wird gewählt (erstmal)
        val chosenPlacement = allPossiblePlacements.first()
        return Optional.of(chosenPlacement)
         }
    }







