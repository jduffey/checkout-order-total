public class CheckoutSession {

    private int preTaxTotal = 0;

    public int getPreTaxTotal() {
        return preTaxTotal;
    }

    public void scanItem(Item item) {
        preTaxTotal += Products.getPrice(item);
    }
}
