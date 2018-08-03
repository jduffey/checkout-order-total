import org.junit.Assert;
import org.junit.Test;

public class ProductsTest {

    @Test
    public void scanningAPerUnitItemShouldAddItsPriceToTheTotal() {
        Item item = new Item("soup", 2);
        CheckoutSession session = new CheckoutSession();
        session.scanItem(item);
        Assert.assertEquals(189, session.getPreTaxTotal());
    }

    @Test
    public void scanningAPerWeightItemShouldAddTheAppropriatePriceToTheTotal() {
        CheckoutSession session = new CheckoutSession();
        Item item = new Item("beef", 2);
        session.scanItem(item);
        Assert.assertEquals(738, session.getPreTaxTotal());
    }

    @Test
    public void thereShouldBeASetOfItemsThatArePricedPerUnit() {
        CheckoutSession session = new CheckoutSession();
        Item item1 = new Item("sledgehammer", 15);
        Item item2 = new Item("chainsaw", 12);
        Item item3 = new Item("bigbagofdogfood", 40);
        session.scanItem(item1);
        session.scanItem(item2);
        session.scanItem(item3);
        Assert.assertEquals(26998, session.getPreTaxTotal());
    }

    @Test
    public void thereShouldBeASetOfItemsThatArePricedPerWeight() {
        CheckoutSession session = new CheckoutSession();
        Item item1 = new Item("coffeebeans", 2);
        Item item2 = new Item("candycornbythebag", 2);
        Item item3 = new Item("birdseed", 2);
        session.scanItem(item1);
        session.scanItem(item2);
        session.scanItem(item3);
        Assert.assertEquals(3394, session.getPreTaxTotal());
    }

}
