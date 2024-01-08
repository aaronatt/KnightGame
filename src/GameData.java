import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public abstract class GameData extends Object{
    
    protected final List<Knight> activeKnights = new ArrayList<Knight>();
    protected final List<Fortune> fortunes = new ArrayList<Fortune>();
    protected final List<Knight> knights = new ArrayList<Knight>();
    protected final List<MOB> monsters = new ArrayList<MOB>();
    private static final int MAX_ACTIVE = 4;
    private static final Random random = new Random();
    
    public GameData() {
    }

    public List<Knight> getKnights() {
        //TO.DO
        return knights;
    }

    public List<Knight> getActiveKnights() {
        //TO.DO
        return this.activeKnights;
    }

    public Knight getActive(String nameOrId) {
        //TO.DO
        return findKnight(nameOrId, activeKnights);
    }

    public Knight getKnight(String nameOrId) {
        //TO.DO
        return findKnight(nameOrId, knights);
    }

    protected Knight findKnight(String nameOrId, List<Knight> list) {
        //TO.DO
        if (nameOrId.matches("[0-9]+")) {
            for (Knight k : list) {
                if (nameOrId.equals(k.getId().toString())) {
                    return k;
                }
            }
        }
        else {
            for (Knight k : list) {
                if (k.getName().toLowerCase().contains(nameOrId.toLowerCase())) {
                    return k;
                }
            }
        }
        return null;
    }

    public boolean setActive(Knight kt) {
        //TO.DO
        if (activeKnights.size() < MAX_ACTIVE) {
            activeKnights.add(kt);
            return true;
        }
        else {
            return false;
        } 
    }

    public void removeActive(Knight kt) {
        //TO.DO
        if (activeKnights.remove(kt)) {
            kt.resetDamage();
        }
    }

    public Fortune getRandomFortune() {
        //TO.DO
        return fortunes.get(random.nextInt(fortunes.size()));
    }

    public List<MOB> getRandomMonsters() {
        //TO.DO
        return getRandomMonsters(activeKnights.size());
    }

    public List<MOB> getRandomMonsters(int number) {
        //TO.DO - Go over later to make sure
        List<MOB> mob = new ArrayList<MOB>(number);
        for (int i = 0; i < number; ++i) {
        mob.add(monsters.get(random.nextInt(monsters.size())).copy());
        }
        return mob;
    }

    public abstract void save(String filename);

}
