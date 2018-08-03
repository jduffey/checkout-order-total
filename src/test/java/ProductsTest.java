import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

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

    @Test
    public void sessionShouldKeepAListOfAllItemsItHasScanned() {
        CheckoutSession session = new CheckoutSession();
        Item item1 = new Item("coffeebeans", 2);
        Item item2 = new Item("candycornbythebag", 2);
        Item item3 = new Item("coffeebeans", 2);
        Item item4 = new Item("birdseed", 2);
        Item item5 = new Item("soup", 2);
        session.scanItem(item1);
        session.scanItem(item2);
        session.scanItem(item3);
        session.scanItem(item4);
        session.scanItem(item5);

        ArrayList<Item> expectedResult = new ArrayList<Item>();
        expectedResult.add(item1);
        expectedResult.add(item2);
        expectedResult.add(item3);
        expectedResult.add(item4);
        expectedResult.add(item5);

        Assert.assertEquals(expectedResult, session.getListOfScannedItems());
    }

    @Test
    public void cashierShouldBeAbleToRemoveAScannedItemAfterItIsScanned() {
        CheckoutSession session = new CheckoutSession();
        Item item1 = new Item("coffeebeans", 2);
        Item item2 = new Item("soup", 2);
        session.scanItem(item1);
        session.scanItem(item2);
        Assert.assertEquals(2 * 799 + 189, session.getPreTaxTotal());

        session.removeItem(item1);

        ArrayList<Item> expectedResult = new ArrayList<Item>();
        expectedResult.add(item2);

        Assert.assertEquals(expectedResult, session.getListOfScannedItems());
        Assert.assertEquals(189, session.getPreTaxTotal());
    }

}
