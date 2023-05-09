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
                {"", 300},
                {null, 200},
                {"       ", 200},
                {"другой язык булки", 200},
                {"1234567890", 200},
                {"a", 200},
                {"this is name of very delicious bun with very very long name", 100},
                {"(black bun)&*^%$#@!_", 200},
                {"black bun", -1},
                {"white bun", 0},
                {"red bun", Float.MIN_VALUE},
                {"black bun", Float.MAX_VALUE},
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