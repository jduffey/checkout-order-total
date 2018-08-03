public class Item {

    private final String name;
    private int weight;

    public Item(String itemName, int weightLbs) {
        this.name = itemName;
        this.weight = weightLbs;
    }

    public String getName() {
        return name;
    }

    public int getWeight() {
        return weight;
    }
}
