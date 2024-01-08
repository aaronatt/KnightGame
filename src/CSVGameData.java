import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class CSVGameData extends GameData{
    

    public CSVGameData(String gamedata, String saveData) {
        //TO.DO
        loadGameData(gamedata);
        loadSaveData(saveData);
    }

    void loadSaveData(String saveData) {
        //TO.DO
        int counter = 0;
        Scanner file = readFile(saveData);
        if(file == null) System.out.println("No saved data");
        while(file.hasNextLine()) {
            Scanner line = new Scanner(file.nextLine());
            line.useDelimiter(","); 
            Knight kt = new Knight(
                    ++counter,
                    line.next().trim(),
                    line.nextInt(),
                    line.nextInt(),
                    line.nextInt(),
                    DiceType.valueOf(line.next()),
                    line.nextInt());
                knights.add(kt);
        }
        file.close();
    }

    private Scanner readFile(String fileName) {
        //TO.DO
        try {
            File file = new File(fileName);
            Scanner knightFile = new Scanner(file);
            return knightFile;
        } catch (FileNotFoundException e) {
            return null;
        }
    }

    void loadGameData(String gamedata) {
        //TO.DO
        parseGameDataLine(gamedata);
    }

    private void parseGameDataLine(String line) {
        //TO.DO
        Scanner file = readFile(line);
        if(file == null) System.out.println("No saved data");

        while(file.hasNextLine()) {
            Scanner infoline = new Scanner(file.nextLine());
            infoline.useDelimiter(","); 
            String category = infoline.next();
                
            if (category.toLowerCase().contains("mob")) {
                    MOB mob = new MOB(
                            infoline.next(),
                            infoline.nextInt(),
                            infoline.nextInt(),
                            infoline.nextInt(),
                            DiceType.valueOf(infoline.next()));
                        monsters.add(mob);
                    }
            else if (category.toLowerCase().contains("fortune")) {
                String name = infoline.next();
                int hpBonus = Integer.parseInt(infoline.next());
                int armor = Integer.parseInt(infoline.next());
                int hitModifier = Integer.parseInt(infoline.next());
                String dice = infoline.next();

                    if (dice.contains("-")) {
                        Fortune fortune = new Fortune(
                            name,
                            hpBonus,
                            armor,
                            hitModifier);
                        fortunes.add(fortune);
                    }
                    else {
                        Fortune fortune = new Fortune(
                            name,
                            hpBonus,
                            armor,
                            hitModifier,
                            DiceType.valueOf(dice));
                        fortunes.add(fortune);
                    }
            }
        }
    }

    public void save(String filename) {
        //TO.DO
        try {
            PrintWriter knightOut = new PrintWriter(filename);
            for (Knight k : knights) {
                knightOut.println(k.toString());
            }
            knightOut.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }


}
