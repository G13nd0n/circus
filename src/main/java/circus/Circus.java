package circus;


import circus.animal.*;

import circus.stuff.Cage;
import circus.stuff.Cannon;
import circus.stuff.Equipment;
import circus.stuff.Ladder;
import circus.animal.Elephant;
import java.util.ArrayList;
import java.util.Arrays;


public class Circus {
    private static Animal[] animals = {
            new Duck("Drake"),
            new Parrot("Polly"),
            new Tiger("Tai Lung")
    };
    private static Equipment[] equipments = {
            new Ladder(50),
            new Cannon(5),
            new Cannon(100)
    };

    private static void makeAnimalsTalk() {
        for (Animal a : animals) {
            System.out.println(a);
            System.out.println(a.speak());
        }
    }

    private static int calculateAssetValue(Asset[] assets) {
        int total = 0;
        for (Asset a : assets) {
            if (a.getValue() <= 5) {
                System.out.println("Ignoring low value item: " + a.getValue());
                continue;
            }
            total += a.getValue();
            System.out.println("Adding item value: " + a.getValue());
        }
        return total;
    }

    private static void printAllAnimals(ArrayList<Animal> animalArrayList) {
        for (Animal a : animalArrayList) {
            System.out.println(a);
        }
    }

    private static void printNumberOfAnimalsInTheCircus(String animalArrayList) {
        System.out.println(animalArrayList);
    }

    public static void main(String[] args) {
        // animals[3] = new Elephant("Eli"); This doesn't work
        System.out.println("Number of animals in the array are: " + animals.length);
        ArrayList<Animal> animalArrayList = new ArrayList<>(Arrays.asList(animals));
        printAllAnimals(animalArrayList);
        printNumberOfAnimalsInTheCircus("Size of our animal array list: " + animalArrayList.size());

        Duck andy = new Duck("Andy");
        animalArrayList.add(andy);

        printAllAnimals(animalArrayList);
        printNumberOfAnimalsInTheCircus("Size of our animal array list: " + animalArrayList.size());
        System.out.println("Before sorting...");
        animalArrayList.sort(Animal.AmimalNameComparator);
        System.out.println("After sorting...");
        printAllAnimals(animalArrayList);
        /*makeAnimalsTalk();
        System.out.println("Total value of animals " + calculateAssetValue(animals));
        System.out.println("Total value of equipments " + calculateAssetValue(equipments));
    */
        animalArrayList.add(new Tiger("Sherkhan"));
        System.out.println("Number of animals: " + animalArrayList.size());

        animalArrayList.add(new Parrot("Louie"));

        Elephant strongOne = new Elephant("StrongOne");
        animalArrayList.add(strongOne);

        printAllAnimals(animalArrayList);

        Cage<Duck> duckCage = new Cage<>();
        Duck duck = new Duck("Henry");
        duckCage.lockUp(duck);
        Parrot parrot = new Parrot("Peter");
        Cage<Parrot> parrotCage = new Cage<>();
        parrotCage.lockUp(parrot);

        ArrayList<Cage> cages = new ArrayList<>();
        cages.add(duckCage);
        cages.add(parrotCage);

        for(Cage c: cages) {
            c.release();
        }
    }
}
