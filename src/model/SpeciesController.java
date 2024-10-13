package model;

public class SpeciesController {

	private Species[] species;

	public SpeciesController() {

		this.species = new Species[80];

	}

	public boolean registerSpecies(String name, String scientificName) {

		for (int i = 0; i < species.length; i++) {
			if (species[i] == null) {
				species[i] = new Species(name, scientificName);
				return true;
			}

		}

		return false;

	}

	public String showSpeciesList() {

		String msg = "";

		for (int i = 0; (i < species.length); i++) {
			if (species[i] != null) {
				msg += "\n" + (i + 1) + ". " + species[i].getName();
			}
		}

		return msg;

	}

}
