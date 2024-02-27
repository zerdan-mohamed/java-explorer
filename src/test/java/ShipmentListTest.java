import org.codewithme.collections.ShipmentList;
import org.codewithme.models.Product;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ShipmentListTest {

    public static Product laptop = new Product("Laptop", 1200);
    public static Product smartphone = new Product("Smartphone", 800);
    public static Product headphones = new Product("Headphones", 150);

    private final ShipmentList shipmentList = new ShipmentList();

    @Test
    public void shouldAddItems() {
        shipmentList.add(laptop);
        shipmentList.add(smartphone);
        assertThat(shipmentList, contains(laptop, smartphone));
    }

    @Test
    public void shouldReplaceItems()
    {
        shipmentList.add(laptop);
        shipmentList.add(smartphone);

        assertTrue(shipmentList.replace(laptop, headphones));
        assertThat(shipmentList, contains(headphones, smartphone));
    }

    @Test
    public void shouldNotReplaceMissingItems() {
        shipmentList.add(laptop);

        assertFalse(shipmentList.replace(smartphone, headphones));
        assertThat(shipmentList, contains(laptop));
    }

    @Test
    void shouldReplaceExistingProduct() {
        shipmentList.add(smartphone);
        shipmentList.add(headphones);

        boolean result = shipmentList.replaceAll(smartphone, laptop);

        assertThat(result, is(true));
        assertThat(shipmentList, contains(laptop, headphones));
    }

    @Test
    void shouldReturnTrueWhenOldProductDoesNotExist() {
        shipmentList.add(smartphone);
        shipmentList.add(headphones);

        Product nonExistingProduct = new Product("Non Existing", 500);
        boolean result = shipmentList.replaceAll(nonExistingProduct, laptop);

        assertThat(result, is(true));
        assertThat(shipmentList, contains(smartphone, headphones));
    }

    @Test
    void shouldReplaceAllInstancesOfOldProduct() {
        shipmentList.add(laptop);
        shipmentList.add(smartphone);
        shipmentList.add(headphones);
        shipmentList.add(laptop);

        boolean result = shipmentList.replaceAll(laptop, smartphone);

        assertThat(result, is(true));
        assertThat(shipmentList, containsInAnyOrder(smartphone, headphones, smartphone, smartphone));
    }

    @Test
    public void shouldIdentifyProductsRequirements()
    {
        shipmentList.add(laptop);
        shipmentList.add(smartphone);
        shipmentList.add(headphones);

        shipmentList.prepare();

        assertThat(shipmentList.getCheapProducts(), contains(headphones));
        assertThat(shipmentList.getExpensiveProducts(), contains(smartphone, laptop));
    }

    @Test
    public void shouldStripExpensiveProducts() {
        shipmentList.add(laptop);
        shipmentList.add(smartphone);
        shipmentList.add(headphones);

        assertTrue(shipmentList.stripExpensiveProducts());
        assertThat(shipmentList, contains(headphones));
    }
}
