package praktikum;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class BunTest {

    private final String name;
    private final float price;

    public BunTest(String name, float price) {
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters(name = "Bun {index} -> Name: {0}, Price:{1}")
    public static Object[][] bunTestData() {
        return new Object[][]{
                {"black bun", 100},
                {"white bun", 200},
                {"red bun", 300}
        };
    }

    @Test
    public void bunGetNameTest() {
        Bun bun = new Bun(name, price);
        String actualName = bun.getName();
        Assert.assertEquals(name, actualName);
    }

    @Test
    public void bunGetPriceTest() {
        Bun bun = new Bun(name, price);
        float actualPrice = bun.getPrice();
        Assert.assertEquals(price, actualPrice, 0);
    }
}