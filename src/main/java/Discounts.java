import java.util.ArrayList;
import java.util.HashMap;

public class Discounts {

    private static final HashMap<String, Integer> markdownsInEffect = new HashMap<>();

    public static void resetDiscounts() {
        markdownsInEffect.clear();
    }

    public static void enableMarkdown(String itemName, int amountToMarkdownPerUnit) {

        markdownsInEffect.put(itemName, amountToMarkdownPerUnit);
    }

    public static int applyDiscounts(int preTaxTotal, ArrayList<Item> listOfScannedItems) {

        int discountedPreTaxTotal = preTaxTotal;

        for (Item item : listOfScannedItems) {

            if (markdownsInEffect.containsKey(item.getName())) {
                discountedPreTaxTotal = discountedPreTaxTotal - markdownsInEffect.get(item.getName());
            }
        }

        return discountedPreTaxTotal;
    }
}

