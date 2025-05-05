import java.util.Random;

public class PokemonDamageCalculator {

    public static int calculateDamage(
            int level,
            boolean isCritical,
            int power,
            int attack,
            int defense,
            boolean isSTAB,
            double type1,
            double type2
    ) {
        int critical = isCritical ? 2 : 1;

        if (attack > 255) attack /= 4;
        if (defense > 255) defense /= 4;

        double base = (((2.0 * level * critical) / 5 + 2) * power * attack / defense) / 50 + 2;
        double stab = isSTAB ? 1.5 : 1.0;

        Random rand = new Random();
        int randFactor = rand.nextInt(39) + 217;
        double randomMultiplier = randFactor / 255.0;

        double damage = base * stab * type1 * type2 * randomMultiplier;

        return (int) damage;
    }

    public static void main(String[] args) {
        int level = 50;
        boolean isCritical = false;
        int power = 100;
        int attack = 120;
        int defense = 100;
        boolean isSTAB = true;
        double type1 = 2.0;
        double type2 = 1.0;

        int damage = calculateDamage(level, isCritical, power, attack, defense, isSTAB, type1, type2);
        System.out.println("Damage: " + damage);
    }
}

