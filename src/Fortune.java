public class Fortune implements Attributes {
    private final String name;
    private final int armor;
    private final int hpBonus;
    private final int hitModifier;
    private final DiceType dtype;

    public Fortune(String name, int hpBonus, int armor, int hitModifier) {
        this(name, hpBonus, armor, hitModifier, null);
    }

    public Fortune(String name, int hpBonus, int armor, int hitModifier, DiceType type) {
        this.name = name;
        this.hpBonus = hpBonus;
        this.armor = armor;
        this.hitModifier = hitModifier;
        dtype = type;
    }
    
    @Override
    public int getArmor() {
        return armor;
    }

    @Override
    public int getMaxHP() {
        // TO.DO Auto-generated method stub
        return hpBonus;
    }

    @Override
    public DiceType getDamageDie() {
        // TO.DO Auto-generated method stub
        return dtype;
    }

    @Override
    public int getHitModifier() {
        // TO.DO Auto-generated method stub
        return hitModifier;
    }

    public String getName() {
        return name;
    }

    public String toString() {
        //TO.DO
        String hp = "" + getMaxHP();
        String armor = "" + getArmor();
        String hit = "" + getHitModifier();
            if (getMaxHP() >= 0) {
                hp = "+" + getMaxHP();
            }
            if (getArmor() >= 0) {
                armor = "+" + getArmor();
            }
            if (getHitModifier() >= 0) {
                hit = "+" + getHitModifier();
            }
            if (getDamageDie() == null) {
                String die = "-";
                return               "+======================+\n" +
                String.format("|%-22s|%n", getName()) +
                String.format("|HP Bonus: %12s|%n", hp) +
                String.format("|AC Bonus: %12s|%n", armor) +
                String.format("|Hit Bonus: %11s|%n", hit) +
                String.format("|Damage Adj: %10s|%n", die) +
                                     "+======================+";
                }
        return               "+======================+\n" +
        String.format("|%-22s|%n", getName()) +
        String.format("|HP Bonus: %12s|%n", hp) +
        String.format("|AC Bonus: %12s|%n", armor) +
        String.format("|Hit Bonus: %11s|%n", hit) +
        String.format("|Damage Adj: %10s|%n", getDamageDie()) +
                             "+======================+";
    }

    public static void main(String[] args) {
        Fortune ftn = new Fortune("Merlin Luck", 10, 5, 2, DiceType.D12);
        System.out.println("TESTING Armor in fortune " + ftn.getArmor());
        System.out.print(ftn.toString());
    }
    
}
