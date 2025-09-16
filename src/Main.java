import java.util.ArrayList;
import java.util.Random;

public class Main {
    static Random randomGenerator = new Random();

    public static void main(String[] args) {
        System.out.println("Welcome to my fighting game");


        // Contains the stats of the first character (HP, Mana, Damage)
        ArrayList<Integer> stats1 = new ArrayList<>();
        stats1.add(100);
        stats1.add(randomGenerator.nextInt(20, 81));
        stats1.add(randomGenerator.nextInt(20, 81));

        // Contains the stats of the first character (HP, Mana, Damage)
        ArrayList<Integer> stats2 = new ArrayList<>();
        stats2.add(100);
        stats2.add(randomGenerator.nextInt(20, 81));
        stats2.add(randomGenerator.nextInt(20, 81));

        // Print character info to check it works
        System.out.println("Character 1 has " + stats1.get(0) + " hp and " + stats1.get(1) + " mana");
        System.out.println("Character 2 has " + stats2.get(0) + " hp and " + stats2.get(1) + " mana");

        // Character 1 hits character 2 with standard attack
        int newHP = standardAttack(stats1.get(2), stats2.get(0));
        stats2.set(0, newHP); // Puts the new HP to current HP in stats2
        System.out.println("Fighter number 2 now has " + stats2.get(0) + " HP");

        // Character 1 hits character 2 with special attack
        int[] hpMana = specialAttack(stats1.get(2), stats1.get(1), stats2.get(0));
        stats2.set(0, hpMana[0]); // Puts the new HP to current HP in stats2
        stats1.set(1, hpMana[1]); // Puts the new mana to current mana in stats1
        System.out.println("Fighter number 2 now has " + stats2.get(0) + " HP");
        System.out.println("Fighter number 1 now has " + stats1.get(1) + " mana");

        //TODO: Fix game loop in seperate method
        //          Start with user interaction
        //          After let AI hit back with random choice
        //          IF time: make ai more clever in attack choice
    }

    // Method for standard attack
    public static int standardAttack(int damage, int hp) {
        int chance = randomGenerator.nextInt(100); // Generates a numer 0-99

        // Chance of crit is appx 1/3
        if (chance < 67) {
            hp = hp - damage / 6;
            System.out.println("Regular hit");
        } else {
            hp = hp - damage;
            System.out.println("Critical hit");
        }
        return hp;
    }

    //method for special attack
    public static int[] specialAttack(int damage, int mana, int hp) {
        if (mana - 20 < 0) {
            System.out.println("You are too low on mana. Special attack is not available");
        } else {
            System.out.println("Special attack");
            hp = (int) (hp - 0.25 * damage); //Calculates a double, (int) forces double to int
            mana -= 20;
        }
        int[] returnArray = {hp, mana};

        return returnArray; // Contains hp and mana
    }
}

// System.out.println("Första"); // Skriver ut och skapar ny rad
// System.out.print("Andra"); // Skriver ut utan att avsluta med ny rad
// System.out.print("Tredje");