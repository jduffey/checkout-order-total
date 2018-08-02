import org.junit.Assert;
import org.junit.Test;

public class ProductsTest {

    @Test
    public void perUnitItemsShouldHaveGettersForPricePerUnitAndProductType() {
        Assert.assertEquals(189, Products.getPrice("soup"));
        Assert.assertEquals(79, Products.getPrice("snickers"));
        Assert.assertEquals(599, Products.getPrice("six_pack_beer"));
    }

}
