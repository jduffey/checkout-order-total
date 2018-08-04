import java.util.HashMap;

public class Discounts {

    private static final HashMap<String, Integer> markdownsInEffect = new HashMap<>();

    public static void resetDiscounts() {
        markdownsInEffect.clear();
    }

    public static void enableMarkdown(String itemName, int amountToMarkdownPerUnit) {

        markdownsInEffect.put(itemName, amountToMarkdownPerUnit);
    }

    public static int applyDiscounts(int preTaxTotal) {

        int discountedPreTaxTotal = preTaxTotal;

        for (String productName : markdownsInEffect.keySet()) {
            discountedPreTaxTotal = discountedPreTaxTotal - markdownsInEffect.get(productName);
        }

        return discountedPreTaxTotal;
    }
}

