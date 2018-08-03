import java.util.HashMap;
import java.util.Map;

public class Products {

    public static int getPrice(Item item) {

        Map<String, Integer> priceList = new HashMap<>();

        priceList.put("soup", 189);
//        priceList.put("snickers", 79);
//        priceList.put("six_pack_beer", 599);
//        priceList.put("beef", 399);
//        priceList.put("bananas", 159);
//        priceList.put("ground_coffee", 799);

        return priceList.get(item.getName());
    }

}
