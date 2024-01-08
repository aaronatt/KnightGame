public class MOB implements Attributes {

    protected int armor;
    protected int damage;
    protected DiceType damageDie;
    protected int hitModifier;
    protected int maxHP;
    private final String name;

    public MOB(String name, int hp, int armor, int hitModifier, DiceType damageDie) {
        this.name = name;
        this.maxHP = hp;
        this.armor = armor;
        this.hitModifier = hitModifier;
        this.damageDie = damageDie;
    }

    public MOB copy() {
        return new MOB(this.name, getHP(), this.armor, this.hitModifier, this.damageDie);
    }

    @Override
    public int getArmor() {
        // TO.DO Auto-generated method stub
        return armor;
    }

    @Override
    public int getMaxHP() {
        // TO.DO Auto-generated method stub
        return maxHP;
    }

    @Override
    public DiceType getDamageDie() {
        // TO.DO Auto-generated method stub
        return damageDie;
    }

    @Override
    public int getHitModifier() {
        // TO.DO Auto-generated method stub
        return hitModifier;
    }

    public int getHP() {
        return this.maxHP - this.damage;
    }

    public String getName() {
        return name;
    }

    public int getDamage() {
        return this.damage;
    }

    public void resetDamage() {
        damage = 0;
    }

    public void addDamage(int damage) {
        this.damage = this.damage + damage;
    }

    public String toString() {
        return               "+============================+\n" +
        String.format("| %-27s|%n", getName()) +
                             "|                            |\n" +
        String.format("|  Health: %-10d        |%n", getHP())  +
        String.format("|  Power: %-6s  Armor: %-4d|%n", getDamageDie().toString(), getArmor()) +
                             "|                            |\n" +
                             "+============================+";
    }
    
    public static void main(String[] args) {
        MOB MOB = new MOB("Aaron", 100, 20, 0, DiceType.valueOf("D12"));
        System.out.print(MOB.toString());
    }
}
