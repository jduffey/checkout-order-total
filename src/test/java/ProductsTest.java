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

    //    @Test
//    public void perUnitItemsShouldHaveGettersForPricePerUnitAndProductType() {
//        Assert.assertEquals(189, Products.getPrice("soup"));
//        Assert.assertEquals(79, Products.getPrice("snickers"));
//        Assert.assertEquals(599, Products.getPrice("six_pack_beer"));
//    }
//
//    @Test
//    public void scanningAnItemShouldAddThatItemsPriceToCheckoutTotal() {
//        CheckoutSession session = new CheckoutSession();
//        Assert.assertEquals(0, session.getPreTaxTotal());
//        session.scanItem("soup");
//        Assert.assertEquals(189, session.getPreTaxTotal());
//        session.scanItem("snickers");
//        Assert.assertEquals(189 + 79, session.getPreTaxTotal());
//        session.scanItem("six_pack_beer");
//        Assert.assertEquals(189 + 79 + 599, session.getPreTaxTotal());
//    }
//
//    @Test
//    public void perWeightItemsShouldHaveGettersForTheirPerPerPoundPrice() {
//        Assert.assertEquals(399, Products.getPrice("beef"));
//        Assert.assertEquals(159, Products.getPrice("bananas"));
//        Assert.assertEquals(799, Products.getPrice("ground_coffee"));
//    }

}
