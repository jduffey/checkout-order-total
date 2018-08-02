import java.util.HashMap;
import java.util.Map;

public class Products {

    public static int getPrice(String productName) {

        Map<String, Integer> priceList = new HashMap<>();

        priceList.put("soup", 189);
        priceList.put("snickers", 79);
        priceList.put("six_pack_beer", 599);

        return priceList.get(productName);
    }

}
