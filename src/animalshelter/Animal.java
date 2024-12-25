
package animalshelter;

public class Animal {
    private String name;
    private String type;
    private boolean isAdopted;

    public Animal(String name, String type) {
        this.name = name;
        this.type = type;
        this.isAdopted = false;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public boolean isAdopted() {
        return isAdopted;
    }

    public String adopt() {
        if (!isAdopted) {
            isAdopted = true;
            return name + " has been adopted!";
        }
        return name + " is already adopted.";
    }

    public String returnToShelter() {
        if (isAdopted) {
            isAdopted = false;
            return name + " is now available for adoption.";
        }
        return name + " is already in the shelter.";
    }

    @Override
    public String toString() {
        String status = isAdopted ? "Adopted" : "Available";
        return name + " (" + type + ") - " + status;
    }
}