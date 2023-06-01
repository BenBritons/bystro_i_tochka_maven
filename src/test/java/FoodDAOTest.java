import by.fpmibsu.bystro_i_tochka.DAO.FoodDAO;
import by.fpmibsu.bystro_i_tochka.entity.Food;
import by.fpmibsu.bystro_i_tochka.exeption.DaoException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class FoodDAOTest {
    private FoodDAO foodDAO;

    @Before
    public void setUp() {
        // Инициализация объекта FoodDAO перед каждым тестом
        foodDAO = new FoodDAO();
    }

    @Test
    public void testFindAll() throws DaoException {
        // Выполнение тестовой логики
        List<Food> foodList = foodDAO.findAll();

        // Проверка результатов
        Assert.assertNotNull(foodList); // Проверка, что список не является null
        Assert.assertFalse(foodList.isEmpty()); // Проверка, что список не пустой

        for (Food food : foodList) {
            Assert.assertNotNull(food.getId()); // Проверка, что у объекта есть ID
            Assert.assertNotNull(food.getName()); // Проверка, что у объекта есть NAME
            Assert.assertNotNull(food.getPrice()); // Проверка, что у объекта есть PRICE
        }
    }
}
