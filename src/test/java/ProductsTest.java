import org.junit.Assert;
import org.junit.Test;

public class ProductsTest {

    @Test
    public void perUnitItemsShouldHaveGettersForPricePerUnitAndProductType() {
        Assert.assertEquals(189, Products.getPrice("soup"));
        Assert.assertEquals(79, Products.getPrice("snickers"));
        Assert.assertEquals(599, Products.getPrice("six_pack_beer"));
    }

    @Test
    public void scanningAnItemShouldAddThatItemsPriceToCheckoutTotal() {
        CheckoutSession session = new CheckoutSession();
        Assert.assertEquals(0, session.getPreTaxTotal());
        session.scanItem("soup");
        Assert.assertEquals(189, session.getPreTaxTotal());
    }

}
