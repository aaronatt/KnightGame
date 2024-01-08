public class Main extends Object {

    private static String gamedata = "/Users/aaronattar/Documents/JavaFiles/PracticalOptionKnightFight-main/gamedata.csv";
    private static String saveData = "knights.csv";

     public static void main(String[] args) {
        //TO.DO

        parseArgs(args); // method that parses the args, optional but cleaned up the code
        GameData data = new CSVGameData(gamedata, saveData);
        GameView view  = new ConsoleView();
        CombatEngine engine = new CombatEngine(data, view);
        GameController controller = new GameController(data, view, engine);
        controller.start();
    }

    private static void parseArgs(String[] args) {
        boolean fileCheck = false;
        String inputFile = "";
        for (String s : args) {
            if (s.startsWith("--data")) { //Needed extra steps if subsequent arg after --data arg
                int fileStart = s.indexOf("=");
                inputFile = s.substring(fileStart+1);
                fileCheck = true;
            }
        }
        if (fileCheck) {
            gamedata = inputFile;
        }
        else {
            gamedata = "gamedata.csv";
        }
    }

}
