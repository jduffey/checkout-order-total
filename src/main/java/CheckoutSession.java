import java.util.ArrayList;

public class CheckoutSession {

    private ArrayList<Item> listOfScannedItems = new ArrayList<>();
    private Discounts discounts = new Discounts();


    public void scanItem(Item item) {
        listOfScannedItems.add(item);
    }

    public void removeItem(Item itemToRemove) {
        listOfScannedItems.remove(itemToRemove);
    }

    private int calculateRawTotalOfAllScannedItems(ArrayList<Item> listOfScannedItems) {
        int preTaxTotal = 0;
        for (Item item : listOfScannedItems) {
            preTaxTotal += Products.calculatePrice(item);
        }
        return preTaxTotal;
    }

    public ArrayList<Item> getListOfScannedItems() {
        return listOfScannedItems;
    }

    public int getPreTaxTotal() {
        int preTaxTotal;
        preTaxTotal = calculateRawTotalOfAllScannedItems(listOfScannedItems);
        preTaxTotal = Discounts.applyDiscounts(preTaxTotal, listOfScannedItems);
        return preTaxTotal;
    }
}
