import by.fpmibsu.bystro_i_tochka.DAO.RestaurantsDAO;
import by.fpmibsu.bystro_i_tochka.entity.Restaurants;
import by.fpmibsu.bystro_i_tochka.exeption.DaoException;
import org.junit.Assert;
import org.junit.Test;

public class RestaurantDAOTest {

    @Test
    public void testDelete() throws DaoException {
        RestaurantsDAO restaurantsDAO = new RestaurantsDAO();

        // Создаем тестовый ресторан
        Restaurants testRestaurant = new Restaurants();
        // ... Установка необходимых полей для тестового ресторана ...

        // Создаем ресторан в базе данных
        restaurantsDAO.create(testRestaurant);

        // Удаляем созданный ресторан
        boolean isDeleted = restaurantsDAO.delete(testRestaurant);

        Assert.assertTrue(isDeleted);
    }
}
