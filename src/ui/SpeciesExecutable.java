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
			System.out.println("2. Edit a Species");
			System.out.println("3. Delete a Species");
			System.out.println("0. Exit");

			int mainOption = reader.nextInt();

			switch (mainOption) {

			case 1:
				registerSpecies();
				break;
			case 2:
				editSpecies();
				break;
			case 3:
				deleteSpecies();
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

		System.out.println("Type the new Species' name: ");
		String name = reader.next();

		System.out.println("Type the new Species' scientific name: ");
		String scientificName = reader.next();

		if (speciesController.registerSpecies(name, scientificName)) {

			System.out.println("Species registered successfully");

		} else {

			System.out.println("Error, Species couldn't be registered");
		}

	}

	public void editSpecies() {

		System.out.println("Which Species do you want to edit?");

		String query = speciesController.showSpeciesList();

		if (!query.equals("")) {
			System.out.println(query);

			// ...

		} else {
			System.out.println("There aren't any species registered yet");
		}

	}

	public void deleteSpecies() {

		System.out.println("Which Species do you want to delete?");

		String query = speciesController.showSpeciesList();

		if (!query.equals("")) {
			System.out.println(query);

			// ...

		} else {
			System.out.println("There aren't any species registered yet");
		}

	}

	public void showSpecies() {

		System.out.println("Which Species do you want to review?");

		String query = speciesController.showSpeciesList();

		if (!query.equals("")) {
			System.out.println(query);

			// ...

		} else {
			System.out.println("There aren't any species registered yet");
		}

	}
}
