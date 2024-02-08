import org.junit.Assert;
import org.junit.Test;
import praktikum.IngredientType;

public class IngredientTypeTest {
    @Test
    public void sauceWithoutData() {
        Assert.assertNotNull("Соусы не указаны", IngredientType.valueOf("SAUCE"));
    }

    @Test
    public void fillingWithoutData() {
        Assert.assertNotNull("Начинка не указана", IngredientType.valueOf("FILLING"));
    }
}
