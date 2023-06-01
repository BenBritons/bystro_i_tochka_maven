import by.fpmibsu.bystro_i_tochka.DAO.RestaurantsDAO;
import by.fpmibsu.bystro_i_tochka.entity.Address;
import by.fpmibsu.bystro_i_tochka.entity.Food;
import by.fpmibsu.bystro_i_tochka.entity.Restaurants;
import by.fpmibsu.bystro_i_tochka.exeption.DaoException;
import by.fpmibsu.bystro_i_tochka.service.AddressServiceImpl;
import org.junit.Assert;
import org.junit.Test;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashSet;

public class RestaurantDAOTest {

    @Test
    public void testDelete() throws DaoException {
        RestaurantsDAO restaurantsDAO = new RestaurantsDAO();

        // Создаем тестовый ресторан
        Restaurants testRestaurant = new Restaurants(12321, new AddressServiceImpl().findEntityById(1), "OCHEN KRUTOI RESTORANCHK", LocalTime.MIDNIGHT, LocalTime.NOON, new HashSet<DayOfWeek>(), new ArrayList<Food>());
        // ... Установка необходимых полей для тестового ресторана ...

        // Создаем ресторан в базе данных
        restaurantsDAO.create(testRestaurant);

        // Удаляем созданный ресторан
        boolean isDeleted = restaurantsDAO.delete(testRestaurant);

        Assert.assertTrue(isDeleted);
    }
}
