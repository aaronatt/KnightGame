import java.util.List;
import java.util.Random;

public class CombatEngine extends Object{
    private final GameData data;
    private final GameView view;
    private final DiceSet dice = new DiceSet();
    private final Random rnd = new Random();


    CombatEngine(GameData data, GameView view) {
        //TO.DO
        this.data = data;
        this.view = view;
    }

    public void initialize() { 
        //TO.DO
        for (Knight k : data.getActiveKnights()) {
            k.setActiveFortune(data.getRandomFortune());
        }
        System.out.println();
        System.out.println("For this quest, our knights drew the following fortunes!");
        view.printFortunes(data.getActiveKnights());
        System.out.println("\n\n");
    }

    public void runCombat() {
        //TODO

        System.out.println("Not implemented"); //Use if in time crunch
    }

    private int doBattle(List<MOB> attackers, List<MOB> defenders) {
        //TODO
        return -1;
    }

    public void clear() {
        //TO.DO
       for (Knight k : data.getKnights()) {
            k.setActiveFortune(null);
        }
    }


}
