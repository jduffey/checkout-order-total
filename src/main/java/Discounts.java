import java.util.HashMap;

public class Discounts {


    private static final HashMap<String, Integer> markdownsInEffect = new HashMap<>();

    public static void enableMarkdown(String itemName, int amountToMarkdownPerUnit) {

        markdownsInEffect.put(itemName, amountToMarkdownPerUnit);
    }

    public static int applyDiscounts(int preTaxTotal) {

        int discountedPreTaxTotal = preTaxTotal;

        if (markdownsInEffect.containsKey("soup")) {
            discountedPreTaxTotal = discountedPreTaxTotal - markdownsInEffect.get("soup");
        }
        if(markdownsInEffect.containsKey("bigbagofdogfood")){
            discountedPreTaxTotal = discountedPreTaxTotal - markdownsInEffect.get("bigbagofdogfood");
        }

        return discountedPreTaxTotal;
    }
}
