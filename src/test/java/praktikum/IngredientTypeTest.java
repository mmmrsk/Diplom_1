package praktikum;

import org.junit.Test;
import static org.junit.Assert.assertNotNull;

public class IngredientTypeTest {
    @Test
    public void ingredientTypeSauceTest() {
        assertNotNull(IngredientType.SAUCE);
    }

    @Test
    public void ingredientTypeFillingTest() {
        assertNotNull(IngredientType.FILLING);
    }
}