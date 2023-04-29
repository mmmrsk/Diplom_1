package praktikum;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.Arrays;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    private Burger burger;
    @Mock
    private Bun bun;
    @Mock
    private Ingredient firstIngredient;
    @Mock
    private Ingredient secondIngredient;

    @Before
    public void setUp() {
        burger= new Burger();
        burger.setBuns(bun);
    }
    @Test
    public void burgerAddIngredientTest() {
        burger.addIngredient(firstIngredient);
        assertEquals(1, burger.ingredients.size());
    }
    @Test
    public void burgerRemoveIngredientTest() {
        burger.addIngredient(firstIngredient);
        burger.addIngredient(secondIngredient);
        burger.removeIngredient(0);
        assertEquals(1, burger.ingredients.size());
    }
    @Test
    public void burgerMoveIngredientTest() {
        burger.addIngredient(firstIngredient);
        burger.addIngredient(secondIngredient);
        burger.moveIngredient(0, 1);
        assertEquals(Arrays.asList(secondIngredient, firstIngredient), burger.ingredients);
    }
    @Test
    public void burgerGetPriceTest() {
        when(bun.getPrice()).thenReturn(200F);
        when(firstIngredient.getPrice()).thenReturn(100F);
        when(secondIngredient.getPrice()).thenReturn(200F);

        burger.addIngredient(firstIngredient);
        burger.addIngredient(secondIngredient);

        assertEquals(700F, burger.getPrice(), 0);
    }
    @Test
    public void testGetReceipt() {
        when(bun.getName()).thenReturn("white bun");
        when(firstIngredient.getType()).thenReturn(IngredientType.FILLING);
        when(firstIngredient.getName()).thenReturn("cutlet");
        when(firstIngredient.getPrice()).thenReturn(100F);
        when(secondIngredient.getType()).thenReturn(IngredientType.SAUCE);
        when(secondIngredient.getName()).thenReturn("sour cream");
        when(secondIngredient.getPrice()).thenReturn(200F);

        burger.addIngredient(firstIngredient);
        burger.addIngredient(secondIngredient);

        String expected = "(==== white bun ====)\r\n" +
                "= filling cutlet =\r\n" +
                "= sauce sour cream =\r\n" +
                "(==== white bun ====)\r\n" +
                "\r\n" +
                "Price: 300,000000\r\n";
        assertEquals(expected, burger.getReceipt());
    }
}