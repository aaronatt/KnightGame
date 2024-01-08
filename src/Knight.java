public class Knight extends MOB {

    private Fortune activeFortune;
    protected final int id;
    protected int xp;

    public Knight(int id, String name, int hp, int armor, int hitModifier, DiceType damageDie, int xp) {
        super(name, hp, armor, hitModifier, damageDie);
        this.id = id;
        this.xp = xp;
    }

    public int getArmor() {
        if (getActiveFortune() != null) {
        return super.getArmor() + activeFortune.getArmor();
        }
        else {
            return super.getArmor();
        }
    }

    public int getMaxHP() {
        if (getActiveFortune() != null) {
            return super.getMaxHP() + activeFortune.getMaxHP();
        }
        else {
            return super.getMaxHP();
        }
    }

    public DiceType getDamageDie() {
        if (getActiveFortune() != null) {
            return activeFortune.getDamageDie();
        }
        else {
            return super.getDamageDie();
        }
    }

    public int getHitModifier() {
        if (getActiveFortune() != null) {
            return super.getHitModifier() + activeFortune.getHitModifier();
        }
        else {
            return super.getHitModifier();
        }
    }

    public int getXP() {
        return xp;
    }

    public Fortune getActiveFortune() {
        return activeFortune;
    }

    public void setActiveFortune(Fortune ActiveFortune) {
        this.activeFortune = ActiveFortune;
    }

    public void addXP(int xp) {
        this.xp = this.xp + xp;
    }

    public Integer getId() {
        return id;
    }

    public String toString() {
        //TO.DO
        return               "+============================+\n" +
        String.format("| %-27s|%n", getName()) +
        String.format("| id: %-23d|%n", getId()) + 
                            "|                            |\n" +
        String.format("|  Health: %-6d XP: %d      |%n", getHP(), getXP())  + 
        String.format("|  Power: %-6s  Armor: %-4d|%n", getDamageDie().toString(), getArmor()) +
                             "|                            |\n" +
                             "+============================+\n\n";
    }

    public String toCSV() {
        return getName() + "," + getMaxHP() + "," + getArmor() + "," + getHitModifier() + "," + getDamageDie() + "," + getXP();
    }

    public static void main(String[] args) {
        Knight myTest =  new Knight(1, "Merlin", 50, 2, 1, DiceType.D12, 0);
        System.out.println("TESTING: " + myTest);
        // add other tests here to test each method individually
        System.out.print(myTest.toString());
    }
    
}
