import java.util.ArrayList;

public class CheckoutSession {

    private int preTaxTotal = 0;
    private Item lastScannedItem;
    ArrayList<Item> listOfScannedItems = new ArrayList<Item>();

    public int getPreTaxTotal() {
        return preTaxTotal;
    }

    public void scanItem(Item item) {
        this.lastScannedItem = item;
        addItemToListOfScannedItems(item);
        decideHowMuchToAddToThePretaxTotal(lastScannedItem);
    }

    private void addItemToListOfScannedItems(Item item) {

        listOfScannedItems.add(item);

    }

    private void decideHowMuchToAddToThePretaxTotal(Item lastScannedItem) {
        preTaxTotal += Products.calculatePrice(lastScannedItem);
    }

    public ArrayList<Item> getListOfScannedItems() {

        return listOfScannedItems;

    }

    public void removeItem(Item itemToRemove) {
        listOfScannedItems.remove(itemToRemove);
        preTaxTotal -= Products.calculatePrice(itemToRemove);
    }
}
