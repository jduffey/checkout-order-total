import java.util.HashMap;
import java.util.Map;

public class Products {

    public static int getPrice(Item item) {

        Map<String, Integer> priceList = new HashMap<>();

        priceList.put("soup", 189);
        priceList.put("sledgehammer", 1599);
        priceList.put("chainsaw", 21900);
        priceList.put("bigbagofdogfood", 3499);
        priceList.put("beef", 369);

        return priceList.get(item.getName());
    }

}
