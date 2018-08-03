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

}
