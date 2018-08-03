import java.util.HashMap;
import java.util.Map;

public class Products {

    public static int calculatePrice(Item item) {

        Map<String, Integer> perWeightPriceList = new HashMap<>();

        perWeightPriceList.put("beef", 369);
        perWeightPriceList.put("coffeebeans", 799);
        perWeightPriceList.put("candycornbythebag", 499);
        perWeightPriceList.put("birdseed", 399);

        Map<String, Integer> perUnitPriceList = new HashMap<>();

        perUnitPriceList.put("soup", 189);
        perUnitPriceList.put("sledgehammer", 1599);
        perUnitPriceList.put("chainsaw", 21900);
        perUnitPriceList.put("bigbagofdogfood", 3499);

        if (perWeightPriceList.containsKey(item.getName())) {

            return item.getWeight() * perWeightPriceList.get(item.getName());

        } else return perUnitPriceList.get(item.getName());
    }

}
