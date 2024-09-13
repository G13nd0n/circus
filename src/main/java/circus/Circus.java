package circus;

import circus.animal.Animal;
import circus.animal.Duck;
import circus.animal.Parrot;
import circus.animal.Tiger;
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

    public static void main(String[] args) {
        // animals[3] = new Elephant("Eli"); This doesn't work
        System.out.println("Number of animals in the array are: " + animals.length);
        ArrayList<Animal> animalArrayList = new ArrayList<>(Arrays.asList(animals));
        printAllAnimals(animalArrayList);
        printNumberOfAnimalsInTheCircus("Size of our animal array list: " + animalArrayList.size());

        Elephant strongOne = new Elephant("Strong One");
        animalArrayList.add(strongOne);
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
    */}

    private static void printNumberOfAnimalsInTheCircus(String animalArrayList) {
        System.out.println(animalArrayList);
    }

    private static void printAllAnimals(ArrayList<Animal> animalArrayList) {
        for (Animal a : animalArrayList) {
            System.out.println(a);
        }
    }
}
