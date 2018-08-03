public class CheckoutSession {

    private int preTaxTotal = 0;
    private int weightOfTheScannedItem;
    private Item lastScannedItem;

    public int getPreTaxTotal() {
        return preTaxTotal;
    }

    public void scanItem(Item item) {
        this.lastScannedItem = item;
        weighItem(lastScannedItem);
        decideHowMuchToAddToTotal(lastScannedItem);
    }

    private void decideHowMuchToAddToTotal(Item lastScannedItem) {
        if ((lastScannedItem.getName().equalsIgnoreCase("beef") ||
                lastScannedItem.getName().equalsIgnoreCase("coffeebeans") ||
                lastScannedItem.getName().equalsIgnoreCase("candycornbythebag") ||
                lastScannedItem.getName().equalsIgnoreCase("birdseed"))) {
            preTaxTotal += weightOfTheScannedItem * Products.getPrice(lastScannedItem);
        } else {
            preTaxTotal += Products.getPrice(lastScannedItem);
        }
    }

    public void weighItem(Item item) {
        this.weightOfTheScannedItem = item.getWeight();
    }

}
