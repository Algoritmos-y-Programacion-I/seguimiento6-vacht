package ui;

import java.util.Scanner;
import model.SpeciesController;

public class SpeciesExecutable {

    private Scanner reader;
    private SpeciesController speciesController;

    public static void main(String[] args) {
        SpeciesExecutable exe = new SpeciesExecutable();
        exe.showMainMenu();
    }

    public SpeciesExecutable() {
        reader = new Scanner(System.in);
        speciesController = new SpeciesController();
    }

    public void showMainMenu() {
        System.out.println("Welcome to Icesi Species");

        boolean stopFlag = false;

        while (!stopFlag) {
            System.out.println("\nType an option");
            System.out.println("1. Register a Species");
            System.out.println("2. Delete a Species");
            System.out.println("3. Show Species");
            System.out.println("0. Exit");

            int mainOption = reader.nextInt();

            switch (mainOption) {
                case 1:
                    registerSpecies();
                    break;
                case 2:
                    deleteSpecies();
                    break;
                case 3:
                    showSpecies();
                    break;
                case 0:
                    System.out.println("Thanks for using our system");
                    stopFlag = true;
                    break;
                default:
                    System.out.println("You must type a valid option");
                    break;
            }
        }
    }

    public void registerSpecies() {
        System.out.println("Is the species Flora or Fauna? (Type 1 for Flora, 2 for Fauna): ");
        int type = reader.nextInt();

        System.out.println("Type the new Species' name: ");
        String name = reader.next();

        System.out.println("Type the new Species' scientific name: ");
        String scientificName = reader.next();

        if (type == 1) {
            System.out.println("Does the species have flowers? (true/false): ");
            boolean hasFlowers = reader.nextBoolean();

            System.out.println("Does the species have fruits? (true/false): ");
            boolean hasFruits = reader.nextBoolean();

            System.out.println("Type the maximum height of the species: ");
            double maxHeight = reader.nextDouble();

            if (speciesController.registerFlora(name, scientificName, hasFlowers, hasFruits, maxHeight)) {
                System.out.println("Flora species registered successfully");
            } else {
                System.out.println("Error, Flora species couldn't be registered");
            }
        } else if (type == 2) {
            System.out.println("Is the species migratory? (true/false): ");
            boolean isMigratory = reader.nextBoolean();

            System.out.println("Type the maximum weight of the species: ");
            double maxWeight = reader.nextDouble();

            if (speciesController.registerFauna(name, scientificName, isMigratory, maxWeight)) {
                System.out.println("Fauna species registered successfully");
            } else {
                System.out.println("Error, Fauna species couldn't be registered");
            }
        } else {
            System.out.println("Invalid type selected.");
        }
    }

    public void deleteSpecies() {
        System.out.println("Which species do you want to delete?");
        String speciesList = speciesController.showSpeciesList();

        if (!speciesList.isEmpty()) {
            System.out.println(speciesList);
            int index = reader.nextInt() - 1;
            if (speciesController.deleteSpecies(index)) {
                System.out.println("Species deleted successfully");
            } else {
                System.out.println("Invalid selection or species does not exist.");
            }
        } else {
            System.out.println("There aren't any species registered yet.");
        }
    }

    public void showSpecies() {
        System.out.println("Registered species:");
        String speciesList = speciesController.showSpeciesList();
        if (!speciesList.isEmpty()) {
            System.out.println(speciesList);
        } else {
            System.out.println("There aren't any species registered yet.");
        }
    }
}
