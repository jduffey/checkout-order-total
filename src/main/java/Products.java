import java.util.HashMap;
import java.util.Map;

public class Products {

    public static int getPrice(Item item) {

        Map<String, Integer> priceList = new HashMap<>();

        priceList.put("soup", 189);
        priceList.put("beef", 369);

        return priceList.get(item.getName());
    }

}
