import java.util.List;
import java.util.Scanner;

public class ConsoleView extends Object implements GameView{
    private final Scanner in = new Scanner(System.in);

    ConsoleView() {
    }

    @Override
    public void splashScreen() {
        // TO.DO
        System.out.println("Round Table Games: Knights of Legend");
        System.out.println("loading...");

    }

    public void endGame() {
        //TO.DO
        System.out.println("Thanks for playing!");
    }

    public String displayMainMenu() {
        //TO.DO
        System.out.print("What would you like to do? ");
        String command = in.nextLine();
        return command;
    }

    public void printHelp() {
        //TO.DO
        System.out.println("Unsure what to do, here are some options:");
        System.out.println("           ls or list all  - listing the knights");
        System.out.println("           list active  - list the active knights knights only");
        System.out.println("           show name or id - show the knight details card");
        System.out.println("           set active name or id - set knight as active (note: only 4 knights can be active)");
        System.out.println("           remove active name or id - remove a knight from active status (heals knight)");
        System.out.println("           explore or adventure or quest - find random monsters to fight");
        System.out.println("           save filename - save the game to the file name (default: saveData.csv)");
        System.out.println("           exit or goodbye - to leave the game");
        System.out.println();
        System.out.println("Game rules: You can have four active knights. As long as they are active, they won't heal,");
        System.out.println("but they can gain XP by going on adventures.");
        System.out.println("When you make a knight inactive, they will heal. How many monsters can you defeat");
        System.out.println("before, you have to heal?");
    }

    public void listKnights(List<Knight> knights) {
        if (knights.isEmpty()) {
            System.out.println("No knights to list");
        }
        else {
        for (Knight k: knights) { //TO.DO
            System.out.println(k.getId() + ": " + k.getName());
            }
        }
        System.out.println();
    }

    public void knightNotFound() {
        //TO.DO
        System.out.println("Knight not found!");
    }

    public void showKnight(Knight knight) {
        //TO.DO
        System.out.println(knight.toString() + "\n");
    }

    public void setActiveFailed() {
        //TO.DO
        System.out.println("Unable to set active knight. Only four can be active at a time.");
    }

    public void printBattleText(List<MOB> monsters, List<Knight> activeKnights) {
        //TODO - Finished but test later
        System.out.println("Our heroes come across the following monsters. Prepare for battle!");
        System.out.println("Knights                     Foes");
        for (Knight k : activeKnights) {
            System.out.print(k.getName());
            if (monsters.size()-1 >= activeKnights.indexOf(k)) {
                System.out.print(String.format("%-27s %n", monsters.get(activeKnights.indexOf(k)).getName()));
            }
            System.out.println();
        }
    }

    public void printBattleText(MOB dead) {
        //TO.DO
        System.out.println(dead.getName() + " was defeated!");

    }

    public void printFortunes(List<Knight> activeKnights) {
        //TO.DO
        for (Knight k : activeKnights) {
            System.out.println(k.getName());
            System.out.println(k.getActiveFortune().toString());
        }
    }

    public boolean checkContinue() {
        //TO.DO
        System.out.println("Would you like to continue on your quest (y/n)?");
        String check = in.nextLine();
        if (check.startsWith("y")) {
            return true;
        }
        else {
            return false;
        }
    }

    public void printDefeated() {
        //TO.DO
        System.out.println("All active knights have been defeated!");
    }

}
