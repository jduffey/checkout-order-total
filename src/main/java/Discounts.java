import java.util.ArrayList;
import java.util.HashMap;

public class Discounts {

    private static final HashMap<String, Integer> markdownsInEffect = new HashMap<>();
    private static final ArrayList<String> buyOneGetOnesInEffect = new ArrayList<>();

    public static void resetDiscounts() {
        markdownsInEffect.clear();
        buyOneGetOnesInEffect.clear();
    }

    public static int applyDiscounts(int preTaxTotal, ArrayList<Item> listOfScannedItems) {

        int discountedPreTaxTotal = preTaxTotal;
        int counter = 0;

        for (Item item : listOfScannedItems) {

            if (markdownsInEffect.containsKey(item.getName())) {
                discountedPreTaxTotal = discountedPreTaxTotal - markdownsInEffect.get(item.getName());
            }
        }

        for (Item item : listOfScannedItems) {

            if (buyOneGetOnesInEffect.contains(item.getName())) {

                counter++;

                if (counter == 2) {

                    discountedPreTaxTotal = discountedPreTaxTotal - Products.calculatePrice(item);
                    counter = 0;
                }
            }
        }

        return discountedPreTaxTotal;
    }

    public static void enableMarkdown(String itemName, int amountToMarkdownPerUnit) {

        markdownsInEffect.put(itemName, amountToMarkdownPerUnit);
    }

    public static void enableBuyOneGetOne(String itemName) {
        buyOneGetOnesInEffect.add(itemName);
    }
}

