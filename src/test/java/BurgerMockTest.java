import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

@RunWith(MockitoJUnitRunner.class)
public class BurgerMockTest {

    protected Burger burger = new Burger();
    @Mock
    Bun bun;
    @Mock
    Ingredient ingredient;

    public Bun getMockBun() {
        Mockito.when(bun.getName()).thenReturn("black bun");
        Mockito.when(bun.getPrice()).thenReturn(100f);
        return bun;
    }

    public Ingredient getMockFirstIngredient() {
        Mockito.when(ingredient.getType()).thenReturn(IngredientType.SAUCE);
        Mockito.when(ingredient.getName()).thenReturn("chili sauce");
        Mockito.when(ingredient.getPrice()).thenReturn(300f);
        return ingredient;
    }

    public Ingredient getMockSecondIngredient() {
        Mockito.when(ingredient.getType()).thenReturn(IngredientType.FILLING);
        Mockito.when(ingredient.getName()).thenReturn("cutlet");
        Mockito.when(ingredient.getPrice()).thenReturn(100f);
        return ingredient;
    }

    @Test
    public void setBunsTest() {
        burger.setBuns(getMockBun());
        Assert.assertEquals(getMockBun(), burger.bun);
    }

    @Test
    public void addIngredientTest() {
        burger.addIngredient(getMockFirstIngredient());
        Assert.assertEquals(getMockFirstIngredient(), burger.ingredients.get(0));
    }

    @Test
    public void removeIngredientTest() {
        burger.addIngredient(getMockSecondIngredient());
        burger.removeIngredient(0);
        Assert.assertTrue(burger.ingredients.isEmpty());
    }

    @Test
    public void moveIngredientTest() {
        burger.addIngredient(getMockFirstIngredient());
        burger.addIngredient(getMockSecondIngredient());
        burger.moveIngredient(0, 1);
        Assert.assertEquals(getMockSecondIngredient().name, burger.ingredients.get(1).name);
    }

    @Test
    public void getPriceTest() {
        burger.setBuns(getMockBun());
        burger.addIngredient(getMockFirstIngredient());
        Assert.assertEquals(500f, burger.getPrice(), 0);
    }

    @Test
    public void getReceiptTest() {
        burger.setBuns(getMockBun());
        burger.addIngredient(getMockFirstIngredient());
        String expected = String.format("(==== black bun ====)%n" +
                "= sauce chili sauce =%n" +
                "(==== black bun ====)%n" +
                "%n" +
                "Price: 500,000000%n");
        Assert.assertEquals(expected, burger.getReceipt());
    }
}
