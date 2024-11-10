package model;

public class SpeciesController {

    private Species[] species;

    public SpeciesController() {
        this.species = new Species[80];
    }

    public boolean registerFlora(String name, String scientificName, boolean hasFlowers, boolean hasFruits, double maxHeight) {
        for (int i = 0; i < species.length; i++) {
            if (species[i] == null) {
                species[i] = new Flora(name, scientificName, hasFlowers, hasFruits, maxHeight);
                return true;
            }
        }
        return false;
    }

    public boolean registerFauna(String name, String scientificName, boolean isMigratory, double maxWeight) {
        for (int i = 0; i < species.length; i++) {
            if (species[i] == null) {
                species[i] = new Fauna(name, scientificName, isMigratory, maxWeight);
                return true;
            }
        }
        return false;
    }

    public String showSpeciesList() {
        StringBuilder msg = new StringBuilder();
        for (int i = 0; i < species.length; i++) {
            if (species[i] != null) {
                msg.append("\n").append(i + 1).append(". ").append(species[i].getName()).append(" - ")
                        .append(species[i].getClass().getSimpleName());
            }
        }
        return msg.toString();
    }

    public boolean deleteSpecies(int index) {
        if (index >= 0 && index < species.length && species[index] != null) {
            species[index] = null;
            return true;
        }
        return false;
    }
}
