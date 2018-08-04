import java.util.ArrayList;

public class CheckoutSession {

    private int preTaxTotal = 0;
    private Item lastScannedItem;
    ArrayList<Item> listOfScannedItems = new ArrayList<Item>();


    public void scanItem(Item item) {
        this.lastScannedItem = item;
        addItemToListOfScannedItems(item);
    }

    private void addItemToListOfScannedItems(Item item) {
        listOfScannedItems.add(item);
    }

    public void removeItem(Item itemToRemove) {
        listOfScannedItems.remove(itemToRemove);
        preTaxTotal -= Products.calculatePrice(itemToRemove);
    }

    private void calculateRawTotalOfAllScannedItems(ArrayList<Item> listOfScannedItems) {
        preTaxTotal = 0;
        for (Item item : listOfScannedItems) {
            preTaxTotal += Products.calculatePrice(item);
        }
    }

    public ArrayList<Item> getListOfScannedItems() {
        return listOfScannedItems;
    }

    public int getPreTaxTotal() {
        calculateRawTotalOfAllScannedItems(listOfScannedItems);
        return preTaxTotal;
    }
}
