public class GameController  extends Object{
    
    private final GameData data;
    private final CombatEngine engine;
    private final GameView view;

    public GameController(GameData data, GameView view, CombatEngine engine) {
        //TO.DO
        this.data = data;
        this.view = view;
        this.engine = engine;
    }

    public void start() {
        //TO.DO
        view.splashScreen();
        boolean processCommand = true;
        while (processCommand) {
            processCommand = processCommand(view.displayMainMenu());
        }

    }

    protected boolean processCommand(String command) {
        //TO.DO
        if (command.contains("ls") || 
            command.replaceAll(" ", "").toLowerCase().contains("listall")) {
            view.listKnights(data.getKnights());
        }
        else if (command.replaceAll(" ", "").toLowerCase().contains("listactive")) {
            view.listKnights(data.getActiveKnights());
        }
        else if (command.trim().toLowerCase().startsWith("show")) {
            processShowKnight(command);
        }
        else if (command.trim().toLowerCase().startsWith("set")) {
            processSetActive(command);
        }
        else if (command.trim().toLowerCase().startsWith("remove")) {
            processRemoveActive(command);
        }
        else if (command.trim().toLowerCase().startsWith("save")) {
            if (command.replaceAll(" ", "").length() < 5) {
                data.save("saveData.csv");
            }
            else {
            data.save(command.replaceAll(" ", "").substring(4));
            }
        }
        else if (command.trim().toLowerCase().contains("explore") || 
                 command.trim().toLowerCase().contains("adventure") || 
                 command.trim().toLowerCase().contains("quest")) {
            if (data.getActiveKnights().isEmpty()) {
                view.knightNotFound();
            }
            else {
            engine.initialize();
            engine.runCombat();
            engine.clear();
            }
        }
        else if (command.trim().toLowerCase().contains("exit") || 
                 command.trim().toLowerCase().contains("bye")) {
            return false;
        }
        else {
            view.printHelp();
        }
        return true;
    }

    private void processRemoveActive(String remove) {
        //TO.DO
        remove = remove.replaceAll(" ", "").substring(6);
        Knight k = data.findKnight(remove, data.getKnights());
        data.removeActive(k);
    }

    private void processSetActive(String active) {
        //TO.DO
        active = active.replaceAll(" ", "").substring(9);
        Knight k = data.findKnight(active, data.getKnights());
        if (!data.setActive(k)) {
            view.setActiveFailed();
        }
    }

    private void processShowKnight(String nameOrId) {
        //TO.DO
        System.out.print(data.findKnight(nameOrId.substring(5), data.getKnights()).toString());
    }

}
