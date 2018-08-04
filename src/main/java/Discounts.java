import java.util.HashMap;

public class Discounts {


    private static final HashMap<String, Integer> markdownsInEffect = new HashMap<>();

    public static void enableMarkdown(String soup, int i) {

        markdownsInEffect.put("soup", 89);
    }

    public static int applyDiscounts(int preTaxTotal) {

        int discountedPreTaxTotal = preTaxTotal;

        if (markdownsInEffect.containsKey("soup")) {
            discountedPreTaxTotal = discountedPreTaxTotal - markdownsInEffect.get("soup");
        }

        return discountedPreTaxTotal;
    }
}
