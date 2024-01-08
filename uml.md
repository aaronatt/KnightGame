classDiagram
Attributes <|-- Fortune
Attributes <|-- MOB
MOB <|-- Knight

class Attributes {
    <<Interface>>
    getArmor() int
    getMaxHP() int
    getDamageDie() DiceType
    getHitModifier() int
}
class DiceType{
    <<Enumeration>>
    +DiceType : D4
    +DiceType : D6
    +DiceType : D8
    +DiceType : D10
    +DiceType : D12
    +DiceType : D20
}
class DiceSet{
    -Random : dice
    +DiceSet()
    +roll(DiceType): int
}
class Fortune {
    -int : armor
    -DiceType : dtype
    -int : hitModifier
    -int : hpBonus
    -String: name
    +Fortune(String, int, int, int)
    +Fortune(String, int, int, int, DiceType)
    +getArmor() int
    +getDamageDie() DiceType
    +getHitModifier() int
    +getMaxHP() int
    +getName() String
    +toString() String
}
class Knight {
    -Fortune : activeFortune
    #int : id
    #int : xp
    +Knight(int, String, int, int, int, DiceType, int)
    +addXP(int) void
    +getActiveFortune() Fortune
    +getArmor() int
    +getDamageDie() DiceType
    +getHitModifier() int
    +getId() Integer
    +getMaxHP() int
    +getXP() int
    +setActiveFortune(Fortune) void
    +toCSV() String
    +toString() String
}
class MOB {
    #int : armor
    #int : damage
    #DiceType : damageDie
    #int : hitModifier
    #int : maxHP
    -String : name
    +MOB(String, int, int, int, DiceType)
    +addDamage(int) void
    +copy() MOB
    +getArmor() int
    +getDamage() int
    +getDamageDie() DiceType
    +getHitModifier() int
    +getHP() int
    +getMaxHP() int
    +getName() String
    +resetDamage() void
    +toString() String
}
```
```mermaid
classDiagram
GameData <|-- CSVGameData
GameView <|-- ConsoleView

class GameData {
    <<Abstract>>
    #List<Knight> : activeKnights
    #List<Fortune> : fortunes
    #List<Knight> : knights
    -int : MAX_ACTIVE
    #List<MOB> : monsters
    -Random : random
    +GameData()
    #findKnight(String, List<Knight>) Knight
    +getActive(String) Knight
    +getActiveKnights() List<Knight>
    +getKnight(String) Knight
    +getKnights() List<Knight>
    +getRandomFortune() Fortune
    +getRandomMonsters() List<MOB>
    +getRandomMonsters(int) List<MOB>
    +removeActive(Knight) void
    +setActive(Knight) boolean
    +(abstract) save(String) void
}
class GameView {
    <<Interface>>
    checkContinue() boolean
    displayMainMenu() String
    endGame() void
    knightNotFound() void
    listKnights(List<Knight>) void
    printBattleText(List<MOB>, List<Knight>) void
    printBattleText(MOB) void
    printDefeated() void
    printFortunes(List<Knight>) void
    printHelp() void
    setActieFailed() void
    showKnight(Knight) void
    splashScreen() void
}
class ConsoleView {
    -Scanner : in
    +ConsoleView()
    +checkContinue() boolean
    +displayMainMenu() String
    +endGame() void
    +knightNotFound() void
    +listKnights(List<Knight>) void
    +printBattleText(List<MOB>, List<Knight>) void
    +printBattleText(MOB) void
    +printDefeated() void
    +printFortunes(List<Knight>) void
    +printHelp() void
    +setActiveFailed() void
    +showKnight(Knight) void
    +splashScreen() void
}
class CSVGameData {
    +CSVGameData(String, String)
    +loadGameData(String) void
    +loadSaveData(String) void
    -parseGameDataLine(Scanner) void
    -readFile(String) Scanner
    +save(String) void
}
```
```mermaid
classDiagram
class CombatEngine {
    -GameData : data
    -DiceSet : dice
    -Random : rnd
    -GameView : view
    +CombatEngine(GameData, GameView)
    +clear() void
    -doBattle(List<MOB>, List<MOB>) int
    +initialize() void
    +runCombat() void 
}
class GameController {
    -GameData : data
    -CombatEngine : engine
    -GameView : view
    +GameController(GameData, GameView, CombatEngine)
    #processCommand(String) boolean
    -processRemoveActive(String) void
    -processSetActive(String) void
    -processShowKnight(String) void
    +start() void
}
class Main {
    -String : gamedata
    -String : saveData
    +main(String) void
    -processArgs(String) void
}