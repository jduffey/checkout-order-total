public class CheckoutSession {

    private int preTaxTotal = 0;
    private Item lastScannedItem;

    public int getPreTaxTotal() {
        return preTaxTotal;
    }

    public void scanItem(Item item) {
        this.lastScannedItem = item;
        decideHowMuchToAddToThePretaxTotal(lastScannedItem);
    }

    private void decideHowMuchToAddToThePretaxTotal(Item lastScannedItem) {
        preTaxTotal += Products.calculatePrice(lastScannedItem);
    }

}
